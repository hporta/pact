package controller;


import java.util.ArrayList;

import retaurant.Achetable;
import retaurant.Command;
import retaurant.Compte;

public class CompteController
{
	private Compte compte;
	
	public CompteController(Compte compte)
	{
		this.compte = compte;
	}
	
	public void passerCommande(ArrayList<Achetable> liste)
	{
		compte.add(new Command(compte.nextId(),liste));
	}
	
	public final Compte getCompte()
	{
		return compte;
	}
}
