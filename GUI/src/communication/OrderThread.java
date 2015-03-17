package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import controller.RestaurantController;

public class OrderThread extends Thread
{
	//Controller
	private RestaurantController controller;
	private ServerSocket server;
	
	public OrderThread(RestaurantController controller)
	{
		this.controller = controller;
		
		try 
		{
			this.server = new ServerSocket(2025);
		}
		catch (IOException e) 
		{
			System.err.println("Erreur lors de l'initialisation du serveur (port 2025");
		}
	}
	
	//Waiting for a connection from the remote device
	public void run()
	{
		while(true)
		{
			waitForClient();
		}
	}
	
	
	public void waitForClient()
	{
		Socket socketOfHost;
		
		try
		{
			//Connection établie
			socketOfHost = server.accept();
			System.out.println("[Commande] Client connecté !");
	            
			//Lecture du message
		    BufferedReader in = new BufferedReader(new InputStreamReader(socketOfHost.getInputStream()));
		    String resultat = in.readLine();
		    System.out.println(resultat);
	
		    //Fermeture de la connexion
		    socketOfHost.close();
		    System.out.println("[Commande] Fin de la connection");
		    
		    //Traitement de la demande
		    controller.passerCommande(resultat);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
