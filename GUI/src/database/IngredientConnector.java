package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import retaurant.Ingredient;

public class IngredientConnector extends Connector
{
	public static ArrayList<Ingredient> getIngredients()
	{
		ArrayList<Ingredient> liste = new ArrayList<Ingredient>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "SELECT * from Ingredient";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(req);
	        
        	while(result.next())
        	{
        		String nom = result.getString("nom");
        		int quantite = result.getInt("quantite");
        		liste.add(new Ingredient(nom,quantite));
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
	
	public static void setIngredient(String name, String newName, int newQuantite)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "UPDATE ingredient SET nom = ?, quantite = ? WHERE nom = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        stmt.setString(1, newName);
	        stmt.setInt(2, newQuantite);
	        stmt.setString(3, name);
	        stmt.executeUpdate();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (update)");
	    }
	}
}
