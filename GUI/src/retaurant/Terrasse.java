package retaurant;
import java.util.ArrayList;
import java.util.Observable;

import database.Connector;



public class Terrasse extends Observable
{
	private ArrayList<Table> terrasse;
	
	public Terrasse(ArrayList<Table> terrasse)
	{
		this.terrasse = terrasse;
	}
	
	public Terrasse()
	{
		this.terrasse = new ArrayList<Table>();
		Connector con = new Connector();
		this.terrasse = con.getTables();				
	}


	public void add(Table table)
	{
		terrasse.add(table);
	}
	
	public void remove(Table table) throws Exception
	{
		if(terrasse == null)
			throw new Exception("il n'y a plus de tables");
		
		terrasse.remove(table);
	}

	
	public ArrayList<Table> getTerrasse()
	{	
		return terrasse;
	}
	
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
