package retaurant;

// ex boisson chips tous ce qui est consommable � l'unit�
public class Consommable extends Produit implements Achetable
{
	private float prix;
	
	public Consommable(String nom, int noinstock, float price)
	{
		super(nom, noinstock);
		this.prix = price;
	}
	
	public float getPrix()
	{
		return prix;
	}
	
	public void setPrix(float prix)
	{
		this.prix = prix;
	}
	
	//méthode de l'interface
	@Override
	public boolean disponible()
	{
		return (this.getNoInStock() != 0 );
	}
	
	@Override
	public void diminution() throws Exception
	{
		this.removeProduct(1);
	}

}
