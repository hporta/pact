package ui.stock.ingredient;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.IngredientController;
import restaurant.Ingredient;
import ui.Constantes;

@SuppressWarnings("serial")
public class IngredientForm extends JPanel implements Observer
{
	//Model
	private Ingredient ingredient;
	
	//Textfields
	private JTextField nom;
	private JFormattedTextField quantite;
	
	public IngredientForm(IngredientCard parent, IngredientController controller)
	{
		ingredient = controller.getIngredient();
		ingredient.addObserver(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(new JLabel("Nom :"),c);
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.nom = new JTextField(ingredient.getNom()),c);
		

		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(new JLabel("Quantité :"),c);
		
		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.quantite = new JFormattedTextField(NumberFormat.getIntegerInstance()),c);
		this.quantite.setValue(new Integer(ingredient.getNoInStock()));
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.7;
		c.weighty = 1;
		add(new JPanel(),c);
		
		c.gridx=4;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon edit = new ImageIcon("data/img/validate.png");
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		JButton validate = new JButton("Valider",edit);
		validate.addActionListener(controller);
		validate.setActionCommand(Constantes.VALIDATE);
		add(validate,c);
		
		c.gridx=4;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon retour = new ImageIcon("data/img/arrow.png");
		retour = new ImageIcon(retour.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		JButton ret = new JButton("Retour",retour);
		ret.addActionListener(parent);
		ret.setActionCommand(Constantes.SWITCH);
		add(ret,c);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		controller.setFields(new IngredientFields(nom, quantite));
		update(ingredient, null);
	}


	@Override
	public void update(Observable o, Object arg) 
	{
		nom.setText(ingredient.getNom());
		quantite.setValue(ingredient.getNoInStock());
	}
}
