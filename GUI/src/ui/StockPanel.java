package ui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockPanel extends JPanel{

	public StockPanel() {
		super();
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(new Item("Coca-cola","le coca c'est bon",1.2,3));
		add(new Item("Café","le café c'est bon",1.0,10));
		add(new Item("Perrier","le perrier c'est bon",1.2,3));
	}

}
