public class UserValidation {

    // Validate First Name
    public static boolean validateFirstName(String firstName) {
        return firstName != null && firstName.length() >= 3 && Character.isUpperCase(firstName.charAt(0));
    }

    // Validate Last Name
    public static boolean validateLastName(String lastName) {
        return lastName != null && lastName.length() >= 3 && Character.isUpperCase(lastName.charAt(0));
    }

    // Validate Email
    public static boolean validateEmail(String email) {
        // Regular expression to validate the specified email format
        String emailPattern = "^[a-zA-Z]+(\\.[a-zA-Z]+)?@[a-zA-Z]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$";
        return email != null && email.matches(emailPattern);
    }

    // Validate Mobile Number
    public static boolean validateMobileNumber(String mobileNumber) {
        String mobilePattern = "^\\d{2} \\d{10}$";
        return mobileNumber != null && mobileNumber.matches(mobilePattern);
    }

    // Validate Password
    public static boolean validatePassword(String password) {

        if(password == null){
            return false;
        }
        if (password.length() < 8) return false;

        boolean hasUpperCase = false;
        boolean hasDigit = false;
        int specialCharCount = 0;
        String specialCharacters = "!@#$%^&*()-+";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (specialCharacters.contains(String.valueOf(c))) specialCharCount++;
        }

        return hasUpperCase && hasDigit && specialCharCount == 1;
    }
}
