package ui.stock.ingredient;

import ui.CardPanel;

import controller.IngredientController;

@SuppressWarnings("serial")
public class IngredientCard extends CardPanel
{		
	public IngredientCard(IngredientController ingredientController)
	{
		//Indique au model de notifier la vue
		ingredientController.setCard(this);
		
		//Création des 2 panels
		add(new IngredientItem(this,ingredientController));
		add(new IngredientForm(this,ingredientController));
	}
}
