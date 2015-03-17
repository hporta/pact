import communication.Host;

import controller.RestaurantController;
import retaurant.Restaurant;
import ui.App;


public class MainTest 
{
	public static void main(String[] args) 
	{	
		
		//Model
		Restaurant restaurant = new Restaurant();
		
		//Controller
		RestaurantController restaurantController = new RestaurantController(restaurant);
		
		//View
		App test = new App(restaurantController);
	
		//Host
		Host host = new Host(restaurantController);
		
	}	
}
