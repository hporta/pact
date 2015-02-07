package ui.stock.ingredient;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.IngredientController;
import controller.StockController;
import retaurant.Ingredient;
import retaurant.Stock;

@SuppressWarnings("serial")
public class IngredientCard extends JPanel implements ActionListener
{  	
	private IngredientForm form;
	private IngredientItem item;
	
	private final String SWITCH = "switch";
	
	public IngredientCard(Ingredient ingredient,StockController stockController)
	{
		IngredientController controller = new IngredientController(ingredient,this,stockController.getStock());
		
		this.form = new IngredientForm(this,controller);
		this.item = new IngredientItem(stockController,this,controller);
		
		setLayout(new CardLayout());
		add(item);
		add(form);
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
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(SWITCH))
			switchCard();
	}
}
