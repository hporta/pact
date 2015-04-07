package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector 
{
	protected static final String url = "jdbc:mysql://localhost/restaurant";
	protected static final String username = "root";
	protected static final String pwd = "";
	
	public static Connection getConnection()
	{
		Connection connect = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect =  DriverManager.getConnection(url, username, pwd);
		}
		
		catch(ClassNotFoundException | SQLException e)
		{
			System.err.println("Erreur dans l'établissement de la connexion à la base de données");
		}
		
		return connect;
	}
}
