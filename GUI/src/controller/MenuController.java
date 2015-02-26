package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import retaurant.Menu;
import retaurant.Plat;
import ui.carte.menu.MenuCard;

public class MenuController implements ActionListener
{
	private Menu menu;
	
	private CarteController carteController;

	private MenuCard menuCard;
	
	public MenuController(Menu menu, CarteController carteController)
	{
		this.menu = menu;
		this.carteController = carteController;
	}

	public Menu getMenu() 
	{
		return menu;
	}

	public boolean setMenu(String text, String text2, float value,
			ArrayList<String> plats) {
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("del"))
			carteController.removeMenu(menu);
		
		else if(e.getActionCommand().equals("validate"))
		{
			if(setMenu())
			{
				menuCard.switchCard();
			}
		}
		
	}

	public void setCard(MenuCard menuCard) 
	{
		this.menuCard = menuCard;
	}

}
