package model.validation;

public class GreaterThan implements IValidate<Double> {
    private final Double minimum;

    public GreaterThan(Double minimum) {
        this.minimum = minimum;
    }

    @Override
    public Result<Double> isValid(Double item) {
        return item > minimum ? Result.ok(item) : Result.error(String.format("Amount must be greater than %.2f.", minimum));
    }
}
