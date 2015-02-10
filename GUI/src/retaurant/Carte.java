package retaurant;
import java.util.ArrayList;

//La carte contient tout ce qui peut être fait dans le restaurant
public class Carte 
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
	}
	
	public void removePlat(Plat plat)
	{
		plats.remove(plat);
	}
	
	public void addMenu(Menu menu)
	{
		menus.add(menu);
	}
	
	public void removeMenu(Menu menu)
	{
		menus.remove(menu);
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
	
	public ArrayList<Achetable> getCarte()
	{
		return carte;
	}

	public ArrayList<Plat> getPlats() 
	{
		return plats;
	}
	
	public ArrayList<Menu> getMenus()
	{
		return menus;
	}
}
