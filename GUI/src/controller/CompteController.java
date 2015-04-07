package controller;


import java.util.ArrayList;

import restaurant.Achetable;
import restaurant.Command;
import restaurant.Compte;
import restaurant.Terrasse;

public class CompteController
{
	private Compte compte;
	private Terrasse terrasse;
	
	public CompteController(Compte compte,Terrasse terrasse)
	{
		this.compte = compte;
		this.terrasse = terrasse;
	}
	
	public void passerCommande(ArrayList<Achetable> liste)
	{
		compte.add(new Command(terrasse.getTableById(1),compte.nextId(),liste));
	}
	
	public final Compte getCompte()
	{
		return compte;
	}
}
