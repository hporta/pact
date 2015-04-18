package worker;

import image.Analyst;
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
				Thread.sleep(30000);
				String pathName = videoTaskList.next();
				
				if(pathName != null)
				{
					//Passer par l'analyse audio pour obtenir un achetable
					//envoyer au controller+
				}
				
				else
				{
					//On ne fait rien : on attend
				}
			}
		}
		
		catch(InterruptedException e)
		{
			System.out.println(Thread.currentThread().getName() + " has stopped");
		}
	}
}
