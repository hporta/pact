package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import restaurant.Achetable;
import restaurant.Command;

public class CommandeController implements ActionListener
{
	private Command commande;
	
	public CommandeController(Command commande)
	{
		this.commande = commande;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("confirmer"))
		{
			confirmerCommande();
		}
	}

	public void confirmerCommande()
	{
		if(allAvailable())
		{
			for(Achetable achetable : commande.getListeCommandes())
				achetable.commander();
			
			commande.setEtat("O");
		}
		
		else
			System.out.println("Un des éléments n'est pas commandable");
	}
	
	public boolean allAvailable()
	{
		for(Achetable achetable : commande.getListeCommandes())
		{
			if(!achetable.disponible())
				return false;
		}
		
		return true;
	}
	
	public Command getCommande()
	{
		return commande;
	}
}
