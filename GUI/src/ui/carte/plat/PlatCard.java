package ui.carte.plat;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.PlatController;
import retaurant.Ingredient;
import retaurant.Plat;

@SuppressWarnings("serial")
public class PlatCard extends JPanel
{
	private PlatController controller;
	private PlatPanel parent;
	
	private PlatForm form;
	private PlatItem item;
	
	public PlatCard(PlatPanel parent, Plat plat)
	{
		this.parent = parent;
		this.controller = new PlatController(plat,new ArrayList<Ingredient>());
		
		this.form = new PlatForm(this,controller,new ArrayList<Ingredient>());
		this.item = new PlatItem(this,plat);
		
		setLayout(new CardLayout());
		add(item);
		add(form);
	}
	
	public PlatCard(PlatPanel parent)
	{
		this(parent, new Plat());
	}
	
	public void switchCard()
	{
		CardLayout card = (CardLayout) getLayout();
		card.next(this);
	}
	
	public void update()
	{
		item.update();
		form.update();
	}
	
	public void removePlat()
	{
		parent.removePlat(this);
	}
}
