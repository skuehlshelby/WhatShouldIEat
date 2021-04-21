package model.validation;

public class LessThan<T extends Number> implements IValidate<T> {
    private final T maximum;
    private final String errorMessage;

    public LessThan(T maximum, String errorMessage) {
        this.maximum = maximum;
        this.errorMessage = errorMessage;
    }

    @Override
    public Result<T> validate(T item) {
        return item != null && item.longValue() < maximum.longValue() ? Result.ok(item) : Result.error(String.format("Amount must be less than %d.", maximum.longValue()));
    }
}
