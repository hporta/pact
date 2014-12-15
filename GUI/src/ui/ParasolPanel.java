package ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ParasolPanel extends JPanel{

	public ParasolPanel() {
		super();
		setLayout(new GridLayout(3,2));
	
		for(int i=0; i < 6; i++)
		{
			JLabel temp = new JLabel("Parasol " + (i+1));
			temp.setHorizontalAlignment(JLabel.CENTER);
			add(temp);
		}
	}

}
