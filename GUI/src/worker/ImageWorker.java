package worker;

import image.Analyst;
import controller.RestaurantController;

public class ImageWorker implements Runnable
{
	private TaskList imageTaskList;
	private RestaurantController controller;
	
	public ImageWorker(TaskList imageTaskList, RestaurantController controller)
	{
		this.imageTaskList = imageTaskList;
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
				String pathName = imageTaskList.next();
				
				if(pathName != null)
				{
					//Passer par l'analyse image
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
