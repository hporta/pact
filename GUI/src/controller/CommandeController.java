package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import restaurant.Achetable;
import restaurant.Command;
import restaurant.Consommable;

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
		for(Achetable achetable : commande.getListeCommandes())
		{
			if(achetable.getClass() == Consommable.class && achetable.disponible())
			{
				Consommable con = (Consommable) achetable;
				try {
					con.diminution();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		commande.setEtat("O");
	}
	
	public Command getCommande()
	{
		return commande;
	}
}
