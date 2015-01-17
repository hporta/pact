package retaurant;

public class Liquide extends Consommable{//boisson qui ne différe par leur nom mais par leur volume
	private float litre;
	
	public Liquide(String nom, int noinstock,float price, float litre){
		super(nom,noinstock,price);
		this.litre = litre;
	}
}
