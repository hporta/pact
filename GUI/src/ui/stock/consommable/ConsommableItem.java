package ui.stock.consommable;

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

import retaurant.Consommable;

@SuppressWarnings("serial")
public class ConsommableItem extends JPanel implements ActionListener
{
	private Consommable consommable;
	private ConsommableCard parent;
	
	//labels
	private JLabel nom;
	private JLabel prix;
	private JLabel quantite;
	
	//Buttons
	private JButton setButton;
	private JButton delButton;
	
	ConsommableItem(ConsommableCard parent,Consommable consommable)
	{
		super();
		this.parent = parent;
		this.consommable = consommable;
		this.nom = new JLabel();
		this.prix = new JLabel();
		this.quantite = new JLabel();
		update();
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(nom,c);
		
		/*
		 * Partie pour la description du produit
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(new JLabel("Une description"),c);
		*/
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(prix,c);

		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(quantite,c);
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon edit = new ImageIcon("data/img/circle.png");
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		add(setButton = new JButton("Modifier",edit),c);
		setButton.addActionListener(this);
		setButton.setActionCommand("set");
		
		c.gridx=2;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon cross = new ImageIcon("data/img/close.png");
		cross = new ImageIcon(cross.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		add(delButton = new JButton("Supprimer",cross),c);
		delButton.addActionListener(this);
		delButton.setActionCommand("del");
		
	}
	
	public void update()
	{
		nom.setText("Nom : " + consommable.getNom());
		prix.setText("Prix : " + consommable.getPrix() +"€");
		quantite.setText("Quantité : " + consommable.getNoInStock() + " unités");
	}
	
	
	public Consommable getConsommable()
	{
		return consommable;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if("del".equals(e.getActionCommand()))
		{
			parent.removeConsommable();
		}
		
		else if("set".equals(e.getActionCommand()))
		{
			parent.switchCard();
		}
	}
}
