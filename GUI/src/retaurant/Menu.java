package retaurant;
import java.util.ArrayList;



public class Menu implements Achetable
	{
	private ArrayList<Plat> menu;
	private final String nom;
	private float prix;

	public void add(Plat plat)
		{for(Plat plataumenu : menu){
			if(plataumenu != plat)
		menu.add(plat);}
		}
	
	public Menu(String nom, float prix)
		{
		this.menu = new ArrayList<Plat>();
		this.nom = nom;
		this.prix = prix;
		}

	public boolean Disponible(){int i = 0;
		for (Plat plat : menu){
			if(plat.Disponible())
				i++;
		}
		return( i == menu.size());
	}
	public void diminution() throws Exception{
		for(Plat plat : menu)
			plat.diminution();
	}
	public ArrayList<Plat> getMenu()
		{	
		return menu;
		}
	public float getPrix(){
		return prix;
	}
	public String getNom(){
		return nom;
		
	}
	public void removePlat(Plat plat) throws Exception{
    	if(menu == null)
    		throw new Exception("le menu est vide");
        menu.remove(plat);
	}
	
	
	}
