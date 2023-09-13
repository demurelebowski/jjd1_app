package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IPCheckerService {
	private static final String ENTER_IP_MSG = "Enter IP address or 'quit' to exit";
	private static final String QUIT_MSG = "quit";

	private final IPChecker ipChecker;
	private final IPValidator ipValidator;

	public IPCheckerService(IPChecker ipChecker, IPValidator ipValidator) {
		this.ipChecker = ipChecker;
		this.ipValidator = ipValidator;
	}

	public void run() {
		System.out.println(ENTER_IP_MSG);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String ipAddress;
			while (!QUIT_MSG.equalsIgnoreCase(ipAddress = reader.readLine()
					.trim())) {
				if (ipValidator.isValidIPAddress(ipAddress)) {
					ipChecker.check(ipAddress);
				}
				System.out.println(ENTER_IP_MSG);
			}
		} catch (IOException e) {
			System.out.println("Error reading input: " + e.getMessage());
		}
	}

}
