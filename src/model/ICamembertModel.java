package model;

import java.util.ArrayList;

public interface ICamembertModel {

	
	void addItem(Item item);
	void deleteIdem (Item item);
	ArrayList<Item> getItems();
	double totalItem();
	String getTitre();
	void update();
}
