package ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AddItemButton extends JButton
{
	private final String ICON_PATH = "cross.png";
	
	public AddItemButton() 
	{
		super();
		setBorderPainted(false);
		setFocusPainted(false);
		
		setContentAreaFilled(false);
		setForeground(new Color(0,0,0,0));
		setBackground(new Color(0,0,0,0));
		setOpaque(true);
		
		ImageIcon img = new ImageIcon(ICON_PATH);
		setIcon(img);
		setRolloverIcon(img);
		setPressedIcon(img);
		setDisabledIcon(img);
		
	}
}
