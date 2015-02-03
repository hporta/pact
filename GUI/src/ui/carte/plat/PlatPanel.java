package ui.carte.plat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Ingredient;
import retaurant.Plat;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class PlatPanel extends JPanel implements ActionListener
{
	private AddItemButton add;
	private ArrayList<PlatCard> liste;
	private JPanel conteneur;
	
	public PlatPanel()
	{
		super();
		add = new AddItemButton();
		liste = new ArrayList<PlatCard>();
		conteneur = new JPanel();
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		add.setActionCommand("add");
		add.addActionListener(this);
		
		ArrayList<Ingredient> liste = new ArrayList<Ingredient>();
		liste.add(new Ingredient("Pommes de terre",15));
		liste.add(new Ingredient("Carrotes",7));
		liste.add(new Ingredient("Pommes",3));
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void addPlat(Plat plat)
	{
		liste.add(new PlatCard(this,plat));
		update();
	}
	
	public void removePlat(PlatCard card)
	{
		liste.remove(card);
		update();
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		for(PlatCard card : liste)
		{
			conteneur.add(card);
		}
		
		validate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("add"))
		{
			addPlat(new Plat());
			update();
		}
	}
	
	
}
