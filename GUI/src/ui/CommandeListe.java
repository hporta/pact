package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Commande;
import model.Item;

public class CommandeListe extends JPanel{
	
	private Commande commande;
	
	public CommandeListe(Commande commande)
	{
		this.commande = commande;
		build();
	}
	
	public void build()
	{
		setLayout(new GridLayout(0,2));
		HashMap<Item,Integer> liste = commande.getListe();
		
		add(new JLabel("Commande"));
		add(new JLabel ("Table"));
		
		for(Item item : liste.keySet())
		{
			int quantity = liste.get(item);
			
			add(new JLabel(quantity + " x " + item.getNom()));
			
			add(new JLabel(item.getPrix()*quantity + "€"));
		}
		
		add(new JLabel("Total "));
		
		add(new JLabel(commande.getMontant() + "€"));
	}
	
	

}
