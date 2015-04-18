package ui.recette.menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MenuController;
import restaurant.Recette;
import restaurant.Menu;
import restaurant.Plat;
import ui.Constantes;

@SuppressWarnings("serial")
public class MenuForm extends JPanel implements ActionListener, Observer
{
	private Menu menu;
	private ArrayList<Plat> listePlats;
	
	//Fields
	private JTextField nom;
	private JTextField description;
	private JFormattedTextField prix;
	private ArrayList<JComboBox<String>> plats;
	
	private JPanel aside;
	
	private JButton validate;
	private JButton ret;
	private JButton addPlat;
	
	//Model
	private Recette carte;
	
	
	public MenuForm(MenuCard parent, MenuController controller)
	{
		menu = controller.getMenu();
		menu.addObserver(this);
		
		this.listePlats = carte.getPlats();
		plats = new ArrayList<JComboBox<String>>();
		
		for(Plat plat : menu.getPlat())
			addJComboBox(plat.getNom());
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(nom = new JTextField(menu.getNom()),c);
		
		/*
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.description = new JTextField(menu.getDescription()),c);
		*/
		
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(prix = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		prix.setValue(new Double(menu.getPrix()));
		
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
		add(addPlat = new JButton("Ajouter un plat"),c);
		addPlat.addActionListener(this);
		addPlat.setActionCommand("addIn");
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon edit = new ImageIcon("data/img/validate.png");
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		add(validate = new JButton("Valider",edit),c);
		validate.addActionListener(controller);
		validate.setActionCommand(Constantes.VALIDATE);
		
		c.gridx=2;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon retour = new ImageIcon("data/img/arrow.png");
		retour = new ImageIcon(retour.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		add(ret = new JButton("Retour",retour),c);
		ret.addActionListener(parent);
		ret.setActionCommand(Constantes.SWITCH);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		controller.setFields(new MenuFields(nom,prix,plats));
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("addIn"))
		{
			addJComboBox();
		}
		
	}
	
	private void addJComboBox()
	{
		JComboBox<String> temp = new JComboBox<String>();
		fillComboBoxWithPlats(temp);
		plats.add(temp);
		aside.add(temp);
		update(menu, null);
	}
	
	private void addJComboBox(String plat)
	{
		JComboBox<String> temp = new JComboBox<String>();
		fillComboBoxWithPlats(temp);
		temp.setSelectedItem(plat);
		plats.add(temp);
		aside.add(temp);
		update(menu, null);
	}
	
	private void fillComboBoxWithPlats(JComboBox<String> box)
	{
		for(Plat plat : listePlats)
			box.addItem(plat.getNom());
	}
	
	public ArrayList<String> getPlats()
	{
		ArrayList<String> liste = new ArrayList<String>();

		for(JComboBox<String> box : plats)
			liste.add((String) box.getSelectedItem());
		
		return liste;
	}


	@Override
	public void update(Observable o, Object arg) 
	{
		validate();
		repaint();		
	}
}
