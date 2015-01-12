package ui.notification;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Notification est une classe générale pour toutes les notifications
//il faut faire des classes filles pour chaque notification particulière
public class Notification extends JPanel{

	private final Color COLOR = Color.gray;
	
	public Notification()
	{
		super();
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(COLOR);
		setLayout(new BorderLayout());
		add(new JButton("Fermer"),BorderLayout.EAST);
	}
}
