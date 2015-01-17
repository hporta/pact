package retaurant;

//boisson qui ne diff�re par leur nom mais par leur volume
public class Liquide extends Consommable
{
	private float litre;
	
	public Liquide(String nom, int noinstock,float price, float litre)
	{
		super(nom,noinstock,price);
		this.litre = litre;
	}
}
