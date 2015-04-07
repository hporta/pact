package ui.carte.plat;

import java.util.Observable;
import java.util.Observer;

import controller.CarteController;
import controller.PlatController;
import restaurant.Carte;
import restaurant.Plat;
import ui.Constantes;
import ui.ListPanel;

@SuppressWarnings("serial")
public class PlatPanel extends ListPanel implements Observer
{
	//Model
	private Carte carte;
	
	//Controller
	private CarteController carteController;
	
	
	public PlatPanel(CarteController carteController)
	{
		super(carteController, Constantes.ADD_PLAT);
		this.carteController = carteController;
		this.carte = carteController.getCarte();
		this.carte.addObserver(this);
		
		update(null);
	}
	
	@Override
	public void update(Observable a, Object e)
	{
		clean();
		
		for(Plat plat : carte.getPlats())
				addElement(new PlatCard(
						new PlatController(plat,carteController)));
		show();
	}
	
}
