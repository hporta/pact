package ui.stock.ingredient;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.IngredientController;

import retaurant.Ingredient;

@SuppressWarnings("serial")
public class IngredientItem extends JPanel
{
	private Ingredient ingredient;
	private IngredientController controller;
	
	//labels
	private JLabel nom;
	private JLabel quantite;
	
	//Buttons
	private JButton setButton;
	private JButton delButton;
	
	private IngredientCard parent;
	
	private final String SET = "set";
	private final String DELETE = "delete";
	
	private final String CIRCLE_ICON_PATH = "data/img/circle.png";
	private final String CLOSE_ICON_PATH = "data/img/close.png";
	
	IngredientItem(IngredientCard parent, IngredientController controller)
	{
		this.parent = parent;
		this.controller = controller;
		this.ingredient = controller.getIngredient();
		this.nom = new JLabel();
		this.quantite = new JLabel();
		update();
		
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints cstr = new GridBagConstraints();
		
		cstr.anchor = GridBagConstraints.PAGE_START;
		cstr.fill = GridBagConstraints.BOTH;
		
		cstr.gridx=0;
		cstr.gridy=0;
		cstr.weightx = 0.6;
		cstr.weighty = 0.5;
		add(nom,cstr);

		cstr.gridx=0;
		cstr.gridy=1;
		cstr.weightx = 0.2;
		cstr.weighty = 0.5;
		add(quantite,cstr);
		
		cstr.gridx=1;
		cstr.gridy=0;
		cstr.weightx = 0.7;
		cstr.weighty = 1;
		add(new JPanel(),cstr);
		
		cstr.gridx=2;
		cstr.gridy=0;
		cstr.weightx = 0.2;
		cstr.weighty = 0.5;
		ImageIcon edit = new ImageIcon(CIRCLE_ICON_PATH);
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		add(setButton = new JButton("Modifier",edit),cstr);
		setButton.addActionListener(controller);
		setButton.setActionCommand(SET);
		
		cstr.gridx=2;
		cstr.gridy=1;
		cstr.weightx = 0.2;
		cstr.weighty = 0.5;
		ImageIcon cross = new ImageIcon(CLOSE_ICON_PATH);
		cross = new ImageIcon(cross.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		add(delButton = new JButton("Supprimer",cross),cstr);
		delButton.addActionListener(controller);
		delButton.setActionCommand(DELETE);
	}
	
	public void update()
	{
		nom.setText("Nom : " + ingredient.getNom());
		quantite.setText("Quantité : " + ingredient.getNoInStock() + " unités");
	}
	
}
