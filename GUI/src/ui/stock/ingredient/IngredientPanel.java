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
	private ArrayList<IngredientCard> liste;
	private JPanel conteneur;
	
	public IngredientPanel() 
	{
		setLayout(new BorderLayout());
		
		add = new AddItemButton();
		add.addActionListener(this);
		add.setActionCommand("add");
		
		liste = new ArrayList<IngredientCard>();
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));		
		add(conteneur,BorderLayout.PAGE_START);
		
		update();
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		liste.add(new IngredientCard(this,ingredient));
		update();
	}
	

	public void removeIngredient(IngredientCard card)
	{
		liste.remove(card);
		update();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if("add".equals(e.getActionCommand()))
		{
			liste.add(new IngredientCard(this));
			update();
	    }
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		for(IngredientCard card : liste)
		{
			card.update();
			conteneur.add(card);
		}
	}
}
