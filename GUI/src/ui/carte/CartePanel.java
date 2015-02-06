package ui.carte;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import retaurant.Consommable;
import retaurant.Ingredient;
import retaurant.Plat;
import retaurant.Stock;
import ui.carte.menu.MenuPanel;
import ui.carte.plat.PlatPanel;

@SuppressWarnings("serial")
public class CartePanel extends JPanel implements ActionListener
{
	private final MenuPanel menu;
	private final PlatPanel plat;
	
	private final String MENUS = "Menus";
	private final String PLATS = "Plats";
	
	private final JButton menuButton;
	private final JButton platButton;
	
	private final JPanel conteneur;
	
	private Stock stock;
	
	public CartePanel()
	{
		this(new Stock());
	}
	
	public CartePanel(Stock stock)
	{
		super();
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(menuButton = new JButton(MENUS));
		temp.add(platButton = new JButton(PLATS));
		add(temp);
		
		menuButton.addActionListener(this);
		menuButton.setActionCommand(MENUS);
		
		platButton.addActionListener(this);
		platButton.setActionCommand(PLATS);
		
		platButton.setEnabled(true);
		menuButton.setEnabled(false);
		
		add(conteneur = new JPanel(new CardLayout()));
		conteneur.add(menu = new MenuPanel(),MENUS);
		conteneur.add(plat= new PlatPanel(),PLATS);
		
		
		Plat temp1 = new Plat("Frites","des frites maison",3.2f);
		temp1.addIngredient(new Ingredient("Pommes de terre",8));
		plat.addPlat(temp1);
		
		temp1 = new Plat("Steak Haché aux haricots","un steak haché pur boeuf et des haricots verts frais",8.0f);
		temp1.addIngredient(new Ingredient("Pommes de terre",8));
		temp1.addIngredient(new Ingredient("Boeuf",2));
		temp1.addIngredient(new Ingredient("Haricots verts",10));
		plat.addPlat(temp1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(MENUS))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, MENUS);
			menuButton.setEnabled(false);
			platButton.setEnabled(true);
		}
		
		else if(e.getActionCommand().equals(PLATS))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, PLATS);
			menuButton.setEnabled(true);
			platButton.setEnabled(false);
		}
	}

	public void update() 
	{
		
	}
	
}
