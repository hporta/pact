package controller;

import image.Analyst;

import java.util.ArrayList;

import restaurant.Achetable;
import restaurant.Restaurant;

public class RestaurantController 
{
	
	private TerrasseController terrasseController;
	private CarteController carteController;
	private StockController stockController;
	private CompteController compteController;

	public RestaurantController(Restaurant restaurant) 
	{		
		terrasseController = new TerrasseController(restaurant.getTerrasse());
		carteController = new CarteController(restaurant.getCarte(), restaurant.getStock());
		stockController = new StockController(restaurant.getStock());
		compteController = new CompteController(restaurant.getCompte(),restaurant.getTerrasse());
	}
	
	public CarteController getCarteController()
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
		ArrayList<Achetable> liste = carteController.parse(commande);
		liste.addAll(stockController.parse(commande));
		
		compteController.passerCommande(liste);
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
