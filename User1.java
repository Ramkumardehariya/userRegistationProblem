

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User1 {
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

        try {
            Validator1.validateFirstName(firstName);
            System.out.println("Valid First Name");
        } catch (InvalidFirstNameException e) {
            System.err.println(e.getMessage());
        }

        try {
            Validator1.validateLastName(lastName);
            System.out.println("Valid Last Name");
        } catch (InvalidLastNameException e) {
            System.err.println(e.getMessage());
        }

        try {
            Validator1.validateMobileNo(mobileNo);
            System.out.println("Valid Mobile Number");
        } catch (InvalidMobileNoException e) {
            System.err.println(e.getMessage());
        }

        try {
            Validator1.validatePassword(password);
            System.out.println("Valid Password");
        } catch (InvalidPasswordException e) {
            System.err.println(e.getMessage());
        }

        System.out.print("Enter Email Samples (comma-separated): ");
        String emailInput = sc.nextLine();
        String[] emailSamples = emailInput.split(",");

        List<String> emailList = new ArrayList<>();
        for (String email : emailSamples) {
            emailList.add(email.trim());
        }

        List<String> validEmails = Validator.clearInvalidEmails(emailList);
        System.out.println("Valid Emails: " + validEmails);

        sc.close();
    }
}
