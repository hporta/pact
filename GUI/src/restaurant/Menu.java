package restaurant;
import java.util.ArrayList;
import java.util.Observable;

import database.MenuConnector;



public class Menu extends Observable implements Achetable
{
	private ArrayList<Plat> menu;
	private String nom;
	private float prix;
	private final int id;
	private String description;

	
	public Menu(String nom, String description, float prix, int id)
	{
		this.menu = new ArrayList<Plat>();

		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.id = id;

	}
	
	public final int getId()
	{
		return id;
	}
	
	public final void setDescription(String description)
	{
		this.description = description;
		update();
	}
	
	public final String getDescription()
	{
		return description;
	}
	
	public final void setNom(String nom)
	{
		this.nom = nom;
		update();
	}
	
	public final String getNom()
	{
		return nom;
	}
	
	public void add(Plat plat)
	{
		for(Plat platAuMenu : menu)
		{
			if(platAuMenu != plat)
				menu.add(plat);
		}
	}
	
	// un menu est disponible que si tous les plats sont disponibles
	@Override
	public boolean disponible()
	{
		for(Plat plat : menu)
		{
			if(!plat.disponible())
				return false;
		}
		  
		return true;
	}
	
	@Override
	public void commander()
	{
		for(Plat plat : menu)
			plat.commander();
	}
	
	public ArrayList<Plat> getMenu()
	{	
		return menu;
	}
	
	@Override
	public float getPrix()
	{
		return prix;
	}
	
	public void removePlat(Plat plat) throws Exception
	{
    	if(menu.size() == 0)
    		throw new Exception("le menu est vide");
    	
        menu.remove(plat);
	}

	public ArrayList<Plat> getPlat() 
	{
		return menu;
	}

	public final void setPlats(ArrayList<Plat> menu) 
	{
		this.menu = menu;
		update();
	}
	
	public final void addPlat(Plat plat)
	{
		menu.add(plat);
	}

	public final void setPrix(float prix) 
	{
		this.prix = prix;
		update();
	}
	
	public final void setPlat(ArrayList<Plat> plats)
	{
		this.menu = plats;
	}
	
	public final void update()
	{
		setChanged();
		notifyObservers();
	}
	
	public final void updateDatabase()
	{
		MenuConnector.updateMenu(nom, description, prix);
	}
}
