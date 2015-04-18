package communication;

import worker.ImageWorker;
import worker.TaskList;
import worker.AudioWorker;
import worker.VideoWorker;
import controller.RestaurantController;


public class Host 
{
	public Host(RestaurantController restaurantController)
	{		
		//Thread pour les images
		TaskList imageTaskList = new TaskList();
		Thread imageThread = new Thread(new ReceptionThread(2025, "data/image/",".jpg",imageTaskList));
		Thread imageWorker = new Thread(new ImageWorker(imageTaskList, restaurantController));
		imageThread.start();
		imageWorker.start();
		
		//Thread pour l'audio
		TaskList audioTaskList = new TaskList();
		Thread audioThread = new Thread(new ReceptionThread(2026, "data/audio/", ".wav",audioTaskList));
		Thread audioWorker = new Thread(new AudioWorker(audioTaskList, restaurantController));
		audioThread.start();
		audioWorker.start();
		
		//Thread pour la video
		TaskList videoTaskList = new TaskList();
		Thread videoThread = new Thread(new ReceptionThread(2027, "data/video/", ".mp4", videoTaskList));
		Thread videoWorker = new Thread(new VideoWorker(videoTaskList, restaurantController));
		videoThread.start();
		videoWorker.start();
	}
}