package ui;

import javax.swing.JTabbedPane;

import retaurant.Ingredient;
import retaurant.Plat;

@SuppressWarnings("serial")
public class CartePanel extends JTabbedPane
{
	private final MenuPanel menu;
	private final PlatPanel plat;
	
	private final String MENUS = "Menus";
	private final String PLATS = "Plats";
	
	public CartePanel()
	{
		super();
		
		addTab(MENUS, menu = new MenuPanel());
		addTab(PLATS, plat = new PlatPanel());
		
		
		Plat temp = new Plat("Frites","des frites maison",3.2f);
		temp.addIngredient(new Ingredient("Pommes de terre",8));
		plat.addPlat(temp);
		
		temp = new Plat("Steak Haché aux haricots","un steak haché pur boeuf et des haricots verts frais",8.0f);
		temp.addIngredient(new Ingredient("Pommes de terre",8));
		temp.addIngredient(new Ingredient("Boeuf",2));
		temp.addIngredient(new Ingredient("Haricots verts",10));
		plat.addPlat(temp);
	}
}
