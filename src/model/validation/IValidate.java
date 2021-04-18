package model.validation;

public interface IValidate<T> {
    Result<T> validate(T item);
}
