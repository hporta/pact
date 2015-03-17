package communication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import controller.RestaurantController;

public class ImageThread extends Thread
{
	//Controller
	private RestaurantController controller;
	private ServerSocket server;
	
	public ImageThread(RestaurantController controller)
	{
		this.controller = controller;
		
		try
		{
			server = new ServerSocket(2026);
		}
		
		catch(Exception e)
		{
			System.err.println("Erreur lors de l'initialisation du serveur (port 2025");
		}
	}
	
	//Waiting for file Transfert from remote device
	public void run()
	{
		while(true)
		{
			waitForFile();
		}
	}
	
	public void waitForFile()
	{
		try 
		{
			//Le client accepte la connexion
			Socket client = server.accept();
			System.out.println("[Fichier] Client connecté");
			
			//Fonction de transfert
			Transfert.transfert(client.getInputStream(), new FileOutputStream("data/output.jpg"), true);
			
			//Fermeture des sockets
			client.close();
			System.out.println("[Fichier] Fin de connection");
			
			//Traitement du fichier image
			controller.traiteImage();
		}
		
		catch (IOException e) 
		{
			System.err.println("[Fichier] Erreur pendant la connection avec le client");;
		}
	}
	
	
}
