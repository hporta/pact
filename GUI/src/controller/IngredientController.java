package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	private ArrayList<String> errors;
	
	//Controller
	private StockController stockController;
		
	
	public IngredientController(Ingredient ingredient, StockController stockController)
	{
		this.ingredient = ingredient;
		this.stockController = stockController;
		errors = new ArrayList<String>();
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
		errors.clear();
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
		boolean valide = true;
		if(nom == "")
		{
			valide = false;
			errors.add("Le nom ne doit pas etre nul");
		}
		
		if(nom.length() > 20 )
		{
			valide = false;
			errors.add("Le nom doit faire moins de 20 caractères");
		}
		
		return valide;
	}
	
	public boolean validateQuantite(int quantite)
	{
		boolean valide = true;
		
		if(quantite < 0)
		{
			valide = false;
			errors.add("La quantite doit etre positive");
		}
	
		return valide;
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
				card.switchCard();

			else
			{
				for(String error : errors)
					System.out.println(error);
			}
		}
	}
}
