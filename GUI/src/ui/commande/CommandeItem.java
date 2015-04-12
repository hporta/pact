package ui.commande;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CommandeController;
import restaurant.Achetable;
import restaurant.Command;


@SuppressWarnings("serial")
public class CommandeItem extends JPanel implements Observer
{	
	private Command commande;
	private CommandeController controller;
	
	public CommandeItem(CommandeController controller)
	{
		//Set the attributes
		commande = controller.getCommande();
		this.controller = controller;
		
		//Add observer
		commande.addObserver(this);
		
		//Update
		update(commande,null);
	}
	
	@Override
	public void update(Observable o, Object args)
	{
		removeAll();
		setLayout(new GridBagLayout());
		GridBagConstraints cstr = new GridBagConstraints();
		
		cstr.fill = GridBagConstraints.BOTH;
		cstr.weightx = 0.5;
		cstr.weighty = 0.2;
		
		cstr.gridx = 0;
		cstr.gridy = 0;
		add(new JLabel("Commande"),cstr);
		
		cstr.gridx = 1;
		cstr.gridy = 0;
		add(new JLabel("Table n°"+commande.getId()),cstr);
		
		JPanel conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,2));
		for(Achetable obj: commande.getListeCommandes())
		{
			conteneur.add(new JLabel(obj.getPrix() + "€"));
		}
		
		cstr.gridx = 0;
		cstr.gridy = 1;
		cstr.weightx = 1;
		cstr.weighty = 0.8;
		add(conteneur,cstr);
		
		cstr.gridx = 0;
		cstr.gridy = 2;
		cstr.weightx = 0.5;
		cstr.weighty = 0.2;
		add(new JLabel("Total "),cstr);
		
		cstr.gridx = 1;
		cstr.gridy = 2;
		add(new JLabel(commande.getTotal() + "€"),cstr);
		
		cstr.gridx = 0;
		cstr.gridy = 3;
		JPanel temp = new JPanel();
		if(commande.getEtat() == "N")
		{
			JButton confirm = new JButton("Commander");
			confirm.addActionListener(controller);
			confirm.setActionCommand("confirmer");
			temp.add(confirm);
		}
		
		else if(commande.getEtat() == "O")
		{
			temp.add(new JLabel("Commande confirmée"));
		}
		add(temp,cstr);
	}
}
