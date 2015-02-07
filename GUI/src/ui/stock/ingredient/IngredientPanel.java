package ui.stock.ingredient;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controller.StockController;
import retaurant.Ingredient;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class IngredientPanel extends JPanel
{
	private AddItemButton add;
	private JPanel conteneur;
	
	//Controller
	private StockController stockController;
		
	public IngredientPanel(StockController stockController)
	{
		this.stockController = stockController;
		
		setLayout(new BorderLayout());
		
		add = new AddItemButton();
		add.addActionListener(stockController);
		add.setActionCommand("add");
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));		
		add(conteneur,BorderLayout.PAGE_START);
		
		update();
	}

	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		for(Ingredient ingredient : stockController.getStock().getIngredients())
		{
			conteneur.add(new IngredientCard(ingredient, stockController));
		}
		
		validate();
		repaint();
	}
}
