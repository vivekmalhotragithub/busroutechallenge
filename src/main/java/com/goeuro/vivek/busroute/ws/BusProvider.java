/**
 * 
 */
package com.goeuro.vivek.busroute.ws;

import java.nio.file.Path;

/**
 * This class represents the Bus Provider class
 *
 */
public final class BusProvider {

	public static Path busRouteFile;

	private static BusProvider instance;

	private BusProvider(Path busRouteFile2) {
		// TODO Auto-generated constructor stub
	}

	public static BusProvider getInstance() {
		if (instance == null) {
			synchronized (BusProvider.class) {
				if (instance == null) {
					if (busRouteFile != null) {
						instance = new BusProvider(busRouteFile);
					} else {
						throw new IllegalArgumentException(
								"Bus Route File not provided");
					}

				}
			}
		}
		return instance;
	}

}
