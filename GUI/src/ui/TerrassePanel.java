package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TerrassePanel extends JPanel{

	private final JLabel header;
	private final ParasolPanel parasol;
	
	public TerrassePanel() {
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.PAGE_START;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 1;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.BOTH;
		add(header = new JLabel("Terrasse"), c);
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setForeground(Color.white);
		header.setBackground(new Color(0,94,197));
		header.setOpaque(true);
		
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 1;
		c.weighty = 0.6;
		c.fill = GridBagConstraints.BOTH;
		add(parasol = new ParasolPanel(), c);
	}
}
