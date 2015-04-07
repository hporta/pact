package ui.stock.ingredient;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.IngredientController;
import controller.StockController;
import restaurant.Ingredient;
import restaurant.Stock;
import ui.AddItemButton;
import ui.Constantes;

@SuppressWarnings("serial")
public class IngredientPanel extends JPanel
{
	private AddItemButton add;
	private JPanel conteneur;
	private JPanel empty;
	
	//Controller
	private StockController stockController;
	
	//Model
	private Stock stock;
		
	public IngredientPanel(StockController stockController)
	{
		this.stockController = stockController;
		this.stock = stockController.getStock();
		
		setLayout(new BorderLayout());
		
		add = new AddItemButton(stockController,Constantes.ADD_INGREDIENTS);
		
		empty = new JPanel();
		empty.add(new JLabel("Pas d'ingredient à afficher"));
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));		
		add(conteneur,BorderLayout.PAGE_START);
		
		update();
	}

	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		if(stock.getIngredients().size() == 0)
			conteneur.add(empty);
		
		for(Ingredient ingredient : stock.getIngredients())
		{
			conteneur.add(new IngredientCard(new IngredientController(ingredient, stockController)));
		}
		
		
		validate();
		repaint();
	}
}
