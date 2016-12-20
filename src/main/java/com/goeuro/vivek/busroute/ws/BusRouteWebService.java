package com.goeuro.vivek.busroute.ws;

import java.net.HttpURLConnection;
import java.nio.file.Paths;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Web Service
 *
 */
@Path("api")
public class BusRouteWebService {

	@GET
	@Path("direct")
	@Produces(MediaType.APPLICATION_JSON)
	public String helloWorld(@QueryParam(value = "dep_sid") String departureId,
			@QueryParam(value = "arr_sid") String arrivalId) {

		// validate 
		if (CommonUtility.isEmpty(departureId)
				|| CommonUtility.isEmpty(arrivalId)
				|| !CommonUtility.isInteger(departureId)
				|| !CommonUtility.isInteger(arrivalId)) {
			throw new BadRequestException(
					Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
							.entity("{ \"errorMsg\" : \"please provide a valid integer as query param in dep_sid and arr_sid\"} ")
							.build());
		}

		// prepare the json
		StringBuilder sbuilder = new StringBuilder();
		// start json
		sbuilder.append("{");
		sbuilder.append("\"dep_sid\" : " + departureId + " ,");
		sbuilder.append("\"arr_sid\" : " + arrivalId);
		// end json
		sbuilder.append("}");
		return sbuilder.toString();
	}
}
