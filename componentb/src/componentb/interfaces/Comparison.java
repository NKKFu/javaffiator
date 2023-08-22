package componentb.interfaces;

public abstract class Comparison<T> {
    protected T valueToCompare;

    public Comparison(T valueToCompare) {
        this.valueToCompare = valueToCompare;
    }

    public abstract T convertFromObject (Object obj);
    public abstract boolean compare(T value);
}
