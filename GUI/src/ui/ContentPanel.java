package ui;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;

import javax.swing.JTabbedPane;

public class ContentPanel extends JTabbedPane{

	private final NotificationPanel notifications;
	private final StockPanel stock;
	private final PaiementPanel paiement;
	
	private final String NOTIFICATION = "Notifications";
	private final String STOCK = "Stocks";
	private final String PAIEMENT = "Paiement";
	
	public ContentPanel() {
		super();
		
		
		addTab(NOTIFICATION,notifications = new NotificationPanel());
		addTab(STOCK, stock = new StockPanel());
		addTab(PAIEMENT, paiement = new PaiementPanel());
	}
}
