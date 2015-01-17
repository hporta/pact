package retaurant;
import java.util.ArrayList;



public class Terrasse
{
	private ArrayList<Table> terrasse;
	
	public Terrasse(ArrayList<Table> terrasse)
	{
		this.terrasse = terrasse;
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
