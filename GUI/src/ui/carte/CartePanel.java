package ui.carte;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.CarteController;
import controller.StockController;

import restaurant.Carte;
import restaurant.Ingredient;
import restaurant.Plat;
import restaurant.Stock;
import ui.carte.menu.MenuPanel;
import ui.carte.plat.PlatPanel;


@SuppressWarnings("serial")
public class CartePanel extends JPanel implements ActionListener, Observer
{	
	private final String MENUS = "Menus";
	private final String PLATS = "Plats";
	
	private final JButton menuButton;
	private final JButton platButton;
	
	private final JPanel conteneur;
	private MenuPanel menu;
	private PlatPanel plat;
		
	
	public CartePanel(CarteController carteController, StockController stockController)
	{
		carteController.getCarte().addObserver(this);
		stockController.getStock().addObserver(this);	
		
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
		conteneur.add(menu = new MenuPanel(carteController),MENUS);
		conteneur.add(plat = new PlatPanel(carteController),PLATS);

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



	@Override
	public void update(Observable arg0, Object arg1) 
	{
		menu.update();
		plat.update();
	}
	
}
