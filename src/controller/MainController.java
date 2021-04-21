package controller;

import model.*;
import view.*;
import view.freshStartPanel.IFreshStartPanelListener;

import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainController implements IButtonPanelListener, IRestaurantsListener, IFreshStartPanelListener {
    private final RootFrame rootFrame = new RootFrame("What Should I Eat?");
    private final IMainPanel mainPanel = new MainPanel();
    private final IChoicePanel choicePanel = new ChoicePanel();
    private final Restaurants restaurants;

    public MainController() {
        restaurants = new Restaurants();

        restaurants.addRestaurantListener(this);
        mainPanel.getButtonPanel().addButtonPanelListener(this);
        mainPanel.getDataPanel().getFreshStartPanel().addFreshStartPanelListener(this);

        WindowListener listener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                onWindowClose();
            }
        };

        rootFrame.addWindowListener(listener);

        IO.getUserPreferredRestaurantDataLocation().flatMap(IO::loadFromFile).ifPresent(data -> {
            data.forEach(restaurants::addRestaurant);
        });

        choicePanel.addChooseAgainActionListener(this::onChooseAgainClick);

        showMainForm();

        rootFrame.setVisible(true);
    }

    public void showMainForm() {
        rootFrame.setContent((Component) mainPanel);
    }

    private void onChooseAgainClick(ActionEvent e) {
        showMainForm();
    }

    @Override
    public void chooseClicked(Object sender) {
        List<String> selectedRestaurants = mainPanel
                .getDataPanel()
                .getCardDisplayPanel()
                .getCards()
                .stream()
                .filter(RestaurantCard::getSelected)
                .map(RestaurantCard::getRestaurantName)
                .collect(Collectors.toList());

        Optional<Restaurant> choice = restaurants.choose(restaurant -> selectedRestaurants.contains(restaurant.getName()));

        if(choice.isPresent()) {
            choicePanel.setChoice(choice.get().getName());
            rootFrame.getContentPane().removeAll();
            rootFrame.getContentPane().add((Component) choicePanel);
            rootFrame.revalidate();
            rootFrame.repaint();
        }
    }

    @Override
    public void selectAllClicked(Object sender) {
        for (IRestaurantCard card : mainPanel.getDataPanel().getCardDisplayPanel().getCards()) {
            card.setSelected(true);
        }
    }

    @Override
    public void selectNoneClicked(Object sender) {
        for (IRestaurantCard card : mainPanel.getDataPanel().getCardDisplayPanel().getCards()) {
            card.setSelected(false);
        }
    }

    @Override
    public void addAnotherClicked(Object sender) {
        NewRestaurantController newRestaurantController = new NewRestaurantController();

        Optional<Restaurant> restaurant = newRestaurantController.getRestaurant(rootFrame);

        restaurant.ifPresent(restaurants::addRestaurant);
    }

    @Override
    public void loadFromFileClicked(Object sender) {
        IO.promptUserForFileLocation(rootFrame).ifPresent(file -> {
            IO.setUserPreferredRestaurantDataLocation(file.getAbsolutePath());
            IO.loadFromFile(file.getAbsolutePath()).ifPresent(data -> {
                data.forEach(restaurants::addRestaurant);
            });
        });
    }

    @Override
    public void restaurantAdded(Object sender, Restaurant restaurant) {
        RestaurantCard card = new RestaurantCard(restaurant.getName());
        mainPanel.getDataPanel().getCardDisplayPanel().addCard(card);
        mainPanel.getDataPanel().showCardDisplayPanel();
    }

    @Override
    public void restaurantRemoved(Object sender, Restaurant restaurant) {

    }

    private void onWindowClose() {
        if(!IO.getUserPreferredRestaurantDataLocation().isPresent()) {
            IO.promptUserForFileLocation(rootFrame).ifPresent(location -> IO.setUserPreferredRestaurantDataLocation(location.getAbsolutePath()));
        }

        IO.getUserPreferredRestaurantDataLocation().ifPresent(location -> IO.writeToFile(location, restaurants.getRestaurants()));
    }
}