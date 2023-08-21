package javalidator.utils;

import javalidator.interfaces.IValidation;
import javlogger.loggers.TextLogger;

// Validator class has a generic type T which is a class that implements IValidation
public class JaValidator {
    public static <F> void validate(IValidation<F> validation, F field) {
        try {
            TextLogger logger = new TextLogger("/Users/nelsonkenmochi");
            logger.log("Validating field: " + field.getClass().toString() + " with value: " + field.toString());
            validation.validate(field);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
