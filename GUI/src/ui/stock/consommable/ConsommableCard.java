package ui.stock.consommable;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.ConsommableController;

@SuppressWarnings("serial")
public class ConsommableCard extends JPanel implements ActionListener
{	
	private ConsommableForm form;
	private ConsommableItem item;
	
	private final String SWITCH = "switch";
	
	public ConsommableCard(ConsommableController controller)
	{
		this.form = new ConsommableForm(this,controller);
		this.item = new ConsommableItem(this,controller);
		
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
