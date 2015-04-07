package ui.notification;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.RestaurantController;


@SuppressWarnings("serial")
public class NotificationPanel extends JPanel implements Observer
{
	private ArrayList<Notification> liste;
	private JPanel content;
	private JLabel empty;
	
	public NotificationPanel(RestaurantController controller) 
	{
		controller.getCompteController().getCompte().addObserver(this);
		this.liste = new ArrayList<Notification>();
		
		setLayout(new BorderLayout());
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		empty = new JLabel("Pas de notification");
		empty.setHorizontalAlignment(JLabel.CENTER);
		
		add(content,BorderLayout.PAGE_START);
		
		update(null,-1);
	}
	
	public void removeNotification(Notification notification)
	{
		liste.remove(notification);
		update(null,-1);
	}
	
	public void addNotification(Notification notification)
	{
		liste.add(notification);
		update(null,-1);
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		if((int) arg > 0)
			liste.add(new CommandeNotification(this, (int) arg));
		
		removeAll();
		content.removeAll();
		
		if(liste.size() > 0)
		{
			for(Notification notification : liste)
				content.add(notification);
			
			add(content,BorderLayout.PAGE_START);
		}
		
		else
		{
			add(empty,BorderLayout.CENTER);
			empty.setHorizontalAlignment(JLabel.CENTER);
		}

		
		validate();
		repaint();
	}

}
