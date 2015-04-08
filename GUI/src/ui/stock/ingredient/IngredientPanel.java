package ui.stock.ingredient;

import java.util.Observable;
import java.util.Observer;

import controller.IngredientController;
import controller.StockController;
import restaurant.Ingredient;
import restaurant.Stock;
import ui.Constantes;
import ui.ListPanel;

@SuppressWarnings("serial")
public class IngredientPanel extends ListPanel implements Observer
{
	//Controller
	private StockController stockController;
	
	//Model
	private Stock stock;
		
	public IngredientPanel(StockController stockController)
	{
		super(stockController, Constantes.ADD_INGREDIENTS);
		this.stockController = stockController;

		stock = stockController.getStock();
		stock.addObserver(this);
		
		update(stock, null);
	}

	@Override
	public void update(Observable a, Object b)
	{
		clean();
		
		for(Ingredient ingredient : stock.getIngredients())
			addElement(new IngredientCard(new IngredientController(ingredient, stockController)));

		showList();
	}
}
