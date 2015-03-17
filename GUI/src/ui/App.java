package ui;

import javax.swing.JFrame;

import controller.RestaurantController;

@SuppressWarnings("serial")
public class App extends JFrame
{
	private final MainPanel main;
	
	public App(RestaurantController restaurantController) 
	{
		super("Interface du Dome");	
		
		main = new MainPanel(restaurantController);
		setContentPane(main);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
