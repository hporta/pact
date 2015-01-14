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
	
	public void removeProduct(){
		for(Produit produit : stock){
			if(produit.getNoInStock() == 0){
				stock.remove(produit);
			}
		}
	}
	public void EtatDesStocks(){// il renvoie tous les produits en stock
		for(Produit produit : stock){
			System.out.println(produit.getNom() + produit.getNoInStock());
		}
	}
	}
