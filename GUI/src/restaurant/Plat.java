package restaurant;
import java.util.ArrayList;
import java.util.Observable;

import database.PlatConnector;



public class Plat extends Observable implements Achetable
{
	private String nom; 
	private String description;
	private float prix;
	private ArrayList<Ingredient> listeingredient;
	private final int id;
	
	public Plat(String nom, String description, float prix, int id)
	{
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		listeingredient = new ArrayList<Ingredient>();
		this.id = id;
	}
	
	public final int getId()
	{
		return id;
	}
	
	public String getNom()
	{	
		return nom;
	}

	public final void setNom(String nom)
	{
		this.nom = nom;
		update();
	}

	public final float getPrix()
	{	
		return prix;
	}
	
	public final void setPrix(float prix)
	{	
		this.prix = prix;
		update();
	}

	public final String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{	
		this.description = description;
		update();
	}

	//toujours un plat est disponible si tous les ingr�dients sont pr�sents
	public boolean disponible()
	{		
		for (Ingredient ingredient : listeingredient)
		{
			if(ingredient.getNoInStock()==0)
				return false;
		}
		
		return true;
	}
	
	// on diminue la quantit� de tous les ingr�dients
	public void diminution () throws Exception 
	{
		for (Ingredient ingredient : listeingredient)
			ingredient.removeProduct(1);
	}
	
	public final ArrayList<Ingredient> getIngredients()
	{
		return listeingredient;
	}
	
	/**
	 * Set the ingredients
	 * Doesn't call database because it's only used during initialization
	 * @param liste
	 */
	public final void setIngredients(ArrayList<Ingredient> liste)
	{
		listeingredient = liste;
		update();
	}
	
	/**
	 * Add ingredient
	 * @param ingredient
	 */
	public final void addIngredient(Ingredient ingredient)
	{
		PlatConnector.insertIngredientToPlat(ingredient.getId(), getId());
		
		listeingredient.add(ingredient);
		
		update();
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
