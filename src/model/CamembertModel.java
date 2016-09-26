package model;

import java.util.ArrayList;

public class CamembertModel implements ICamembertModel {

	String titre;
	ArrayList<Item> items;

	public CamembertModel(String titre) {
		super();
		this.titre = titre;
		this.items = new ArrayList<Item>();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public double totalItem() {
		double total = 0;
		for (int i = 0; i < this.items.size(); i++) {
			
			total += this.items.get(i).getValeur();
		}
		return total;
	}

	@Override
	public void deleteIdem(Item item) {
		items.remove(item);

	}

	@Override
	public void addItem(Item item) {
		this.items.add(item);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
