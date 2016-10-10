package com.lvmama.lvf.cat.interceptor;

import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.dianping.cat.message.internal.AbstractMessage;
import com.dianping.cat.message.spi.MessageTree;
import com.lvmama.lvf.cat.constants.CatComConstants;
import com.lvmama.lvf.cat.utils.CatContext;
import com.lvmama.lvf.cat.utils.JSONMapper;
import com.lvmama.lvf.cat.utils.LoggerNameUtil;
import com.lvmama.lvf.cat.utils.NetUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CatFilterClientResteasy implements ClientRequestFilter,ClientResponseFilter {

	private static Logger logger = LoggerFactory.getLogger(CatFilterServerResteasy.class);

	private ThreadLocal<Cat.Context> catContext = new ThreadLocal<Cat.Context>(){};


	public void filter(ClientRequestContext requestContext) throws IOException {

		String type = CatComConstants.CROSS_CONSUMER;
		String loggerName = LoggerNameUtil.getLoggerName(requestContext);
		Transaction transaction = Cat.newTransaction(type,loggerName);
		try{
			String requestData = JSONMapper.getInstance().writeValueAsString(requestContext.getEntity());
			transaction.addData(CatComConstants.CONSUMER_CALL_REQEST,requestData);
			String headCatContext = "";
			Object catContextObj = requestContext.getHeaders().getFirst(CatComConstants.CAT_CONTEXT);
			if(catContextObj!=null){
				headCatContext = catContextObj.toString();
			}
			Cat.Context context = this.getContext(headCatContext);
			this.createConsumerCross(transaction);
			Cat.logRemoteCallClient(context);
			requestContext.getHeaders().putSingle(CatComConstants.CAT_CONTEXT,this.getContextHeadStr(context));
			//logger.error(loggerName+"-pass_context"+JSONMapper.getInstance().writeValueAsString(context));

		}catch (Throwable e){
			Cat.logError(loggerName,e);
		}finally {
			transaction.setStatus(Transaction.SUCCESS);
			transaction.complete();
		}
	}

	private void completeEvent(Event event){
		AbstractMessage message = (AbstractMessage) event;
		message.setCompleted(true);
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

	private String getContextHeadStr(Cat.Context context){
		String catContextStr = null;
		Map<String,String> catContextMap = new HashMap<String, String>();
		catContextMap.put(Cat.Context.ROOT,context.getProperty(Cat.Context.ROOT));
		catContextMap.put(Cat.Context.CHILD,context.getProperty(Cat.Context.CHILD));
		catContextMap.put(Cat.Context.PARENT,context.getProperty(Cat.Context.PARENT));
		try {
			 catContextStr = JSONMapper.getInstance().writeValueAsString(catContextMap);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return catContextStr;
	}


	private void createConsumerCross(Transaction transaction){
		MessageTree tree = Cat.getManager().getThreadLocalMessageTree();
		String domain = tree.getDomain();
		Event crossAppEvent =   Cat.newEvent(CatComConstants.CONSUMER_CALL_APP,domain);
		Event crossServerEvent =   Cat.newEvent(CatComConstants.CONSUMER_CALL_SERVER, NetUtils.getLocalHost());
		crossAppEvent.setStatus(Event.SUCCESS);
		crossServerEvent.setStatus(Event.SUCCESS);
		this.completeEvent(crossAppEvent);
		this.completeEvent(crossServerEvent);
		transaction.addChild(crossAppEvent);
		transaction.addChild(crossServerEvent);
	}

	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		catContext.remove();
	}
}
