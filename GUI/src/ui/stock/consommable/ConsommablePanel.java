package ui.stock.consommable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
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
	private JPanel empty;
	
	//Model
	private Stock stock;
	
	//Controller
	private StockController stockController;
	
	
	public ConsommablePanel(StockController stockController)
	{
		this.stockController = stockController;
		this.stock = stockController.getStock();
		

		
		setLayout(new BorderLayout());
		add = new AddItemButton(stockController,"AddConsommable");
		empty = new JPanel();
		empty.setLayout(new BorderLayout());
		empty.add(new JLabel("Pas de consommables à afficher"),BorderLayout.CENTER);
		empty.setPreferredSize(new Dimension(this.getWidth(),100));
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		
		add(conteneur,BorderLayout.PAGE_START);
		
		update();
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		if(stock.getConsommables().size() == 0)
			conteneur.add(empty);
		
		for(Consommable consommable : stock.getConsommables())
		{
			conteneur.add(new ConsommableCard(new ConsommableController(consommable,stockController)));
		}
			
		
		validate();
		repaint();
	}
	
}
