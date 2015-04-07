package ui.parasol;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import restaurant.Table;


@SuppressWarnings("serial")
public class ParasolLabel extends JLabel implements Observer
{
	
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		repaint();
	}

	private static final Color GREEN = new Color(0,200,0);
	private static final Color RED = new Color(200,0,0);
	//private static final Color ORANGE = new Color(236,67,48);
	
	private Table table;
	
	public ParasolLabel(Table table)
	{
		super();
		this.table = table;
		table.addObserver(this);
		setOpaque(true);
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		int min = Math.min(this.getWidth(), this.getHeight());
		
		g.setColor(getColor());
		g.fillOval(this.getWidth()/2-min/4,this.getHeight()/2-min/4,min/2,min/2);
		g.setColor(getColor().darker());
		g.drawOval(this.getWidth()/2-min/4, this.getHeight()/2-min/4, min/2, min/2);
		
		
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman",Font.PLAIN,min/8));
		int width = g.getFontMetrics().charWidth('0' + table.getNo());
		g.drawString(table.getNo()+"",this.getWidth()/2-width/2,this.getHeight()/2+min/16);
	}
	
	private Color getColor()
	{
		//pas de commande, personne n'est là
		if(!table.isCommande() && table.isLibre())
		{
			return GREEN;
		}
		
		//une commande, et une table --> il faut aller servir
		else if(table.isCommande() && table.isLibre())
		{
			return RED;
		}
		
		else
			return Color.orange;
	}
	
	

}
