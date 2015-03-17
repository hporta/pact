package retaurant;
import java.util.ArrayList;
import java.util.Observable;

public class Command extends Observable
{
	
	private Table table;
	private ArrayList<Achetable> listeCommandes;
	private String etat;
	private int id;
	
	
	public Command(Table table)
	{
		listeCommandes = new ArrayList<Achetable>();
		etat = new String("N");
		//this.table= table;
	}
	
	public Command(int id)
	{
		listeCommandes = new ArrayList<Achetable>();
		etat = new String("N");
		this.id = id;
		add(new Plat("Entrée","l'entrée",1.0f));
		add(new Plat("le plat","le plat de résistance",2.0f));
		add(new Plat("Dessert", "le dessert", 6.0f));
	}

	public Command(Table table, int id, ArrayList<Achetable> liste) 
	{
		this.id = id;
		this.etat = "N";
		this.listeCommandes = liste;
		this.table = table;
	}

	public void add(Achetable achat)
	{ 
		listeCommandes.add(achat);
	}
	
	public void remove(Achetable achat) throws Exception
	{
		if(listeCommandes == null)
			throw new Exception("pas de plats command�s");
		
		listeCommandes.remove(achat);
	}
	
	public Table getTable()
	{	
		return table;
	}
	
	public ArrayList<Achetable> getListeCommandes()
	{	
		return listeCommandes;
	}
	
	
	public String getEtat()
	{	
		return etat;
	}
	
	public void setEtat(String etat)
	{
		this.etat = etat;
		table.setCommande(true);
		setChanged();
		notifyObservers();
	}
	
	public float getTotal()
	{
		float total = 0.f;
		for(Achetable achat : listeCommandes)
			total += achat.getPrix();
		
		return total;
	}
	
	public int getId()
	{
		return id;
	}
	
}
