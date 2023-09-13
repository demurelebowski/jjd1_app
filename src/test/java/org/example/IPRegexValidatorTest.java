package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IPRegexValidatorTest {
	private IPValidator validator;

	@BeforeEach
	void setUp() {
		validator = new IPRegexValidator();
	}

	@Test
	public void testValidIPAddress() {
		assertTrue(validator.isValidIPAddress("192.168.0.1"));
		assertTrue(validator.isValidIPAddress("77.2.0.12"));
		assertTrue(validator.isValidIPAddress("128.0.0.1"));

	}

	@Test
	public void testInvalidIPAddress_withLetters() {
		assertFalse(validator.isValidIPAddress("q.0.0.1"));
		assertFalse(validator.isValidIPAddress("ip"));

	}

	@Test
	public void testInvalidIPAddress_withIncompleteIP() {
		assertFalse(validator.isValidIPAddress("192.168.0"));
		assertFalse(validator.isValidIPAddress("192.168.0."));
		assertFalse(validator.isValidIPAddress("192.168.."));
	}

	@Test
	public void testInvalidIPAddress_withEmptyString() {
		assertFalse(validator.isValidIPAddress(""));
	}

	@Test
	public void testInvalidIPAddress_withNullParameter() {
		assertFalse(validator.isValidIPAddress(null));
	}
}
