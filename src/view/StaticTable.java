package view;


	
	import java.awt.*;
	import javax.swing.*;

	public class StaticTable extends JFrame {

		// constructor that will display a JTable based on elements received as arguments
		StaticTable(Object[][] obj, String[] header) {
			super("Static JTable example");
			
			// JPanel to horl the JTable
			JPanel panel = new JPanel(new BorderLayout());
			// constructor of JTable with a fix number of objects
			JTable table = new JTable(obj, header);
			panel.add(new JScrollPane(table));
			add(panel);    // adding panel to frame
			// and display it
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
			pack();
		}
		
		// to run the whole thing
		public static void main(String[] args) {
			// defines rows and column of the JTable
			Object[][] rowAndColumn = {
					
					{"Loyer", "trop cher" , new Integer(500) },
					
			};
			// defines the header
			String[] header = {"Name", "Description", "Value"};
			// build the GUI
			new StaticTable(rowAndColumn, header);
		}
	


}
