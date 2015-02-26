package ui.carte.menu;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.carte.menu.MenuForm;
import ui.carte.menu.MenuItem;

import controller.MenuController;

@SuppressWarnings("serial")
public class MenuCard extends JPanel implements ActionListener
{	
	public MenuCard(MenuController menuController)
	{
		//Informe le menu qu'il doit notifier ses modifications
		menuController.setCard(this);
		
		//Création des 2 panels
		setLayout(new CardLayout());
		add(new MenuForm(this, menuController));
		add(new MenuItem(this, menuController));
	}
	
	
	public void switchCard()
	{
		CardLayout card = (CardLayout) getLayout();
		card.next(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Switch"))
			switchCard();		
	}
	
	
}
