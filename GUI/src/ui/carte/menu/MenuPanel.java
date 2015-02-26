package ui.carte.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CarteController;

import retaurant.Carte;
import retaurant.Ingredient;
import retaurant.Menu;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel
{
	private AddItemButton add;
	private JPanel conteneur;
	
	//Model
	private Carte carte;
	
	//Controller
	private CarteController carteController;
		
	public MenuPanel(CarteController carteController)
	{
		this.carte = carteController.getCarte();
		this.carteController = carteController;
		
		add = new AddItemButton(carteController,"AddMenu");
		conteneur = new JPanel();
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		if(carte.getMenus().size() > 0)
			for(Menu menu : carte.getMenus())
				conteneur.add(new MenuCard(this, menu));
		
		else
			conteneur.add(new JLabel("Pas de menu à afficher"));
		
		validate();
		repaint();
	}
	
}
