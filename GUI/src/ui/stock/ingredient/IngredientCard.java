package ui.stock.ingredient;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.IngredientController;

@SuppressWarnings("serial")
public class IngredientCard extends JPanel implements ActionListener, Observer
{
	private IngredientForm form;
	private IngredientItem item;
	
	private final String SWITCH = "switch";
	
	public IngredientCard(IngredientController ingredientController)
	{
		//Informe l'ingredient qu'il doit notifier ses modifications
		ingredientController.getIngredient().addObserver(this);
		
		//Création des 2 panels
		setLayout(new CardLayout());
		add(item = new IngredientItem(this,ingredientController));
		add(form = new IngredientForm(this,ingredientController));
	}
	
	public void switchCard()
	{
		CardLayout card = (CardLayout) getLayout();
		card.next(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(SWITCH))
			switchCard();
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		item.update();
		form.update();
	}
}
