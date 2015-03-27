package retaurant;
import java.util.ArrayList;
import java.util.Observable;

import database.Connector;
import database.ConsommableConnector;
import database.IngredientConnector;


public class Stock extends Observable
{
	private ArrayList<Produit> stock;
	private ArrayList<Consommable> consommables;
	private ArrayList<Ingredient> ingredients;

	public Stock()
	{
		stock = new ArrayList<Produit>();
		consommables = new ArrayList<Consommable>();
		ingredients = new ArrayList<Ingredient>();

		consommables = ConsommableConnector.getConsommables();
		ingredients = IngredientConnector.getIngredients();
	}

	public void addProduct(Produit produit)
	{
		stock.add(produit);
	}

	public void addConsommable(Consommable consommable)
	{
		consommables.add(consommable);
		stock.add(consommable);
		setChanged();
		notifyObservers();
	}

	public void addIngredient(Ingredient ingredient)
	{
		ingredients.add(ingredient);
		stock.add(ingredient);
		setChanged();
		notifyObservers();
	}

	public void removeProduct()
	{
		for(Produit produit : stock)
		{
			if(produit.getNoInStock() == 0)
				stock.remove(produit);
		}
	}

	// il renvoie tous les produits en stock
	public void etatDesStocks()
	{
		System.out.println("Etat des stocks");
		for(Produit produit : stock)
			System.out.println("Nom : " + produit.getNom() + " : " + produit.getNoInStock());

		System.out.println();
		System.out.println();
		System.out.println();
	}

	public ArrayList<Ingredient> getIngredients()
	{
		return ingredients;
	}

	public ArrayList<Consommable> getConsommables()
	{
		return consommables;
	}

	public void removeIngredient(Ingredient ingredient)
	{
		ingredients.remove(ingredient);
		stock.remove(ingredient);
		setChanged();
		notifyObservers();
	}

	public void removeConsommable(Consommable consommable)
	{
		consommables.remove(consommable);
		stock.remove(consommable);
		setChanged();
		notifyObservers();
	}
}
