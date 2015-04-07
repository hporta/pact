package retaurant;
import java.util.Observable;


/**
 * Table represents a table
 */
public class Table extends Observable
{
	private final int no;
	private boolean commande; 
	private boolean libre;
	
	public Table(int no)
	{
		this.no = no;
		this.commande = false;
		this.libre = true;
	}

	public final boolean isCommande()
	{
		return commande;
	}
	
	public final void setCommande(boolean commande)
	{	
		this.commande = commande;
		update();
	}
	
	public final boolean isLibre()
	{
		return libre;
	}
	
	public final void setLibre(boolean libre)
	{
		this.libre = libre;
		update();
	}
	
	public final int getNo()
	{	
		return no;
	}
	
	/**
	 * Notify observers
	 */
	public void update()
	{
		setChanged();
		notifyObservers();		
	}
}
