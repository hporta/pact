package ui.recette.plat;

import java.util.Observable;
import java.util.Observer;

import controller.RecetteController;
import controller.PlatController;
import restaurant.Recette;
import restaurant.Plat;
import ui.Constantes;
import ui.ListPanel;

@SuppressWarnings("serial")
public class PlatPanel extends ListPanel implements Observer
{
	//Model
	private Recette carte;
	
	//Controller
	private RecetteController carteController;
	
	
	public PlatPanel(RecetteController carteController)
	{
		super(carteController, Constantes.ADD_PLAT);
		this.carteController = carteController;
		this.carte = carteController.getCarte();
		this.carte.addObserver(this);
		
		update(carte, null);
	}
	
	@Override
	public void update(Observable a, Object e)
	{
		clean();
		
		for(Plat plat : carte.getPlats())
				addElement(new PlatCard(
						new PlatController(plat,carteController)));
		showList();
	}
}
