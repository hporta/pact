package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import restaurant.Recette;
import restaurant.Menu;
import restaurant.Plat;
import ui.Constantes;
import ui.recette.menu.MenuCard;
import ui.recette.menu.MenuFields;

public class MenuController implements ActionListener
{
	//Model
	private Menu menu;
	private Recette carte;
	
	//controller
	private RecetteController carteController;

	//View
	private MenuCard menuCard;
	private MenuFields fields;
	
	public MenuController(Menu menu, RecetteController carteController)
	{
		this.menu = menu;
		this.carte = carteController.getCarte();
		this.carteController = carteController;
	}

	public Menu getMenu() 
	{
		return menu;
	}

	public boolean setMenu(String nom, float price, ArrayList<String> liste)
	{

		if(validateNom(nom)
				&& validatePrice(price)
				&& validatePlats(liste))
		{
			menu.setNom(nom);
			//menu.setDescription(description);
			menu.setPrix(price);
			menu.setPlats(buildListe(liste));
			return true;
		}
		
		else
			return false;
	}
	
	public boolean validateNom(String nom)
	{
		return nom.length() <= 20 && nom != "";
	}
	
	public boolean validateDescription(String description)
	{
		return description.length() <= 150 && description != "";
	}
	
	public boolean validatePrice(float price)
	{
		return price > 0;
	}
	
	public boolean validatePlats(ArrayList<String> liste)
	{
		for(String name : liste)
		{
			if(!isIn(name))
				return false;
		}
		
		return true;
	}
	
	private boolean isIn(String name)
	{
		for(Plat plat : carte.getPlats())
		{
			if(plat.getNom().equals(name))
				return true;
		}
		
		return false;
	}
	
	private ArrayList<Plat> buildListe(ArrayList<String> liste)
	{
		ArrayList<Plat> plats = new ArrayList<Plat>();
		
		for(String nom : liste)
		{
			for(Plat plat : carte.getPlats())
			{
				if(nom.equals(plat.getNom()))
					plats.add(plat);
			}
		}
		
		return plats;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(Constantes.DELETE))
			carteController.removeMenu(menu);
		
		else if(e.getActionCommand().equals(Constantes.VALIDATE))
		{
			if(setMenu(fields.getNom(),fields.getPrix(),fields.getPlats()))
				menuCard.switchCard();
		}
		
	}

	public void setCard(MenuCard menuCard) 
	{
		this.menuCard = menuCard;
	}

	public RecetteController getCarteController()
	{
		return carteController;
	}

	public void setFields(MenuFields menuFields) {
		this.fields = menuFields;
	}

}
