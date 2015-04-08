package ui.stock.consommable;

import java.util.Observable;
import java.util.Observer;

import controller.ConsommableController;
import controller.StockController;
import restaurant.Consommable;
import restaurant.Stock;
import ui.Constantes;
import ui.ListPanel;

@SuppressWarnings("serial")
public class ConsommablePanel extends ListPanel implements Observer
{
	//Model
	private Stock stock;
	
	//Controller
	private StockController stockController;
	
	
	public ConsommablePanel(StockController stockController)
	{
		super(stockController, Constantes.ADD_CONSOMMABLE);
		this.stockController = stockController;
		
		stock = stockController.getStock();
		stock.addObserver(this);
		
		update(stock, null);
	}
	
	@Override
	public void update(Observable a, Object b)
	{
		clean();
		
		for(Consommable consommable : stock.getConsommables())
			addElement(new ConsommableCard(
					new ConsommableController(consommable,stockController)));
		
		showList();
	}
	
}
