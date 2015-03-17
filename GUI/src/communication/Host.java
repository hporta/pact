package communication;

import controller.RestaurantController;


public class Host 
{
	public Host(RestaurantController restaurantController)
	{
		//Thread pour les commandes
		Thread orders = new OrderThread(restaurantController);
		orders.start();
		
		//Thread pour les images
		Thread images = new ImageThread(restaurantController);
		images.start();
	}
}