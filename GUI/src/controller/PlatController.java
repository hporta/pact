package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import restaurant.Ingredient;
import restaurant.Plat;
import restaurant.Stock;
import ui.Constantes;
import ui.ErrorDialog;
import ui.recette.plat.PlatCard;
import ui.recette.plat.PlatFields;

public class PlatController implements ActionListener
{
	//View
	private PlatCard card;
	private PlatFields fields;
	
	
	//Model
	private final Plat plat;
	private final Stock stock;
	
	private ArrayList<String> errors;
	
	//Superior controller
	RecetteController carteController;

	
	public PlatController(Plat plat, RecetteController carteController)
	{
		this.plat = plat;
		this.stock = carteController.getStock();
		this.carteController = carteController;
		
		errors = new ArrayList<String>();
	}
	
	public Plat getPlat()
	{
		return plat;
	}
	
	public Stock getStock()
	{
		return carteController.getStock();
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
		boolean valide = true;
		
		if(nom.equals(""))
		{
			valide = false;
			errors.add("Le nom ne doit pas être nul");
		}
		
		if(nom.length() > 20)
		{
			valide = false;
			errors.add("Le nom doit faire moins de 20 caractères");
		}
		
		return valide;
	}
	
	public boolean validateDescription(String description)
	{
		boolean valide = true;
		
		if(description.length() > 150)
		{
			valide = false;
			errors.add("La description doit faire moins de 150 caractères");
		}
		
		if(description.equals(""))
		{
			valide = false;
			errors.add("La description ne doit pas être nul");
		}
		
		return valide;
	}
	
	public boolean validatePrice(float price)
	{
		boolean valide = true;
		
		if(price < 0)
		{
			valide = false;
			errors.add("Le prix ne peut pas être négatif");
		}
		
		return valide;
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
		for(Ingredient ingredient : stock.getIngredients())
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
			for(Ingredient ingredient : stock.getIngredients())
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
		if(e.getActionCommand().equals(Constantes.DELETE))
			carteController.removePlat(plat);
		
		else if(e.getActionCommand().equals(Constantes.VALIDATE))
		{
			if(setPlat(fields.getNom(),fields.getDescription(),fields.getPrix(),fields.getIngredients()))
				card.switchCard();
			
			else
				new ErrorDialog(errors);
		}
		
	}

	public void setCard(PlatCard platCard) 
	{
		this.card = platCard;
	}
	
	public void setField(PlatFields fields)
	{
		this.fields = fields;
	}
}
