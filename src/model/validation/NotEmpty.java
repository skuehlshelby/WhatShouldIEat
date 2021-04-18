package model.validation;

public class NotEmpty implements IValidate<String> {

    @Override
    public Result<String> validate(String item) {
        return item != null && item.isEmpty() ? Result.error("Item cannot be empty.") : Result.ok(item);
    }
}
