package ui.carte.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Menu;
import ui.AddItemButton;


@SuppressWarnings("serial")
public class MenuPanel extends JPanel
{
	private AddItemButton add;
	private ArrayList<MenuItem> liste;
	private JPanel conteneur;
	
	public MenuPanel()
	{
		super();
		add = new AddItemButton();
		liste = new ArrayList<MenuItem>();
		conteneur = new JPanel();
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void addMenu(Menu menu)
	{
		MenuItem temp = new MenuItem(menu);
		liste.add(temp);
		conteneur.add(temp);
	}
}
