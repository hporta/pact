package ui.notification;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;



public class StockNotification extends Notification{

	private final Color STOCK_COLOR = Color.cyan;
	
	public StockNotification(String nom, int quantite)
	{
		super();
		setBackground(STOCK_COLOR);
		add(new JLabel("Attention stock faible"),BorderLayout.NORTH);
		add(new JLabel("La quantité de " + nom + " est faible : " + quantite),BorderLayout.CENTER);
	}
}
