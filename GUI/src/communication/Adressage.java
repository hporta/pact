package communication;

import java.net.InetAddress;
import java.net.UnknownHostException;




public class Adressage 
{




	public static void main(String[] args) 
	{
		InetAddress LocaleAdresse ;
		InetAddress ServeurAdresse;
		InetAddress KazouSteph;
		

		try {

			LocaleAdresse = InetAddress.getLocalHost();  // R�cup�ration de l'adresse IP de la machine 
			System.out.println("L'adresse locale est : "+LocaleAdresse ); 
			
			ServeurAdresse= InetAddress.getByName("KazouSteph"); //R�cup�ration de l'adresse distante pour une possible utilisation ult�rieure
                        
		
			} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	


}
