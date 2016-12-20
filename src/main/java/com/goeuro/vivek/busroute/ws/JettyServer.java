package com.goeuro.vivek.busroute.ws;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * 
 * Main class to startup a jetty instance
 *
 */
public class JettyServer {

	public static void main(String[] args) throws Exception {

		if (isBusRouteFileExist(args)) {
			BusProvider.busRouteFile = Paths.get(args[0]);
		} else {
			throw new IllegalArgumentException(
					"Expecting a bus route file! exiting ...");
		}

		ResourceConfig config = new ResourceConfig();
		config.packages("com.goeuro.vivek.busroute.ws");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(8088);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}

	// check if a Bus Route File is provided
	private static boolean isBusRouteFileExist(String[] args) {
		if (args.length != 1) {
			return false;
		} else {
			Path busRouteFile = Paths.get(args[0]);
			if (!Files.exists(busRouteFile)) {
				return false;
			}
		}
		
		return true;

	}
}
