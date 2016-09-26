package main;

import java.awt.Color;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import adaptor.CamembertAdaptor;
import controller.CamembertController;
import model.CamembertModel;

import model.Item;
import view.CamembertView;

import view.ItemTableModel;

public class MainCamembert extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Item i1 = new Item("Mobile", "trop cher", 600);
		Item i2 = new Item("Loyer", "trop cher", 600);
		Item i3 = new Item("Alimentation", "cher", 400);

		CamembertModel cModel = new CamembertModel("Budget");
		cModel.addItem(i1);
		cModel.addItem(i2);
		cModel.addItem(i3);

		CamembertController cController = new CamembertController();
		CamembertAdaptor adaptor = new CamembertAdaptor(cModel);

		CamembertView cView = new CamembertView(adaptor, cController);

		adaptor.addObserver(cView);

		ItemTableModel tmodel = new ItemTableModel(adaptor, cView);

		JTable table = new JTable(tmodel);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("	Camembert ");

		frame.setBackground(Color.white);

		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(cView);
		panel.add(new JScrollPane(table));

		frame.getContentPane().add(panel);

		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
