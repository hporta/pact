package ui;

import java.awt.Color;

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
		this.id = id;
		this.state = state;
		setHorizontalAlignment(JLabel.CENTER);
		setText("Parasol n°" + id);
		setColor();
		setOpaque(true);
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
		setColor();
	}
	
	private void setColor()
	{
		switch(state)
		{
			// L = Libre
			case "L" : 	
				setBackground(GREEN);
				break;
				
			// O = occupé sans commande	
			case "O":
				setBackground(ORANGE);
				break;
				
			// C = a commandé	
			case "C":
				setBackground(RED);
				break;
				
			default:
				setBackground(RED);		
		}
	}
	
	

}
