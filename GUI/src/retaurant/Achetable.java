package retaurant;

//Interface des produits achetables
public interface Achetable 
{
	//renvoie le prix
	public float getPrix();
	public void setPrix(float prix);
	
	//renvoie le nom
	public String getNom();
	public void setNom(String nom);
	
	//indique si l'achetable est disponible (test de quantité)
	public boolean disponible();
	
	//permet de retirer un achetable
	public void diminution() throws Exception;

}
