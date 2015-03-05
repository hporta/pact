package controller;

import java.util.ArrayList;

import retaurant.Achetable;
import retaurant.Restaurant;

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
		compteController = new CompteController(restaurant.getCompte());
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

}
