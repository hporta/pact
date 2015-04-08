package ui;

import controller.RestaurantController;
import ui.commande.CommandePanel;
import ui.notification.NotificationPanel;
import ui.recette.RecettePanel;
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
		addTab(CARTE,new RecettePanel(restaurantController.getCarteController()));
		addTab(COMMANDE,new CommandePanel(restaurantController.getCompteController()));
	}
}
