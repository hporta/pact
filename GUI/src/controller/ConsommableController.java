package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import retaurant.Consommable;
import ui.Constantes;
import ui.stock.consommable.ConsommableCard;
import ui.stock.consommable.ConsommableFields;

public class ConsommableController implements ActionListener
{
	//View
	private ConsommableCard card;
	private ConsommableFields fields; 
	
	//Model
	private Consommable consommable;
	
	//Controller
	private StockController stockController;
	
	public ConsommableController(Consommable consommable, StockController stockController)
	{
		this.consommable = consommable;
		this.stockController = stockController;
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
		return (nom != "" && nom.length() < 20 && nom != "Nom");
	}
	
	public boolean validateQuantite(int quantite)
	{
		return quantite > 0 && quantite < 999;
	}
	
	public boolean validatePrice(float price)
	{
		return price > 0 && price < 999.;
	}

	public Consommable getConsommable() 
	{
		return consommable;
	}
	
	
	public void remove()
	{
		stockController.removeConsommable(consommable);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(Constantes.DELETE.equals(e.getActionCommand()))
		{
			remove();
		}
		
		else if(Constantes.VALIDATE.equals(e.getActionCommand()))
		{
			if(setConsommable(fields.getNom(), fields.getQuantite(), fields.getPrix()))
			{
				card.switchCard();
			}
		}
	}
	
}
