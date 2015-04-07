package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import restaurant.Ingredient;
import ui.Constantes;
import ui.stock.ingredient.IngredientCard;
import ui.stock.ingredient.IngredientFields;

public class IngredientController implements ActionListener
{
	//View
	private IngredientCard card;
	private IngredientFields fields;
	
	//Model
	private Ingredient ingredient;
	
	//Controller
	private StockController stockController;
		
	
	public IngredientController(Ingredient ingredient, StockController stockController)
	{
		this.ingredient = ingredient;
		this.stockController = stockController;
	}
	
	public void setCard(IngredientCard card)
	{
		this.card = card;
	}
	
	public void setFields(IngredientFields fields)
	{
		this.fields = fields;
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
		if(Constantes.DELETE.equals(e.getActionCommand()))
		{
			stockController.removeIngredient(ingredient);
		}
		
		//Events from IngredientForm
		else if(Constantes.VALIDATE.equals(e.getActionCommand()))
		{
			if(setIngredient(fields.getNom(), fields.getQuantite()))
			{
				card.switchCard();
			}
		}
	}
}
