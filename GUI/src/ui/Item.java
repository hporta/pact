package ui;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Item extends JPanel{

	private String nom;
	private String description;
	private double prix;
	private int quantite;
	
	public Item(String nom, String description, double prix, int quantite) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		
		setLayout(new BorderLayout());
		add(new JLabel(nom),BorderLayout.WEST);
		add(new JLabel(description),BorderLayout.PAGE_END);
		add(new JLabel("Prix : "+prix + "€  Stocks : "+quantite),BorderLayout.EAST);
		
		setBorder(BorderFactory.createLineBorder(Color.blue));
	}
	
	
	
}
