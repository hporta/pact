package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import retaurant.Menu;
import retaurant.Plat;

public class MenuController implements ActionListener
{
	private Menu menu;
	
	private CarteController carteController;
	
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("del"))
			carteController.removeMenu(menu);
		
	}

}
