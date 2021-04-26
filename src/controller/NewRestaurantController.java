package controller;

import model.Address;
import model.Cuisine;
import model.Restaurant;
import model.validation.*;
import view.*;
import view.addRestaurantDialog.IAddRestaurantDialog;
import view.addRestaurantDialog.IAddRestaurantDialogListener;
import view.addRestaurantDialog.AddRestaurantDialog;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Scott Kuehl-Shelby
 */
public class NewRestaurantController implements IAddRestaurantDialogListener {
    private Restaurant restaurant;
    private Address address;
    private final List<IValidate<String>> nameValidation;
    private final List<IValidate<Integer>> zipCodeValidation;

    public NewRestaurantController() {
        restaurant = new Restaurant();
        address = new Address();

        nameValidation = new ArrayList<>();
        nameValidation.add(new NotEmpty("Restaurants must have a name."));

        zipCodeValidation = new ArrayList<>();
        zipCodeValidation.add(new GreaterThan<>(9999, "Zip codes must be greater than 9999."));
        zipCodeValidation.add(new LessThan<>(99999, "Zip codes must be less than 99999."));
    }

    public Optional<Restaurant> getRestaurant(RootFrame rootFrame) {
        IAddRestaurantDialog dialog = new AddRestaurantDialog(rootFrame, Arrays.stream(Cuisine.values()).map(Enum::toString).toArray(String[]::new));
        restaurant = new Restaurant();
        address = new Address();

        dialog.addRestaurantDialogListener(this);
        dialog.display();

        if(!dialog.isCancelled()) {
            restaurant.setAddress(address);
            return Optional.of(restaurant);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void nameChanged(Object sender, String name) {
        if(nameValidation.stream().noneMatch(rule -> rule.validate(name).isError())) {
            restaurant.setName(name);
        }
        else {
            List<String> errors = nameValidation.stream().map(rule -> rule.validate(name)).filter(Result::isError).map(Result::toString).collect(Collectors.toList());
            ((IAddRestaurantDialog) sender).displayErrors(errors);
        }

        validateRestaurantDialog((IAddRestaurantDialog) sender);
    }

    @Override
    public void cuisineChanged(Object sender, String cuisine) {
        restaurant.setCuisine(Cuisine.valueOf(cuisine));

        validateRestaurantDialog((IAddRestaurantDialog) sender);
    }

    @Override
    public void streetChanged(Object sender, String street) {
        address.setStreet(street);

        validateRestaurantDialog((IAddRestaurantDialog) sender);
    }

    @Override
    public void cityChanged(Object sender, String city) {
        address.setCity(city);

        validateRestaurantDialog((IAddRestaurantDialog) sender);
    }

    @Override
    public void stateChanged(Object sender, String state) {
        address.setState(state);

        validateRestaurantDialog((IAddRestaurantDialog) sender);
    }

    @Override
    public void zipChanged(Object sender, String zip) {
        try {
            Integer parsedZip = Integer.parseInt(zip);

            if(zipCodeValidation.stream().noneMatch(rule -> rule.validate(parsedZip).isError())){
                address.setZip(parsedZip);
            }
            else {
                List<String> errors = zipCodeValidation.stream().map(rule -> rule.validate(parsedZip)).filter(Result::isError).map(Result::toString).collect(Collectors.toList());
                ((IAddRestaurantDialog) sender).displayErrors(errors);
            }
        }
        catch (NumberFormatException e) {
            ((IAddRestaurantDialog) sender).displayErrors(Collections.singletonList("Zip codes must be numeric."));
        }

        validateRestaurantDialog((IAddRestaurantDialog) sender);
    }

    private void validateRestaurantDialog(IAddRestaurantDialog dialog) {
        if(restaurant.getErrors().isEmpty() && address.getErrors().isEmpty()) {
            dialog.enableOkay();
        }
        else {
            dialog.disableOkay();
        }
    }
}
