import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {

	public static void main(String[] args) throws LengthException, NoUpperAlphaException, NoDigitException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException {
		// TODO Auto-generated method stub
		String[] p = { "334455BB", "LOWERCASE", "Im2cool4U", "george2ZZZ@", "4sale", "bertha22", "4wardMarch", "august30", "abcdef",
				"Applesxx", "aa11b", "pilotProject", "myPassword", "myPassword2" };
		ArrayList<String>passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
		

		
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		Scanner scan = new Scanner(results.get(2)); //
		
		System.out.println(scan.nextLine());
	}

}

