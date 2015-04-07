package communication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import controller.RestaurantController;

/**
 * Sert pour l'envoi de fichiers image
 */
public class ImageThread extends Thread
{
	//Controller
	private RestaurantController controller;

	//Socket
	private ServerSocket server;
	private final int IMAGES_PORT = 2026;
	
	public ImageThread(RestaurantController controller)
	{
		this.controller = controller;
		
		try
		{
			server = new ServerSocket(IMAGES_PORT);
		}
		
		catch(Exception e)
		{
			System.err.println("[Image] Erreur lors de l'initialisation du serveur (port 2026");
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
			System.out.println("[Image] Client connecté");
			
			//Fonction de transfert
			Transfert.transfert(client.getInputStream(), new FileOutputStream("data/output.jpg"), true);
			
			//Fermeture des sockets
			client.close();
			System.out.println("[Image] Fin de connection");
			
			//Traitement du fichier image
			controller.traiteImage();
		}
		
		catch (IOException e) 
		{
			System.err.println("[Image] Erreur pendant la connection avec le client");
		}
	}
	
	
}
