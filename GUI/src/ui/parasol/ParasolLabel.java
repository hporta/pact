package ui.parasol;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import retaurant.Table;


@SuppressWarnings("serial")
public class ParasolLabel extends JLabel implements Observer, MouseListener
{
	
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		repaint();
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		table.setEtat(!table.getPropre());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	private static final Color GREEN = new Color(0,200,0);
	private static final Color RED = new Color(200,0,0);
	private static final Color ORANGE = new Color(236,67,48);
	
	private Table table;
	
	public ParasolLabel(Table table)
	{
		super();
		this.table = table;
		table.addObserver(this);
		setOpaque(true);
		
		addMouseListener(this);
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
		int width = g.getFontMetrics().charWidth('0' + table.getNo());
		g.drawString(table.getNo()+"",this.getWidth()/2-width/2,this.getHeight()/2);
	}
	
	private Color getColor()
	{
		if(table.getPropre() && table.isLibre())
		{
			return GREEN;
		}
		
		else if(!table.getPropre() && table.isLibre())
		{
			return RED;
		}
		
		else
			return Color.orange;
	}
	
	

}
