package ui.stock;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import retaurant.Consommable;
import retaurant.Ingredient;
import retaurant.Stock;
import ui.stock.consommable.ConsommablePanel;
import ui.stock.ingredient.IngredientPanel;


@SuppressWarnings("serial")
public class StockPanel extends JPanel implements ActionListener
{	
	private final ConsommablePanel consommable;
	private final IngredientPanel ingredient;
	
	private final String CONSOMMABLES = "Consommables";
	private final String INGREDIENTS = "Ingredients";
	
	private final JButton consommableButton;
	private final JButton ingredientButton;
	
	private final JPanel conteneur;
	
	private final Stock stock;
	
	public StockPanel() 
	{
		this(new Stock());
	}
	
	public StockPanel(Stock stock)
	{
		this.stock = stock;
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(consommableButton = new JButton(CONSOMMABLES));
		temp.add(ingredientButton = new JButton(INGREDIENTS));
		add(temp);
		
		consommableButton.addActionListener(this);
		consommableButton.setActionCommand(CONSOMMABLES);
		
		ingredientButton.addActionListener(this);
		ingredientButton.setActionCommand(INGREDIENTS);
		
		ingredientButton.setEnabled(true);
		consommableButton.setEnabled(false);
		
		add(conteneur = new JPanel(new CardLayout()));
		
		conteneur.add(consommable = new ConsommablePanel(stock),CONSOMMABLES);
		conteneur.add(ingredient= new IngredientPanel(stock),INGREDIENTS);
		
		update();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(CONSOMMABLES))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, CONSOMMABLES);
			consommableButton.setEnabled(false);
			ingredientButton.setEnabled(true);
			stock.etatDesStocks();
		}
		
		else if(e.getActionCommand().equals(INGREDIENTS))
		{
			CardLayout cl = (CardLayout) conteneur.getLayout();
			cl.show(conteneur, INGREDIENTS);
			consommableButton.setEnabled(true);
			ingredientButton.setEnabled(false);
		}
	}
	
	public void update()
	{
		consommable.update();
		ingredient.update();
	}
}
