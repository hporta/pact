package ui;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class TabPanel extends JPanel implements ActionListener
{
	private HashMap<String, JButton> map;
	
	private JPanel conteneur;
	private JPanel buttonPanel;
	
	public TabPanel() 
	{
		map = new HashMap<>();
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		buttonPanel = new JPanel();
		add(buttonPanel);
		
		add(conteneur = new JPanel(new CardLayout()));
		update();
	}
	
	public void addTab(String tabName, JPanel tab)
	{
		JButton bouton = new JButton(tabName);
		bouton.addActionListener(this);
		bouton.setActionCommand(tabName);
		
		buttonPanel.add(bouton);
		conteneur.add(tab, tabName);
		
		buttonPanel.setLayout(new GridLayout(1,map.size()));
		
		map.put(tabName, bouton);
	}
	
	private void enableButton(String tabName)
	{
		for(String key : map.keySet())
		{
			if(key.equals(tabName))
				map.get(key).setEnabled(false);
			
			else
				map.get(key).setEnabled(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		CardLayout cl = (CardLayout) conteneur.getLayout();
		cl.show(conteneur, e.getActionCommand());
		enableButton(e.getActionCommand());
	}
	
	public void update()
	{
		validate();
		repaint();
	}
}
