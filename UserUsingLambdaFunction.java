

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class UserUsingLambdaFunction{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter First Name: ");
		String firstName = sc.nextLine();

		System.out.print("Enter Last Name: ");
		String lastName = sc.nextLine();

		System.out.print("Enter Mobile Number: ");
		String mobileNo = sc.nextLine();

		System.out.print("Enter Password: ");
		String password = sc.nextLine();

		validateInput(firstName, name -> name.matches("[A-Z][a-zA-Z]{2,}"), "Invalid First Name");

		validateInput(lastName, name -> name.matches("[A-Z][a-zA-Z]{2,}"), "Invalid Last Name");

		validateInput(mobileNo, mobile -> mobile.matches("91 \\d{10}"), "Invalid Mobile Number");

		validateInput(password, pass -> pass.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$"),
				"Invalid Password");

		System.out.print("Enter Email Samples (comma-separated): ");
		String emailInput = sc.nextLine();
		String[] emailSamples = emailInput.split(",");

		List<String> emailList = new ArrayList<>();
		for (String email : emailSamples) {
			emailList.add(email.trim());
		}

		List<String> validEmails = clearInvalidEmails(emailList,
				email -> email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"));

		System.out.println("Valid Emails: " + validEmails);

		sc.close();
	}

	public static void validateInput(String input, Predicate<String> validator, String errorMessage) {
		if (!validator.test(input)) {
			System.out.println(errorMessage + ": " + input);
		} else {
			System.out.println("Valid " + errorMessage.substring(7));
		}
	}

	public static List<String> clearInvalidEmails(List<String> emailSamples, Predicate<String> emailValidator) {
		List<String> validEmails = new ArrayList<>();
		for (String email : emailSamples) {
			if (emailValidator.test(email)) {
				validEmails.add(email);
			} else {
				System.out.println("Invalid Email: " + email);
			}
		}
		return validEmails;
	}
}
