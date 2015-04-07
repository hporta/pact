package controller;

import restaurant.Terrasse;

public class TerrasseController 
{
	private Terrasse terrasse;
	
	public TerrasseController(Terrasse terrasse)
	{
		this.terrasse = terrasse;
	}

	public Terrasse getTerrasse() 
	{
		return terrasse;
	}
}
