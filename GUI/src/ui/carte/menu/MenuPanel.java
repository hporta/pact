package ui.carte.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import retaurant.Carte;
import retaurant.Ingredient;
import retaurant.Menu;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements ActionListener
{
	private AddItemButton add;
	private ArrayList<MenuCard> liste;
	private JPanel conteneur;
	private Carte carte;
	
	public MenuPanel()
	{
		super();
		this.carte = new Carte();
		add = new AddItemButton();
		liste = new ArrayList<MenuCard>();
		conteneur = new JPanel();
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		add.setActionCommand("add");
		add.addActionListener(this);
		
		addMenu((new Carte()).getMenus().get(0));
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public MenuPanel(Carte carte)
	{
		super();
		this.carte = carte;
		add = new AddItemButton();
		liste = new ArrayList<MenuCard>();
		conteneur = new JPanel();
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		add.setActionCommand("add");
		add.addActionListener(this);
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void addMenu(Menu menu)
	{
		carte.addMenu(menu);
		update();
	}
	
	public void removeMenu(Menu menu)
	{
		carte.removeMenu(menu);
		update();
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		for(Menu menu : carte.getMenus())
		{
			conteneur.add(new MenuCard(this, menu));
		}
		
		validate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("add"))
		{
			addMenu(new Menu());
		}
	}
	
}
