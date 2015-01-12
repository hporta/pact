package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockPanel extends JPanel{

	private final JButton addItemButton;
	
	public StockPanel() {
		super();
		
		setLayout(new BorderLayout());
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(0,1));
		/*GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx =1;
		c.weighty = 0.1;
		c.insets = new Insets(0,0,0,0);*/
		
		temp.add(addItemButton = new JButton("Ajouter"));
		temp.add(new Item("Coca-cola","le coca c'est bon",1.2,3));
		temp.add(new Item("Café","le café c'est bon",1.0,10));
		temp.add(new Item("Perrier","le perrier c'est bon",1.2,3));
		
		add(temp,BorderLayout.PAGE_START);
	}

}
