package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuItem implements IValidateSelf {

    private String name;
    private BigDecimal price;

    public MenuItem(String name) {
        this(name, null);
    }

    public MenuItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<BigDecimal> getPrice() {
        return Optional.ofNullable(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public List<String> isValid() {
        List<String> errors = new ArrayList<>();

        validatePrice().ifPresent(errors::add);

        return errors;
    }

    public static List<String> isValid(String name, String price) {
        List<String> errors = new ArrayList<>();

        validatePrice(price).ifPresent(errors::add);

        return errors;
    }

    private Optional<String> validatePrice() {
        if(getPrice().isPresent()) {
            if(getPrice().get().compareTo(BigDecimal.valueOf(0.00)) < 0) {
                return Optional.of("Menu item prices must be positive.");
            }
        }

        return Optional.empty();
    }

    private static Optional<String> validatePrice(String price) {
        if(price != null) {
            try {
                BigDecimal parsedPrice = BigDecimal.valueOf(Double.parseDouble(price));

                if(parsedPrice.compareTo(BigDecimal.valueOf(0.00)) < 0) {
                    return Optional.of("Menu item prices must be positive.");
                }
            }
            catch (NumberFormatException numberFormatException) {
                return Optional.of("Menu item prices must be numeric.");
            }
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        if(getPrice().isPresent()) {
            return String.format("%s: $%,.2f", getName(), getPrice().get().doubleValue());
        }
        else {
            return getName();
        }
    }
}
