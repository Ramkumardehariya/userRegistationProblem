import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {

    @Test
    public void testValidFirstName() throws InvalidFirstNameException {
        assertTrue(UserValidation.validateFirstName("John"));
    }

    @Test
    public void testValidLastName() throws InvalidLastNameException{
        assertTrue(UserValidation.validateLastName("Doe"));
    }

    @Test
    public void testValidEmail() throws InvalidEmailException {
        assertTrue(UserValidation.validateEmail("abc.xyz@bl.co.in"));
    }
    

    @Test
    public void testValidMobileNumber() throws InvalidMobileNumberException {
        assertTrue(UserValidation.validateMobileNumber("91 9919819801"));
    }

    @Test
    public void testValidPassword() throws InvalidPasswordException {
        assertTrue(UserValidation.validatePassword("Password1!"));
    }

    // Sad Test Cases

    @Test
    public void testInvalidFirstName() {
        Exception exception = assertThrows(InvalidFirstNameException.class, () -> {
            Validation.validateFirstName("123");
        });

        assertEquals("Invalid first name: 123", exception.getMessage());
        assertFalse(UserValidation.validateFirstName("jo"));
        assertFalse(UserValidation.validateFirstName("john")); // Should start with capital letter
        assertFalse(UserValidation.validateFirstName(null)); // Null check
    }

    @Test
    public void testInvalidLastName() {
        Exception exception = assertThrows(InvalidLastNameException.class, () -> {
            Validation.validateLastName("");
        });
        assertEquals("Invalid last name: ", exception.getMessage());
        assertFalse(UserValidation.validateLastName("do"));
        assertFalse(UserValidation.validateLastName("doe")); // Should start with capital letter
        assertFalse(UserValidation.validateLastName(null)); // Null check
    }

    @Test
    public void testInvalidEmail() {
        Exception exception = assertThrows(InvalidEmailException.class, () -> {
            Validation.validateEmail("abc@bl");
        });

        assertEquals("Invalid email: abc@bl", exception.getMessage());
        assertFalse(UserValidation.validateEmail("abc@bl.c")); // Invalid TLD
        assertFalse(UserValidation.validateEmail("abc.xyz@bl")); // Missing TLD
        assertFalse(UserValidation.validateEmail("abc.xyz@.com")); // Invalid format
        assertFalse(UserValidation.validateEmail("abc@bl.co"));
        assertFalse(UserValidation.validateEmail(null)); // Null check
    }

    @Test
    public void testInvalidMobileNumber() {
        Exception exception = assertThrows(InvalidMobileNumberException.class, () -> {
            Validation.validateMobileNumber("12345");
        });
        assertEquals("Invalid mobile number: 12345", exception.getMessage());
        assertFalse(UserValidation.validateMobileNumber("919919819801")); // No space
        assertFalse(UserValidation.validateMobileNumber("91 991981980")); // Less than 10 digits
        assertFalse(UserValidation.validateMobileNumber(null)); // Null check
    }

    @Test
    public void testInvalidPassword() {

        Exception exception = assertThrows(InvalidPasswordException.class, () -> {
            Validation.validatePassword("123");
        });
        assertEquals("Invalid password: 123", exception.getMessage());
        assertFalse(UserValidation.validatePassword("pass")); // Too short
        assertFalse(UserValidation.validatePassword("password123")); // No uppercase
        assertFalse(UserValidation.validatePassword("Password")); // No digit
        assertFalse(UserValidation.validatePassword("Password1")); // No special character
        assertFalse(UserValidation.validatePassword("Password!!1")); // More than 1 special character
        assertFalse(UserValidation.validatePassword(null)); // Null check
    }
}
