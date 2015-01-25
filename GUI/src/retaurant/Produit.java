package retaurant;

//cette classe repr�sente l'ensemble de ce qui est en stock
public abstract class Produit 
{
	private String nom;
	private int noinstock; //nombre de produit dans les stock
	
	public String getNom()
	{	
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public int getNoInStock()
	{	
		return noinstock;
	}
	
	public void setNoInStock(int noinstock)
	{
		this.noinstock = noinstock;
	}
	
	public Produit(String nom, int noinstock)
	{
		this.nom = nom;
		this.noinstock = noinstock;
	}
	
	public void addProduct(int quantity)
	{
		noinstock += quantity;
	}
	
    public void removeProduct(int quantity) throws Exception
    {
    	if (noinstock == 0)
    		throw new Exception("on a plus de" + nom);
    	
    	noinstock -= quantity;
	}
	
}
