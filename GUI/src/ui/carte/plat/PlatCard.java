package ui.carte.plat;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;

import ui.Constantes;

import controller.PlatController;

@SuppressWarnings("serial")
public class PlatCard extends JPanel implements ActionListener
{	
	
	public PlatCard(PlatController platController)
	{
		platController.setCard(this);
		
		//Création des 2 panels
		setLayout(new CardLayout());
		add(new PlatItem(this, platController));
		add(new PlatForm(this, platController));
	}
	
	
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
