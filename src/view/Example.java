package view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class Example{
  public static void main(String[] args) {
  new Example();
  }
  public Example(){
  JFrame frame = new JFrame("Shading Rows in a JTable");
  JPanel panel = new JPanel();
  String data[][] = {{"Vinod","100","MCA","Computer"},
  {"Deepak","101","PGDCA","History"},
  {"Ranjan","102","M.SC.","Biology"},
  {"Radha","103","BCA","Computer"}};
  String col[] = {"Name","Roll","Course","Subject"};
  DefaultTableModel model = new DefaultTableModel(data,col);
  //Setting the sadding in rows
  JTable table = new JTable(model){
  public Component prepareRenderer
  (TableCellRenderer renderer,int Index_row, int Index_col) {
  Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
  //even index, selected or not selected
  if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
  comp.setBackground(Color.lightGray);
  } 
  else {
  comp.setBackground(Color.white);
  }
  return comp;
  }
  };
  JTableHeader header = table.getTableHeader();
  header.setBackground(Color.yellow);
  JScrollPane pane = new JScrollPane(table);
  panel.add(pane);
  frame.add(panel);
  frame.setSize(460,200);
  frame.setUndecorated(true);
  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  }
}