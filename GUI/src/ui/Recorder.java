package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import restaurant.Achetable;

@SuppressWarnings("serial")
public class Recorder extends JFrame
{
	private ArrayList<String> records;
	private final Achetable achetable;
	private JPanel mainPanel;
	private JPanel conteneur;
	
	public Recorder(Achetable achetable)
	{
		super("Enregistrements audios pour un produit");
		this.achetable = achetable;
		//this.records = Connector.getRecordsFor(achetable);
		this.records = new ArrayList<String>();
		records.add("data/temp1.wav");
		records.add("data/temp2.wav");
		records.add("data/temp3.wav");
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(0,1));
		setContentPane(mainPanel);
		
		mainPanel.add(conteneur);
		
		update();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		pack();

		setVisible(true);
	}
	
	public void update()
	{
		conteneur.removeAll();
		for(String name : records)
		{
			conteneur.add(new RecordItem(name));
		}
		validate();
		repaint();
	}

}
