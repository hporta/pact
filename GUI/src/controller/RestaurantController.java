package controller;

import image.Analyst;

import java.util.ArrayList;

import restaurant.Achetable;
import restaurant.Consommable;
import restaurant.Restaurant;

public class RestaurantController 
{
	
	private TerrasseController terrasseController;
	private RecetteController carteController;
	private StockController stockController;
	private CompteController compteController;

	public RestaurantController(Restaurant restaurant) 
	{		
		terrasseController = new TerrasseController(restaurant.getTerrasse());
		carteController = new RecetteController(restaurant.getCarte(), restaurant.getStock());
		stockController = new StockController(restaurant.getStock());
		compteController = new CompteController(restaurant.getCompte(),restaurant.getTerrasse());
	}
	
	public RecetteController getCarteController()
	{
		return carteController;
	}
	
	public TerrasseController getTerrasseController()
	{
		return terrasseController;
	}
	
	public StockController getStockController()
	{
		return stockController;
	}

	public void passerCommande(String commande) 
	{
		ArrayList<Achetable> listeAchetable = new ArrayList<Achetable>();
		listeAchetable.add(stockController.getStock().findConsommableById(5));
		compteController.passerCommande(listeAchetable);
	}

	public CompteController getCompteController() 
	{
		return compteController;
	}
	
	public void traiteImage()
	{
		terrasseController.getTerrasse().getTableById(1).setLibre(false);
	}
	
	public void traiteAudio()
	{
		
	}
	
	public void changeEtat(int num, boolean libre)
	{
		terrasseController.getTerrasse().getTableById(num).setLibre(libre);
	}

}
