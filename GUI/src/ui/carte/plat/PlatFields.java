package ui.carte.plat;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

//Sert d'intermédiaire encapsulant tous les champs
public class PlatFields 
{
	private JTextField nom;
	private JTextField description;
	private JFormattedTextField prix;
	private ArrayList<JComboBox<String>> ingredients;

	public PlatFields(JTextField nom, JFormattedTextField prix,
			JTextField description, ArrayList<JComboBox<String>> ingredients) 
	{
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.ingredients = ingredients;
	}
	
	public String getNom()
	{
		return nom.getText();
	}
	
	public float getPrix()
	{
		return Float.parseFloat(prix.getText());
	}

	public String getDescription()
	{
		return description.getText();
	}
	
	public ArrayList<String> getIngredients()
	{
		ArrayList<String> liste = new ArrayList<String>();
		
		for(JComboBox<String> box : ingredients)
			liste.add((String) box.getSelectedItem());
		
		return liste;
	}
}
