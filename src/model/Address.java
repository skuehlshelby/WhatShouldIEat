package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Address {

    private String street;
    private String city;
    private String state;
    private Integer zip;

    public Optional<String> getStreet() {
        return Optional.ofNullable(street);
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Optional<String> getState() {
        return Optional.ofNullable(state);
    }

    public void setState(String state) {
        this.state = state;
    }

    public Optional<Integer> getZip() {
        return Optional.ofNullable(zip);
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public List<String> isValid() {
        List<String> errors = new ArrayList<>();

        validateZip().ifPresent(errors::add);
        validateState().ifPresent(errors::add);

        return errors;
    }

    private Optional<String> validateZip(){
        if(getZip().isPresent()) {
            if(getZip().get() < 10000 || getZip().get() > 99999) {
                return Optional.of("Zip codes must be five digits.");
            }
        }

        return Optional.empty();
    }

    private Optional<String> validateState(){
        if(getState().isPresent()) {
            if(getState().get().length() != 2) {
                return Optional.of("States must be abbreviated as two letters.");
            }
        }

        return Optional.empty();
    }
}
