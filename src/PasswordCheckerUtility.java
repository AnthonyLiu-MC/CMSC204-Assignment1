import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PasswordCheckerUtility {

	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException {

		if (passwordString.length() < 6) {
			throw new LengthException();
		}

		char[] password = passwordString.toCharArray();

		if (!Character.isUpperCase(password[0])) {

			boolean hasUpper = false;

			for (int i = 1; i < password.length; i++) {
				if (Character.isUpperCase(password[i])) {
					hasUpper = true;
					break;
				}
			}

			if (!hasUpper) {
				throw new NoUpperAlphaException();
			}
		}

		if (!Character.isLowerCase(password[0])) {

			boolean hasLower = false;

			for (int i = 1; i < password.length; i++) {
				if (Character.isLowerCase(password[i])) {
					hasLower = true;
					break;
				}
			}

			if (!hasLower) {
				throw new NoLowerAlphaException();
			}
		}

		if (!Character.isDigit(password[0])) {

			boolean hasDigit = false;

			for (int i = 1; i < password.length; i++) {
				if (Character.isDigit(password[i])) {
					hasDigit = true;
					break;
				}
			}

			if (!hasDigit) {
				throw new NoDigitException();
			}
		}

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(passwordString);
		boolean specialChar = !matcher.matches();

		if (!specialChar) {
			throw new NoSpecialCharacterException();
		}

		for (int i = 0; i < password.length - 2; i++) {
			if (password[i] == password[i + 1] && password[i] == password[i + 2]) {
				throw new InvalidSequenceException();
			}
		}

		return true;
	}

	public static boolean isWeakPassword(String passwordString) {
		if (passwordString.length() >= 6 && passwordString.length() <= 9) {
			return true;
		}

		return false;
	}

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> invalidPasswords = new ArrayList<>();

		for (String s : passwords) {
			try {
				isValidPassword(s);
			} catch (LengthException e) {
				invalidPasswords.add(s + "->" + e.getMessage());
			} catch (NoUpperAlphaException e) {
				invalidPasswords.add(s + "->" + e.getMessage());
			} catch (NoLowerAlphaException e) {
				invalidPasswords.add(s + "->" + e.getMessage());
			} catch (NoDigitException e) {
				invalidPasswords.add(s + "->" + e.getMessage());
			} catch (NoSpecialCharacterException e) {
				invalidPasswords.add(s + "->" + e.getMessage());
			} catch (InvalidSequenceException e) {
				invalidPasswords.add(s + "->" + e.getMessage());
			}

		}

		return invalidPasswords;

	}

}
