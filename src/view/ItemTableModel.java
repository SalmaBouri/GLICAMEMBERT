package view;

import javax.swing.table.AbstractTableModel;

import adaptor.CamembertAdaptor;

public class ItemTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CamembertAdaptor model;
	CamembertView view;

	private final String[] columnNames = new String[] {

			"Name", "Value", "Description" };
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { String.class, Long.class, String.class };

	public ItemTableModel(CamembertAdaptor model, CamembertView view) {
		this.model = model;
		this.view = view;

	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (0 == columnIndex) {
			return this.model.getItems().get(rowIndex).getIntitule();
		} else if (1 == columnIndex) {
			return this.model.getItems().get(rowIndex).getValeur();
		} else if (2 == columnIndex) {
			return this.model.getItems().get(rowIndex).getDescription();
		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (0 == columnIndex) {
			this.model.getItems().get(rowIndex).setIntitule((String) aValue);
		} else if (1 == columnIndex) {
			this.model.getItems().get(rowIndex).setValeur((long) aValue);
		} else if (2 == columnIndex) {
			this.model.getItems().get(rowIndex).setDescription((String) aValue);
		}
		this.model.update();

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return true;
	}

	@Override
	public int getRowCount() {

		return this.model.getItems().size();
	}

}
