package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import retaurant.Carte;
import retaurant.Menu;
import retaurant.Plat;
import retaurant.Stock;

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
		if(e.getActionCommand().equals("AddPlat"))
			addPlat(new Plat());
		
		else if(e.getActionCommand().equals("AddMenu"))
			addMenu(new Menu());
		
	}
}
