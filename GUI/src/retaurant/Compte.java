package retaurant;

import java.util.ArrayList;

public class Compte 
{
	private ArrayList<Command> commandes;
	
	public Compte()
	{
		commandes = new ArrayList<Command>();
	}
	
	public void add(Command command)
	{
		commandes.add(command);
	}
	
	public void remove(Command command)
	{
		commandes.remove(command);
	}
}
