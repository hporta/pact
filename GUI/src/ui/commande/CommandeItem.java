package ui.commande;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import retaurant.Achetable;
import retaurant.Command;


@SuppressWarnings("serial")
public class CommandeItem extends JPanel
{	
	private Command commande;
	
	public CommandeItem(Command commande)
	{
		this.commande = commande;
		update();
	}
	
	public void update()
	{
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
		add(new JLabel("Table n° commande.getId()"),cstr);
		
		JPanel conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,2));
		for(Achetable obj: commande.getListeCommandes())
		{
			conteneur.add(new JLabel(obj.getNom()));
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
	}
}
