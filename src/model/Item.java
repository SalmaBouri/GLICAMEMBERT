package model;

public class Item {
	
	String intitule;
	String description;
	long valeur;
	
	
	
	public Item(String intitule, String description, long valeur) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.valeur = valeur;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public long getValeur() {
		return valeur;
	}


	public void setValeur(long valeur) {
		this.valeur = valeur;
	}
	
	

	

}
