package retaurant;

import database.Connector;
import database.ConsommableConnector;

// ex boisson chips tous ce qui est consommable � l'unit�
public class Consommable extends Produit implements Achetable
{
	private float prix;
	
	public Consommable(String nom, int noinstock, float price)
	{
		super(nom, noinstock);
		this.prix = price;
	}
	
	public Consommable()
	{
		super("Nom",0);
		this.prix = 0.f;
	}
	
	public float getPrix()
	{
		return prix;
	}
	
	public void setPrix(float prix)
	{
		this.prix = prix;
    	updateDatabase();
		setChanged();
		notifyObservers();
	}
	
	//méthode de l'interface
	@Override
	public boolean disponible()
	{
		return (this.getNoInStock() != 0 );
	}
	
	@Override
	public void diminution() throws Exception
	{
		this.removeProduct(1);
	}
	
    public void removeProduct(int quantity) throws Exception
    {    	
    	setNoInStock(getNoInStock() - quantity);
 		updateDatabase();
    	setChanged();
		notifyObservers();
	}
    
    public void updateDatabase()
    {
    	ConsommableConnector.setConsommable(getNom(),getNom(),getNoInStock(),getPrix());
    }

}
