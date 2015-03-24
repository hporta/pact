package retaurant;

import database.Connector;

//element d'un  plat non consommable � l'unit�
public class Ingredient extends Produit
{
	public Ingredient(String nom, int noinstock)
	{
		super(nom,noinstock);
	}
	
	public Ingredient()
	{
		this("Nom",0);
	}
	
    public void removeProduct(int quantity) throws Exception
    {
    	setNoInStock(getNoInStock()-quantity);
    	Connector.setIngredient(getNom(), getNom(), getNoInStock());
		setChanged();
		notifyObservers();
	}

}