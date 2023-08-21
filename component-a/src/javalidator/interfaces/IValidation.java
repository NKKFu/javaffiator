package javalidator.interfaces;

public interface IValidation<T> {
    public void validate(T field) throws IllegalArgumentException;
}
