package ui;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ErrorDialog extends JDialog
{
	public ErrorDialog(ArrayList<String> errors)
	{
		super();
		setSize(300, 200);
		setTitle("Erreur modification");
		
		String text = "<html>";
		for(String error : errors)
			text += error +"<br>";
		text += "</html>";
		
		JPanel content = new JPanel();
		content.add(new JLabel(text));
		setContentPane(content);
		
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}
