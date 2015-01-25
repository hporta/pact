package ui.stock.ingredient;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Ingredient;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class IngredientPanel extends JPanel implements ActionListener
{
	private AddItemButton add;
	private ArrayList<JPanel> liste;
	private JPanel conteneur;
	
	public IngredientPanel() 
	{
		setLayout(new BorderLayout());
		add = new AddItemButton();
		add.addActionListener(this);
		add.setActionCommand("add");
		
		liste = new ArrayList<JPanel>();
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		IngredientItem temp = new IngredientItem(ingredient);
		liste.add(temp);
		conteneur.add(temp);
	}
	/*
	public void add(JPanel panneau)
	{
		
	}
	
	public boolean remove(IngredientItem ingredient)
	{
		liste.remove(ingredient);
		conteneur.remove(ingredient);
		return true;
	}
	*/
	
	public void actionPerformed(ActionEvent e)
	{
		if("add".equals(e.getActionCommand()))
		{
			JPanel form = new IngredientForm(this);
			liste.add(form);
			conteneur.add(form);
			validate();
			repaint();
	    }
	}
}
