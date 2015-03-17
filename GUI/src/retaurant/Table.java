package retaurant;
import java.util.Observable;



public class Table extends Observable
{
	private int no;
	private boolean commande; 
	private boolean libre;
	
	public Table(int no)
	{
		this.no = no;
		this.commande = false;
		this.libre = true;
	}
	
	public Table(int no, boolean commande, boolean libre)
	{
		this.no = no;
		this.commande = commande;
		this.libre = libre;
	}
    
	public final void setCommande(boolean commande)
	{	
		this.commande = commande;
		setChanged();
		notifyObservers();
	}
	
	public final boolean isCommande()
	{
		return commande;
	}
	
	public final void setLibre(boolean libre)
	{
		this.libre = libre;
		setChanged();
		notifyObservers();
	}

	public final boolean isLibre()
	{
		return libre;
	}
	
	public final int getNo()
	{	
		return no;
	}
	

	
	//Si la table est prope on a une rreur
	/*public void clean() throws Exception
	{
		if(commande == false)
			System.out.println("envoyer un serveur nettoyer table" + no);
	}
	
	// si la table est libre on a une erreur
	public void callServeur() throws Exception
	{
		if(libre == true)
			throw new Exception("Erreur il n'y a personne à table");
		
		System.out.println("Besoin de serveur à la table : " + no);
	}
	
	//on reconnait des achetables dans les paroles que l'on r�cup�rent du module audio
	public Command passerCommande(ArrayList<String> paroles) throws Exception
	{
		if(libre == true)
			throw new Exception("Erreur il n'y a personne à  table");
		
		Command command = new Command(this);
		for(String mot : paroles)
			for(Achetable element : Carte.getCarte())
				if(mot.equals(element))
					command.add(element);
	
		return command;
	}*/	

}
