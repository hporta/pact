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
		updateDatabase();
	}

	public final float getPrix()
	{	
		return prix;
	}
	
	public final void setPrix(float prix)
	{	
		this.prix = prix;
		update();
		updateDatabase();
	}

	public final String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{	
		this.description = description;
		update();
		updateDatabase();
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
	
	public void commander()
	{
		for(Ingredient ingredient : listeingredient)
			ingredient.diminution();
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
	public final void initIngredients(ArrayList<Ingredient> liste)
	{
		listeingredient = liste;
		update();
	}
	
	public final void setIngredients(ArrayList<Ingredient> newListeIngredients)
	{
		ArrayList<Ingredient> delete = new ArrayList<Ingredient>();
		ArrayList<Ingredient> insert = new ArrayList<Ingredient>();
		
		for(Ingredient ingredient : this.listeingredient)
		{
			if(!newListeIngredients.contains(ingredient))
				delete.add(ingredient);
		}
		
		for(Ingredient ingredient : newListeIngredients)
		{
			if(!listeingredient.contains(ingredient))
				insert.add(ingredient);
		}
		
		for(Ingredient ingredient : delete)
			removeIngredient(ingredient);
		
		for(Ingredient ingredient : insert)
			addIngredient(ingredient);
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
	
	public final void removeIngredient(Ingredient ingredient)
	{
		PlatConnector.removeIngredientOfPlat(ingredient.getId(), getId());
		
		listeingredient.remove(ingredient);
		
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
	
	public final void updateDatabase()
	{
		PlatConnector.setPlat(getId(), nom, description, prix);
	}
}
