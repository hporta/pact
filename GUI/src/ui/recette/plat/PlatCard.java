package ui.recette.plat;

import ui.CardPanel;

import controller.PlatController;

@SuppressWarnings("serial")
public class PlatCard extends CardPanel
{	
	public PlatCard(PlatController platController)
	{
		platController.setCard(this);
		
		//Création des 2 panels
		add(new PlatItem(this, platController));
		add(new PlatForm(this, platController));
	}	
}
