package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AddItemButton extends JButton
{
	private final String ICON_PATH = "data/img/plus.png";
	private final String UPPER_LEFT_ICON = "data/img/upper_left.png";
	private final String UPPER_RIGHT_ICON = "data/img/upper_right.png";
	private final String LOWER_LEFT_ICON = "data/img/lower_left.png";
	private final String LOWER_RIGHT_ICON = "data/img/lower_right.png";
	private Image img1;
	private Image img2;
	private Image img3;
	private Image img4;
	private Image img5;
	
	public AddItemButton(ActionListener actionListener, String actionCommand) 
	{
		super();
		try {
			img1 = ImageIO.read(new File(ICON_PATH));
			img2 = ImageIO.read(new File(UPPER_LEFT_ICON));
			img3 = ImageIO.read(new File(UPPER_RIGHT_ICON));
			img4 = ImageIO.read(new File(LOWER_LEFT_ICON));
			img5 = ImageIO.read(new File(LOWER_RIGHT_ICON));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addActionListener(actionListener);
		setActionCommand(actionCommand);
		
		setOpaque(false);
		
	}
	
	public void paintComponent(Graphics g)
	{
		int width = this.getWidth();
		int height = this.getHeight();
		
		//drawing the cross in the center
		g.drawImage(img1, width/2-height/4,height/4,height/2,height/2,this);

		//drawing the borders
		g.drawImage(img2,0,0,width/10,height/3,this);
		g.drawImage(img3,width-width/10,0,width/10,height/3,this);
		g.drawImage(img4,0,height-height/3,width/10,height/3,this);
		g.drawImage(img5,width-width/10,height-height/3,width/10,height/3,this);
				
	}
}
