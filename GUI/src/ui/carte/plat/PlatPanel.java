package ui.carte.plat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Plat;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class PlatPanel extends JPanel
{
	private AddItemButton add;
	private ArrayList<PlatItem> liste;
	private JPanel conteneur;
	
	public PlatPanel()
	{
		super();
		add = new AddItemButton();
		liste = new ArrayList<PlatItem>();
		conteneur = new JPanel();
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void addPlat(Plat plat)
	{
		PlatItem temp = new PlatItem(plat);
		liste.add(temp);
		conteneur.add(temp);
	}
}
