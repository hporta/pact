package communication;

import controller.RestaurantController;


public class Host 
{
	public Host(RestaurantController restaurantController)
	{		
		//Thread pour les images
		Thread images = new ImageThread(restaurantController);
		images.start();
		
		//Thread pour l'audio
		Thread audio = new AudioThread(restaurantController);
		audio.start();
		
		//Thread pour la video
		Thread video = new VideoThread(restaurantController);
		video.start();
	}
}