package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import controller.RestaurantController;


public class Host 
{

	private boolean continuer;
	private RestaurantController controller;
	
	public Host(RestaurantController restaurantController)
	{
		continuer = true;
		this.controller = restaurantController;
		
		ServerSocket socketHost  ;

		try {
		
			//Création de la socket serveur
			socketHost = new ServerSocket(2025);
			
			System.out.println("Le serveur est à l'écoute du port "+socketHost.getLocalPort());
			
			while(continuer)
			{
				waitForClient(socketHost);
			}
			
			//Fermeture de la socket serveur
			socketHost.close();
		    
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void waitForClient(ServerSocket socketHost)
	{
		Socket socketOfHost;
		
		try
		{
			//Connection établie
			socketOfHost = socketHost.accept();
			System.out.println("Client connecté !");
	            
			//Lecture du message
		    BufferedReader in = new BufferedReader(new InputStreamReader(socketOfHost.getInputStream()));
		    String resultat = in.readLine();
		    System.out.println(resultat);
	
		    //Fermeture de la connexion
		    socketOfHost.close();
		    System.out.println("Fin de la connection");
		    
		    //Traitement de la demande
		    controller.passerCommande(resultat);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}