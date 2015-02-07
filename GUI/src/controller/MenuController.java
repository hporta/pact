package controller;

import java.util.ArrayList;

import retaurant.Menu;
import retaurant.Plat;

public class MenuController 
{
	private Menu menu;
	
	public MenuController(Menu menu, ArrayList<Plat> plats)
	{
		this.menu = menu;
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

}
