package model.validation;

public class FixedLength implements IValidate<String> {
    private final int requiredLength;
    private final String errorMessage;

    public FixedLength(int requiredLength, String errorMessage) {
        this.requiredLength = requiredLength;
        this.errorMessage = errorMessage;
    }

    @Override
    public Result<String> validate(String item) {
        return item != null && item.length() == requiredLength ? Result.ok(item) : Result.error(errorMessage);
    }
}
