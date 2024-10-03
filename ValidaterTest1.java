

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ValidaterTest1 {

	@Test
	public void testInvalidFirstName() {
		assertThrows(InvalidFirstNameException.class, () -> Validator1.validateFirstName("jo"));
		assertThrows(InvalidFirstNameException.class, () -> Validator1.validateFirstName("j"));
		assertThrows(InvalidFirstNameException.class, () -> Validator1.validateFirstName("john123"));
		assertThrows(InvalidFirstNameException.class, () -> Validator1.validateFirstName(" john"));
	}

	@Test
	public void testInvalidLastName() {
		assertThrows(InvalidLastNameException.class, () -> Validator1.validateLastName("doe"));
		assertThrows(InvalidLastNameException.class, () -> Validator1.validateLastName("d"));
		assertThrows(InvalidLastNameException.class, () -> Validator1.validateLastName("doe123"));
		assertThrows(InvalidLastNameException.class, () -> Validator1.validateLastName(" doe"));
	}

	@Test
	public void testInvalidEmail() {
		assertThrows(InvalidEmailException.class, () -> Validator1.validateEmail("invalid-email"));
		assertThrows(InvalidEmailException.class, () -> Validator1.validateEmail("user@.com"));
		assertThrows(InvalidEmailException.class, () -> Validator1.validateEmail("@domain.com"));
		assertThrows(InvalidEmailException.class, () -> Validator1.validateEmail("user@domain..com"));
		assertThrows(InvalidEmailException.class, () -> Validator1.validateEmail(" user@domain.com"));
		assertThrows(InvalidEmailException.class, () -> Validator1.validateEmail("user@domain.com "));
		assertThrows(InvalidEmailException.class, () -> Validator1.validateEmail("User123@domain.com "));
	}

	@Test
	public void testInvalidMobileNumber() {
		assertThrows(InvalidMobileNoException.class, () -> Validator1.validateMobileNo("91 12345"));
		assertThrows(InvalidMobileNoException.class, () -> Validator1.validateMobileNo("1234567890"));
		assertThrows(InvalidMobileNoException.class, () -> Validator1.validateMobileNo("91 12345678901"));
		assertThrows(InvalidMobileNoException.class, () -> Validator1.validateMobileNo("91 123456abc"));
	}

	@Test
	    public void testInvalidPassword() {
	        assertThrows(InvalidPasswordException.class, () -> Validator1.validatePassword("abc12345"));
	        assertThrows(InvalidPasswordException.class, () -> Validator1.validatePassword("ABC12345"));
	        assertThrows(InvalidPasswordException.class, () -> Validator1.validatePassword("Abcdefgh"));
	        assertThrows(InvalidPasswordException.class, () -> Validator1.validatePassword("Abc@1@34"));
	        assertThrows(InvalidPasswordException.class, () -> Validator1.validatePassword("Ab1@"));
	    
	}
}
