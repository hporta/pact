package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdministrationPanel extends JPanel{

	private final JLabel header;
	private final ContentPanel content;
	
	public AdministrationPanel() {
		super();
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.PAGE_START;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 1;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.BOTH;
		
		add(header = new JLabel("Administration"), c);
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setForeground(Color.white);
		header.setBackground(new Color(200,55,55));
		header.setOpaque(true);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 1;
		c.weighty = 0.6;
		c.fill = GridBagConstraints.BOTH;
		add(content = new ContentPanel(), c);
	}
}
