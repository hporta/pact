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
				String pathName = imageTaskList.next();
				
				if(pathName != null)
				{
					boolean libre = Analyst.isLibre(pathName);
					controller.changeEtat(1,libre);
				}
			}
		}
		
		catch(InterruptedException e)
		{
			System.out.println(Thread.currentThread().getName() + " has stopped");
		}
	}
}
