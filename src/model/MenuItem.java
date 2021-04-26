package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Scott Kuehl-Shelby
 */
public class MenuItem implements IValidateSelf {

    private String name;
    private Double price;

    public MenuItem(String name) {
        this(name, null);
    }

    public MenuItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public List<String> getErrors() {
        List<String> errors = new ArrayList<>();

        validatePrice().ifPresent(errors::add);

        return errors;
    }

    public static List<String> validate(String name, String price) {
        List<String> errors = new ArrayList<>();

        validatePrice(price).ifPresent(errors::add);

        return errors;
    }

    private Optional<String> validatePrice() {
        if(getPrice().isPresent()) {
            if(getPrice().get().compareTo(0.00) < 0) {
                return Optional.of("Menu item prices must be positive.");
            }
        }

        return Optional.empty();
    }

    private static Optional<String> validatePrice(String price) {
        if(price != null) {
            try {
                Double parsedPrice = Double.parseDouble(price);

                if(parsedPrice.compareTo(0.00) < 0) {
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
            return String.format("%s: $%,.2f", getName(), getPrice().get());
        }
        else {
            return getName();
        }
    }
}