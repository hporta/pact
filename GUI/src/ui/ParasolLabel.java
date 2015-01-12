package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import model.Table;

/* Solution non définitive pour l'id et la table, il devrait y avoir un objet parasol pour gérer ces paramètres*/
public class ParasolLabel extends JLabel{
	
	private Table table;
	
	private static final Color GREEN = new Color(0,200,0);
	private static final Color RED = new Color(200,0,0);
	private static final Color ORANGE = new Color(200,120,120);
	
	
	public ParasolLabel(int id, String state)
	{
		super();
		table = new Table(id,state);
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g)
	{
		int min = Math.min(this.getWidth(), this.getHeight());
		g.setColor(getColor());
		g.fillOval(min/4,min/4,this.getWidth()/2,this.getHeight()/2);
		g.setColor(Color.white);
		int width = g.getFontMetrics().charWidth('0' + table.getId());
		g.drawString(table.getId()+"",this.getWidth()/2-width/2,this.getHeight()/2);
	}
	
	private Color getColor()
	{
		switch(table.getState())
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
