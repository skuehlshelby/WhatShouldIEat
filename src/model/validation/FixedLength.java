package model.validation;

public class FixedLength implements IValidate<String> {
    private final int requiredLength;

    public FixedLength(int requiredLength) {
        this.requiredLength = requiredLength;
    }

    @Override
    public Result<String> validate(String item) {
        return item != null && item.length() == requiredLength ? Result.ok(item) : Result.error(String.format("Item must be %d characters long.", requiredLength));
    }
}
