

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
	 @Test
	    public void testValidFirstName() {
	        assertTrue(Validator.isValidName("John"));
	        assertTrue(Validator.isValidName("Alice"));
	    }

	    @Test
	    public void testInvalidFirstName() {
	        assertFalse(Validator.isValidName("jo"));
	        assertFalse(Validator.isValidName("j"));
	        assertFalse(Validator.isValidName("john123"));
	        assertFalse(Validator.isValidName(" john")); 
	        assertFalse(Validator.isValidName("john ")); 
	    }

	    @Test
	    public void testValidLastName() {
	        assertTrue(Validator.isValidName("Doe"));
	        assertTrue(Validator.isValidName("Smith"));
	    }

	    @Test
	    public void testInvalidLastName() {
	        assertFalse(Validator.isValidName("doe"));
	        assertFalse(Validator.isValidName("d"));
	        assertFalse(Validator.isValidName("doe123"));
	        assertFalse(Validator.isValidName(" doe")); 
	        assertFalse(Validator.isValidName("doe ")); 
	    }

	    @Test
	    public void testValidEmail() {
	        assertTrue(Validator.isValidEmail("john.doe@example.com"));
	        assertTrue(Validator.isValidEmail("user123@domain.org"));
	    }

	    @Test
	    public void testInvalidEmail() {
	        assertFalse(Validator.isValidEmail("invalid-email"));
	        assertFalse(Validator.isValidEmail("user@.com"));
	        assertFalse(Validator.isValidEmail("@domain.com"));
	        assertFalse(Validator.isValidEmail("user@domain..com"));
	        assertFalse(Validator.isValidEmail(" user@domain.com"));
	        assertFalse(Validator.isValidEmail("user@domain.com "));
	        assertFalse(Validator.isValidEmail("User123@domain.org"));
	    }

	    @Test
	    public void testValidMobileNumber() {
	        assertTrue(Validator.isValidMobileNo("91 1234567890"));
	        assertTrue(Validator.isValidMobileNo("91 9876543210"));
	    }

	    @Test
	    public void testInvalidMobileNumber() {
	        assertFalse(Validator.isValidMobileNo("91 12345")); 
	        assertFalse(Validator.isValidMobileNo("1234567890")); 
	        assertFalse(Validator.isValidMobileNo("91 12345678901"));
	        assertFalse(Validator.isValidMobileNo("91 123456abc")); 
	    }

	    @Test
	    public void testValidPassword() {
	        assertTrue(Validator.isValidPassword("Abc@1234"));
	        assertTrue(Validator.isValidPassword("Valid1@Password"));
	    }

	    @Test
	    public void testInvalidPassword() {
	        assertFalse(Validator.isValidPassword("abc12345")); 
	        assertFalse(Validator.isValidPassword("ABC12345"));
	        assertFalse(Validator.isValidPassword("Abcdefgh"));
	        assertFalse(Validator.isValidPassword("Abc@1@34")); 
	        assertFalse(Validator.isValidPassword("Ab1@")); 
	    }
	 
	    @ParameterizedTest
	    @ValueSource(strings = {
	        "john.doe@example.com",
	        "user123@domain.org",
	        "alice.smith@service.co.in",
	        "abc.def@company.net"
	    })
	    public void testValidEmailParameterized(String email) {
	        assertTrue(Validator.isValidEmail(email), "The email should be valid: " + email);
	    }

	    
	    @ParameterizedTest
	    @ValueSource(strings = {
	        "invalid-email",
	        "user@.com",
	        "@domain.com",
	        "user@domain..com",
	        " user@domain.com", 
	        "user@domain.com "  
	    })
	    public void testInvalidEmailParameterized(String email) {
	        assertFalse(Validator.isValidEmail(email), "The email should be invalid: " + email);
	    }

	    
	    @ParameterizedTest
	    @CsvSource({
	        "'john.doe@example.com', true", 
	        "'user@domain.com', true",
	        "'invalid-email', false",
	        "'user@.com', false",
	        "'user@domain..com', false",
	        "' user@domain.com', false",   
	        "'user@domain.com ', false"   
	    })
	    public void testEmailWithExpectedResult(String email, boolean expectedResult) {
	        String trimmedEmail = email;  

	        if (expectedResult) {
	            assertTrue(Validator.isValidEmail(trimmedEmail), "Expected valid email: " + trimmedEmail);
	        } else {
	            assertFalse(Validator.isValidEmail(trimmedEmail), "Expected invalid email: " + trimmedEmail);
	        }
	    }

	    }

