package com.lvmama.lvfit.adapter.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.comm.pet.po.pub.ComIps;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvfit.adapter.util.LvfComIpsAreaData;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.vst.pet.adapter.ComIpsServiceAdapter;

@Component
@Path("")
public class ComIpsResource {

	private static final Logger logger = LoggerFactory.getLogger(CommHeaderResource.class);
	
    @Autowired
    private ComIpsServiceAdapter comIpsServiceAdapter;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(VstClientPath.Path.GET_COM_IPS)
    public Response getComIps(String ip)  {
    	ComIps comIps = null;
    	try{
    		comIps = LvfComIpsAreaData.selectComIpsAreaByIp(Long.valueOf(ip), comIpsServiceAdapter); 
    	}catch(Exception ex){
    		logger.error(ex.getMessage(),ex);
    		throw new ExceptionWrapper("Ip获取头异常:"+ex.getMessage());
    	}
    	if(comIps == null){
    		return Response.ok(new ComIps()).build();
    	}
       return Response.ok(comIps).build();
    }
	
}
