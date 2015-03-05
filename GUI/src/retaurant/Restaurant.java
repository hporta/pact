package retaurant;

public class Restaurant 
{
	private final Terrasse terrasse;
	private final Stock stock;
	private final Carte carte;
	private final Compte compte;
	
	public Restaurant()
	{
		this.terrasse = new Terrasse();
		this.stock = new Stock();
		this.carte = new Carte();
		this.compte = new Compte();
	}

	public final Terrasse getTerrasse() 
	{
		return terrasse;
	}

	public final Stock getStock() 
	{
		return stock;
	}

	public final Carte getCarte() 
	{
		return carte;
	}
	
	public final Compte getCompte()
	{
		return compte;
	}
	
	
}
