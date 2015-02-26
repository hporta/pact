package ui.carte.menu;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class MenuFields 
{
	//Fields
	private JTextField nom;
	private JTextField description;
	private JFormattedTextField prix;
	private ArrayList<JComboBox<String>> plats;
	
	
	public MenuFields(JTextField nom, JTextField description,
			JFormattedTextField prix, ArrayList<JComboBox<String>> plats) 
	{
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.plats = plats;
	}
	
	
	public String getNom()
	{
		return nom.getText();
	}
	
	public String getDescription()
	{
		return description.getText();
	}
	
	public float getPrix()
	{
		return Float.parseFloat(prix.getText());
	}
	
	public ArrayList<String> getPlats()
	{
		return new ArrayList<>();
	}

}
