package adaptor;

import java.util.ArrayList;
import java.util.Observable;

import model.CamembertModel;
import model.ICamembertModel;
import model.Item;

public class CamembertAdaptor extends Observable implements ICamembertModel{

	CamembertModel model;
	
	
	
	
	public CamembertAdaptor(CamembertModel model) {
		super();
		this.model = model;
	}
	
	

	public CamembertModel getModel() {
		return model;
	}



	public void setModel(CamembertModel model) {
		this.model = model;
	}



	@Override
	public void addItem(Item item) {
		
		model.addItem(item);
		setChanged();
		notifyObservers();
		
	}

	@Override
	public void deleteIdem(Item item) {
		
		model.deleteIdem(item);
		setChanged();
		notifyObservers();
		
	}



	@Override
	public ArrayList<Item> getItems() {
		
		return this.model.getItems();
	}



	@Override
	public double totalItem() {
		return this.model.totalItem();
	}



	@Override
	public String getTitre() {
		
		return this.model.getTitre();
	}
	
	public void update() {
		setChanged();
		notifyObservers();
		
	
	}
	
	
	
	

}
