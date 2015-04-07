package retaurant;

import java.util.Observable;

//cette classe représente l'ensemble de ce qui est en stock
public abstract class Produit extends Observable
{
	private String nom;
	private int noinstock;
	private final int id;
	
	/**
	 * 
	 * @param nom
	 * @param noinstock
	 * @param id
	 */
	public Produit(String nom, int noinstock, int id)
	{
		this.nom = nom;
		this.noinstock = noinstock;
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public final String getNom()
	{	
		return nom;
	}
	
	/**
	 * 
	 * @param nom
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
		update();
	}
	
	/**
	 * 
	 * @return
	 */
	public final int getNoInStock()
	{	
		return noinstock;
	}
	
	/**
	 * 
	 * @param noinstock
	 */
	public final void setNoInStock(int noinstock)
	{
		this.noinstock = noinstock;
		update();
	}	
	
	/**
	 * 
	 * @return
	 */
	public final int getId()
	{
		return id;
	}
	
	/**
	 * Update the database and the notify the observers
	 */
	public void update()
	{
		updateDatabase();
		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 */
	public abstract void updateDatabase();
}
