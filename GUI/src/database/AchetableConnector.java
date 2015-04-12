package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AchetableConnector extends Connector
{
	private static final String CONSOMMABLE_LABEL = "produit";
	private static final String MENU_LABEL = "menu";
	private static final String PLAT_LABEL = "plat";
	
	private static final String INSERT_INTO = "SELECT * FROM Achetable";
	private static final String DELETE = "DELETE FROM Achetable WHERE idAchetable = ? AND type = ?";
	
	public static void insertConsommable(int idConsommable)
	{
		insert(idConsommable, CONSOMMABLE_LABEL);
	}
	
	public static void deleteConsommable(int idConsommable)
	{
		delete(idConsommable, CONSOMMABLE_LABEL);
	}
	
	public static void insertMenu(int idMenu)
	{
		insert(idMenu, MENU_LABEL);
	}
	
	public static void deleteMenu(int idMenu)
	{
		delete(idMenu, MENU_LABEL);
	}
	
	public static void insertPlat(int idPlat)
	{
		insert(idPlat, PLAT_LABEL);
	}
	
	public static void deletePlat(int idPlat)
	{
		delete(idPlat, PLAT_LABEL);
	}
	
	private static void insert(int id, String type)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = INSERT_INTO;
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
	    	System.out.println("Erreur lors de la requete SQL (insertion achetable)");
	    }
	}
	
	private static void delete(int id, String type)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = DELETE;
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
	    	System.out.println("Erreur lors de la requete SQL (insertion achetable)");
	    }
	}
}
