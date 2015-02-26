package ui.carte.menu;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import retaurant.Carte;
import retaurant.Menu;
import retaurant.Plat;
import ui.carte.menu.MenuForm;
import ui.carte.menu.MenuItem;
import ui.carte.menu.MenuPanel;
import controller.MenuController;

@SuppressWarnings("serial")
public class MenuCard extends JPanel implements Observer, ActionListener
{
	private MenuForm form;
	private MenuItem item;
	
	public MenuCard(MenuController menuController)
	{
		//Informe le menu qu'il doit notifier ses modifications
		menuController.getMenu().addObserver(this);
		
		//Création des 2 panels
		setLayout(new CardLayout());
		add(item = new MenuForm(this, menuController));
		add(form = new MenuItem(this, menuController));
	}
	
	
	public void switchCard()
	{
		CardLayout card = (CardLayout) getLayout();
		card.next(this);
	}
	

	@Override
	public void update(Observable o, Object arg) 
	{
		item.update();
		form.update();
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Switch"))
			switchCard();		
	}
	
	
}
