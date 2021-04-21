package model.validation;

public class GreaterThan<T extends Number> implements IValidate<T> {
    private final T minimum;
    private final String errorMessage;

    public GreaterThan(T minimum, String errorMessage) {
        this.minimum = minimum;
        this.errorMessage = errorMessage;
    }

    @Override
    public Result<T> validate(T item) {
        return item != null && item.longValue() > minimum.doubleValue() ? Result.ok(item) : Result.error(String.format("Amount must be greater than %d.", minimum.longValue()));
    }
}
