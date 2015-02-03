package ui.stock.consommable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import retaurant.Consommable;
import retaurant.Stock;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class ConsommablePanel extends JPanel implements ActionListener
{
	private AddItemButton add;
	private JPanel conteneur;
	private Stock stock;
	
	public ConsommablePanel() 
	{
		this(new Stock());
	}
	
	public ConsommablePanel(Stock stock)
	{
		this.stock = stock;
		
		setLayout(new BorderLayout());
		add = new AddItemButton();
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add.addActionListener(this);
		add.setActionCommand("add");
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void addConsommable(Consommable consommable)
	{
		stock.addConsommable(consommable);
		update();
	}
	
	public void removeConsommable(Consommable consommable)
	{
		stock.removeConsommable(consommable);
		update();
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if("add".equals(e.getActionCommand()))
		{
			stock.addConsommable(new Consommable());
			update();
	    }
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		for(Consommable consommable : stock.getConsommables())
		{
			conteneur.add(new ConsommableCard(this, consommable));
		}
		
		validate();
		repaint();
	}
	
	
}
