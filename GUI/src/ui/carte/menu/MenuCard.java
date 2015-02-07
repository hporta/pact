package ui.carte.menu;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.MenuController;
import retaurant.Plat;
import retaurant.Menu;
import retaurant.Stock;

@SuppressWarnings("serial")
public class MenuCard extends JPanel
{
	private MenuController controller;
	private MenuPanel parent;
	
	private MenuForm form;
	private MenuItem item;
	
	public MenuCard(MenuPanel parent, Menu menu)
	{
		this.parent = parent;
		this.controller = new MenuController(menu,new ArrayList<Plat>());
		
		this.form = new MenuForm(this,controller,new Stock());
		this.item = new MenuItem(this,menu);
		
		setLayout(new CardLayout());
		add(item);
		add(form);
	}
	
	public MenuCard(MenuPanel parent)
	{
		this(parent, new Menu());
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
	
	public void removeMenu()
	{
		parent.removeMenu(this);
	}
}
