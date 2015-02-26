package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class CardPanel extends JPanel implements ActionListener
{

	public CardPanel()
	{
		super();
		setLayout(new CardLayout());
	}
	
	
	//Switching between the 2 panels (card layout)
	public final void switchCard()
	{
		CardLayout card = (CardLayout) getLayout();
		card.next(this);
	}
	
	
	@Override
	public final void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(Constantes.SWITCH))
			switchCard();
	}
}
