package retaurant;
import java.util.ArrayList;
import java.util.Observable;



public class Plat extends Observable implements Achetable
{
	
	private String nom; 
	private String description;
	private float prix;
	private ArrayList<Ingredient> listeingredient;
	private final int id;
	
	public Plat(String nom, String description, float prix, int id)
	{
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		listeingredient = new ArrayList<Ingredient>();
		this.id = id;
	}
	
	public final int getId()
	{
		return id;
	}
	
	//toujours un plat est disponible si tous les ingr�dients sont pr�sents
	public boolean disponible()
	{		
		for (Ingredient ingredient : listeingredient)
		{
			if(ingredient.getNoInStock()==0)
				return false;
		}
		
		return true;
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
		update();
	}
	
	public float getPrix()
	{	
		return prix;
	}
	
	public void setPrix(float prix)
	{	
		this.prix = prix;
		update();
	}
	
	public ArrayList<Ingredient> getIngredients()
	{
		return listeingredient;
	}
	
	public String getDescription()
	{
		return description;
	}
		
	public final void setNom(String nom)
	{
		this.nom = nom;
		update();
	}
	
	public final void setIngredients(ArrayList<Ingredient> liste)
	{
		listeingredient = liste;
		update();
	}
	
	/**
	 * Notify observers for update
	 */
	public void update()
	{
		setChanged();
		notifyObservers();
	}
}
