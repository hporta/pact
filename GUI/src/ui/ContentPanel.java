package ui;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ui.carte.CartePanel;
import ui.stock.StockPanel;

public class ContentPanel extends JPanel implements ActionListener
{

	private final NotificationPanel notifications;
	private final StockPanel stock;
	private final CartePanel carte;
	private final CommandePanel commande;

	private final String NOTIFICATION = "Notifications";
	private final String STOCK = "Stocks";
	private final String CARTE = "Carte";
	private final String COMMANDE = "Commande";
	
	private final JPanel conteneur;
	private final JButton notificationButton;
	private final JButton stockButton;
	private final JButton carteButton;
	private final JButton commandeButton;
	
	public ContentPanel() 
	{
		super();
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel temp = new JPanel(new GridLayout(1,4));
		temp.add(notificationButton = new JButton(NOTIFICATION));
		temp.add(stockButton = new JButton(STOCK));
		temp.add(carteButton = new JButton(CARTE));
		temp.add(commandeButton = new JButton(COMMANDE));
		add(temp);
		
		notificationButton.addActionListener(this);
		notificationButton.setActionCommand(NOTIFICATION);
		
		stockButton.addActionListener(this);
		stockButton.setActionCommand(STOCK);
		
		carteButton.addActionListener(this);
		carteButton.setActionCommand(CARTE);
		
		commandeButton.addActionListener(this);
		commandeButton.setActionCommand(COMMANDE);
		
		notificationButton.setEnabled(false);
		stockButton.setEnabled(true);
		carteButton.setEnabled(true);
		commandeButton.setEnabled(true);
		
		conteneur = new JPanel(new CardLayout());
		
		conteneur.add(NOTIFICATION,notifications = new NotificationPanel());
		conteneur.add(STOCK, stock = new StockPanel());
		conteneur.add(CARTE, carte = new CartePanel());
		conteneur.add(COMMANDE, commande = new CommandePanel());
		
		add(conteneur);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(NOTIFICATION))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, NOTIFICATION);
			notificationButton.setEnabled(false);
			stockButton.setEnabled(true);
			carteButton.setEnabled(true);
			commandeButton.setEnabled(true);
		}
		
		else if(e.getActionCommand().equals(STOCK))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, STOCK);
			notificationButton.setEnabled(true);
			stockButton.setEnabled(false);
			carteButton.setEnabled(true);
			commandeButton.setEnabled(true);
		}
		
		
		else if(e.getActionCommand().equals(CARTE))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, CARTE);
			notificationButton.setEnabled(true);
			stockButton.setEnabled(true);
			carteButton.setEnabled(false);
			commandeButton.setEnabled(true);
		}
		
		else if(e.getActionCommand().equals(COMMANDE))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, COMMANDE);
			notificationButton.setEnabled(true);
			stockButton.setEnabled(true);
			carteButton.setEnabled(true);
			commandeButton.setEnabled(false);
		}
	}
}
