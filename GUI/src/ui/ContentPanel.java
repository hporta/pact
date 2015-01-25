package ui;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;

import javax.swing.JTabbedPane;

import ui.carte.CartePanel;
import ui.stock.StockPanel;

public class ContentPanel extends JTabbedPane{

	private final NotificationPanel notifications;
	private final StockPanel stock;
	private final CartePanel carte;
	private final CommandePanel commande;

	private final String NOTIFICATION = "Notifications";
	private final String STOCK = "Stocks";
	private final String CARTE = "Carte";
	private final String COMMANDE = "Commande";
	
	public ContentPanel() {
		super();
		
		
		addTab(NOTIFICATION,notifications = new NotificationPanel());
		addTab(STOCK, stock = new StockPanel());
		addTab(CARTE, carte = new CartePanel());
		addTab(COMMANDE, commande = new CommandePanel());
	}
}
