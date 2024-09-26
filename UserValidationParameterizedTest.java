import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;


public class UserValidationParameterizedTest {

    // Parameterized test for email validation
    @ParameterizedTest
    @CsvSource({
            "abc.xyz@bl.co.in, true",  // Valid email
            "abc@bl.co, true",         // Invalid TLD
            "abc.xyz@bl, false",        // Missing TLD
            "abc.xyz@.com, false",      // Invalid format
            "abc.xyz@bl.c, false",      // Invalid TLD (too short)
            "abc.xyz@bl.co.uk, true",   // Valid email with longer domain
            "xyz@bl.co, true",          // Valid email
            "@bl.co.in, false",         // Invalid format (missing local part)
            "abc.xyz@, false",          // Invalid format (missing domain)
            "abc.xyz@bl..co.in, false", // Invalid format (double dot in domain)
            "abc.xyz@.bl.co.in, false", // Invalid format (dot before domain)
            "abc.xyz@bl.c, false",      // Invalid TLD (too short)
            "abc.xyz@bl#co.in, false",  // Invalid character in domain
            "abc.xyz@bl.co.in, true"    // Valid email
    })
    void testEmailValidation(String email, boolean expectedValidity) {
        boolean isValid = UserValidation.validateEmail(email);
        assertEquals(expectedValidity, isValid);
    }
}
