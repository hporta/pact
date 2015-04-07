package ui.carte;

import controller.CarteController;
import ui.TabPanel;
import ui.carte.menu.MenuPanel;
import ui.carte.plat.PlatPanel;


@SuppressWarnings("serial")
public class CartePanel extends TabPanel
{	
	private final String MENUS = "Menus";
	private final String PLATS = "Plats";
	
	public CartePanel(CarteController carteController)
	{
		addTab(MENUS, new MenuPanel(carteController));
		addTab(PLATS, new PlatPanel(carteController));
	}	
}
