package ui.commande;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import retaurant.Command;
import retaurant.Plat;


@SuppressWarnings("serial")
public class CommandePanel extends JPanel implements ActionListener
{
	private ArrayList<Command> commandes;
	
	private JPanel conteneur;
	private JPanel aside;
	private JPanel buttonPanel;
	
	public CommandePanel() 
	{
		this.commandes = new ArrayList<Command>();
		
		commandes.add(new Command(2));
		commandes.add(new Command(3));
		commandes.add(new Command(4));
		commandes.add(new Command(5));
		commandes.add(new Command(17));
		commandes.add(new Command(8));
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridheight = 1;
		c.gridwidth = 2;

		
		c.weightx = 0.25;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_START;
		aside = new JPanel();
		aside.setLayout(new BorderLayout());
		add(aside,c);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,1));
		aside.add(buttonPanel);
		

		c.weightx = 0.75;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		conteneur = new JPanel();
		conteneur.setLayout(new CardLayout());
		add(conteneur,c);
		
		update();
	}

	public void update() 
	{
		buttonPanel.removeAll();
		conteneur.removeAll();
		
		for(int i=0; i < commandes.size(); i++)
		{
			Command com = commandes.get(i);
			JButton bouton = new JButton("Commande n°" + com.getId());
			bouton.addActionListener(this);
			bouton.setActionCommand(com.getId() +"");
			bouton.setPreferredSize(new Dimension(bouton.getWidth(),85));
			
			buttonPanel.add(bouton);
			conteneur.add(new CommandeItem(commandes.get(i)),""+com.getId());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		CardLayout cl = (CardLayout) conteneur.getLayout();
		cl.show(conteneur, e.getActionCommand());
	}
	

}
