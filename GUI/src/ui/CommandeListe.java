package ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import retaurant.Achetable;
import retaurant.Command;


public class CommandeListe extends JPanel{
	
	private Command commande;
	
	public CommandeListe(Command commande)
	{
		this.commande = commande;
		build();
	}
	
	public void build()
	{
		setLayout(new GridLayout(0,2));
		
		add(new JLabel("Commande"));
		add(new JLabel ("Table"));
		
		for(Achetable obj: commande.getListeCommandes())
		{
			add(new JLabel(obj.getNom()));
			add(new JLabel("une quantite"));
			
			add(new JLabel(obj.getPrix() + "€"));
		}
		
		add(new JLabel("Total "));
		
		add(new JLabel("Pas de total pour le moment"));
	}
	
	

}
