
/***********************************************************************
 Class: CMSC203 CRN 22378
 Program: Assignment # 1
 Instructor: Professor Alexander
 Description: A Utility Class for Password Checker
 Due: 09/16/2020
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Anthony Liu
************************************************************************/

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PasswordCheckerUtility {
	/**
	 * Returns true if password is valid, Throws exceptions for invalid passwords
	 * 
	 * @param passwordString String to be checked for validity
	 * @return True if password is valid, throws a exception if password is invalid
	 * @throws LengthException             Thrown if length is less than 6
	 *                                     characters
	 * @throws NoDigitException            Thrown if there is no digit
	 * @throws NoUpperAlphaException       Thrown if there is no uppercase
	 *                                     alphabetic
	 * @throws NoLowerAlphaException       Thrown if there is no lowercase
	 *                                     alphabetic
	 * @throws NoSpecialCharacterException Thrown if there is no special character
	 * @throws InvalidSequenceException    Thrown if there is more than 2 characters
	 *                                     in sequence
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException {

		checkLength(passwordString);
		checkUppercase(passwordString);
		checkLowercase(passwordString);
		checkDigit(passwordString);
		checkSpecialCharacter(passwordString);
		checkInvalidSequence(passwordString);

		return true;

	}

	/**
	 * Return true if length of password is greater than or equal to 6 but less than
	 * equal to 9
	 * 
	 * @param passwordString String to be checked if it is weak
	 * @return True if length of password is greater than or equal to 6 but less
	 *         than or equal to 9
	 */
	public static boolean isWeakPassword(String passwordString) {
		if (passwordString.length() >= 6 && passwordString.length() <= 9) {
			return true;
		}

		return false;
	}

	/**
	 * Returns and ArrayList of invalid passwords with their exception messages.
	 * Weak passwords are not included
	 * 
	 * @param passwords ArrayList to be checked for validity
	 * @return An ArrayList of invalid passwords, not including weak ones.
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> invalidPasswords = new ArrayList<>();

		for (String s : passwords) { //Loop through arraylist and catch exceptions thrown buy current password when checked
			try {
				isValidPassword(s);
			} catch (LengthException e) {
				invalidPasswords.add(s + " " + e.getMessage());
			} catch (NoUpperAlphaException e) {
				invalidPasswords.add(s + " " + e.getMessage());
			} catch (NoLowerAlphaException e) {
				invalidPasswords.add(s + " " + e.getMessage());
			} catch (NoDigitException e) {
				invalidPasswords.add(s + " " + e.getMessage());
			} catch (NoSpecialCharacterException e) {
				invalidPasswords.add(s + " " + e.getMessage());
			} catch (InvalidSequenceException e) {
				invalidPasswords.add(s + " " + e.getMessage());
			}

		}

		return invalidPasswords;

	}

	/**
	 * Checks to see is password is long enough
	 * 
	 * @param passwordString Password which length is checked
	 * @throws LengthException Thrown if password is less than 6 characters
	 */
	private static void checkLength(String passwordString) throws LengthException {
		if (passwordString.length() < 6) {
			throw new LengthException();
		}

	}

	/**
	 * Checks if the password has a uppercase alpha character
	 * 
	 * @param passwordString Password which is searched for a uppercase alpha
	 *                       character
	 * @throws NoUpperAlphaException Thrown is no uppercase alpha is found
	 */
	private static void checkUppercase(String passwordString) throws NoUpperAlphaException {
		char[] password = passwordString.toCharArray();
		if (!Character.isUpperCase(password[0])) { // Checks if first character of char array is criteria we are
													// searching for

			boolean hasUpper = false;

			for (int i = 1; i < password.length; i++) {
				if (Character.isUpperCase(password[i])) { // If uppercase is found, set upper boolean to true and exit
															// loop
					hasUpper = true;
					break;
				}
			}

			if (!hasUpper) { // If upper not found after loop, exception is thrown
				throw new NoUpperAlphaException();
			}
		}

	}

	/**
	 * Checks if the password has a lowercase alpha character
	 * 
	 * @param passwordString Password which is searched for a lowercase alpha
	 *                       character
	 * @throws NoLowerAlphaException Thrown is no lowercase alpha character is found
	 */
	private static void checkLowercase(String passwordString) throws NoLowerAlphaException {
		char[] password = passwordString.toCharArray();
		if (!Character.isLowerCase(password[0])) { // Checks if first character fulfils requirement

			boolean hasLower = false;

			for (int i = 1; i < password.length; i++) {
				if (Character.isLowerCase(password[i])) { // If lowercase character is found, exit loop and set boolean
															// to true
					hasLower = true;
					break;
				}
			}

			if (!hasLower) { // If not found, throw exception
				throw new NoLowerAlphaException();
			}
		}

	}

	/**
	 * Checks password for a digit
	 * 
	 * @param passwordString Password to be checked for a digit
	 * @throws NoDigitException Thrown if no digit is found
	 */
	private static void checkDigit(String passwordString) throws NoDigitException {
		char[] password = passwordString.toCharArray();
		if (!Character.isDigit(password[0])) { //Check if first character is a digit

			boolean hasDigit = false;

			for (int i = 1; i < password.length; i++) {
				if (Character.isDigit(password[i])) { //If a digit is found exit the loop
					hasDigit = true;
					break;
				}
			}

			if (!hasDigit) {  //Throw a exception if digit is not found after loop 
				throw new NoDigitException();
			}
		}

	}

	/**
	 * Checks password for a special character
	 * 
	 * @param passwordString Password to be checked for a special character
	 * @throws NoSpecialCharacterException Thrown if no special character is found
	 */
	private static void checkSpecialCharacter(String passwordString) throws NoSpecialCharacterException {

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(passwordString);
		boolean specialChar = matcher.matches();

		if (specialChar) {
			throw new NoSpecialCharacterException();
		}

	}

	/**
	 * Checks if password has more than 2 subsequent characters
	 * 
	 * @param passwordString Password to be checked for subsequent characters
	 * @throws InvalidSequenceException Thrown if more than 2 subsequent characters
	 *                                  are found
	 */
	private static void checkInvalidSequence(String passwordString) throws InvalidSequenceException {

		Pattern pattern = Pattern.compile("^.*(.)\\1\\1.*$"); //
		Matcher matcher = pattern.matcher(passwordString);

		if (matcher.find()) {
			throw new InvalidSequenceException();
		}
//Solved using a for loop instead of regex. 

//		char[] password = passwordString.toCharArray();
//		
//		if (password.length >= 3) {
//			for (int i = 0; i < password.length - 2; i++) {
//				if (password[i] == password[i + 1] && password[i] == password[i + 2]) {
//					throw new InvalidSequenceException();
//			}
//		}
//		}

	}

}
