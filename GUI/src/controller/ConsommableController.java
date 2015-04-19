package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import restaurant.Consommable;
import ui.Constantes;
import ui.ErrorDialog;
import ui.stock.consommable.ConsommableCard;
import ui.stock.consommable.ConsommableFields;

public class ConsommableController implements ActionListener
{
	//View
	private ConsommableCard card;
	private ConsommableFields fields; 
	
	//Model
	private Consommable consommable;
	private ArrayList<String> errors;
	
	//Controller
	private StockController stockController;
	
	public ConsommableController(Consommable consommable, StockController stockController)
	{
		this.consommable = consommable;
		this.stockController = stockController;
		errors = new ArrayList<String>();
	}
	
	public void setCard(ConsommableCard card)
	{
		this.card = card;
	}
	
	public void setFields(ConsommableFields fields)
	{
		this.fields = fields;
	}
	
	public boolean setConsommable(String nom, int quantite, float price)
	{
		errors.clear();
		
		if(validateNom(nom) 
				&& validateQuantite(quantite) 
				&& validatePrice(price))
		{
			consommable.setNom(nom);
			consommable.setNoInStock(quantite);
			consommable.setPrix(price);
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
			errors.add("Le nom ne doit pas être vide");
		}
		
		if(nom.length() > 20)
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
		
		if(quantite > 999)
		{
			valide = false;
			errors.add("La quantite doit etre inférieur à 999");
		}
		
		return valide;
	}
	
	public boolean validatePrice(float price)
	{
		boolean valide = true;
		
		if(price < 0)
		{
			valide = false;
			errors.add("Le prix doit être positif");
		}
		
		if(price > 999)
		{
			valide = false;
			errors.add("Le prix doit être inférieur à 999€");
		}
		
		return valide;
	}

	public Consommable getConsommable() 
	{
		return consommable;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(Constantes.DELETE.equals(e.getActionCommand()))
			stockController.removeConsommable(consommable);
		
		else if(Constantes.VALIDATE.equals(e.getActionCommand()))
		{
			if(setConsommable(fields.getNom(), fields.getQuantite(), fields.getPrix()))
				card.switchCard();
			
			else
				new ErrorDialog(errors);
		}
	}
}
