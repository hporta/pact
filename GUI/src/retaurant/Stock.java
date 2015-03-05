package retaurant;
import java.util.ArrayList;
import java.util.Observable;


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
		
		addConsommable(new Consommable("Chips",10,1.5f));
		addConsommable(new Consommable("Perrier",7,3.0f));
		addConsommable(new Consommable("Coca",5,1.2f));
		addConsommable(new Consommable("Eau",10,1.5f));
		addConsommable(new Consommable("Thé à la menthe",7,3.0f));

		addIngredient(new Ingredient("Pommes de terre",15));
		addIngredient(new Ingredient("Carrotes",7));
		addIngredient(new Ingredient("Pommes",3));
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
