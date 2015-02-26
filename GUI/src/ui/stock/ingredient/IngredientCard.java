package ui.stock.ingredient;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.Constantes;

import controller.IngredientController;

@SuppressWarnings("serial")
public class IngredientCard extends JPanel implements ActionListener
{		
	public IngredientCard(IngredientController ingredientController)
	{
		//Indique au model de notifier la vue
		ingredientController.setCard(this);
		
		//Création des 2 panels
		setLayout(new CardLayout());
		add(new IngredientItem(this,ingredientController));
		add(new IngredientForm(this,ingredientController));
	}
	
	
	//Switching between the 2 panels (card layout)
	public void switchCard()
	{
		CardLayout card = (CardLayout) getLayout();
		card.next(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(Constantes.SWITCH))
			switchCard();
	}

}
