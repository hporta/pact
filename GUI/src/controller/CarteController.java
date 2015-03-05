package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import retaurant.Achetable;
import retaurant.Carte;
import retaurant.Command;
import retaurant.Menu;
import retaurant.Plat;
import retaurant.Stock;
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
	
	public final void addPlat(Plat plat)
	{
		carte.addPlat(plat);
	}
	
	public final void removePlat(Plat plat)
	{
		carte.removePlat(plat);
	}
	
	public final void removeMenu(Menu menu)
	{
		carte.removeMenu(menu);
	}
	
	public final void addMenu(Menu menu)
	{
		carte.addMenu(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(Constantes.ADD_PLAT))
			addPlat(new Plat());
		
		else if(e.getActionCommand().equals(Constantes.ADD_MENU))
			addMenu(new Menu());
		
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
