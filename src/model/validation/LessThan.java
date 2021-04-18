package model.validation;

public class LessThan implements IValidate<Double> {
    private final Double maximum;

    public LessThan(Double maximum) {
        this.maximum = maximum;
    }

    @Override
    public Result<Double> isValid(Double item) {
        return item < maximum ? Result.ok(item) : Result.error(String.format("Amount must be less than %.2f.", maximum));
    }
}
