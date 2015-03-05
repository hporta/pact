package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {

	public static void main(String[] args) {
		
		
				Socket socket;
				PrintWriter out;
				
				Audio audio= new  Audio("Coca");
				System.out.println(audio.getResultReco());
				try {
			
				     socket = new Socket(InetAddress.getLocalHost(),2025); // Connexion au serveur sur port 2025
				        
				     out = new PrintWriter(socket.getOutputStream());
				     out.println(audio.getResultReco());
				     out.flush();
				     
			         socket.close();   // Fermeture socket

				}catch (UnknownHostException e) {
					
					e.printStackTrace();
				}catch (IOException e) {
					
					e.printStackTrace();

		

				}
				
	}
}


