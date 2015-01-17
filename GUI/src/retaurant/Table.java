package retaurant;
import java.util.ArrayList;



public abstract class Table
	{
	private int no;
	private boolean propre; //propre ou sale
	private float note;
	private boolean libre; // libre ou occupé
	
	public Table(int no)
		{
		this.no = no;
		}

	public void addNote(int prixCommande){
		note += prixCommande;
	}
    public void clearNote(){
    	note = 0;
    }
	public void setEtat(boolean etat)
		{	
		propre = etat;
		}

	
	public final int getNo(){	
		return no;
		}

	
	public boolean getPropre(){	
		return propre;
		}
	
	public void clean() throws Exception//Si la table est prope on a une rreur
		{
		if(propre == false)
			System.out.println("envoyer un serveur nettoyer table" + no);
		}
	public void callServeur() throws Exception// si la table est libre on a une erreur
	{if(libre == true)
		throw new Exception("Erreur il n'y a personne à table");
	System.out.println("besoin de serveur" + no);
	}

public Command passerCommande(ArrayList<String> paroles) throws Exception//on reconnait des achetables dans les paroles que l'on récupèrent du module audio
	{
	if(libre == true)
		throw new Exception("Erreur il n'y a personne à  table");
	Command command = new Command(this);
	for(String mot : paroles){
		for(Achetable element : Carte.getCarte())
		if(mot.equals(element))
		command.add(element);
	}
	return command;
	}	

	}
