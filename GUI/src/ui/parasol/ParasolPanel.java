package ui.parasol;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.RestaurantController;
import controller.TerrasseController;

import retaurant.Table;
import retaurant.Terrasse;

@SuppressWarnings("serial")
public class ParasolPanel extends JPanel implements Observer
{
	//Model
	private Terrasse terrasse;
	
	
	public ParasolPanel(TerrasseController terrasseController) 
	{
		this.terrasse = terrasseController.getTerrasse();
		terrasse.addObserver(this);
		
		update(terrasse,null);
	}
	

	@Override
	public void update(Observable o, Object arg) 
	{
		removeAll();
		setLayout(new GridLayout(terrasse.getTerrasse().size()/2,2));
		
		for(Table table : terrasse.getTerrasse())
		{
			add(new ParasolLabel(table));
		}
	}
	
}
