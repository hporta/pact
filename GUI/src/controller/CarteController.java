package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import restaurant.Achetable;
import restaurant.Carte;
import restaurant.Menu;
import restaurant.Plat;
import restaurant.Stock;
import ui.Constantes;

public class CarteController implements ActionListener
{
	//Model
	private Carte carte;
	private Stock stock;
	
	public CarteController(Carte carte, Stock stock) 
	{
		this.carte = carte;
		this.stock = stock;
	}

	public final Carte getCarte() 
	{
		return carte;
	}
	
	public final Stock getStock()
	{
		return stock;
	}
	
	public final void removePlat(Plat plat)
	{
		carte.removePlat(plat);
	}
	
	public final void removeMenu(Menu menu)
	{
		carte.removeMenu(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(Constantes.ADD_PLAT))
			carte.addPlat();
		
		else if(e.getActionCommand().equals(Constantes.ADD_MENU))
			carte.addMenu();
		
	}

	public ArrayList<Achetable> parse(String commande) 
	{
		ArrayList<Achetable> liste = new ArrayList<Achetable>();
		for(Achetable achetable : carte.getCarte())
		{
			if(achetable.getNom().equals(commande))
				liste.add(achetable);
		}
		
		return liste;
	}
}
