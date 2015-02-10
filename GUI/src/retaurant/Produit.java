package retaurant;

import java.util.Observable;

//cette classe repr�sente l'ensemble de ce qui est en stock
public abstract class Produit extends Observable
{
	private String nom;
	private int noinstock; //nombre de produit dans les stock
	
	public Produit(String nom, int noinstock)
	{
		this.nom = nom;
		this.noinstock = noinstock;
	}
	
	public String getNom()
	{	
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
		setChanged();
		notifyObservers();
	}
	
	public int getNoInStock()
	{	
		return noinstock;
	}
	
	public void setNoInStock(int noinstock)
	{
		this.noinstock = noinstock;
		setChanged();
		notifyObservers();
	}
	
	
	public void addProduct(int quantity)
	{
		noinstock += quantity;
		setChanged();
		notifyObservers();
	}
	
    public void removeProduct(int quantity) throws Exception
    {
    	if (noinstock == 0)
    		throw new Exception("on a plus de" + nom);
    	
    	noinstock -= quantity;
		setChanged();
		notifyObservers();
	}
	
}
