package ui.stock.consommable;

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

import controller.ConsommableController;
import retaurant.Consommable;

@SuppressWarnings("serial")
public class ConsommableForm extends JPanel implements ActionListener
{
	private Consommable consommable;
	private ConsommableController controller;
	
	private JTextField nom;
	private JFormattedTextField prix;
	private JFormattedTextField quantite;
	
	private JButton validate;
	private JButton ret;
	
	private ConsommablePanel parent;
	private final boolean nouveau;
	
	
	public ConsommableForm(ConsommablePanel parent)
	{
		this(parent, new ConsommableController(new Consommable("Nom",0,0.f)),true);
	}
	
	public ConsommableForm(ConsommablePanel parent, ConsommableController controller)
	{
		this(parent, controller, false);
	}
	
	public ConsommableForm(ConsommablePanel parent, ConsommableController controller, boolean nouveau)
	{
		super();
		this.controller = controller;
		this.consommable = controller.getConsommable();
		this.parent = parent;
		this.nouveau = nouveau;

		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.nom = new JTextField(consommable.getNom()),c);
			
		
		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.prix = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.prix.setValue(new Double(consommable.getPrix()));
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.quantite = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.quantite.setValue(new Integer(consommable.getNoInStock()));
		
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
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if("validate".equals(e.getActionCommand()))
		{
			if(controller.setConsommable(nom.getText(), Integer.parseInt(quantite.getText()), Float.parseFloat(prix.getText())))
			{		
				//supprime du conteneur
				this.getParent().remove(this);
				
				parent.addConsommable(controller.getConsommable());

			}
		}
		
		else if("return".equals(e.getActionCommand()))
		{
			this.getParent().remove(this);
			
			if(!nouveau)
			{
				parent.addConsommable(controller.getConsommable());
			}
		}		
	}
}
