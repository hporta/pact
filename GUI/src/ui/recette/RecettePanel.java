package ui.recette;

import controller.RecetteController;
import ui.TabPanel;
import ui.recette.menu.MenuPanel;
import ui.recette.plat.PlatPanel;


@SuppressWarnings("serial")
public class RecettePanel extends TabPanel
{	
	private final String MENUS = "Menus";
	private final String PLATS = "Plats";
	
	public RecettePanel(RecetteController carteController)
	{
		addTab(MENUS, new MenuPanel(carteController));
		addTab(PLATS, new PlatPanel(carteController));
	}	
}
