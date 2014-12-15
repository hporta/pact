package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel{

	private final TerrassePanel terrasse;
	private final AdministrationPanel administration;
	
	MainPanel()
	{
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.33;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		add(terrasse = new TerrassePanel(),c);
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.66;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		add(administration = new AdministrationPanel(),c);

	}
	
}
