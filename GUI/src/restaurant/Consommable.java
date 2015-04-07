package restaurant;

import database.ConsommableConnector;

// ex boisson chips tous ce qui est consommable � l'unit�
public class Consommable extends Produit implements Achetable
{
	private float prix;

	/**
	 * 
	 * @param nom
	 * @param noinstock
	 * @param price
	 * @param id
	 */
	public Consommable(String nom, int noinstock, float price, int id)
	{
		super(nom, noinstock,id);
		this.prix = price;
	}
	
	/**
	 * 
	 */
	public final float getPrix()
	{
		return prix;
	}
	
	/**
	 * 
	 */
	public final void setPrix(float prix)
	{
		this.prix = prix;
		update();
	}
	
	@Override
	public final boolean disponible()
	{
		return (getNoInStock() > 0);
	}
    
    /**
     * Update the database according to current values
     */
    public final void updateDatabase()
    {
    	ConsommableConnector.setConsommable(getId(),getNom(),getNoInStock(),getPrix());
    }

}
