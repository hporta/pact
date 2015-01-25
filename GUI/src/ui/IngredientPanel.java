package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Ingredient;

@SuppressWarnings("serial")
public class IngredientPanel extends JPanel
{
	private AddItemButton add;
	private ArrayList<IngredientItem> liste;
	private JPanel conteneur;
	
	public IngredientPanel() 
	{
		setLayout(new BorderLayout());
		add = new AddItemButton();
		liste = new ArrayList<IngredientItem>();
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add(conteneur);
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		IngredientItem temp = new IngredientItem(ingredient);
		liste.add(temp);
		conteneur.add(temp);
	}
}
