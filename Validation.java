

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// Custom exception for invalid first name
class InvalidFirstNameException extends Exception {
    public InvalidFirstNameException(String message) {
        super(message);
    }
}

// Custom exception for invalid last name
class InvalidLastNameException extends Exception {
    public InvalidLastNameException(String message) {
        super(message);
    }
}

// Custom exception for invalid email
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

// Custom exception for invalid mobile number
class InvalidMobileNumberException extends Exception {
    public InvalidMobileNumberException(String message) {
        super(message);
    }
}

// Custom exception for invalid password
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}



public class Validation {
    private static List<String> emailSamples = new ArrayList<>();

    

    public static String validateFirstName(String name)throws InvalidFirstNameException {
        if (name == null || name.isEmpty() || !name.matches("[A-Za-z]+")) {
            throw new InvalidFirstNameException("Invalid first name: " + name);
        }

        if(name.length() < 3){
            return "First name must be at least 3 character";
        }

        if(!Character.isUpperCase(name.charAt(0))){
            return "First Character must be in upper case";
        }

        for(int i = 0; i<name.length(); i++){
            if(!Character.isLetter(name.charAt(i))){
                return "name must be in character only";
            }
        }

        return "first name is valid";
    }

    public static String validateLastName(String lastName) throws InvalidLastNameException {

        if (lastName == null || lastName.isEmpty() || !lastName.matches("[A-Za-z]+")) {
            throw new InvalidLastNameException("Invalid last name: " + lastName);
        }

       
        if (lastName.length() < 3) {
            return "Last name must be at least 3 characters long.";
        }

        if (!Character.isUpperCase(lastName.charAt(0))) {
            return "Last name must start with a capital letter.";
        }

        for (int i = 0; i < lastName.length(); i++) {
            if (!Character.isLetter(lastName.charAt(i))) {
                return "Last name should only contain alphabetical characters.";
            }
        }

        return "Last name is valid.";
    }


    public static String validateEmail(String email) throws InvalidEmailException {

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email == null || !email.matches(emailRegex)) {
            throw new InvalidEmailException("Invalid email: " + email);
        }
        String emailPattern = "^[a-zA-Z]+(\\.[a-zA-Z]+)?@[a-zA-Z]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return "Email is valid.";
        } else {
            return "Invalid email format. Expected format: abc.xyz@bl.co.in";
        }
    }


    public static String validateMobileNumber(String mobileNumber)  throws InvalidMobileNumberException {

        if (mobileNumber == null || !mobileNumber.matches("\\d{10}")) {
            throw new InvalidMobileNumberException("Invalid mobile number: " + mobileNumber);
        }

        String mobilePattern = "^\\d{2} \\d{10}$";

        Pattern pattern = Pattern.compile(mobilePattern);
        Matcher matcher = pattern.matcher(mobileNumber);

        if (matcher.matches()) {
            return "Mobile number is valid.";
        } else {
            return "Invalid mobile number format. Expected format: 91 9919819801";
        }
    }

    public static String validatePassword(String password) throws InvalidPasswordException {

        if (password == null || password.length() < 6) {
            throw new InvalidPasswordException("Invalid password: " + password);
        }

        //Rule 1: password must have minimum 8 length
        if (password.length() < 8) {
            return "Password must be at least 8 characters long.";
        }

        //Rule 2: Password must contain at least one uppercase
        boolean hasUpperCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
                break;
            }
        }
        if (!hasUpperCase) {
            return "Password must contain at least one uppercase letter.";
        }

        // Rule 3: Password must contain at least one numeric digit
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            return "Password must contain at least one numeric digit.";
        }

        // Rule 4: Password must contain exactly one special character
        String specialCharacters = "!@#$%^&*()-+";
        int specialCharCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (specialCharacters.contains(Character.toString(password.charAt(i)))) {
                specialCharCount++;
            }
        }
        if (specialCharCount != 1) {
            return "Password must contain exactly one special character.";
        }


        return "Password is valid.";
    }


    public static void clearEmailSamples() {
        emailSamples.clear();
        System.out.println("All email samples have been cleared.");
    }
    public static void main(String[] args)  {
        Scanner sc =new Scanner(System.in);
        //Ramkumar Dehariya ramkumardehariya26@gamil.com

        //firstName
        System.out.println("Enter your firstName name: ");
        String firstName = sc.nextLine();
        try {
            String result = validateFirstName(firstName);
            System.out.println(result);
        } catch (InvalidFirstNameException e) {
            System.out.println("firstName exception: "+e.getMessage());
        }


        // String result = "";

        //lastName
        System.out.println("Enter your lastName name: ");
        String lastName = sc.nextLine();

        try {
            String result = validateLastName(lastName);
            System.out.println(result);
        } catch (InvalidLastNameException e) {
            System.out.println("lastName exception: "+e.getMessage());
        }


        // email
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        try {
            String result = Validation.validateEmail(email);
            System.out.println(result);
        } catch (InvalidEmailException e) {
            System.out.println("eamil exeption: "+e.getMessage());
        }


        // mobile number
        System.out.print("Enter your mobile number: ");
        String mobileNumber = sc.nextLine();
        try{
            String result = validateMobileNumber(mobileNumber);
            System.out.println(result);
        }catch (InvalidMobileNumberException e) {
            System.out.println("mobile number exception exeption: "+e.getMessage());
        }

        // password
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        try{
            String result = validatePassword(password);
            System.out.println(result);
        }catch (InvalidPasswordException e) {
            System.out.println("password exeption: "+e.getMessage());
        }


        String choice;
        do {
            System.out.println("1. Validate Email");
            System.out.println("2. Clear Email Samples");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter your email: ");
                    email = sc.nextLine();
                    try{
                        String result = validateEmail(email);
                        System.out.println(result);
                    }catch (InvalidEmailException e) {
                        System.out.println("eamil exeption: "+e.getMessage());
                    }
                    break;
                case "2":
                    clearEmailSamples();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("3"));
    }
}
