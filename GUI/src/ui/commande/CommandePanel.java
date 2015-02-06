package ui.commande;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import retaurant.Command;
import retaurant.Plat;


@SuppressWarnings("serial")
public class CommandePanel extends JPanel
{
	private JPanel conteneur;
	
	public CommandePanel() 
	{
		setLayout(new BorderLayout());
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		
		Command commande = new Command(5);
		commande.add(new Plat("Perrier","qlmkd",2.5f));
		commande.add(new Plat("Coca-cola","qmjldf",2.3f));
		conteneur.add(new CommandeItem(commande));
		
		add(conteneur,BorderLayout.PAGE_START);
	}

	public void update() 
	{
		
	}

}
