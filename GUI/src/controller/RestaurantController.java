package controller;

import image.Analyst;

import java.util.ArrayList;

import restaurant.Achetable;
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

	}

	public CompteController getCompteController() 
	{
		return compteController;
	}
	
	public void traiteImage()
	{
		terrasseController.getTerrasse().getTableById(1).setLibre(Analyst.isLibre());
	}
	
	public void traiteAudio()
	{
		
	}

}
