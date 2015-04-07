package restaurant;
import java.util.ArrayList;
import java.util.Observable;

import database.MenuConnector;
import database.PlatConnector;

/**
 * Carte contains both Plats and Menus
 * They are composed types
 */
public class Carte extends Observable
{
	private ArrayList<Plat> plats;
	private ArrayList<Menu> menus;
	
	/**
	 * Default constructor using the database content
	 */
	public Carte(Stock stock)
	{
		this.plats = PlatConnector.getPlats(stock);
		this.menus = MenuConnector.getMenus(this);
	}
	
	/**
	 * 
	 * @return
	 */
	public final ArrayList<Plat> getPlats() 
	{
		return plats;
	}
	
	/**
	 * 
	 * @return
	 */
	public final ArrayList<Menu> getMenus()
	{
		return menus;
	}
	
	/**
	 * 
	 */
	public void addPlat()
	{
		//Insert Plat in database
		
		//
		plats.add(plat);
		
		//Update
		update();
	}
	
	/**
	 * Remove Plat
	 * @param plat
	 */
	public void removePlat(Plat plat)
	{
		plats.remove(plat);
		update();
	}
	
	/**
	 * 
	 * @param menu
	 */
	public void addMenu(Menu menu)
	{
		menus.add(menu);
		update();
	}
	
	/**
	 * 
	 * @param menu
	 */
	public void removeMenu(Menu menu)
	{
		menus.remove(menu);
		update();
	}
	
	/**
	 * 
	 * @param idPlat
	 * @return
	 */
	public final Plat findPlatById(int idPlat)
	{
		for(Plat plat : plats)
		{
			if(plat.getId() == idPlat)
				return plat;
		}
		
		return null;
	}

	
	/**
	 * Notify observers for update
	 */
	public final void update()
	{
		setChanged();
		notifyObservers();
	}
}
