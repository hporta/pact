package worker;

import java.io.File;

import audio.FinalCarte;
import controller.RestaurantController;

public class AudioWorker implements Runnable
{
	private TaskList audioTaskList;
	private RestaurantController controller;
	private FinalCarte carte;
	
	public AudioWorker(TaskList audioTaskList, RestaurantController controller)
	{
		this.audioTaskList = audioTaskList;
		this.controller = controller;
		System.out.println("Chargement de la carte");
		carte = new FinalCarte();
		System.out.println("Fin du chargement de la carte");
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
					int result = carte.recognize(pathName);
					controller.passerCommande(result);
					
					File fichier = new File(pathName);
					fichier.delete();
				}
			}
		}
		
		catch(InterruptedException e)
		{
			System.out.println(Thread.currentThread().getName() + " has stopped");
		}
	}
}
