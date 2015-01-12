package model;

public class Table {

	private final int id;
	private String state;
	
	public Table(int id,String state)
	{
		this.id = id;
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public int getId()
	{
		return id;
	}
}
