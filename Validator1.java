

import java.util.ArrayList;
import java.util.List;

class InvalidFirstNameException extends Exception {
	public InvalidFirstNameException(String message) {
		super(message);
	}
}

class InvalidLastNameException extends Exception {
	public InvalidLastNameException(String message) {
		super(message);
	}
}

class InvalidEmailException extends Exception {
	public InvalidEmailException(String message) {
		super(message);
	}
}

class InvalidMobileNoException extends Exception {
	public InvalidMobileNoException(String message) {
		super(message);
	}
}

class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String message) {
		super(message);
	}
}

public class Validator1 {

	public static void validateFirstName(String firstName) throws InvalidFirstNameException {
		if (!firstName.matches("[A-Z][a-zA-Z]{2,}")) {
			throw new InvalidFirstNameException("Invalid First Name: " + firstName);
		}
	}

	public static void validateLastName(String lastName) throws InvalidLastNameException {
		if (!lastName.matches("[A-Z][a-zA-Z]{2,}")) {
			throw new InvalidLastNameException("Invalid Last Name: " + lastName);
		}
	}

	public static void validateEmail(String email) throws InvalidEmailException {
	   
	    if (!email.matches("^[a-z0-9]+(\\\\.[a-z0-9]+)?@[a-z0-9]+(\\\\.[a-z]{2,}){1,2}$")) {
	        throw new InvalidEmailException("Invalid Email: " + email);
	    }
	}

	

	public static void validateMobileNo(String mobileNo) throws InvalidMobileNoException {
		if (!mobileNo.matches("91 \\d{10}")) {
			throw new InvalidMobileNoException("Invalid Mobile Number: " + mobileNo);
		}
	}

	public static void validatePassword(String password) throws InvalidPasswordException {
		String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9])(?!.*[^a-zA-Z0-9].*[^a-zA-Z0-9]).{8,}$";
		if (!password.matches(regex)) {
			throw new InvalidPasswordException("Invalid Password: " + password);
		}
	}

	public static List<String> clearInvalidEmails(List<String> emailSamples) {
		List<String> validEmails = new ArrayList<>();
		for (String email : emailSamples) {
			try {
				validateEmail(email);
				validEmails.add(email);
			} catch (InvalidEmailException e) {
				System.out.println(e.getMessage());
			}
		}
		return validEmails;
	}
}
