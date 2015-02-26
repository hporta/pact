package ui.stock.ingredient;

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

import controller.IngredientController;
import retaurant.Ingredient;
import ui.Constantes;

@SuppressWarnings("serial")
public class IngredientItem extends JPanel implements Observer
{
	//Model
	private Ingredient ingredient;
	
	//Labels
	private JLabel nom;
	private JLabel quantite;
	
	private final String CIRCLE_ICON_PATH = "data/img/circle.png";
	private final String CLOSE_ICON_PATH = "data/img/close.png";
	
	
	IngredientItem(IngredientCard parent,IngredientController controller)
	{
		this.ingredient = controller.getIngredient();
		ingredient.addObserver(this);
		this.nom = new JLabel();
		this.quantite = new JLabel();
		update(ingredient, null);
		
		
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
		JButton setButton = new JButton("Modifier",edit);
		setButton.addActionListener(parent);
		setButton.setActionCommand(Constantes.SWITCH);
		add(setButton,cstr);
		
		cstr.gridx=2;
		cstr.gridy=1;
		cstr.weightx = 0.2;
		cstr.weighty = 0.5;
		ImageIcon cross = new ImageIcon(CLOSE_ICON_PATH);
		cross = new ImageIcon(cross.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		JButton delButton = new JButton("Supprimer",cross);
		delButton.addActionListener(controller);
		delButton.setActionCommand(Constantes.DELETE);
		add(delButton,cstr);
	}


	@Override
	public void update(Observable o, Object arg)
	{
		nom.setText("Nom : " + ingredient.getNom());
		quantite.setText("Quantité : " + ingredient.getNoInStock() + " unités");
	}
	
}
