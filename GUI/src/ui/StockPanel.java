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

import retaurant.Plat;


public class StockPanel extends JPanel{

	private final JButton addItemButton;
	
	public StockPanel() {
		super();
		
		setLayout(new BorderLayout());
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(0,1));
		
		temp.add(addItemButton = new JButton("Ajouter"));
		temp.add(new ItemPanel(new Plat("Coca-cola","le coca c'est bon",1.2f)));
		temp.add(new ItemPanel(new Plat("Café","le café c'est bon",1.0f)));
		temp.add(new ItemPanel(new Plat("Perrier","le perrier c'est bon",1.2f)));
		temp.add(new ItemSetting(new Plat("Perrier","le perrier c'est bon",1.2f)));
		
		add(temp,BorderLayout.PAGE_START);
	}

}
