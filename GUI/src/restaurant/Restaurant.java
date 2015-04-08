package restaurant;

//Restaurant contains every part of the model
public class Restaurant 
{	
	private final Terrasse terrasse;
	private final Stock stock;
	private final Recette carte;
	private final Compte compte;
	
	public Restaurant()
	{
		this.terrasse = new Terrasse();
		this.stock = new Stock();
		this.carte = new Recette(stock);
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

	public final Recette getCarte() 
	{
		return carte;
	}
	
	public final Compte getCompte()
	{
		return compte;
	}	
}
