package ui.carte.menu;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Carte;
import retaurant.Menu;
import retaurant.Plat;
import ui.carte.menu.MenuForm;
import ui.carte.menu.MenuItem;
import ui.carte.menu.MenuPanel;
import controller.MenuController;

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
		
		this.form = new MenuForm(this,controller,new Carte());
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
		parent.removeMenu(controller.getMenu());
	}

}
