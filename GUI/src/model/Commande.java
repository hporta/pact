package model;

import java.util.HashMap;

public class Commande {

	private HashMap<Item,Integer> liste;
	private double montant;
	
	public Commande()
	{
		liste = new HashMap<Item,Integer>();
	}
	
	public void addItem(Item item)
	{
		addItem(item,1);
	}
	
	public void addItem(Item item, int quantity)
	{
		if(liste.containsKey(item))
			liste.replace(item, new Integer(liste.get(item)+quantity));

		else
			liste.put(item, new Integer(quantity));
		
		montant += item.getPrix()*quantity;
	}
	
	public void removeItem(Item item)
	{
		liste.remove(item);
	}
	
	public double getMontant()
	{
		return montant;
	}
	
	public HashMap<Item,Integer> getListe()
	{
		return liste;
	}
	
	
}
