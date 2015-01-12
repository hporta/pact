package ui;
import javax.swing.JPanel;

import model.Commande;
import model.Item;


public class CommandePanel extends JPanel{
	
	public CommandePanel() {
	
		Commande commande = new Commande();
		commande.addItem(new Item("Perrier","qlmkd",2.5,5));
		commande.addItem(new Item("Coca-cola","qmjldf",2.3,1));
		add(new CommandeListe(commande));
	}

}
