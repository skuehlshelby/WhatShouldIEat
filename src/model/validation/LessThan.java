package model.validation;

public class LessThan<T extends Number> implements IValidate<T> {
    private final T maximum;

    public LessThan(T maximum) {
        this.maximum = maximum;
    }

    @Override
    public Result<T> validate(T item) {
        return item != null && item.longValue() < maximum.longValue() ? Result.ok(item) : Result.error(String.format("Amount must be less than %d.", maximum.longValue()));
    }
}
