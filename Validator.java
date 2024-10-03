

import java.util.ArrayList;
import java.util.List;

class Validator {
    public static boolean isValidName(String name) {
        return name.matches("[A-Z][a-zA-Z]{2,}");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-z0-9]+(\\.[a-z0-9]+)?@[a-z0-9]+(\\.[a-z]{2,}){1,2}$");
    }

 public static boolean isValidMobileNo(String mobileNo) {
        return mobileNo.matches("91 \\d{10}");
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9])(?!.*[^a-zA-Z0-9].*[^a-zA-Z0-9]).{8,}$";
        return password.matches(regex);
    }

    public static void displayValidationResult(String name, String nameType) {
        if (isValidName(name)) {
            System.out.println("Valid " + nameType);
        } else {
            System.out.println("Invalid " + nameType);
        }
    }

    public static void displayEmailValidationResult(String email) {
        if (isValidEmail(email)) {
            System.out.println("Valid Email: " + email);
        } else {
            System.out.println("Invalid Email: " + email);
        }
    }

    public static List<String> clearInvalidEmails(List<String> emailSamples) {
        List<String> validEmails = new ArrayList<>();
        for (String email : emailSamples) {
            if (isValidEmail(email)) {
                validEmails.add(email);
            }
        }
        return validEmails;
    }

    public static void displayMobileValidationResult(String mobileNo) {
        if (isValidMobileNo(mobileNo)) {
            System.out.println("Valid MobileNo");
        } else {
            System.out.println("Invalid MobileNo");
        }
    }

    public static void displayPasswordValidationResult(String password) {
        if (isValidPassword(password)) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
    }
}
