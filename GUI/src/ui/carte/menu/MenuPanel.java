package ui.carte.menu;

import java.util.Observable;
import java.util.Observer;

import controller.CarteController;
import controller.MenuController;
import restaurant.Carte;
import restaurant.Menu;
import ui.Constantes;
import ui.ListPanel;

@SuppressWarnings("serial")
public class MenuPanel extends ListPanel implements Observer
{
	//Model
	private Carte carte;
	
	//Controller
	private CarteController carteController;
		
	public MenuPanel(CarteController carteController)
	{
		super(carteController, Constantes.ADD_MENU);
		this.carte = carteController.getCarte();
		this.carteController = carteController;
		
		this.carte.addObserver(this);
		
		update(null);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		clean();
		
		for(Menu menu : carte.getMenus())
			addElement(new MenuCard(new MenuController(menu, carteController)));

		show();
	}
}
