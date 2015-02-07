package ui.stock.ingredient;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.IngredientController;
import retaurant.Ingredient;

@SuppressWarnings("serial")
public class IngredientForm extends JPanel
{
	private Ingredient ingredient;
	
	//Textfields
	private JTextField nom;
	private JFormattedTextField quantite;
	
	//Buttons
	private JButton validate;
	private JButton ret;
	
	private final String VALIDATE = "validate";
	private final String SWITCH = "switch";

	
	public IngredientForm(IngredientCard parent,IngredientController controller)
	{
		this.ingredient = controller.getIngredient();
		
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
		add(validate = new JButton("Valider",edit),c);
		validate.addActionListener(controller);
		validate.setActionCommand(VALIDATE);
		
		c.gridx=4;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon retour = new ImageIcon("data/img/arrow.png");
		retour = new ImageIcon(retour.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		add(ret = new JButton("Retour",retour),c);
		ret.addActionListener(parent);
		ret.setActionCommand(SWITCH);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void update()
	{
		nom.setText(ingredient.getNom());
		quantite.setValue(ingredient.getNoInStock());
	}
}
