package controller;

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

	public void passerCommande(int achetable) 
	{
		ArrayList<Achetable> listeAchetable = new ArrayList<Achetable>();
		listeAchetable.add(stockController.getStock().findConsommableById(achetable));
		compteController.passerCommande(listeAchetable);
	}

	public CompteController getCompteController() 
	{
		return compteController;
	}
	
	public void changeEtat(int num, boolean propre)
	{
		terrasseController.getTerrasse().getTableById(num).setPropre(propre);
	}
	
	public void changeLibre(int num, boolean libre)
	{
		terrasseController.getTerrasse().getTableById(num).setLibre(libre);
	}

}
