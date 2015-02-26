package ui.stock.consommable;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

//Sert d'intermédiaire encapsulant tous les champs
public class ConsommableFields 
{
	private JTextField nom;
	private JTextField prix;
	private JFormattedTextField quantite;

	public ConsommableFields(JTextField nom, JTextField prix,
			JFormattedTextField quantite) 
	{
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public String getNom()
	{
		return nom.getText();
	}
	
	public int getQuantite()
	{
		return Integer.parseInt(quantite.getText());
	}
	
	public float getPrix()
	{
		return Float.parseFloat(prix.getText().replace(',' ,'.'));
	}

}
