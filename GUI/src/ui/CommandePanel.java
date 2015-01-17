package ui;
import javax.swing.JPanel;

import retaurant.Command;
import retaurant.Plat;
import retaurant.Table;


public class CommandePanel extends JPanel{
	
	public CommandePanel() 
	{
		Command commande = new Command(5);
		commande.add(new Plat("Perrier","qlmkd",2.5f));
		commande.add(new Plat("Coca-cola","qmjldf",2.3f));
		add(new CommandeListe(commande));
	}

}
