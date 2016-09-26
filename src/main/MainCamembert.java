package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import adaptor.CamembertAdaptor;
import controller.CamembertController;
import model.CamembertModel;
import model.ICamembertModel;
import model.Item;
import view.CamembertView;

import view.ItemTableModel;



public class MainCamembert extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Item i1 = new Item("Mobile", "trop cher", 600);
		Item i2 = new Item("Loyer", "trop cher", 600);
		Item i3 = new Item("Alimentation", "cher", 400);
		
		
		
		CamembertModel cModel = new CamembertModel("Budget") ;
		cModel.addItem(i1);
		cModel.addItem(i2);
		cModel.addItem(i3);
		
		
		   //System.out.println(cModel.totalItem());
		// defines rows and column of the JTable
				
			
		
		CamembertController cController = new CamembertController();
		CamembertAdaptor adaptor = new CamembertAdaptor(cModel) ;
		
		CamembertView cView = new CamembertView(adaptor, cController);
		
		adaptor.addObserver(cView);
		//build the list
       /* List<Item> itemList = new ArrayList<Item>();
        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);*/
        
        //create the model
        ItemTableModel model = new ItemTableModel(adaptor, cView);
        //create the table
        JTable table = new JTable(model);
         
        //add the table to the frame
       // this.add(new JScrollPane(table));
         
        //this.setTitle("Editable Table Example");
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        //this.pack();
        //this.setVisible(true);
        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel paintPanel = new JPanel();
        JPanel textPanel = new JPanel();

       
		
	    
		
		JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("	Camembert ");
	    
	   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.white);
	    //frame.setSize(400, 500);
	    
	    JPanel panel = new JPanel(new GridLayout(2,1));
	    panel.add(cView);
        panel.add(new JScrollPane(table));
        
        frame.getContentPane().add(panel);

        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	    //CamembertView panel = new CamembertView(adapter, cController);
	    //System.out.println(cModel.totalItem());
	    
	 
	   // frame.add(panel);
	  //  frame.add(new JScrollPane(table),0);
	   // frame.add(panel,1);
	    
	  /*  JPanel p = new JPanel();

	    p.add( new CamembertView(adapter, cController) );
	    p.add( new JScrollPane(table) );

	   // frame.getContentPane().add( p, BorderLayout.CENTER );
	    
	    
	    frame.getContentPane().add(new CamembertView(adapter, cController));
	    frame.revalidate();
	    frame.repaint();
	    frame.getContentPane().add(new JScrollPane(table));
	    frame.revalidate();
	    frame.repaint();
	 
	 
	    frame.setVisible(true);*/
	    
		
			
			
		
	
       

	}

}
