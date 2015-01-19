package ui.notification;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CommandeNotification extends Notification{
		
	public static final Color CMD_COLOR = new Color(126,170,250);
	
	public CommandeNotification(int idTable)
	{
		super();
		setBackground(CMD_COLOR);
		add(new JLabel("Commande de table"),BorderLayout.NORTH);
		add(new JLabel("La table n°" + idTable + " a passé une commande."),BorderLayout.CENTER);
		//add(new JButton("Voir"),BorderLayout.LINE_END);
	}


}
