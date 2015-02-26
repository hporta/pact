package ui.stock.ingredient;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class IngredientFields 
{
	//Fields
	private JTextField nom;
	private JFormattedTextField quantite;
	
	public IngredientFields(JTextField nom, JFormattedTextField quantite) 
	{
		this.nom = nom;
		this.quantite = quantite;
	}
	
	
	//Name field
	public String getNom()
	{
		return nom.getText();
	}
	
	
	//Quantite field
	public int getQuantite()
	{
		return Integer.parseInt(quantite.getText());
	}
	
}
