package ui.stock.ingredient;

import java.awt.CardLayout;

import javax.swing.JPanel;

import controller.IngredientController;
import retaurant.Ingredient;
import retaurant.Stock;

@SuppressWarnings("serial")
public class IngredientCard extends JPanel
{  	
	private IngredientForm form;
	private IngredientItem item;
	
	public IngredientCard(Ingredient ingredient,Stock stock)
	{
		IngredientController controller = new IngredientController(ingredient,this,stock);
		
		this.form = new IngredientForm(this,controller);
		this.item = new IngredientItem(this,controller);
		
		setLayout(new CardLayout());
		add(item);
		add(form);
	}
	
	public IngredientCard(Stock stock)
	{
		this(new Ingredient("Nom",0), stock);
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
}
