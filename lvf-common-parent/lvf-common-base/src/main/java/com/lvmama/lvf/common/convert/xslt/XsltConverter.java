package com.lvmama.lvf.common.convert.xslt;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.pool.KeyedObjectPool;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.convert.Binding;
import com.lvmama.lvf.common.convert.Converter;
import com.lvmama.lvf.common.convert.exception.ResourceNotExistException;
import com.lvmama.lvf.common.trace.TraceContext;

public class XsltConverter implements Converter {
	
	private String xslt;
	private Binding<String> binding;
	
	private static Logger logger = LoggerFactory.getLogger(XsltConverter.class);
	
	private static TransformerFactory transformerFactory = TransformerFactory.newInstance();
	
	private static ConcurrentHashMap<Class<?>,JAXBContext> contexts = new ConcurrentHashMap<Class<?>,JAXBContext>();
	
    public static JAXBContext getContext(Object key) throws Exception {
        Class<?> clazz = (Class<?>)key;
        if(!contexts.containsKey(clazz)){
            JAXBContext context = JAXBContext.newInstance(clazz);
            contexts.put(clazz, context);
        }
        return contexts.get(clazz);
    }
	
	public XsltConverter(String xsltFile,Binding<String> binding) throws Exception {
		InputStream inputStream =this.getClass().getResourceAsStream(xsltFile);
		if(null==inputStream){
			throw new ResourceNotExistException(xsltFile+" not exist!");
		}
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		inputStream.close();
		xslt=new String(bytes,"UTF-8");
		this.binding=binding;
	}
	
	public XsltConverter(StringBuffer xsltString, Binding<String> binding) throws Exception {
		xslt = String.valueOf(xsltString);
		this.binding = binding;
	}

	public XsltConverter() {
		// TODO Auto-generated constructor stub
	}

	public <S, T> T to(S s, Class<T> t) throws Exception {
		return to(s,t,null);
	}
	
	public <S,T> String toXml(S s,String t) throws Exception {
		return toXml(s,t,null);
	}
	
	@Override
	public <S, T> T to(S s, Class<T> t, String prefix) throws Exception {
		Long start = System.currentTimeMillis();
//		logger.error(TraceContext.getTraceId()+" convertxml start to!");
		JAXBContext context = getContext(t);
//		logger.error(TraceContext.getTraceId()+" convertxml start JAXBContext.newInstance!"+(System.currentTimeMillis()-start));
		Unmarshaller unmarshaller=context.createUnmarshaller();
//		logger.error(TraceContext.getTraceId()+" convertxml unmarshaller create : "+(System.currentTimeMillis()-start));
		T r = (T) unmarshaller.unmarshal(new StringReader(toXml(s)));
//		logger.error(TraceContext.getTraceId()+" convertxml unmarshal end : "+(System.currentTimeMillis()-start));
		return r;
	}

	@Override
	public <S, T> String toXml(S s, String t, String prefix) throws Exception {
		return toXml(s);
	}

	public <S,T> String toXml(S s) throws Exception {
		
		Long start = System.currentTimeMillis();
		
		String  sourceStr=null;
		
		if(s instanceof String){
			sourceStr=s+"";
		}else{
//			logger.error(TraceContext.getTraceId()+" convertxml start toXml:"+(System.currentTimeMillis()-start));
			JAXBContext context = getContext(s.getClass());
//			logger.error(TraceContext.getTraceId()+" convertxml start toXml JAXBContext.newInstance:"+(System.currentTimeMillis()-start));
			Marshaller jaxbMarshaller = context.createMarshaller();
//			logger.error(TraceContext.getTraceId()+" convertxml marshaller create :"+(System.currentTimeMillis()-start));
			StringWriter writer = new StringWriter();
			jaxbMarshaller.marshal(s, writer);
//			logger.error(TraceContext.getTraceId()+" convertxml marshaller end :"+(System.currentTimeMillis()-start));
			sourceStr =writer.toString();
		}
		
		StreamSource source = new StreamSource(new StringReader(sourceStr));
		StringWriter resultWriter = new StringWriter();
		StreamResult result = new StreamResult(resultWriter);
		
//		logger.error(TraceContext.getTraceId()+" convertxml transformer start toXml:"+(System.currentTimeMillis()-start));
		Transformer transformer = 
				transformerFactory.newTransformer(
						new StreamSource(new StringReader(xslt)));
//		logger.error(TraceContext.getTraceId()+" convertxml transformer create toXml:"+(System.currentTimeMillis()-start));
		transformer.transform(source,result);
//		logger.error(TraceContext.getTraceId()+" convertxml transformer transform end toXml:"+(System.currentTimeMillis()-start));
		return binding(result.getWriter().toString());
	}

	private String binding(String xml){
		if(null==binding){
			return xml;
		}
		return binding.binding(xml);
	}

}
