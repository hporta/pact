package restaurant;

import database.IngredientConnector;

/**
 * Ingredient is a class of objects with basic informations
 * Name
 * Quantity in stock
 * They are used for Plats 
 */
public class Ingredient extends Produit
{
	/**
	 * 
	 * @param nom
	 * @param noinstock
	 * @param id
	 */
	public Ingredient(String nom, int noinstock, int id)
	{
		super(nom,noinstock,id);
	}
	
	/**
	 * Constructor with default values
	 * Should not be used since the id
	 * has incorrect value for database
	 */
	public Ingredient()
	{
		this("Nom",0, -1);
	}

	/**
	 * Update the database with the current values
	 * of the ingredient
	 */
	public final void updateDatabase()
	{
		IngredientConnector.setIngredient(getId(), getNom(), getNoInStock());
	}
}