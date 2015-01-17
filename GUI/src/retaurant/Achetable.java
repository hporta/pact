package retaurant;

public interface Achetable {// on crée une interface qui récupère l'ensemble des propriétés d'un produit que l'on peut consommer au café
	public float getPrix();
	public String getNom();
	public boolean Disponible();//méthode qui permettra de mettre à  jour la carte si on a plus un produit
	public void diminution() throws Exception;//méthode qui diminura la quantité d'un consommable

}
