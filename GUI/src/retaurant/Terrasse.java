package retaurant;
import java.util.ArrayList;
import java.util.Observable;

import database.Connector;
import database.TableConnector;


/**
 * Terrasse represents the list of tables outside
 */
public class Terrasse extends Observable
{
	//M
	private ArrayList<Table> terrasse;
	
	/**
	 * Default constructor
	 * Will use the tables found in the database
	 */
	public Terrasse()
	{
		this.terrasse = TableConnector.getTables();				
	}

	/**
	 * Get the list of tables
	 * @return
	 */
	public ArrayList<Table> getTerrasse()
	{	
		return terrasse;
	}
	
	
	/**
	 * Not used in this version
	 * @param table
	 */
	public void add(Table table)
	{
		terrasse.add(table);
	}
	
	/**
	 * Not used in this version
	 * @param table
	 * @throws Exception
	 */
	public void remove(Table table) throws Exception
	{
		if(terrasse == null)
			throw new Exception("il n'y a plus de tables");
		
		terrasse.remove(table);
	}
	
	/**
	 * Finds a table by its id
	 * @param id
	 * @return
	 */
	public Table getTableById(int id)
	{
		for(Table table : terrasse)
		{
			if(table.getNo() == id)
				return table;
		}
		
		return null;
	}
	
}
