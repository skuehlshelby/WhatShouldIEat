package model.validation;

public class ShorterThan implements IValidate<String> {
    private final int maxLength;

    public ShorterThan(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Result<String> isValid(String item) {
        return item.length() <= maxLength ? Result.ok(item) : Result.error(String.format("Item cannot be more than %d characters.", maxLength));
    }
}
