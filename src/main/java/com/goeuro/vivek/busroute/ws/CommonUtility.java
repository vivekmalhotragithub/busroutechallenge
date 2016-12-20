/**
 * 
 */
package com.goeuro.vivek.busroute.ws;

/**
 * @author vivekmalhotra
 *
 */
public final class CommonUtility {

	public static boolean isEmpty(String sCheck) {
		if (sCheck == null || "".equals(sCheck)) {
			return true;
		}
		return false;
	}

	public static boolean isInteger(String sCheck) {
		try {
			Integer.parseInt(sCheck);
		} catch (NumberFormatException ex) {
			return false;
		}

		return true;
	}
}
