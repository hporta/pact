package ui;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class NotificationPanel extends JPanel{

	private ArrayList<Notification> liste;
	
	public NotificationPanel() {
		super();
		liste = new ArrayList<Notification>();
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		add(new CommandeNotification(1));
		add(new CommandeNotification(2));
		add(new CommandeNotification(3));
		
	}
}
