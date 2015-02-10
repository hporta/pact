package ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ParasolPanel extends JPanel{

	public ParasolPanel() {
		super();
		setLayout(new GridLayout(3,2));
	
		add(new ParasolLabel(1,"L"));
		add(new ParasolLabel(2,"O"));
		add(new ParasolLabel(3,"C"));
		add(new ParasolLabel(4,"L"));
		add(new ParasolLabel(5,"L"));
		add(new ParasolLabel(6,"O"));
		
	}

}
