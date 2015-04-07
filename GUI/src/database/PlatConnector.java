package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restaurant.Ingredient;
import restaurant.Plat;
import restaurant.Stock;

public class PlatConnector extends Connector
{
	
	private static final String DEFAULT_NAME = "nom";
	private static final String DEFAULT_DESCRIPTION = "description";
	private static final float DEFAULT_PRICE = 0.f;
	
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
	
	public static Plat insertPlat(String name, String description, float price)
	{
		int id = -1;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = "INSERT INTO Plat(nom = ?, description = ?, prix = ?)";
	        PreparedStatement stmt = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
	        
	        stmt.setString(1, name);
	        stmt.setString(2, description);
	        stmt.setFloat(3, price);
	        
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
		
		return new Plat(name, description, price, id);
	}
	
	/**
	 * Insert plat using the default values
	 * @return
	 */
	public static Plat insertPlat()
	{
		return insertPlat(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_PRICE);
	}
	
	/**
	 * 
	 * @param idIngredient
	 * @param idPlat
	 */
	public static void insertIngredientToPlat(int idPlat, int idIngredient)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);

			String req = "INSERT INTO composerPlat(idPlat = ?, idIngredient = ?)";
	        PreparedStatement stmt = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
	        
	        stmt.setInt(1, idPlat);
	        stmt.setInt(2, idIngredient);
	        
	        stmt.executeUpdate();
	        
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
	
	/**
	 * Remove
	 * @param idIngredient
	 * @param idPlat
	 */
	public static void removeIngredientOfPlat(int idIngredient, int idPlat)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);

			String req = "DELETE composerPlat(idPlat = ?, idIngredient = ?)";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, idPlat);
	        stmt.setInt(2, idIngredient);
	        
	        stmt.executeUpdate();
	        
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
	
	/**
	 * Deletes plat from database
	 * Also deletes entries from composerPlat
	 */
	public static void deletePlat(int idPlat)
	{
		deletePlatFromPlat(idPlat);
		deleteAssociatedEntriesToPlat(idPlat);
	}
	
	private static void deletePlatFromPlat(int idPlat)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			
			String req = "DELETE Plat WHERE idPlat = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, idPlat);
	        
	        stmt.executeUpdate();
	        
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
	
	/**
	 * Delete entries from composerPlat
	 * @param idPlat
	 */
	private static void deleteAssociatedEntriesToPlat(int idPlat)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			
			String req = "DELETE composerPlat WHERE idPlat = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, idPlat);
	        
	        stmt.executeUpdate();
	        
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
