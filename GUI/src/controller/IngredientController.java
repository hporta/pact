package controller;

import retaurant.Ingredient;

public class IngredientController 
{
	private Ingredient ingredient;
	
	public IngredientController(Ingredient ingredient)
	{
		this.ingredient = ingredient;
	}
	
	public boolean setIngredient(String nom, int quantite)
	{
		if(validateNom(nom) && validateQuantite(quantite))
		{
			ingredient.setNom(nom);
			ingredient.setNoInStock(quantite);
			return true;
		}
		
		return false;
	}
	
	public boolean validateNom(String nom)
	{
		return (nom != "" && nom.length() < 20 && nom != "Nom");
	}
	
	public boolean validateQuantite(int quantite)
	{
		return quantite > 0;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}
	
}
