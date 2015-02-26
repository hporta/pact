package ui.parasol;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Table;
import retaurant.Terrasse;

@SuppressWarnings("serial")
public class ParasolPanel extends JPanel
{

	public ParasolPanel() 
	{
		super();
		setLayout(new GridLayout(3,2));
	
		add(new ParasolLabel(new Table(1,true,false)));
		add(new ParasolLabel(new Table(2,false, true)));
		add(new ParasolLabel(new Table(3,true,true)));
		add(new ParasolLabel(new Table(4,false,false)));
		add(new ParasolLabel(new Table(5,true,false)));
		add(new ParasolLabel(new Table(6,true,true)));
	}
	
	public ParasolPanel(Terrasse terrasse)
	{
		super();
		ArrayList<Table> tables = terrasse.getTerrasse();
		setLayout(new GridLayout(((tables.size()+1)/2),2));
		
		for(Table table : tables)
			add(new ParasolLabel(table));
	}
	
	public void update()
	{
		
	}

}
