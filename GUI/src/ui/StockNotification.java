package ui;
import java.awt.BorderLayout;

import javax.swing.JLabel;



public class StockNotification extends Notification{

	public StockNotification(String nom, int quantite)
	{
		super();
		add(new JLabel("Attention stock faible"),BorderLayout.NORTH);
		add(new JLabel("La quantité de " + nom + " est faible : " + quantite),BorderLayout.CENTER);
	}
}
