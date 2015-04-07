package communication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import controller.RestaurantController;

/**
 * Sert pour le transfert de fichier audio
 *
 */
public class AudioThread extends Thread
{
	//Controller
	private RestaurantController controller;
	
	//Socket
	private ServerSocket server;
	private final int AUDIO_PORT = 2027;
	
	public AudioThread(RestaurantController controller)
	{
		this.controller = controller;
		
		try
		{
			server = new ServerSocket(AUDIO_PORT);
		}
		
		catch(Exception e)
		{
			System.err.println("[Audio] Erreur lors de l'initialisation du serveur (port 2027");
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
			System.out.println("[Audio] Client connecté");
			
			//Fonction de transfert
			Transfert.transfert(client.getInputStream(), new FileOutputStream("data/record.wav"), true);
			
			//Fermeture des sockets
			client.close();
			System.out.println("[Audio] Fin de connection");
			
			//Traitement du fichier image
			controller.traiteAudio();
		}
		
		catch (IOException e) 
		{
			System.err.println("[Fichier] Erreur pendant la connection avec le client");
		}
	}
}
