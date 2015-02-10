package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

/* Solution non définitive pour l'id et la table, il devrait y avoir un objet parasol pour gérer ces paramètres*/
public class ParasolLabel extends JLabel{
	
	private final int id;
	private String state;
	
	private static final Color GREEN = new Color(0,200,0);
	private static final Color RED = new Color(200,0,0);
	private static final Color ORANGE = new Color(200,120,120);
	
	
	public ParasolLabel(int id, String state)
	{
		super();
		this.id = id;
		this.state = state;
		setOpaque(true);
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(getColor());
		g.fillOval(this.getWidth()/4,this.getWidth()/4,this.getWidth()/2,this.getHeight()/2);
		g.setColor(Color.white);
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
