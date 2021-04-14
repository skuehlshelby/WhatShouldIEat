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

    private Optional<String> validatePrice() {
        if(getPrice().isPresent()) {
            if(getPrice().get().compareTo(BigDecimal.valueOf(0.00)) < 0) {
                return Optional.of("Menu item prices must be positive.");
            }
        }

        return Optional.empty();
    }
}
