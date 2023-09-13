package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IPBlackListChecker implements IPChecker {
	private static final String BLACKLIST_FILE = "blacklist.txt";
	private static final String ACCESS_DISALLOWED_MSG = "Access disallowed.";
	private static final String ACCESS_ALLOWED_MSG = "Access allowed.";

	@Override
	public void check(String ipAddress) {
		try {
			if (isBlacklisted(ipAddress)) {
				System.out.println(ACCESS_DISALLOWED_MSG);
			} else {
				System.out.println(ACCESS_ALLOWED_MSG);
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

	private boolean isBlacklisted(String ipAddress) throws IOException {
		Path blacklistPath = Paths.get(BLACKLIST_FILE);
		List<String> lines = Files.readAllLines(blacklistPath);

		return lines.contains(ipAddress);
	}

}
