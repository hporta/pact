package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ItemSetting extends JPanel{
	
	private JTextField nom;
	private JTextArea description;
	private JFormattedTextField prix;
	private JFormattedTextField quantite;
	
	public ItemSetting() {
		super();
	}
	
	public ItemSetting(String nom, String description, double prix, int quantite) {
		
		super();
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.nom = new JTextField(nom),c);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.description = new JTextArea(description),c);
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.prix = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.prix.setValue(new Double(prix));

		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.quantite = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.quantite.setValue(new Integer(quantite));
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		c.gridheight=0;
		add(new JButton("Valider"),c);
		
		setBorder(BorderFactory.createLineBorder(Color.blue));
	}

}
