package com.lvmama.lvf.cat.interceptor;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.dianping.cat.message.internal.AbstractMessage;
import com.dianping.cat.message.spi.MessageTree;
import com.lvmama.lvf.cat.constants.CatComConstants;
import com.lvmama.lvf.cat.utils.*;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Provider
@Component
public class CatFilterServerResteasy implements ContainerRequestFilter,ContainerResponseFilter{


	private static Logger logger = LoggerFactory.getLogger(CatFilterServerResteasy.class);

	private static ThreadLocal<Transaction> tranLocal = new ThreadLocal<Transaction>();

	private static ThreadLocal<Cat.Context> catContext = new ThreadLocal<Cat.Context>(){};


	public void filter(ContainerRequestContext arg0) throws IOException {

		String headCatContext = arg0.getHeaders().getFirst(CatComConstants.CAT_CONTEXT);
		String loggerName = "";
		if(StringUtils.isNotBlank(headCatContext)){
			try{
				String type = CatComConstants.CROSS_SERVER;
				loggerName = LoggerNameUtil.getLoggerName(arg0);
				Transaction transaction = Cat.newTransaction(type,loggerName);
				tranLocal.set(transaction);
				Cat.Context context = this.getContext(headCatContext);
				this.createProviderCross(transaction);
				Cat.logRemoteCallServer(context);
			}catch (Throwable e){
				Cat.logError(loggerName,e);
			}
		}

	}




	public void filter(ContainerRequestContext arg0,ContainerResponseContext arg1) throws IOException {

		Transaction transaction = tranLocal.get();
		if(transaction!=null){
			String status = Transaction.SUCCESS;
			String loggerName = LoggerNameUtil.getLoggerName(arg0);
			if(Response.Status.OK.getStatusCode() != arg1.getStatus()) {
				Object entity = arg1.getEntity();
				ExceptionWrapper ew = null;
				try {
					ew = JSONMapper.getInstance().readValue(JSONMapper.getInstance().writeValueAsString(entity), ExceptionWrapper.class);
					status = ew.getClass().getSimpleName();
					Event event = Cat.newEvent(CatComConstants.REST_EXCEPTION+arg1.getStatus(),loggerName);
					event.addData(JSONMapper.getInstance().writeValueAsString(new ExceptionSimpleWrapper(ew)));
					event.setStatus(status);
					this.completeEvent(event);
					transaction.addChild(event);
				} catch (Exception ex) {
					status = ex.getClass().getSimpleName();
					Cat.logError(loggerName, ex);
				}
			}else {
				String responseData = JSONMapper.getInstance().writeValueAsString(arg1.getEntity());
				transaction.addData(CatComConstants.PROVIDER_CALL_RESPONSE,responseData);
			}
			transaction.setStatus(status);
			transaction.complete();
		}
		catContext.remove();

	}





	private void completeEvent(Event event){
		AbstractMessage message = (AbstractMessage) event;
		message.setCompleted(true);
	}

	private void createProviderCross(Transaction transaction){

		MessageTree tree = Cat.getManager().getThreadLocalMessageTree();
		String domain = tree.getDomain();
		Event crossAppEvent = Cat.newEvent(CatComConstants.PROVIDER_CALL_APP,domain);
		Event crossServerEvent = Cat.newEvent(CatComConstants.PROVIDER_CALL_SERVER, NetUtils.getLocalHost());
		crossAppEvent.setStatus(Event.SUCCESS);
		crossServerEvent.setStatus(Event.SUCCESS);
		completeEvent(crossAppEvent);
		completeEvent(crossServerEvent);
		transaction.addChild(crossAppEvent);
		transaction.addChild(crossServerEvent);
	}

	private Cat.Context getContext(String headCatContext){
		Cat.Context context = catContext.get();
		if(context==null){
			context = initContext(headCatContext);
			catContext.set(context);
		}
		return context;
	}


	private Cat.Context initContext(String headCatContext){
		Cat.Context context = new CatContext();
		Map<String,String> catContextMap = new HashMap<String, String>();
		if (StringUtils.isNotBlank(headCatContext)){
			try {
				catContextMap = JSONMapper.getInstance().readValue(headCatContext, new TypeReference<Map<String,String>>(){});
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
			context.addProperty(Cat.Context.PARENT, catContextMap.get(Cat.Context.PARENT));
			context.addProperty(Cat.Context.CHILD, catContextMap.get(Cat.Context.CHILD));
			context.addProperty(Cat.Context.ROOT, catContextMap.get(Cat.Context.ROOT));
		}
		return context;
	}


}
