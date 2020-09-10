
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @Anthony Liu
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	@Before
	public void setUp() throws Exception {
		String[] password = { "abcABC123@", "uppercase", "LOWERCASE", "NoDigits", "NoSpecialCharacter1",
				"IncorrrectSequence1!", "small", "WeakPW1!" };
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(password));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;

	}

	/**
	 * Test if the password is less than 6 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC123@"));
			PasswordCheckerUtility.isValidPassword("abc12");
			assertTrue("Did not throw lengthException", false);
		} catch (LengthException e) {
			assertTrue("Successfully threw a LengthException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead of LengthException", false);
		}
	}

	

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC123!"));
			PasswordCheckerUtility.isValidPassword("aaaaaaaaa");
			assertTrue("Did not throw NoUpperAlphaException", false);
		} catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead of NoUpperAlphaException", false);
		}
	}
	

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC123@"));
			PasswordCheckerUtility.isValidPassword("ABCDEF");
			assertTrue("Did not throw a NoLowerAlphaException", false);
		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead on NoLowerAlphaException", false);
		}
	}

	/**
	 * Test if the password is a weak password
	 * Test should not throw an exception if it is only weak
	 */
	@Test
	public void testIsWeakPassword() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("abcABC12!"));
			boolean weakPassword = PasswordCheckerUtility.isWeakPassword("abcABC12!");
			assertTrue(weakPassword);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Wrong exception thrown", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC1233@"));
			PasswordCheckerUtility.isValidPassword("abcABC12333@");
			assertTrue("Did not throw InvalidSequenceException", false);
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a InvalidSequenceException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead of InvalidSequenceException", false);
		}
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC123@"));
			PasswordCheckerUtility.isValidPassword("abcABC");
			assertTrue("Did not throw NoDigitException", false);
		} catch (NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead of InvalidSequenceException", false);
		}
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			PasswordCheckerUtility.isValidPassword("abcABC123@");
			PasswordCheckerUtility.isValidPassword("Password123!");
			PasswordCheckerUtility.isValidPassword("AczasC231@");
			assertTrue("No exceptions thrown", true);		
		} catch (Exception e) {
			assertTrue("Should not have thrown any exceptions", false);
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 * 
	 * Each scan checks if the password matches the exception message
	 * 
	 * Correct and Weak passwords are omitted. 
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "uppercase");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));

		scan = new Scanner(results.get(1)); 
		assertEquals(scan.next(), "LOWERCASE");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("one lowercase"));

		scan = new Scanner(results.get(2)); 
		assertEquals(scan.next(), "NoDigits");
		System.out.println(scan.next());
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));

		scan = new Scanner(results.get(3)); 
		assertEquals(scan.next(), "NoSpecialCharacter1");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special"));

		scan = new Scanner(results.get(4)); 
		assertEquals(scan.next(), "IncorrrectSequence1!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence"));
		
		scan = new Scanner(results.get(5)); 
		assertEquals(scan.next(), "small");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		

	}

}