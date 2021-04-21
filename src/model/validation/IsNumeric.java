package model.validation;

public class IsNumeric implements IValidate<String> {
    private final String errorMessage;

    public IsNumeric(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public Result<String> validate(String item) {
        try{
            Double.parseDouble(item);
            return Result.ok(item);
        }
        catch (NumberFormatException e) {
            return Result.error("Item must be numeric.");
        }
    }
}
