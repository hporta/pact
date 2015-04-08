package ui.recette.plat;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PlatController;
import restaurant.Ingredient;
import restaurant.Plat;
import ui.Constantes;

@SuppressWarnings("serial")
public class PlatItem extends JPanel implements Observer
{
	//Model
	private Plat plat;
	
	//Labels
	private JLabel nom;
	private JLabel description;
	private JLabel prix;
	
	
	public PlatItem(PlatCard parent,PlatController platController)
	{
		this.plat = platController.getPlat();
		plat.addObserver(this);
		
		this.nom = new JLabel();
		this.prix = new JLabel();
		this.description = new JLabel();
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.2;
		add(nom,c);

		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.2;
		add(prix,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.8;
		c.weighty = 0.8;
		add(description,c);
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon edit = new ImageIcon("data/img/circle.png");
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		JButton setButton = new JButton("Modifier",edit);
		setButton.addActionListener(parent);
		setButton.setActionCommand(Constantes.SWITCH);
		add(setButton,c);
		
		
		c.gridx=2;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon cross = new ImageIcon("data/img/close.png");
		cross = new ImageIcon(cross.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		JButton delButton = new JButton("Supprimer",cross);
		delButton.addActionListener(platController);
		delButton.setActionCommand(Constantes.DELETE);
		add(delButton,c);
		
		update(plat,null);
	}
	

	@Override
	public void update(Observable o, Object arg) 
	{
		nom.setText("Nom : " + plat.getNom());
		prix.setText("Prix : " + plat.getPrix() +"€");
		
		String descr = "<html>" + plat.getDescription() +"<br/> Ingrédients : ";
		for(Ingredient ingre : plat.getIngredients())
		{
			descr += ingre.getNom()+", ";
		}
		descr += "</html>";
		
		description.setText(descr);
	}
	
}
