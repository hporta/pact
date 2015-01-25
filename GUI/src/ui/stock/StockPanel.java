package ui.stock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import retaurant.Consommable;
import retaurant.Ingredient;
import retaurant.Plat;
import ui.stock.consommable.ConsommablePanel;
import ui.stock.ingredient.IngredientPanel;


public class StockPanel extends JTabbedPane
{	
	private final ConsommablePanel consommable;
	private final IngredientPanel ingredient;
	
	private final String CONSOMMABLES = "Consommables";
	private final String INGREDIENTS = "Ingredients";
	
	public StockPanel() 
	{
		super();
		
		addTab(CONSOMMABLES, consommable = new ConsommablePanel());
		addTab(INGREDIENTS,ingredient= new IngredientPanel());
		
		consommable.addConsommable(new Consommable("Chips",10,1.5f));
		consommable.addConsommable(new Consommable("Perrier",7,3.0f));
		consommable.addConsommable(new Consommable("Coca",5,1.2f));
		
		ingredient.addIngredient(new Ingredient("Pommes de terre",15));
		ingredient.addIngredient(new Ingredient("Carrotes",7));
		ingredient.addIngredient(new Ingredient("Pommes",3));
	}

}
