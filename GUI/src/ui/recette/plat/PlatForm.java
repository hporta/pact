package ui.recette.plat;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PlatController;
import restaurant.Ingredient;
import restaurant.Plat;
import restaurant.Stock;
import ui.Constantes;

@SuppressWarnings("serial")
public class PlatForm extends JPanel implements ActionListener
{
	//Model
	private Plat plat;
	private Stock stock;
	private ArrayList<Ingredient> listeIngredients;
	
	//fields
	private JTextField nom;
	private JTextField description;
	private JFormattedTextField prix;
	private ArrayList<JComboBox<String>> ingredients;
	
	
	private JPanel aside;
	
	private JButton addIngredient;
	
	private final String ADD_IN = "add ingre";
		
	
	public PlatForm(PlatCard parent, PlatController controller)
	{
		this.stock = controller.getStock();
		this.plat = controller.getPlat();
		this.listeIngredients = stock.getIngredients();
		
		ingredients = new ArrayList<JComboBox<String>>();
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.nom = new JTextField(plat.getNom()),c);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.description = new JTextField(plat.getDescription()),c);
		
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.prix = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.prix.setValue(new Double(plat.getPrix()));
		
		//coin pour les ingredients
		c.gridx=0;
		c.gridy=3;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(aside = new JPanel(),c);
		aside.setLayout(new GridLayout(0,1));
		
		
		//bouton pour ajouter un ingredient
		c.gridx=0;
		c.gridy=2;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(addIngredient = new JButton("Ajouter un ingredient"),c);
		addIngredient.addActionListener(this);
		addIngredient.setActionCommand(ADD_IN);
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon edit = new ImageIcon("data/img/validate.png");
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		JButton validate = new JButton("Valider",edit);
		validate.addActionListener(controller);
		validate.setActionCommand(Constantes.VALIDATE);
		add(validate,c);
		
		c.gridx=2;
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
		
		controller.setField(new PlatFields(nom,prix,description,ingredients));
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(ADD_IN))
		{
			JComboBox<String> temp = new JComboBox<String>();
			fillComboBoxWithIngredients(temp);
			ingredients.add(temp);
			aside.add(temp);
			
			validate();
			repaint();
		}
	}

	
	private void fillComboBoxWithIngredients(JComboBox<String> box)
	{
		for(Ingredient ingredient : listeIngredients)
			box.addItem(ingredient.getNom());
	}
	
	
	public void update()
	{
		nom.setText(plat.getNom());
		prix.setText(""+plat.getPrix());
		description.setText(plat.getDescription());
		
		validate();
		repaint();
	}
}
