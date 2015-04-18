package ui.parasol;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.TerrasseController;
import restaurant.Table;
import restaurant.Terrasse;

@SuppressWarnings("serial")
public class ParasolPanel extends JPanel implements Observer
{
	//Model
	private Terrasse terrasse;
	
	//GridBagContraints
	private GridBagConstraints cstr;
	
	public ParasolPanel(TerrasseController terrasseController) 
	{
		//Model + observer
		terrasse = terrasseController.getTerrasse();
		terrasse.addObserver(this);
		
		//Prepare the layout
		buildLayout();
		
		//Update with model
		update(terrasse, null);
	}
	
	public void buildLayout()
	{
		setLayout(new GridBagLayout());
		cstr = new GridBagConstraints();
		cstr.fill = GridBagConstraints.BOTH;
		cstr.anchor = GridBagConstraints.PAGE_START;
		cstr.gridwidth = 2;
		cstr.gridx = 0;
		cstr.gridy = 0;
		cstr.weightx = 0.5;
		cstr.weighty = 1;
	}
	

	@Override
	public void update(Observable o, Object arg) 
	{
		removeAll();
		
		for(Table table : terrasse.getTerrasse())
			add(new ParasolLabel(table),cstr);
		
		validate();
		repaint();
	}
	
}
