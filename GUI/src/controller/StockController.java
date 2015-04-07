package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import retaurant.Achetable;
import retaurant.Consommable;
import retaurant.Ingredient;
import retaurant.Stock;
import ui.Constantes;

public class StockController implements ActionListener
{
	//Model
	private Stock stock;

	/**
	 * 
	 * @param stock
	 */
	public StockController(Stock stock) 
	{
		this.stock = stock;
	}
	
	/**
	 * 
	 * @return
	 */
	public Stock getStock()
	{
		return stock;
	}
	
	/**
	 * 
	 * @param ingredient
	 */
	public void removeIngredient(Ingredient ingredient)
	{
		stock.removeIngredient(ingredient);
	}
	
	/**
	 * 
	 * @param consommable
	 */
	public void removeConsommable(Consommable consommable)
	{
		stock.removeConsommable(consommable);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(Constantes.ADD_INGREDIENTS))
		{
			stock.addIngredient();
		}
		
		else if(e.getActionCommand().equals(Constantes.ADD_CONSOMMABLE))
		{
			stock.addConsommable();
		}
		
	}

	public ArrayList<Achetable> parse(String commande) 
	{
		ArrayList<Achetable> liste = new ArrayList<Achetable>();
		
		for(Consommable consommable : stock.getConsommables())
		{
			if(consommable.getNom().equals(commande))
				liste.add(consommable);
		}
		
		return liste;
	}
	
}
