package ui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class App extends JFrame
{
	private final MainPanel main;
	
	public App() 
	{
		super("Interface du Dome");		
		
		main = new MainPanel();
		setContentPane(main);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
