package ui.stock.ingredient;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Ingredient;
import retaurant.Stock;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class IngredientPanel extends JPanel implements ActionListener
{
	private AddItemButton add;
	private JPanel conteneur;
	private Stock stock;
	
	public IngredientPanel() 
	{
		this.stock = new Stock();
		
		setLayout(new BorderLayout());
		
		add = new AddItemButton();
		add.addActionListener(this);
		add.setActionCommand("add");
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));		
		add(conteneur,BorderLayout.PAGE_START);
		
		update();
	}
	
	public IngredientPanel(Stock stock)
	{
		this.stock = stock;
		
		setLayout(new BorderLayout());
		
		add = new AddItemButton();
		add.addActionListener(this);
		add.setActionCommand("add");
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));		
		add(conteneur,BorderLayout.PAGE_START);
		
		update();
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		stock.addIngredient(ingredient);
		update();
	}
	

	public void removeIngredient(Ingredient ingredient)
	{
		stock.removeIngredient(ingredient);
		update();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if("add".equals(e.getActionCommand()))
		{
			stock.addIngredient(new Ingredient());
			update();
	    }
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		for(Ingredient ingredient : stock.getIngredients())
		{
			conteneur.add(new IngredientCard(this, ingredient));
		}
		
		validate();
		repaint();
	}
}
