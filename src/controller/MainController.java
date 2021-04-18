package controller;

import model.*;
import model.validation.IsNumeric;
import view.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    private final RootFrame rootFrame = new RootFrame("What Should I Eat?");
    private final IMainPanel mainPanel = new MainPanel();
    private final IChoicePanel choicePanel = new ChoicePanel();

    private final Restaurants restaurants;

    public MainController() {
        restaurants = new Restaurants();

        List<Restaurant> restaurantList = IO.loadFromFile();
        restaurantList.forEach(restaurants::addRestaurant);

        mainPanel.getButtonPanel().addChooseClickListener(this::onChooseClick);
        mainPanel.getButtonPanel().addAddAnotherClickListener(this::onAddAnotherClick);

        rootFrame.getContentPane().add((Component) mainPanel);
    }

    public void showMainForm() {
        rootFrame.getContentPane().removeAll();
        rootFrame.getContentPane().add((Component) mainPanel);
        rootFrame.setVisible(true);
    }

    private void onChooseClick(ActionEvent e) {
        Restaurant choice = restaurants.choose();
        choicePanel.setChoice(choice.getName());
        rootFrame.getContentPane().removeAll();
        rootFrame.getContentPane().add((Component) choicePanel);
        rootFrame.revalidate();
        rootFrame.repaint();
    }

    private void onAddAnotherClick(ActionEvent e) {
        INewRestaurantDialog restaurantDialog = new NewRestaurantDialog(rootFrame, Arrays.stream(Cuisine.values()).map(Cuisine::toString).toArray(String[]::new));
        restaurantDialog.addChangeListener(this::validateRestaurantDialog);

        restaurantDialog.display();

        if(!restaurantDialog.isCancelled()) {
            Restaurant restaurant = new Restaurant();
            restaurantDialog.getRestaurantName().ifPresent(restaurant::setName);
            restaurantDialog.getCuisine().ifPresent(cuisine -> restaurant.setCuisine(Cuisine.valueOf(cuisine)));

            restaurants.addRestaurant(restaurant);

            mainPanel.getDataPanel().getCardDisplayPanel().addCard(new RestaurantCard(restaurant.getName()));
            mainPanel.getDataPanel().showCardDisplayPanel();
        }
    }

    private void validateRestaurantDialog(RestaurantDialogChangeEvent e) {
        Restaurant restaurant = new Restaurant();
        Address address = new Address();
        List<String> errors = new ArrayList<>();

        e.getRestaurantName().ifPresent(restaurant::setName);
        e.getCuisine().ifPresent(cuisine -> restaurant.setCuisine(Cuisine.valueOf(cuisine)));

        e.getStreet().ifPresent(address::setStreet);
        e.getCity().ifPresent(address::setCity);
        e.getState().ifPresent(address::setState);

        if(e.getZip().isPresent()) {
            IsNumeric numeric = new IsNumeric();
            String zip = e.getZip().get();

            if(numeric.validate(zip).isError()) {
                errors.add(numeric.validate(zip).toString());
            }
            else{
                address.setZip(Integer.parseInt(zip));
            }
        }

        errors.addAll(address.isValid());
        errors.addAll(restaurant.isValid());

        INewRestaurantDialog source = (INewRestaurantDialog)e.getSource();

        if(errors.isEmpty()) {
            source.enableOkay();
        }
        else {
            source.disableOkay();
            source.displayErrors(errors);
        }
    }
}
