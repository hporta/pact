package model;

public class Item {

	private String nom;
	private String description;
	private double prix;
	private int quantite;
	
	public Item(String nom, String description, double prix, int quantite) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public Item() {
		this.nom = "Nom";
		this.description = "Description";
		this.prix = 0;
		this.quantite = 0;
	}

	public final String getNom() {
		return nom;
	}

	public final void setNom(String nom) {
		this.nom = nom;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final double getPrix() {
		return prix;
	}

	public final void setPrix(double prix) {
		this.prix = prix;
	}

	public final int getQuantite() {
		return quantite;
	}

	public final void setQuantite(int quantite) {
		this.quantite = quantite;
	}
		
}
