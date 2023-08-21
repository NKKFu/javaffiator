package test.javalidator;

import javalidator.utils.JaValidator;
import junit.framework.TestCase;

// A test case for the JaValidator class
public class JaValidatorTests extends TestCase {

    // Test the JaValidator class
    public void testJaValidator() {
        // Create a new JaValidator object
        JaValidator.validate(new SimpleGenericTest(), "True");
    }

    public void testJaValidatorThrows() {
        // Assert that the JaValidator class throws an exception
        try {
            JaValidator.validate(new SimpleGenericTest(), "False");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "String received is not equals to True");
        }
    }
}
