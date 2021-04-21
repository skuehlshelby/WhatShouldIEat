package model.validation;

public class ShorterThan implements IValidate<String> {
    private final int maxLength;
    private final String errorMessage;

    public ShorterThan(int maxLength, String errorMessage) {
        this.maxLength = maxLength;
        this.errorMessage = errorMessage;
    }

    @Override
    public Result<String> validate(String item) {
        return item != null && item.length() <= maxLength ? Result.ok(item) : Result.error(String.format("Item cannot be more than %d characters.", maxLength));
    }
}
