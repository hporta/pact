package controller;

import retaurant.Restaurant;

public class RestaurantController 
{
	private Restaurant restaurant;
	
	private TerrasseController terrasseController;
	private CarteController carteController;
	private StockController stockController;

	public RestaurantController(Restaurant restaurant) 
	{
		this.restaurant = restaurant;
		
		terrasseController = new TerrasseController(restaurant.getTerrasse());
		carteController = new CarteController(restaurant.getCarte(), restaurant.getStock());
		stockController = new StockController(restaurant.getStock());
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
	

}
