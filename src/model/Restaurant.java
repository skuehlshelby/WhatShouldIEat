package model;

import model.validation.IValidate;
import model.validation.NotEmpty;
import model.validation.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Reyes Villalva
 */
public class Restaurant {
	private String name;
	private final List<IValidate<String>> nameValidation;
	private Cuisine cuisine;
	private Address address;
	private List<MenuItem>menuItems;

	public Restaurant() {
		nameValidation = new ArrayList<>();
		nameValidation.add(new NotEmpty("Restaurants must have a name."));
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the cuisine
	 */
	public Optional<Cuisine> getCuisine() {
		return Optional.ofNullable(cuisine);
	}
	
	/**
	 * @param cuisine 
	 */
	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}
	
	/**
	 * @return the address
	 */
	public Optional<Address> getAddress() {
		return Optional.ofNullable(address);
	}
	
	/**
	 * @param address 
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * @return the menuItems
	 */
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	
	/**
  *****************************************************RETURN TYPE IN UML - MenuItem - RETURN SAME ITEM SENT IN FOR CLARIFICATION TO USER?
	 * @param item
	 */
	public MenuItem addMenuItem(MenuItem item) {
		menuItems.add(item);
		return item;
	}
	
	/**
	 * ***************************************************WHAT ITEMS NEED VALIDATION 
	 * @return the errors
	 */
	public List<String> getErrors() {

        return nameValidation.stream()
				.map(item -> item.validate(name))
				.filter(Result::isError)
				.map(Result::toString)
				.collect(Collectors.toList());
    }
}
