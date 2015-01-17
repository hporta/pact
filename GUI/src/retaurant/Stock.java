package retaurant;
import java.util.ArrayList;
import java.util.Hashtable;



public class Stock
{
	private ArrayList<Produit> stock;

	public Stock()
	{
		stock = new ArrayList<Produit>();
	}
	
	public void addProduct(Produit produit)
	{
		stock.add(produit);
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
		for(Produit produit : stock)
			System.out.println("Nom" + produit.getNom() + " : " + produit.getNoInStock());
	}
}
