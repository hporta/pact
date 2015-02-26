package ui.carte.plat;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.PlatController;
import retaurant.Ingredient;
import retaurant.Plat;
import retaurant.Stock;

@SuppressWarnings("serial")
public class PlatCard extends JPanel implements ActionListener, Observer
{
	//panels
	private PlatForm form;
	private PlatItem item;
	
	private final String SWITCH = "switch";
	
	
	public PlatCard(PlatController platController)
	{
		//Informe le plat qu'il doit notifier ses modifications
		platController.getPlat().addObserver(this);
		
		
		//Création des 2 panels
		setLayout(new CardLayout());
		add(item = new PlatItem(this, platController));
		add(form = new PlatForm(this, platController));
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
