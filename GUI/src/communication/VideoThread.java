package communication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import controller.RestaurantController;

/**
 * Sert pour l'envoi de fichiers video
 */
public class VideoThread extends Thread
{
	//Controller
	private RestaurantController controller;

	//Socket
	private ServerSocket server;
	private final int VIDEO_PORT = 2028;
	
	public VideoThread(RestaurantController controller)
	{
		this.controller = controller;
		
		try
		{
			server = new ServerSocket(VIDEO_PORT);
		}
		
		catch(Exception e)
		{
			System.err.println("[Video] Erreur lors de l'initialisation du serveur (port 2028");
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
			System.out.println("[Video] Client connecté");
			
			//Fonction de transfert
			Transfert.transfert(client.getInputStream(), new FileOutputStream("data/output.mp4"), true);
			
			//Fermeture des sockets
			client.close();
			System.out.println("[Video] Fin de connection");
		}
		
		catch (IOException e) 
		{
			System.err.println("[Video] Erreur pendant la connection avec le client");
		}
	}
	
	
}
