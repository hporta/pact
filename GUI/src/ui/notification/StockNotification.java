package ui.notification;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;

import ui.NotificationPanel;



public class StockNotification extends Notification{

	public static final Color STOCK_COLOR = new Color(255,67,42);
	
	public StockNotification(NotificationPanel parent, String nom, int quantite)
	{
		super(parent);
		setBackground(STOCK_COLOR);
		add(new JLabel("Attention stock faible"),BorderLayout.NORTH);
		add(new JLabel("La quantité de " + nom + " est faible : " + quantite),BorderLayout.CENTER);
	}
}
