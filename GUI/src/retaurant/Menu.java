package retaurant;
import java.util.ArrayList;
import java.util.Observable;



public class Menu extends Observable implements Achetable
{
	private ArrayList<Plat> menu;
	private String nom;
	private float prix;
	private final int id;

	
	public Menu(String nom, float prix, int id)
	{
		this.menu = new ArrayList<Plat>();
		this.nom = nom;
		this.prix = prix;
		this.id = id;
	}
	
	public Menu()
	{
		this("Nom",0.f,-1);
	}
	
	
	
	public void add(Plat plat)
	{
		for(Plat platAuMenu : menu)
		{
			if(platAuMenu != plat)
				menu.add(plat);
		}
	}
	
	// un menu est disponible que si tous les plats sont disponibles
	@Override
	public boolean disponible()
	{
		for(Plat plat : menu)
		{
			if(!plat.disponible())
				return false;
		}
		  
		return true;
	}
	
	@Override
	public void diminution() throws Exception
	{
		for(Plat plat : menu)
			plat.diminution();
	}
	
	public ArrayList<Plat> getMenu()
	{	
		return menu;
	}
	
	@Override
	public float getPrix()
	{
		return prix;
	}
	
	@Override
	public String getNom()
	{
		return nom;
		
	}
	
	public void removePlat(Plat plat) throws Exception
	{
    	if(menu.size() == 0)
    		throw new Exception("le menu est vide");
    	
        menu.remove(plat);
	}

	public ArrayList<Plat> getPlat() 
	{
		return menu;
	}

	public final void setPlats(ArrayList<Plat> menu) 
	{
		this.menu = menu;
		setChanged();
		notifyObservers();
	}

	public final void setPrix(float prix) 
	{
		this.prix = prix;
		setChanged();
		notifyObservers();
	}

	public final void setNom(String nom) 
	{
		this.nom = nom;
		setChanged();
		notifyObservers();
	}
	

}
