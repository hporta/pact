package retaurant;
import java.util.ArrayList;

public class Command
	{
	private final Table table;
	private ArrayList<Achetable> listecommandes;
	private String etat;// etat de la commande
	
	
	public Command(Table table)
		{
		listecommandes = new ArrayList<Achetable>();
		etat = new String("En cours");// lorsqu'on crée une commande elle sera en cours
		this.table= table;
		}
	
	public void add(Achetable achat)
		{ 
		listecommandes.add(achat);
		}
	public void remove(Achetable achat) throws Exception{
		if(listecommandes == null)
			throw new Exception("pas de plats commandés");
		listecommandes.remove(achat);
	}
	
	public Table getTable()
		{	
		return table;
		}
	
	public ArrayList<Achetable> getListeCommandes()
		{	
		return listecommandes;
		}
	
	
	public String getEtat()
		{	
		return etat;
		}
	
	public void setEtat(String etat)
		{
	
		this.etat = etat;
		}
	
	}
