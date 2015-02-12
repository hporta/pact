package ui.carte.plat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import retaurant.Carte;
import retaurant.Plat;
import ui.AddItemButton;

@SuppressWarnings("serial")
public class PlatPanel extends JPanel implements ActionListener
{
	private AddItemButton add;
	private Carte carte;
	private JPanel conteneur;
	
	public PlatPanel()
	{
		super();
		add = new AddItemButton();
		carte = new Carte();
		conteneur = new JPanel();
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		add.setActionCommand("add");
		add.addActionListener(this);
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public PlatPanel(Carte carte)
	{
		super();
		add = new AddItemButton();
		this.carte = carte;
		conteneur = new JPanel();
		
		setLayout(new BorderLayout());
		conteneur.setLayout(new GridLayout(0,1));
		conteneur.add(add);
		add.setActionCommand("add");
		add.addActionListener(this);
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	
	
	public void addPlat(Plat plat)
	{
		carte.addPlat(plat);
		update();
	}
	
	public void removePlat(Plat plat)
	{
		carte.removePlat(plat);
		update();
	}
	
	public void update()
	{
		conteneur.removeAll();
		
		conteneur.add(add);
		
		if(carte.getPlats().size() > 0)
			for(Plat plat : carte.getPlats())
				conteneur.add(new PlatCard(this,plat));
		
		else
			conteneur.add(new JLabel("Pas de plat à afficher"));
		
		validate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("add"))
		{
			addPlat(new Plat());
		}
	}
	
}
