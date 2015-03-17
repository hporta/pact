package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import retaurant.Command;
import retaurant.Consommable;
import retaurant.Ingredient;
import retaurant.Menu;
import retaurant.Plat;
import retaurant.Table;

public class Connector 
{
	private final String url = "jdbc:mysql://localhost/restaurant";
	private final String username = "root";
	private final String pwd = "";
	
	public Connector()
	{		

	}
	
	
	public ArrayList<Ingredient> getIngredients()
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
	
	public ArrayList<Consommable> getConsommables()
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
	
	public ArrayList<Plat> getPlats()
	{
		return new ArrayList<Plat>();
	}
	
	public ArrayList<Menu> getMenus()
	{
		return new ArrayList<Menu>();
	}
	
	public ArrayList<Table> getTables()
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
	
	public ArrayList<Command> getCommandes()
	{
		return new ArrayList<Command>();
	}
}
