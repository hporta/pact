package worker;

import java.io.File;

import image.Analyst;
import image.MotionDetector;
import controller.RestaurantController;

public class VideoWorker implements Runnable
{
	private TaskList videoTaskList;
	private RestaurantController controller;
	
	public VideoWorker(TaskList videoTaskList, RestaurantController controller)
	{
		this.videoTaskList = videoTaskList;
		this.controller = controller;
	}
	
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				String pathName = videoTaskList.next();
				
				if(pathName != null)
				{
					boolean result = MotionDetector.detect(pathName);
					controller.changeLibre(1, result);
					
					//File fichier = new File(pathName);
					//fichier.delete();
				}
			}
		}
		
		catch(InterruptedException e)
		{
			System.out.println(Thread.currentThread().getName() + " has stopped");
		}
	}
}
