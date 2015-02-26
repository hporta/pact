package retaurant;
import java.util.ArrayList;
import java.util.Observable;

//La carte contient tout ce qui peut être fait dans le restaurant
public class Carte extends Observable
{
	private ArrayList<Achetable> carte;
	private ArrayList<Plat> plats;
	private ArrayList<Menu> menus;
	
	public Carte()
	{
		this.carte = new ArrayList<Achetable>();
		this.plats = new ArrayList<Plat>();
		this.menus = new ArrayList<Menu>();
		
		addPlat(new Plat("Entrée","l'entrée",1.0f));
		addPlat(new Plat("le plat","le plat de résistance",2.0f));
		addPlat(new Plat("Dessert", "le dessert", 6.0f));
		
		addMenu(new Menu("Royal", 10.f));
		menus.get(0).add(plats.get(0));
		menus.get(0).add(plats.get(1));
		menus.get(0).add(plats.get(2));
		
		
	}
	
	// on ajoute un elment � la carte en v�rifiant qu'il est disponible ou pas d�j� pr�sent
	public void addElement(Achetable element)
	{
		carte.add(element);
	}
	
	public void removeElement(Achetable element) throws Exception
	{
		if(carte.size() == 0)
			throw new Exception("la carte est vide");
		
		carte.remove(element);
	}
	
	public void addPlat(Plat plat)
	{
		plats.add(plat);
		setChanged();
		notifyObservers();
	}
	
	public void removePlat(Plat plat)
	{
		plats.remove(plat);
		setChanged();
		notifyObservers();
	}
	
	public void addMenu(Menu menu)
	{
		menus.add(menu);
		setChanged();
		notifyObservers();
	}
	
	public void removeMenu(Menu menu)
	{
		menus.remove(menu);
		setChanged();
		notifyObservers();
	}
	
	// on enleve les elements de la carte qui ne sont plus disponible
	public void gestionCarte()
	{
		for(Achetable element : carte)
		{
			if(element.disponible() == false)
				carte.remove(element);
		}
	}
	
	public final ArrayList<Achetable> getCarte()
	{
		return carte;
	}

	public final ArrayList<Plat> getPlats() 
	{
		return plats;
	}
	
	public final ArrayList<Menu> getMenus()
	{
		return menus;
	}
}
