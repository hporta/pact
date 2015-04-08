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
	private final String TERRASSE_LABEL = "Terrasse";
	private final String ADMINISTRATION_LABEL = "Administration";
	
	private final Color TERRASSE_COLOR = new Color(0,94,197);
	private final Color ADMINISTRATION_COLOR = new Color(200,55,55);
	
	private final String FONT = "TimesRoman";
	
	public MainPanel(RestaurantController restaurantController)
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		//Top left header
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.33;
		c.weighty = 0.2;
		JLabel parasolHeader = new JLabel(TERRASSE_LABEL);
		parasolHeader.setBackground(TERRASSE_COLOR);
		labelSettings(parasolHeader);
		add(parasolHeader,c);
		
		//Left panel
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.33;
		c.weighty = 0.8;
		add(new ParasolPanel(restaurantController.getTerrasseController()),c);
		
		//Top right header
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.66;
		c.weighty = 0.2;
		JLabel contentHeader = new JLabel(ADMINISTRATION_LABEL);
		contentHeader.setBackground(ADMINISTRATION_COLOR);
		labelSettings(contentHeader);
		add(contentHeader,c);
		
		//Right panel
		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.66;
		c.weighty = 0.8;
		add(new ContentPanel(restaurantController),c);
	}
	
	public void labelSettings(JLabel label)
	{
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(Color.white);
		label.setFont(new Font(FONT, Font.PLAIN, 25));
		label.setOpaque(true);
	}
}
