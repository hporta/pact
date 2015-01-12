package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;

public class CommandeNotification extends Notification{

	public CommandeNotification(int idTable)
	{
		super();
		add(new JLabel("Commande de table"),BorderLayout.NORTH);
		add(new JLabel("La table n°" + idTable + " a passé une commande."),BorderLayout.CENTER);
	}
}
