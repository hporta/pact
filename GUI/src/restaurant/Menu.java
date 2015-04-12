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
		updateDatabase();
	}
	
	public final String getDescription()
	{
		return description;
	}
	
	public final void setNom(String nom)
	{
		this.nom = nom;
		update();
		updateDatabase();
	}
	
	public final String getNom()
	{
		return nom;
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
	
	@Override
	public final void setPrix(float prix) 
	{
		this.prix = prix;
		update();
		updateDatabase();
	}

	public ArrayList<Plat> getPlat() 
	{
		return menu;
	}

	public final void initPlats(ArrayList<Plat> menu) 
	{
		this.menu = menu;
		update();
	}
	
	public final void setPlats(ArrayList<Plat> newMenu)
	{
		ArrayList<Plat> delete = new ArrayList<Plat>();
		ArrayList<Plat> insert = new ArrayList<Plat>();
		
		for(Plat plat : this.menu)
		{
			if(!newMenu.contains(plat))
				delete.add(plat);
		}
		
		for(Plat plat : newMenu)
		{
			if(!menu.contains(plat))
				insert.add(plat);
		}
		
		for(Plat plat : delete)
			removePlat(plat);
		
		for(Plat plat : insert)
			addPlat(plat);
	}
	
	public final void addPlat(Plat plat)
	{
		menu.add(plat);
		MenuConnector.insertPlatToMenu(getId(), plat.getId());
		update();
	}
	
	public final void removePlat(Plat plat)
	{
		menu.remove(plat);
		MenuConnector.removePlatOfMenu(plat.getId(), getId());
		update();
	}


	public final void update()
	{
		setChanged();
		notifyObservers();
	}
	
	public final void updateDatabase()
	{
		MenuConnector.updateMenu(getId(),nom, description, prix);
	}
}
