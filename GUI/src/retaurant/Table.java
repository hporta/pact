package retaurant;
import java.util.ArrayList;
import java.util.Observable;



public class Table extends Observable
{
	private int no;
	private boolean propre; //propre ou sale
	private float note;
	private boolean libre; // libre ou occup�
	
	public Table(int no)
	{
		this.no = no;
	}

	public void addNote(int prixCommande)
	{
		note += prixCommande;
	}
	
    public void clearNote()
    {
    	note = 0;
    }
    
	public void setEtat(boolean etat)
	{	
		propre = etat;
	}

	
	public final int getNo()
	{	
		return no;
	}
	
	public boolean isLibre()
	{
		return libre;
	}

	
	public boolean getPropre()
	{	
		return propre;
	}
	
	//Si la table est prope on a une rreur
	public void clean() throws Exception
	{
		if(propre == false)
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
	/*public Command passerCommande(ArrayList<String> paroles) throws Exception
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
