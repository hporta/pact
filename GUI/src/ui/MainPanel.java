package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.RestaurantController;

import ui.parasol.ParasolPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel
{
	private final ParasolPanel parasol;
	private final JLabel parasolHeader;
	private final ContentPanel content;
	private final JLabel contentHeader;
	
	private final String FONT = "TimesRoman";
	
	public MainPanel(RestaurantController restaurantController)
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.33;
		c.weighty = 0.2;
		add(parasolHeader = new JLabel("Terrasse"), c);
		parasolHeader.setHorizontalAlignment(JLabel.CENTER);
		parasolHeader.setForeground(Color.white);
		parasolHeader.setBackground(new Color(0,94,197));
		parasolHeader.setFont(new Font(FONT, Font.PLAIN, 25));
		parasolHeader.setOpaque(true);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.33;
		c.weighty = 0.8;
		add(parasol = new ParasolPanel(restaurantController.getTerrasseController()),c);
		
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.66;
		c.weighty = 0.2;
		add(contentHeader = new JLabel("Administration"), c);
		contentHeader.setHorizontalAlignment(JLabel.CENTER);
		contentHeader.setForeground(Color.white);
		contentHeader.setBackground(new Color(200,55,55));
		contentHeader.setFont(new Font(FONT, Font.PLAIN, 25));
		contentHeader.setOpaque(true);
		
		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.66;
		c.weighty = 0.8;
		add(content = new ContentPanel(restaurantController),c);

	}
	
}
