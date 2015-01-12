package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ui.notification.CommandeNotification;
import ui.notification.Notification;
import ui.notification.StockNotification;

public class NotificationPanel extends JPanel{

	private ArrayList<Notification> liste;
	
	public NotificationPanel() {
		super();
		liste = new ArrayList<Notification>();
		
		setLayout(new BorderLayout());
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(0,1));
		
		temp.add(new CommandeNotification(1));
		temp.add(new StockNotification("Cola-cola",4));
		temp.add(new CommandeNotification(2));
		temp.add(new CommandeNotification(3));
		
		add(temp,BorderLayout.PAGE_START);
		
	}
}
