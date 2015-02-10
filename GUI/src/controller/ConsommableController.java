package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import retaurant.Consommable;

public class ConsommableController implements ActionListener
{
	private Consommable consommable;
	private StockController stockController;
	
	public ConsommableController(Consommable consommable, StockController stockController)
	{
		this.consommable = consommable;
		this.stockController = stockController;
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
		if("del".equals(e.getActionCommand()))
		{
			remove();
		}
		
		else if("set".equals(e.getActionCommand()))
		{
			
		}
	}
	
}
