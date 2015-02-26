package ui.carte.plat;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CarteController;
import controller.PlatController;

import retaurant.Carte;
import retaurant.Plat;
import ui.AddItemButton;
import ui.Constantes;

@SuppressWarnings("serial")
public class PlatPanel extends JPanel
{
	private AddItemButton add;
	private JPanel conteneur;
	
	//Model
	private Carte carte;
	
	//Controller
	private CarteController carteController;
	
	
	public PlatPanel(CarteController carteController)
	{
		this.carteController = carteController;
		this.carte = carteController.getCarte();
		
		conteneur = new JPanel();
		add = new AddItemButton(carteController,Constantes.ADD_PLAT);
		
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		
		add(conteneur,BorderLayout.PAGE_START);
		
		update();
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		if(carte.getPlats().size() == 0)
			conteneur.add(new JLabel("Pas de plat à afficher"));
		
		for(Plat plat : carte.getPlats())
				conteneur.add(new PlatCard(
						new PlatController(plat,carteController)));
		
		validate();
		repaint();

	}
	
}
