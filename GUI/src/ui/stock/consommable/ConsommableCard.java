package ui.stock.consommable;

import ui.CardPanel;

import controller.ConsommableController;

@SuppressWarnings("serial")
public class ConsommableCard extends CardPanel
{		
	public ConsommableCard(ConsommableController controller)
	{
		controller.setCard(this);
		
		//Ajout des 2 panels
		add(new ConsommableItem(this,controller));
		add(new ConsommableForm(this,controller));
	}
}
