package model.validation;

public class IsNumeric implements IValidate<String> {
    @Override
    public Result<String> isValid(String item) {
        try{
            Double.parseDouble(item);
            return Result.ok(item);
        }
        catch (NumberFormatException e) {
            return Result.error("Item must be numeric.");
        }
    }
}
