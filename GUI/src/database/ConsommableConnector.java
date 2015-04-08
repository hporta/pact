package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restaurant.Consommable;


public class ConsommableConnector extends Connector
{	
	private static final String DEFAULT_NAME = "nom";
	private static final int DEFAULT_QUANTITY = 0;
	private static final float DEFAULT_PRICE = 0.f;
	
	/**
	 * Returns a list of consommables from the database.
	 * Every consommable is initialized with the value found in the columns
	 * @return the list of consommables
	 */
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
        		int id = result.getInt("idProduit");
        		liste.add(new Consommable(nom,quantite,prix,id));
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
	 * Insert Consommable in the database
	 * @param name
	 * @param quantity 
	 * @param price 
	 * @return
	 */
	public static Consommable insertConsommable(String name, int quantity, float price)
	{
		int id = -1;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = "INSERT INTO Produit(nom, quantite, prix, description) VALUES(?,?,?,?)";
	        PreparedStatement stmt = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
	        
	        stmt.setString(1, name);
	        stmt.setInt(2, quantity);
	        stmt.setFloat(3, price);
	        stmt.setString(4, "description");
	        
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
	    	System.out.println("Erreur lors de la requete SQL (insertion consommable)");
	    }
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
			String req = "INSERT INTO Achetable(idAchetable, type) VALUES(?,?)";
	        PreparedStatement stmt = con.prepareStatement(req);
	        
	        stmt.setInt(1, id);
	        stmt.setString(2, "produit");
	        
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
		
		return new Consommable(name, quantity, price, id);
	}
	
	/**
	 * Uses the insertConsommable with default values defined in this file
	 * @return 
	 */
	public static Consommable insertConsommable()
	{
		return insertConsommable(DEFAULT_NAME, DEFAULT_QUANTITY, DEFAULT_PRICE);
	}
	
	/**
	 * Set consommable to the current values
	 * @param idProduit
	 * @param newName
	 * @param newQuantity
	 * @param newPrice
	 */
	public static void setConsommable(int idProduit, String newName, int newQuantity, float newPrice)
	{
		Connection con = null;
		PreparedStatement stmt = null;
		
		try
		{
			//Connexion à la base de données
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pwd);
			
			//Préparation de la requete d'update
	        stmt = con.prepareStatement("UPDATE Produit SET nom = ?, quantite = ?, prix = ? WHERE idProduit = ?");
	        stmt.setString(1, newName);
	        stmt.setInt(2, newQuantity);
	        stmt.setFloat(3, newPrice);
	        stmt.setInt(4, idProduit);
	        
	        //Execution de la requete
	        stmt.executeUpdate();	    
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (update consommable)");
	    }
		
		finally 
		{
			try
			{
				if(stmt != null)
					stmt.close();
				
				if(con != null)
					con.close();
			}
			
			catch (Exception e){}
		}
	}

	/**
	 * Delete consommable from database
	 * @param idProduit
	 */
	public static void deleteConsommable(int idProduit) 
	{
		Connection con = null;
		PreparedStatement stmt = null;
		
		try
		{
			//Connexion à la base de données
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pwd);
			
			//Préparation de la requete d'update
	        stmt = con.prepareStatement("DELETE FROM Produit WHERE idProduit = ?");
	        stmt.setInt(1, idProduit);
	        
	        //Execution de la requete
	        stmt.executeUpdate();	    
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (update consommabel)");
	    }
		
		finally 
		{
			try
			{
				if(stmt != null)
					stmt.close();
				
				if(con != null)
					con.close();
			}
			
			catch (Exception e){}
		}
		
		
		/**
		 * Suppression de la table d'achetable
		 */
		try
		{
			//Connexion à la base de données
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pwd);
			
			//Préparation de la requete d'update
	        stmt = con.prepareStatement("DELETE FROM Achetable WHERE idAchetable = ? AND type = ?");
	        stmt.setInt(1, idProduit);
	        stmt.setString(2, "produit");
	        
	        //Execution de la requete
	        stmt.executeUpdate();	    
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL (update consommabel)");
	    }
		
		finally 
		{
			try
			{
				if(stmt != null)
					stmt.close();
				
				if(con != null)
					con.close();
			}
			
			catch (Exception e){}
		}
	}
}
