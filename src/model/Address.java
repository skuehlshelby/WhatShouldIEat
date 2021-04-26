package model;

import model.validation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Scott Kuehl-Shelby
 */
public class Address implements IValidateSelf {

    private String street;
    private String city;
    private String state;
    private final List<IValidate<String>> stateValidation;
    private Integer zip;
    private final List<IValidate<Integer>> zipCodeValidation;

    public Address() {
        zipCodeValidation = new ArrayList<>();
        zipCodeValidation.add(new GreaterThan<>(9999, "Zip codes must be greater than 9999."));
        zipCodeValidation.add(new LessThan<>(99999, "Zip codes must be less than 99999."));

        stateValidation = new ArrayList<>();
        stateValidation.add(new FixedLength(2, "State abbreviations must be two letters."));
    }

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

    @Override
    public List<String> getErrors() {
        List<String> zipCodeErrors = zipCodeValidation.stream()
                .map(item -> item.validate(zip))
                .filter(Result::isError)
                .map(Result::toString)
                .collect(Collectors.toList());

        List<String> stateErrors = stateValidation.stream()
                .map(item -> item.validate(state))
                .filter(Result::isError)
                .map(Result::toString)
                .collect(Collectors.toList());

        zipCodeErrors.addAll(stateErrors);

        return zipCodeErrors;
    }
}