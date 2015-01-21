package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import retaurant.Achetable;



public class ItemPanel extends JPanel{


	private Achetable item;
	
	public ItemPanel(Achetable item)
	{
		super();
		this.item = item;
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(new JLabel(item.getNom()),c);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(new JLabel("Une description"),c);
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(new JLabel("Prix : "+item.getPrix() + "€"),c);

		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(new JLabel("Quantite : "+ "une quantité"),c);
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(new JButton("Modifier"),c);
		
		c.gridx=2;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(new JButton("Supprimer"),c);
	}	
}
