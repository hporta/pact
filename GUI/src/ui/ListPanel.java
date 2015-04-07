package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class ListPanel extends JPanel
{
	private JPanel conteneur;
	private JButton addItem;
	private JPanel empty;
	
	private boolean vide = true;
	
	public ListPanel(ActionListener listener, String command)
	{
		setLayout(new BorderLayout());
		
		addItem = new AddItemButton(listener, command);
		
		empty = new JPanel();
		empty.setLayout(new BorderLayout());
		empty.add(new JLabel("Rien à afficher"),BorderLayout.CENTER);
		empty.setPreferredSize(new Dimension(this.getWidth(),100));
		
		conteneur = new JPanel(new GridLayout(0,1));
		
		add(conteneur,BorderLayout.PAGE_START);
	}
	
	public void clean()
	{
		conteneur.removeAll();
		conteneur.add(addItem);
		vide = true;
	}
	
	public void addElement(JPanel panel)
	{
		conteneur.add(panel);
		vide = false;
	}
	
	public void show()
	{
		if(vide)
			conteneur.add(empty);
		
		validate();
		repaint();
	}
}
