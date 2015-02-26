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
		
		//remplissage de table
		for(int i =0; i < 9; i++)
			terrasse.add(new Table(i,i%3==0,i%2==0));
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
