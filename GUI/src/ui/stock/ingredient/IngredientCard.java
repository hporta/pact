package ui.stock.ingredient;

import java.awt.CardLayout;

import javax.swing.JPanel;

import controller.IngredientController;
import retaurant.Ingredient;

@SuppressWarnings("serial")
public class IngredientCard extends JPanel
{
	private IngredientController controller;
	private IngredientPanel parent;
	
	private IngredientForm form;
	private IngredientItem item;
	
	public IngredientCard(IngredientPanel parent, Ingredient ingredient)
	{
		this.parent = parent;
		this.controller = new IngredientController(ingredient);
		
		this.form = new IngredientForm(this,controller);
		this.item = new IngredientItem(this,controller);
		
		setLayout(new CardLayout());
		add(item);
		add(form);
	}
	
	public IngredientCard(IngredientPanel parent)
	{
		this(parent, new Ingredient("Nom",0));
	}
	
	public void switchCard()
	{
		CardLayout card = (CardLayout) getLayout();
		card.next(this);
	}
	
	public void update()
	{
		item.update();
		form.update();
	}
	
	public void removeIngredient()
	{
		parent.removeIngredient(controller.getIngredient());
	}
}
