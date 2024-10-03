

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class User {
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

        Validator.displayValidationResult(firstName, "First Name");
        Validator.displayValidationResult(lastName, "Last Name");
        Validator.displayMobileValidationResult(mobileNo);
        Validator.displayPasswordValidationResult(password);

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
