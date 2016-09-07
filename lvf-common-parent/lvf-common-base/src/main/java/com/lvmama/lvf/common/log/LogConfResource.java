package com.lvmama.lvf.common.log;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Path("/logconf")
@Component("logConfResource")
public class LogConfResource {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/log/package/{className}/{level}")
    public Response index(@PathParam("className") String className, @PathParam("logLevel") String logLevel) {
        Level level = Level.toLevel(logLevel);
        Logger logger = LogManager.getLogger(className);
        logger.setLevel(level);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/log/root/{logLevel}")
    public Response index(@PathParam("logLevel") String logLevel) {
        Level level = Level.toLevel(logLevel);
        LogManager.getRootLogger().setLevel(level);
        return Response.ok().build();
    }

}
