package controller;

import retaurant.Consommable;

public class ConsommableController 
{
	private Consommable consommable;
	private StockController controller;
	
	public ConsommableController(Consommable consommable, StockController controller)
	{
		this.consommable = consommable;
		this.controller = controller;
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
		controller.removeConsommable(consommable);
	}
	
}
