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
	 * Return an ArrayList of Plat
	 * @return
	 */
	public final ArrayList<Plat> getPlats() 
	{
		return plats;
	}
	
	/**
	 * Return an ArrayList of Menu
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
		Plat plat = PlatConnector.insertPlat();
		
		//Add the object to the model
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
		//Remove Plat from database
		PlatConnector.deletePlat(plat.getId());
		
		//Remove Plat from model
		plats.remove(plat);
		
		//Update
		update();
	}
	
	/**
	 * 
	 * @param menu
	 */
	public void addMenu()
	{
		//Insert Menu in database
		Menu menu = MenuConnector.insertMenu();
		
		//Add the object to the model
		menus.add(menu);
		
		//Update
		update();
	}
	
	/**
	 * 
	 * @param menu
	 */
	public void removeMenu(Menu menu)
	{
		//Remove from the database
		MenuConnector.deleteMenu(menu.getId());
		
		//Remove from the model
		menus.remove(menu);
		
		//Update
		update();
	}
	
	/**
	 * Return Plat from Carte chosing by Id
	 * If not found, return null
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
