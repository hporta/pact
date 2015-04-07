package ui;

import controller.RestaurantController;

import ui.carte.CartePanel;
import ui.commande.CommandePanel;
import ui.notification.NotificationPanel;
import ui.stock.StockPanel;

@SuppressWarnings("serial")
public class ContentPanel extends TabPanel
{
	//Tab names
	private final String NOTIFICATION = "Notifications";
	private final String STOCK = "Stocks";
	private final String CARTE = "Carte";
	private final String COMMANDE = "Commande";
	
	public ContentPanel(RestaurantController restaurantController) 
	{
		addTab(NOTIFICATION,new NotificationPanel(restaurantController));
		addTab(STOCK,new StockPanel(restaurantController.getStockController()));
		addTab(CARTE,new CartePanel(restaurantController.getCarteController()));
		addTab(COMMANDE,new CommandePanel(restaurantController.getCompteController()));
	}
}
