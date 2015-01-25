package ui.stock.ingredient;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.IngredientController;
import retaurant.Ingredient;

@SuppressWarnings("serial")
public class IngredientForm extends JPanel implements ActionListener
{
	private Ingredient ingredient;
	private IngredientController controller;
	
	private JTextField nom;
	private JFormattedTextField quantite;
	
	private JButton validate;
	private JButton ret;
	
	private IngredientPanel parent;
	
	public IngredientForm(IngredientPanel parent,IngredientController controller)
	{
		super();
		this.controller = controller;
		this.ingredient = controller.getIngredient();
		this.parent = parent;
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.nom = new JTextField(ingredient.getNom()),c);
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.quantite = new JFormattedTextField(NumberFormat.getIntegerInstance()),c);
		this.quantite.setValue(new Integer(ingredient.getNoInStock()));
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon edit = new ImageIcon("data/img/validate.png");
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		add(validate = new JButton("Valider",edit),c);
		validate.addActionListener(this);
		validate.setActionCommand("validate");
		
		c.gridx=2;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon retour = new ImageIcon("data/img/arrow.png");
		retour = new ImageIcon(retour.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		add(ret = new JButton("Retour",retour),c);
		ret.addActionListener(this);
		ret.setActionCommand("return");
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public IngredientForm(IngredientPanel parent)
	{
		this(parent,new IngredientController(new Ingredient("Nom",0)));
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if("validate".equals(e.getActionCommand()))
		{
			if(controller.setIngredient(nom.getText(), Integer.parseInt(quantite.getText())))
			{
				parent.addIngredient(controller.getIngredient());
				//supprime du conteneur
				this.getParent().remove(this);
			}
		}
		
		else if("return".equals(e.getActionCommand()))
		{
			
		}
		
	}
}
