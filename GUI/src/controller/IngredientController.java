package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import retaurant.Ingredient;
import retaurant.Stock;
import ui.stock.ingredient.IngredientCard;

public class IngredientController implements ActionListener
{
	//View
	private IngredientCard card;
	
	//Model
	private Ingredient ingredient;
	
	//Controller
	private StockController stockController;
	
	//Events
	private final String DELETE = "delete";
	private final String VALIDATE = "validate";
	
	
	public IngredientController(Ingredient ingredient, StockController stockController)
	{
		this.ingredient = ingredient;
		this.stockController = stockController;
	}
	
	public void setCard(IngredientCard card)
	{
		this.card = card;
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
			stockController.removeIngredient(ingredient);
		}
		
		//Events from IngredientForm
		else if(VALIDATE.equals(e.getActionCommand()))
		{
			if(setIngredient(card.getNom(), card.get)))
			{
				card.switchCard();
			}
		}
	}
}
