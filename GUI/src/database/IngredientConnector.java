package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restaurant.Ingredient;

public class IngredientConnector extends Connector
{
	private static final String DEFAULT_NAME = "nom";
	private static final int DEFAULT_QUANTITY = 0;
	
	/**
	 * Get all the ingredients from the database and return in an ArrayList
	 * @return
	 */
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
        		int id = result.getInt("idIngredient");
        		liste.add(new Ingredient(nom,quantite,id));
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
	
	/**
	 * Updates the values of an ingredient 
	 * @param id
	 * @param newName
	 * @param newQuantite
	 */
	public static void setIngredient(int id, String newName, int newQuantite)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "UPDATE ingredient SET nom = ?, quantite = ? WHERE idIngredient = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        stmt.setString(1, newName);
	        stmt.setInt(2, newQuantite);
	        stmt.setInt(3, id);
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

	/**
	 * Insert an ingredient in the database
	 * @param name
	 * @param quantity 
	 * @return
	 */
	public static Ingredient insertIngredient(String name, int quantity)
	{
		int id = -1;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = "INSERT INTO Ingredient(nom = ?, quantite = ?)";
	        PreparedStatement stmt = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
	        
	        stmt.setString(1, name);
	        stmt.setInt(2, quantity);
	        
	        stmt.executeUpdate();
	        
	        ResultSet keys = stmt.getGeneratedKeys();
	        if(keys.next())  
	        	id = keys.getInt(1);
	        
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (insertion consommabel)");
	    }
		
		return new Ingredient(name, quantity, id);
	}
	
	/**
	 * Uses the insertIngredient with default values defined in this file
	 * @return
	 */
	public static Ingredient insertIngredient()
	{
		return insertIngredient(DEFAULT_NAME, DEFAULT_QUANTITY);
	}
	
	/**
	 * Deletes ingredient from the database found by Id
	 * @param id
	 */
	public static void deleteIngredient(int id)
	{
		try
		{
			//Connection to the database
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			
			//Prepare the statement
			String req = "DELETE Ingredient WHERE idIngredient = ?";
	        PreparedStatement stmt = con.prepareStatement(req);

	        //Bind idIngredient with id
	        stmt.setInt(1, id);
	        
	        //Execute
	        stmt.executeUpdate();
	        
	        //Close
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (insertion consommabel)");
	    }
	}
}
