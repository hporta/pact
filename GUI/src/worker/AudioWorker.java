package worker;

import image.Analyst;
import controller.RestaurantController;

public class AudioWorker implements Runnable
{
	private TaskList audioTaskList;
	private RestaurantController controller;
	
	public AudioWorker(TaskList audioTaskList, RestaurantController controller)
	{
		this.audioTaskList = audioTaskList;
		this.controller = controller;
	}
	
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				String pathName = audioTaskList.next();
				
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
