package ui.recette.menu;

import java.util.Observable;
import java.util.Observer;

import controller.RecetteController;
import controller.MenuController;
import restaurant.Recette;
import restaurant.Menu;
import ui.Constantes;
import ui.ListPanel;

@SuppressWarnings("serial")
public class MenuPanel extends ListPanel implements Observer
{
	//Model
	private Recette carte;
	
	//Controller
	private RecetteController carteController;
		
	public MenuPanel(RecetteController carteController)
	{
		super(carteController, Constantes.ADD_MENU);
		this.carteController = carteController;

		carte = carteController.getCarte();
		carte.addObserver(this);
		
		update(carte, null);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		clean();
		
		for(Menu menu : carte.getMenus())
			addElement(new MenuCard(new MenuController(menu, carteController)));

		showList();
	}
}
