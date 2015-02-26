package ui;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.RestaurantController;

import ui.carte.CartePanel;
import ui.commande.CommandePanel;
import ui.notification.NotificationPanel;
import ui.stock.StockPanel;

@SuppressWarnings("serial")
public class ContentPanel extends JPanel implements ActionListener
{
	//Main panel
	private final JPanel conteneur;
	
	//Tab names
	private final String NOTIFICATION = "Notifications";
	private final String STOCK = "Stocks";
	private final String CARTE = "Carte";
	private final String COMMANDE = "Commande";
	
	public ContentPanel(RestaurantController restaurantController) 
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JButton notificationButton = new JButton(NOTIFICATION);
		JButton stockButton = new JButton(STOCK);
		JButton carteButton = new JButton(CARTE);
		JButton commandeButton = new JButton(COMMANDE); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,4));
		buttonPanel.add(notificationButton);
		buttonPanel.add(stockButton);
		buttonPanel.add(carteButton);
		buttonPanel.add(commandeButton);
		add(buttonPanel);
		
		//Setting the event for every button
		notificationButton.addActionListener(this);
		notificationButton.setActionCommand(NOTIFICATION);
		
		stockButton.addActionListener(this);
		stockButton.setActionCommand(STOCK);
		
		carteButton.addActionListener(this);
		carteButton.setActionCommand(CARTE);
		
		commandeButton.addActionListener(this);
		commandeButton.setActionCommand(COMMANDE);
		
		//Main panel
		conteneur = new JPanel(new CardLayout());
		conteneur.add(NOTIFICATION,new NotificationPanel());
		conteneur.add(STOCK,new StockPanel(restaurantController.getStockController()));
		conteneur.add(CARTE,new CartePanel(restaurantController.getCarteController(),restaurantController.getStockController()));
		conteneur.add(COMMANDE,new CommandePanel());
		
		add(conteneur);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		CardLayout cl = (CardLayout) conteneur.getLayout();
		cl.show(conteneur, e.getActionCommand());
	}
	
}
