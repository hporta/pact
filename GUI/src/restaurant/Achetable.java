package restaurant;

//Interface des produits achetables
public interface Achetable 
{
	//renvoie le prix
	public float getPrix();
	public void setPrix(float prix);
	
	//indique si l'achetable est disponible (test de quantité)
	public boolean disponible();
}
