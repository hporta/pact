package ui.stock;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.StockController;
import retaurant.Stock;
import ui.stock.consommable.ConsommablePanel;
import ui.stock.ingredient.IngredientPanel;


@SuppressWarnings("serial")
public class StockPanel extends JPanel implements ActionListener, Observer
{	
	private final ConsommablePanel consommable;
	private final IngredientPanel ingredient;
	
	//Tabs
	private final String CONSOMMABLES = "Consommables";
	private final String INGREDIENTS = "Ingredients";
	
	//Buttons
	private final JPanel buttonPanel;
	private final JButton consommableButton;
	private final JButton ingredientButton;
	
	private final JPanel conteneur;
	
	//Model
	private final Stock stock;
	
	
	public StockPanel(StockController stockController)
	{

		this.stock = stockController.getStock();
		
		stock.addObserver(this);
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(consommableButton = new JButton(CONSOMMABLES));
		buttonPanel.add(ingredientButton = new JButton(INGREDIENTS));
		add(buttonPanel);
		
		consommableButton.addActionListener(this);
		consommableButton.setActionCommand(CONSOMMABLES);
		
		ingredientButton.addActionListener(this);
		ingredientButton.setActionCommand(INGREDIENTS);
		
		enableButton(INGREDIENTS);
		
		add(conteneur = new JPanel(new CardLayout()));
		conteneur.add(consommable = new ConsommablePanel(stockController),CONSOMMABLES);
		conteneur.add(ingredient= new IngredientPanel(stockController),INGREDIENTS);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(CONSOMMABLES))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, CONSOMMABLES);
			enableButton(INGREDIENTS);
		}
		
		else if(e.getActionCommand().equals(INGREDIENTS))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, INGREDIENTS);
			enableButton(CONSOMMABLES);
		}
	}
	
	
	private void enableButton(String name)
	{
		if(name.equals(INGREDIENTS))
		{
			consommableButton.setEnabled(false);
			ingredientButton.setEnabled(true);
		}
		
		else if(name.equals(CONSOMMABLES))
		{
			consommableButton.setEnabled(true);
			ingredientButton.setEnabled(false);
		}
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		consommable.update();
		ingredient.update();
	}
	
	
}
