package ui.stock.consommable;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controller.ConsommableController;
import controller.StockController;

import retaurant.Consommable;
import retaurant.Stock;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class ConsommablePanel extends JPanel
{
	private AddItemButton add;
	private JPanel conteneur;
	
	//Model
	private Stock stock;
	
	//Controller
	private StockController stockController;
	
	
	public ConsommablePanel(StockController stockController)
	{
		this.stockController = stockController;
		this.stock = stockController.getStock();
		
		setLayout(new BorderLayout());
		add = new AddItemButton();
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add.addActionListener(stockController);
		add.setActionCommand("addConsommable");
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		for(Consommable consommable : stock.getConsommables())
		{
			conteneur.add(new ConsommableCard(new ConsommableController(consommable,stockController)));
		}
		
		validate();
		repaint();
	}
	
}
