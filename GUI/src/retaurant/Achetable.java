package retaurant;

// on cr�e une interface qui r�cup�re l'ensemble des propri�t�s d'un produit que l'on peut consommer au caf�
public interface Achetable 
{
	//renvoie le prix
	public float getPrix();
	
	//renvoie le nom
	public String getNom();
	
	//indique si l'achetable est disponible (test de quantité)
	public boolean disponible();
	
	//permet de retirer un achetable
	public void diminution() throws Exception;

}
