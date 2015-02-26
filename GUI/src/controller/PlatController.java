package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import retaurant.Ingredient;
import retaurant.Plat;
import retaurant.Stock;

public class PlatController implements ActionListener
{
	//Model
	private final Plat plat;
	private final Stock stock;
	
	//Superior controller
	CarteController carteController;
	
	public PlatController(Plat plat, CarteController carteController)
	{
		this.plat = plat;
		this.stock = carteController.getStock();
		this.carteController = carteController;
	}
	
	public Plat getPlat()
	{
		return plat;
	}
	
	public boolean setPlat(String nom, String description, float price, ArrayList<String> liste)
	{

		if(validateNom(nom)
				&& validateDescription(description)
				&& validatePrice(price)
				&& validateIngredients(liste))
		{
			plat.setNom(nom);
			plat.setDescription(description);
			plat.setPrix(price);
			plat.setIngredients(buildListe(liste));
			return true;
		}
		
		else
			return false;
	}
	
	public boolean validateNom(String nom)
	{
		return nom.length() <= 20 && nom != "";
	}
	
	public boolean validateDescription(String description)
	{
		return description.length() <= 150 && description != "";
	}
	
	public boolean validatePrice(float price)
	{
		return price > 0;
	}
	
	public boolean validateIngredients(ArrayList<String> liste)
	{
		for(String name : liste)
		{
			if(!isIn(name))
				return false;
		}
		
		return true;
	}
	
	private boolean isIn(String name)
	{
		for(Ingredient ingredient : stock)
		{
			if(ingredient.getNom().equals(name))
				return true;
		}
		
		return false;
	}
	
	private ArrayList<Ingredient> buildListe(ArrayList<String> liste)
	{
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		for(String nom : liste)
		{
			for(Ingredient ingredient : stock)
			{
				if(nom.equals(ingredient.getNom()))
					ingredients.add(ingredient);
			}
		}
		
		return ingredients;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("del"))
			carteController.removePlat(plat);
		
	}
}
