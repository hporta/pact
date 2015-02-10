package retaurant;
import java.util.ArrayList;
import java.util.Observable;



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
	
}
