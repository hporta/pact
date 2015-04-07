package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import retaurant.Consommable;
import retaurant.Ingredient;
import retaurant.Plat;
import retaurant.Stock;

public class PlatConnector extends Connector
{
	/**
	 * Returns a list of dishes from the database.
	 * Every dish is initialized with the value found in the columns
	 * @return the list of dishes
	 */
	public static ArrayList<Plat> getPlats(Stock stock)
	{
		ArrayList<Plat> liste = new ArrayList<Plat>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "SELECT * from Plat";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(req);
	        
        	while(result.next())
        	{
        		String nom = result.getString("nom");
        		String description = result.getString("description");
        		float prix = result.getFloat("prix");
        		int id = result.getInt("idPlat");
        		liste.add(new Plat(nom,description,prix,id));
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
		
		/** At this point liste is filled with plats with no ingredients
		*   we need to fill it now
		*/
		for(Plat plat : liste)
		{
			plat.setIngredients(findIngredients(stock, plat.getId()));
		}
		
		return liste;
	}
	
	public static void insertPlat()
	{
		
	}
	
	public static void insertPlat()
	{
		
	}
	
	public static void insertIngredientToPlat(int idIngredient, int idPlat)
	{
		
	}
	
	public static void removeIngredientOfPlat(int idIngredient, int idPlat)
	{
		
	}
	
	/**
	 * Deletes plat from database
	 * Also deletes entries from *****
	 */
	public static void deletePlat()
	{
		
	}
	
	/**
	 * 
	 * @param stock
	 * @param idPlat
	 * @return
	 */
	private static ArrayList<Ingredient> findIngredients(Stock stock, int idPlat)
	{
		ArrayList<Ingredient> liste = new ArrayList<Ingredient>();
		ArrayList<Integer> listeId = new ArrayList<Integer>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "SELECT * from ********** WHERE idPlat = ?";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(req);
	        
        	while(result.next())
        	{
        		Integer id = result.getInt("id*****");
        		listeId.add(id);
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
		
		/*
		 * At this point liste is filled with ids with no ingredients
		 *   we need to fill it now
		 */
		for(int id : listeId)
		{
			liste.add(stock.findIngredientById(id));
		}
		
		return liste;
	}
}
