package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Consommable;

@SuppressWarnings("serial")
public class ConsommablePanel extends ProduitPanel
{
	private AddItemButton add;
	private ArrayList<ConsommableItem> liste;
	private JPanel conteneur;
	
	public ConsommablePanel() 
	{
		setLayout(new BorderLayout());
		add = new AddItemButton();
		liste = new ArrayList<ConsommableItem>();
		
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add(conteneur);
	}
	
	public void addConsommable(Consommable consommable)
	{
		ConsommableItem temp = new ConsommableItem(consommable);
		liste.add(temp);
		conteneur.add(temp);
	}
}
