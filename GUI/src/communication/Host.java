package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Host 
{

	public Host()
	{
		
		ServerSocket sockethost  ;
		Socket socketofhost ;

		try {
		
			sockethost = new ServerSocket(2025);  //Cr�ation socket serveur pour connexions r�seau
			
			System.out.println("Le serveur est à l'écoute du port "+sockethost.getLocalPort());
			socketofhost = sockethost.accept();  // Le serveur accepte la connexion du client
			System.out.println("Client connect� !");
	            
		    BufferedReader in = new BufferedReader(new InputStreamReader(socketofhost.getInputStream()));
		    String resultat = in.readLine();
		    System.out.println(resultat);

		    
		    socketofhost.close();
			sockethost.close();    // Fermeture des sockets
		    
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}