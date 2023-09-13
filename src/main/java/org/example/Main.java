package org.example;

public class Main {
	public static void main(String[] args) {
		IPChecker ipChecker = new IPBlackListChecker();
		IPValidator ipValidator = new IPRegexValidator();
		IPCheckerService service = new IPCheckerService(ipChecker, ipValidator);
		service.run();
	}

}
