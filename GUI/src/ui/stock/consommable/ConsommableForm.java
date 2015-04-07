package ui.stock.consommable;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

import restaurant.Consommable;
import ui.Constantes;
import controller.ConsommableController;

@SuppressWarnings("serial")
public class ConsommableForm extends JPanel implements Observer
{
	//Model
	private Consommable consommable;
	
	//Fields
	private JTextField nom;
	private JTextField prix;
	private JFormattedTextField quantite;
	
	
	public ConsommableForm(ConsommableCard parent, ConsommableController controller)
	{
		this.consommable = controller.getConsommable();
		consommable.addObserver(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.nom = new JTextField(),c);
			
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.prix = new JTextField(),c);
		
		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.quantite = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		
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
		
		c.gridx=0;
		c.gridy=3;
		c.weightx = 1;
		c.weighty = 0.12;
		JButton rec = new JButton("Enregistrements");
		rec.addActionListener(controller);
		rec.setActionCommand(Constantes.RECORD);
		add(rec,c);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		controller.setFields(new ConsommableFields(nom,prix,quantite));
		update();
	}
	
	
	public void update()
	{
		nom.setText(consommable.getNom());
		prix.setText(""+consommable.getPrix());
		quantite.setValue(consommable.getNoInStock());
	}


	@Override
	public void update(Observable o, Object arg) 
	{
		nom.setText(consommable.getNom());
		prix.setText(""+consommable.getPrix());
		quantite.setValue(consommable.getNoInStock());
	}
	
	
}
