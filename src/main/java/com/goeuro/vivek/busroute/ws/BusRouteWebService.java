package com.goeuro.vivek.busroute.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 * Web Service 
 *
 */
@Path("api")
public class BusRouteWebService 
{

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";
	}
}
