package controller;


import java.util.ArrayList;

import retaurant.Achetable;
import retaurant.Command;
import retaurant.Compte;
import retaurant.Terrasse;

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
