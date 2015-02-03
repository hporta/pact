package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;



/* Solution non définitive pour l'id et la table, il devrait y avoir un objet parasol pour gérer ces paramètres*/
public class ParasolLabel extends JLabel
{
	
	private static final Color GREEN = new Color(0,200,0);
	private static final Color RED = new Color(200,0,0);
	private static final Color ORANGE = new Color(200,120,120);
	
	private final int id;
	private final String state;
	
	public ParasolLabel(int id, String state)
	{
		super();
		this.id = id;
		this.state = state;
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int min = Math.min(this.getWidth(), this.getHeight());
		
		g.setColor(getColor());
		g.fillOval(this.getWidth()/4,this.getHeight()/4,min/2,min/2);
		g.setColor(getColor().darker());
		g.drawOval(this.getWidth()/4, this.getHeight()/4, min/2, min/2);
		
		
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman",Font.PLAIN,min/8));
		int width = g.getFontMetrics().charWidth('0' + id);
		g.drawString(id+"",this.getWidth()/2-width/2,this.getHeight()/2);
	}
	
	private Color getColor()
	{
		switch(state)
		{
			// L = Libre
			case "L" : 	
				return(GREEN);
			// O = occupé sans commande	
			case "O":
				return(ORANGE);
				
			// C = a commandé	
			case "C":
				return(RED);
				
			default:
				return(RED);		
		}
	}
	
	

}
