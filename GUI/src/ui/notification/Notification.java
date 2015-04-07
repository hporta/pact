package ui.notification;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.Constantes;


//Notification est une classe générale pour toutes les notifications
//il faut faire des classes filles pour chaque notification particulière
@SuppressWarnings("serial")
public class Notification extends JPanel implements ActionListener
{
	public static final Color COLOR = Color.gray;
	
	private NotificationPanel parent;
	private JButton close;
	
	public Notification(NotificationPanel parent)
	{
		super();
		this.parent = parent;
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(COLOR);
		setLayout(new BorderLayout());
		
		
		ImageIcon cross = new ImageIcon("data/img/close.png");
		cross = new ImageIcon(cross.getImage().getScaledInstance(12, 12,Image.SCALE_DEFAULT));
		add(close = new JButton(cross),BorderLayout.EAST);
		close.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		close.setBorder(null);
		
		close.addActionListener(this);
		close.setActionCommand(Constantes.DELETE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(Constantes.DELETE))
		{
			parent.removeNotification(this);
		}		
	}
	
	
}
