package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import restaurant.Recette;
import restaurant.Menu;
import restaurant.Plat;
import restaurant.Stock;
import ui.Constantes;

public class RecetteController implements ActionListener
{
	//Model
	private Recette carte;
	private Stock stock;
	
	public RecetteController(Recette carte, Stock stock) 
	{
		this.carte = carte;
		this.stock = stock;
	}

	public final Recette getCarte() 
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
}
