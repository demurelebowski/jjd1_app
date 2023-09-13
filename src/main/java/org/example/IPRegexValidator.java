package org.example;

public class IPRegexValidator implements IPValidator {
	private static final String INVALID_IP_MSG = "Invalid IP address.";

	@Override
	public boolean isValidIPAddress(String ipAddress) {
		if (ipAddress != null && ipAddress.matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b")) {
			return true;
		}
		System.out.println(INVALID_IP_MSG);
		return false;
	}
}
