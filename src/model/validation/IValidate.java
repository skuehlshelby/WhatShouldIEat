package model.validation;

public interface IValidate<T> {
    Result<T> isValid(T item);
}
