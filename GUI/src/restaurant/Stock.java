package restaurant;
import java.util.ArrayList;
import java.util.Observable;

import database.ConsommableConnector;
import database.IngredientConnector;


public class Stock extends Observable
{
	private ArrayList<Consommable> consommables;
	private ArrayList<Ingredient> ingredients;

	/**
	 * Default constructor using the values from database
	 */
	public Stock()
	{
		//Initialize the stock with the database
		this.consommables = ConsommableConnector.getConsommables();
		this.ingredients = IngredientConnector.getIngredients();
	}
	
	public final ArrayList<Ingredient> getIngredients()
	{
		return ingredients;
	}

	public final ArrayList<Consommable> getConsommables()
	{
		return consommables;
	}

	/**
	 * Add a consommable to the ArrayList
	 */
	public void addConsommable()
	{
		//First add to the database to get an id
		Consommable consommable = ConsommableConnector.insertConsommable();
		
		//Then add it to the model
		consommables.add(consommable);
		
		//Notify observers for update
		update();
	}

	/**
	 * Add an ingredient to the ArrayList
	 */
	public void addIngredient()
	{
		//First add to the database to get an id
		Ingredient ingredient = IngredientConnector.insertIngredient();
		
		//Then add it to the model
		ingredients.add(ingredient);
		
		//Notify observers for update
		update();
	}

	/**
	 * Remove ingredient
	 * @param ingredient
	 */
	public final void removeIngredient(Ingredient ingredient)
	{
		//Remove the ingredient from database
		IngredientConnector.deleteIngredient(ingredient.getId());
		
		//Remove the ingredient from model
		ingredients.remove(ingredient);
		
		//Update();
		update();
	}

	/**
	 * Remove consommable
	 * @param consommable
	 */
	public final void removeConsommable(Consommable consommable)
	{
		//Rremove the ingredient from database
		ConsommableConnector.deleteConsommable(consommable.getId());
		
		//Remove the ingredient from model
		consommables.remove(consommable);

		//Update()
		update();
	}
	
	/**
	 * Find an ingredient using the provided id
	 * Return null if not found
	 * @param id
	 * @return
	 */
	public final Ingredient findIngredientById(int id)
	{
		for(Ingredient ingredient : ingredients)
		{
			if(ingredient.getId() == id)
				return ingredient;
		}
		
		return null;
	}
	
	/**
	 * Notify observers for update
	 */
	public void update()
	{
		setChanged();
		notifyObservers();
	}
}
