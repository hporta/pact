package retaurant;

public class Restaurant 
{
	private Terrasse terrasse;
	private Stock stock;
	private Carte carte;
	private Compte compte;
	
	public Restaurant()
	{
		this.terrasse = new Terrasse();
		this.stock = new Stock();
		this.carte = new Carte();
		this.compte = new Compte();
	}
}
