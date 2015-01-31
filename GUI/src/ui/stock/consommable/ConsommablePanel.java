package ui.stock.consommable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ConsommableController;
import retaurant.Consommable;
import ui.AddItemButton;
import ui.stock.consommable.ConsommableForm;
import ui.stock.consommable.ConsommableItem;

@SuppressWarnings("serial")
public class ConsommablePanel extends JPanel implements ActionListener
{
	private AddItemButton add;
	private ArrayList<JPanel> liste;
	private JPanel conteneur;
	
	public ConsommablePanel() 
	{
		setLayout(new BorderLayout());
		add = new AddItemButton();
		liste = new ArrayList<JPanel>();
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add.addActionListener(this);
		add.setActionCommand("add");
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void addConsommable(Consommable consommable)
	{
		ConsommableItem temp = new ConsommableItem(consommable,this);
		liste.add(temp);
		conteneur.add(temp);
	}
	
	
	public void setConsommable(ConsommableItem consommable)
	{
		liste.remove(consommable);
		JPanel temp = new ConsommableForm(this, new ConsommableController(consommable.getConsommable()));
		liste.add(temp);
		conteneur.remove(consommable);
		conteneur.add(temp);
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if("add".equals(e.getActionCommand()))
		{
			JPanel form = new ConsommableForm(this);
			liste.add(form);
			conteneur.add(form);
			validate();
			repaint();
	    }
	}
	
	
}
