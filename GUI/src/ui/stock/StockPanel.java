package ui.stock;

import controller.StockController;
import ui.TabPanel;
import ui.stock.consommable.ConsommablePanel;
import ui.stock.ingredient.IngredientPanel;

@SuppressWarnings("serial")
public class StockPanel extends TabPanel
{	
	//Tabs
	private final String CONSOMMABLES = "Consommables";
	private final String INGREDIENTS = "Ingredients";
	
	public StockPanel(StockController stockController)
	{
		addTab(CONSOMMABLES, new ConsommablePanel(stockController));
		addTab(INGREDIENTS, new IngredientPanel(stockController));
	}
}
