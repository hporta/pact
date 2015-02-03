package ui.stock.consommable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Consommable;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class ConsommablePanel extends JPanel implements ActionListener
{
	private AddItemButton add;
	private ArrayList<ConsommableCard> liste;
	private JPanel conteneur;
	
	public ConsommablePanel() 
	{
		setLayout(new BorderLayout());
		add = new AddItemButton();
		liste = new ArrayList<ConsommableCard>();
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add.addActionListener(this);
		add.setActionCommand("add");
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void addConsommable(Consommable consommable)
	{
		liste.add(new ConsommableCard(this,consommable));
		update();
	}
	
	public void removeConsommable(ConsommableCard card)
	{
		liste.remove(card);
		update();
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if("add".equals(e.getActionCommand()))
		{
			liste.add(new ConsommableCard(this));
			update();
	    }
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		for(ConsommableCard card : liste)
		{
			card.update();
			conteneur.add(card);
		}
	}
	
	
}
