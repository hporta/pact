package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import retaurant.Ingredient;
import retaurant.Stock;
import ui.stock.ingredient.IngredientCard;

public class IngredientController
{
	//View
	private IngredientCard card;
	
	//Model
	private Ingredient ingredient;
	private Stock stock;
	
	//Events
	private final String SET = "set";
	private final String DELETE = "delete";
	private final String VALIDATE = "validate";
	private final String RETURN = "return";
	
	public IngredientController(Ingredient ingredient, IngredientCard card, Stock stock)
	{
		this.ingredient = ingredient;
		this.card = card;
		this.stock = stock;
	}
	
	public Ingredient getIngredient() 
	{
		return ingredient;
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
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Events form IngredientItem
		if(DELETE.equals(e.getActionCommand()))
		{
			stock.removeIngredient(ingredient);
		}
		
		else if(SET.equals(e.getActionCommand()))
		{
			card.switchCard();
		}
		
		
		//Events from IngredientForm
		else if(VALIDATE.equals(e.getActionCommand()))
		{
			if(setIngredient(nom.getText(), Integer.parseInt(quantite.getText())))
			{
				card.switchCard();
				card.update();
			}
		}
		
		else if(RETURN.equals(e.getActionCommand()))
			card.switchCard();
	}
}
