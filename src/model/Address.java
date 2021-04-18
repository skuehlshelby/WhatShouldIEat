package model;

import model.validation.FixedLength;
import model.validation.GreaterThan;
import model.validation.IValidate;
import model.validation.LessThan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Address implements IValidateSelf {

    private String street;
    private String city;
    private String state;
    private final List<IValidate<String>> stateValidation;
    private Integer zip;
    private final List<IValidate<Double>> zipCodeValidation;

    public Address() {
        zipCodeValidation = new ArrayList<>();
        zipCodeValidation.add(new GreaterThan(10000.00));
        zipCodeValidation.add(new LessThan(99999.00));

        stateValidation = new ArrayList<>();
        stateValidation.add(new FixedLength(2));
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
    public List<String> isValid() {
        List<String> zipCodeErrors = zipCodeValidation.stream()
                .filter(item -> item.isValid(zip.doubleValue()).isError())
                .map(Object::toString)
                .collect(Collectors.toList());

        List<String> stateErrors = stateValidation.stream()
                .filter(item -> item.isValid(state).isError())
                .map(Object::toString)
                .collect(Collectors.toList());

        zipCodeErrors.addAll(stateErrors);

        return zipCodeErrors;
    }
}