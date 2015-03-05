package ui.notification;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import retaurant.Compte;

import controller.RestaurantController;
import controller.StockController;


@SuppressWarnings("serial")
public class NotificationPanel extends JPanel implements Observer
{
	private ArrayList<Notification> liste;
	private JPanel content;
	
	public NotificationPanel(RestaurantController controller) 
	{
		controller.getCompteController().getCompte().addObserver(this);
		this.liste = new ArrayList<Notification>();
		
		setLayout(new BorderLayout());
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		
		add(content,BorderLayout.PAGE_START);
		
		update();
	}
	
	public void removeNotification(Notification notification)
	{
		liste.remove(notification);
		update();
	}
	
	public void addNotification(Notification notification)
	{
		liste.add(notification);
		update();
	}
	
	//update the contentPanel by filling it with all the notifications of liste
	public void update()
	{
		content.removeAll();
		
		if(liste.size() > 0)
			for(Notification notification : liste)
				content.add(notification);
		
		else
			content.add(new JLabel("Pas de notification"));
		
		validate();
		repaint();
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		liste.add(new CommandeNotification(this, (int) arg));
		
		content.removeAll();
		
		if(liste.size() > 0)
			for(Notification notification : liste)
				content.add(notification);
		
		else
			content.add(new JLabel("Pas de notification"));
		
		validate();
		repaint();
	}

}
