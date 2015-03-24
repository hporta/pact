package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import retaurant.Command;
import retaurant.Consommable;
import retaurant.Ingredient;
import retaurant.Menu;
import retaurant.Plat;
import retaurant.Table;

public class Connector 
{
	private static final String url = "jdbc:mysql://localhost/restaurant";
	private static final String username = "root";
	private static final String pwd = "";	
	
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
	
	public static ArrayList<Plat> getPlats()
	{
		return new ArrayList<Plat>();
	}
	
	public static ArrayList<Menu> getMenus()
	{
		return new ArrayList<Menu>();
	}
	
	public static ArrayList<Table> getTables()
	{
		ArrayList<Table> liste = new ArrayList<Table>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pwd);
	        String req = "SELECT * from Tables";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(req);
	        
        	while(result.next())
        	{
        		int id = (int) result.getInt("idTable");
        		liste.add(new Table(id,false,true));
        	}
		}
		
    	catch (ClassNotFoundException e) 
		{
        	System.out.println("Erreur lors de l'initialisation de la classe");
    	}
	    
	    catch(SQLException e)
	    {
	    	System.out.println("Erreur lors de la requete SQL des Tables");
	    }
		
		return liste;
	}
	
	public static ArrayList<Command> getCommandes()
	{
		return new ArrayList<Command>();
	}
}
