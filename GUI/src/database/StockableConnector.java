package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockableConnector extends Connector
{
	private static final String CONSOMMABLE_LABEL = "produit";
	private static final String INGREDIENT_LABEL = "ingredient";
	
	public static void insertConsommable(int idConsommable)
	{
		insert(idConsommable, CONSOMMABLE_LABEL);
	}
	
	public static void deleteConsommable(int idConsommable)
	{
		delete(idConsommable, CONSOMMABLE_LABEL);
	}
	
	public static void insertIngredient(int idIngredient)
	{
		insert(idIngredient, INGREDIENT_LABEL);
	}
	
	public static void deleteIngredient(int idIngredient)
	{
		delete(idIngredient, INGREDIENT_LABEL);
	}
	
	private static void insert(int id, String type)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = "INSERT INTO Stockable(idStockable, type) VALUES(?,?)";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, id);
	        stmt.setString(2, type);
	        
	        stmt.executeUpdate();
	        
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (insertion stockable)");
	    }
	}
	
	private static void delete(int id, String type)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = "DELETE FROM Stockable WHERE idStockable = ? AND type = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, id);
	        stmt.setString(2, type);
	        
	        stmt.executeUpdate();
	        
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (delete Stockable)");
	    }
	}
}
