package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import adaptor.CamembertAdaptor;
import model.CamembertModel;
import model.Item;

public class ItemTableModel extends AbstractTableModel {
	
	CamembertAdaptor model;
	CamembertView view;
	
    
    private final String[] columnNames = new String[] {
           // "Id", "Name", "Hourly Rate", "Part Time"
    		"Name", "Value", "Description"
    };
    private final Class[] columnClass = new Class[] {
        String.class, Long.class, String.class
    };
 
    public ItemTableModel(CamembertAdaptor model, CamembertView view)
    {
        this.model = model;
        this.view= view;
        
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
  
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if(0 == columnIndex) {
            return this.model.getItems().get(rowIndex).getIntitule();
        }
        else if(1 == columnIndex) {
            return this.model.getItems().get(rowIndex).getValeur();
        }
        else if(2 == columnIndex) {
            return this.model.getItems().get(rowIndex).getDescription();
        }
        
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        if(0 == columnIndex) {
            this.model.getItems().get(rowIndex).setIntitule((String) aValue);
        }
        else if(1 == columnIndex) {
            this.model.getItems().get(rowIndex).setValeur((long) aValue);
        }
        else if(2 == columnIndex) {
            this.model.getItems().get(rowIndex).setDescription((String) aValue);
        }
        this.model.update();
       
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
    	//System.out.println( itemList);
    	
    	
    	
        return true;
    }

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.model.getItems().size();
	}



	
	
			
		
	

	
	


	/*public void actionPerformed(ActionEvent arg0) {
		int row = this.getSelectedRow();
		int column = this.getSelectedColumn();

		if ( evt.getSource() == getValue ) {
			String value = String.valueOf( table.getValueAt(row,column) );
			JOptionPane.showMessageDialog( this,
				"Value at (" + row + "," + column + ") is " + "\'" + value + "\'");
		}	
		
	}*/
}


	

