package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import retaurant.Consommable;

public class ConsommableConnector extends Connector
{
	public static ArrayList<Consommable> getConsommables()
	{
		ArrayList<Consommable> liste = new ArrayList<Consommable>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "SELECT * from Produit";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(req);
	        
        	while(result.next())
        	{
        		String nom = result.getString("nom");
        		float prix = result.getFloat("prix");
        		int quantite = result.getInt("quantite");
        		liste.add(new Consommable(nom,quantite,prix));
        	}
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL");
	    }
		
		return liste;
	}
	
	public static void setConsommable(String name, String newName, int newQuantity, float newPrice)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        PreparedStatement stmt = con.prepareStatement("UPDATE Produit SET nom = ?, quantite = ?, prix = ? WHERE nom = ?");
	        stmt.setString(1, newName);
	        stmt.setInt(2, newQuantity);
	        stmt.setFloat(3, newPrice);
	        stmt.setString(4, name);
	        System.out.println(stmt);
	        stmt.executeUpdate();	
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (update consommabel)");
	    }
	}
}
