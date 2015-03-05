package retaurant;

import java.util.ArrayList;
import java.util.Observable;

public class Compte extends Observable
{
	private ArrayList<Command> commandes;
	
	public Compte()
	{
		commandes = new ArrayList<Command>();
	}
	
	public void add(Command command)
	{
		commandes.add(command);
		setChanged();
		notifyObservers(command.getId());
	}
	
	public void remove(Command command)
	{
		commandes.remove(command);
		setChanged();
		notifyObservers();
	}
	
	public final ArrayList<Command> getCommandes()
	{
		return commandes;
	}

	public int nextId() 
	{
		return commandes.size()+1;
	}
}
