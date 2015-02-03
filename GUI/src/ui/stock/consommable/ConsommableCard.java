package ui.stock.consommable;

import java.awt.CardLayout;

import javax.swing.JPanel;

import controller.ConsommableController;
import retaurant.Consommable;

@SuppressWarnings("serial")
public class ConsommableCard extends JPanel
{
	private ConsommableController controller;
	private ConsommablePanel parent;
	
	private ConsommableForm form;
	private ConsommableItem item;
	
	public ConsommableCard(ConsommablePanel parent, Consommable consommable)
	{
		this.parent = parent;
		this.controller = new ConsommableController(consommable);
		
		this.form = new ConsommableForm(this,controller);
		this.item = new ConsommableItem(this,consommable);
		
		setLayout(new CardLayout());
		add(item);
		add(form);
	}
	
	public ConsommableCard(ConsommablePanel parent)
	{
		this(parent, new Consommable());
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
	
	public void removeConsommable()
	{
		parent.removeConsommable(controller.getConsommable());
	}
}
