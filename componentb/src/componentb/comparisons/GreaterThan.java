package componentb.comparisons;

import componentb.interfaces.Comparison;

public class GreaterThan extends Comparison<Number> {

    public GreaterThan(Number valueToCompare) {
        super(valueToCompare);
    }

    @Override
    public boolean compare(Number value) {
        return valueToCompare.doubleValue() < value.doubleValue();
    }

    @Override
    public Number convertFromObject(Object obj) {
        // Try parse
        try {
            return Double.parseDouble(obj.toString());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing " + obj.toString() + " to Double");
            return 0;
        }
    }
}
