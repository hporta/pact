package ui.recette.menu;

import ui.CardPanel;
import ui.recette.menu.MenuForm;
import ui.recette.menu.MenuItem;
import controller.MenuController;

@SuppressWarnings("serial")
public class MenuCard extends CardPanel
{	
	public MenuCard(MenuController menuController)
	{
		//Informe le menu qu'il doit notifier ses modifications
		menuController.setCard(this);
		
		//Création des 2 panels
		add(new MenuItem(this, menuController));
		add(new MenuForm(this, menuController));
	}
	
}
