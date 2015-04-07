package ui.parasol;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.TerrasseController;
import restaurant.Table;
import restaurant.Terrasse;

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
		setLayout(new GridBagLayout());
		GridBagConstraints cstr = new GridBagConstraints();
		cstr.fill = GridBagConstraints.BOTH;
		cstr.anchor = GridBagConstraints.PAGE_START;
		cstr.gridwidth = 2;
		cstr.gridx = 0;
		cstr.gridy = 0;
		cstr.weightx = 0.5;
		cstr.weighty = 1;
		
		
		for(Table table : terrasse.getTerrasse())
		{
			add(new ParasolLabel(table),cstr);
		}
	}
	
}
