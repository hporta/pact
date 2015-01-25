package retaurant;
import java.util.ArrayList;



public class Plat implements Achetable
{
	
	private final String nom; 
	private String description;
	private float prix;
	private ArrayList<Ingredient> listeingredient;
	
	public Plat(String nom, String description, float prix)
	{
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		listeingredient = new ArrayList<Ingredient>();
	}
	
	//toujours un plat est disponible si tous les ingr�dients sont pr�sents
	public boolean disponible()
	{
		int i =0;
		
		for (Ingredient ingredient : listeingredient)
		{
			if (ingredient.getNoInStock()!=0)
				i++;
		}
		
		return(i == listeingredient.size());
	}
	
	// on diminue la quantit� de tous les ingr�dients
	public void diminution () throws Exception 
	{
		for (Ingredient ingredient : listeingredient)
			ingredient.removeProduct(1);
	}
	
	public String getNom()
	{	
		return nom;
	}
	
	// si erreur d'ortographe
	public void setDescription(String description)
	{	
		this.description = description;
	}
	
	public float getPrix()
	{	
		return prix;
	}
	
	public void setPrix(float prix)
	{	
		this.prix = prix;
	}
	
	public ArrayList<Ingredient> getIngredients()
	{
		return listeingredient;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		listeingredient.add(ingredient);
	}
}
