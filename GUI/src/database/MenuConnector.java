package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restaurant.Plat;
import restaurant.Menu;
import restaurant.Recette;

public class MenuConnector extends Connector
{
	
	private static final String DEFAULT_NAME = "nom";
	private static final String DEFAULT_DESCRIPTION = "description";
	private static final float DEFAULT_PRICE = 0.f;
	
	/**
	 * Returns a list of Menus from the database.
	 * Every Menu is initialized with the value found in the columns
	 * @return the list of Menu
	 */
	public static ArrayList<Menu> getMenus(Recette carte)
	{
		ArrayList<Menu> liste = new ArrayList<Menu>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "SELECT * from Menu";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(req);
	        
        	while(result.next())
        	{
        		String nom = result.getString("nom");
        		String description = result.getString("description");
        		float prix = result.getFloat("prix");
        		int id = result.getInt("idMenu");
        		
        		liste.add(new Menu(nom,description,prix,id));
        	}
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL getMenus");
	    }
		
		/** At this point liste is filled with Menus with no Plats
		*   we need to fill it now
		*/
		for(Menu menu : liste)
		{
			menu.initPlats(findPlats(carte, menu.getId()));
		}
		
		return liste;
	}
	
	public static Menu insertMenu(String name, String description, float price)
	{
		int id = -1;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = "INSERT INTO Menu(nom, description, prix) VALUES(?,?,?)";
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
	    	System.out.println("Erreur lors de la requete SQL (insertion menu)");
	    }
		
		return new Menu(name, description, price, id);
	}
	
	/**
	 * Insert Menu using the default values
	 * @return
	 */
	public static Menu insertMenu()
	{
		return insertMenu(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_PRICE);
	}
	
	/**
	 * 
	 * @param idPlat
	 * @param idMenu
	 */
	public static void insertPlatToMenu(int idMenu, int idPlat)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);

			String req = "INSERT INTO composerMenu(idMenu, idPlat) VALUES(?,?)";
	        PreparedStatement stmt = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
	        
	        stmt.setInt(1, idMenu);
	        stmt.setInt(2, idPlat);
	        
	        stmt.executeUpdate();
	        
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (insertion plat to menu)");
	    }
	}
	
	/**
	 * Remove
	 * @param idPlat
	 * @param idMenu
	 */
	public static void removePlatOfMenu(int idPlat, int idMenu)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);

			String req = "DELETE composerMenu WHERE idMenu = ? AND idPlat = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, idMenu);
	        stmt.setInt(2, idPlat);
	        
	        stmt.executeUpdate();
	        
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (morve plat of menu)");
	    }
	}
	
	/**
	 * Deletes Menu from database
	 * Also deletes entries from composerMenu
	 */
	public static void deleteMenu(int idMenu)
	{
		deleteMenuFromMenu(idMenu);
		deleteAssociatedEntriesToMenu(idMenu);
	}
	
	private static void deleteMenuFromMenu(int idMenu)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			
			String req = "DELETE Menu WHERE idMenu = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, idMenu);
	        
	        stmt.executeUpdate();
	        
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (delete menu)");
	    }
	}
	
	/**
	 * Delete entries from composerMenu
	 * @param idMenu
	 */
	private static void deleteAssociatedEntriesToMenu(int idMenu)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			
			String req = "DELETE composerMenu WHERE idMenu = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, idMenu);
	        
	        stmt.executeUpdate();
	        
	        stmt.close();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (delete associated menu)");
	    }
	}
	
	/**
	 * 
	 * @param carte
	 * @param idMenu
	 * @return
	 */
	private static ArrayList<Plat> findPlats(Recette carte, int idMenu)
	{
		ArrayList<Plat> liste = new ArrayList<Plat>();
		ArrayList<Integer> listeId = new ArrayList<Integer>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "SELECT idPlat FROM composerMenu WHERE idMenu = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        stmt.setInt(1, idMenu);
	        ResultSet result = stmt.executeQuery();
	        
        	while(result.next())
        	{
        		Integer id = result.getInt("idPlat");
        		listeId.add(id);
        	}
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL findMenu");
	    }
		
		/*
		 * At this point liste is filled with ids with no Plats
		 *   we need to fill it now
		 */
		for(int id : listeId)
		{
			liste.add(carte.findPlatById(id));
		}
		
		return liste;
	}

	public static void updateMenu(int id, String nom, String description, float prix) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "UPDATE Menu SET nom = ?, description = ?, prix = ? WHERE idMenu = ?";
	        PreparedStatement stmt = con.prepareStatement(req);
	        stmt.setString(1, nom);
	        stmt.setString(2, description);
	        stmt.setFloat(3, prix);
	        stmt.setInt(4, id);
	        stmt.executeUpdate();
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (update menu)");
	    }
	}
}
