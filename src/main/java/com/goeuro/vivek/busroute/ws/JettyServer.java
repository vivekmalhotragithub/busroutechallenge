package com.goeuro.vivek.busroute.ws;

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

}
