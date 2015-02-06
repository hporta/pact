package retaurant;
import java.util.ArrayList;

public class Command
{
	
	//private final Table table;
	private ArrayList<Achetable> listeCommandes;
	private String etat;// etat de la commande
	
	
	public Command(Table table)
	{
		listeCommandes = new ArrayList<Achetable>();
		etat = new String("En cours");// lorsqu'on cr�e une commande elle sera en cours
		//this.table= table;
	}
	
	public Command(int id)
	{
		listeCommandes = new ArrayList<Achetable>();
		etat = new String("En cours");
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
	/*
	public Table getTable()
	{	
		return table;
	}*/
	
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
	}
	
	public float getTotal()
	{
		float total = 0.f;
		for(Achetable achat : listeCommandes)
			total += achat.getPrix();
		
		return total;
	}
	
}
