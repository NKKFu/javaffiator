package test.javalidator;

import javalidator.interfaces.IValidation;

public class SimpleGenericTest implements IValidation<String> {
    // Assert string received is equals to True
    public void validate(String input) {
        if (input != "True") {
            throw new IllegalArgumentException("String received is not equals to True");
        }
    }
}
