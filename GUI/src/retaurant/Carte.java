package retaurant;
import java.util.ArrayList;


public class Carte 
{
	private static ArrayList<Achetable> carte = new ArrayList<Achetable>();
	
	// on ajoute un elment � la carte en v�rifiant qu'il est disponible ou pas d�j� pr�sent
	public static void addElement(Achetable element)
	{
		for(Achetable elementalacarte : carte)
		{
			if(elementalacarte != element && element.disponible())
				carte.add(element);
		}
	}
	
	public static void removeElement(Achetable element) throws Exception
	{
		if(carte.size() == 0)
			throw new Exception("la carte est vide");
		
		carte.remove(element);
	}
	
	// on enleve les elements de la carte qui ne sont plus disponible
	public static void gestionCarte()
	{
		for(Achetable element : carte)
		{
			if(element.disponible() == false)
				carte.remove(element);
		}
	}
	
	public static ArrayList<Achetable> getCarte()
	{
		return carte;
	}
}
