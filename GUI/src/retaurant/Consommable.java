package retaurant;

public class Consommable extends Produit implements Achetable{
	private float prix;
	
public Consommable(String nom, int noinstock, float price ){
	super(nom, noinstock);
	this.prix = price;
}
public float getPrix(){
	return prix;
}
public boolean Disponible(){
	return ( this.getNoInStock() != 0 );
}
public void diminution() throws Exception{
	this.removeProduct(1);
}
}
