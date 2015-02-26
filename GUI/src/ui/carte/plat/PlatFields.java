package ui.carte.plat;

import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

//Sert d'intermédiaire encapsulant tous les champs
public class PlatFields 
{
	private JTextField nom;
	private JTextField description;
	private JFormattedTextField prix;

	public PlatFields(JTextField nom, JFormattedTextField prix,
			JTextField description) 
	{
		this.nom = nom;
		this.prix = prix;
		this.description = description;
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
		return new ArrayList<String>();
	}
}
