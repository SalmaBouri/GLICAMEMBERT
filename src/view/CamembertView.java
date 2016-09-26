package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import controller.CamembertController;

import model.ICamembertModel;

public class CamembertView extends JComponent implements MouseListener, Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ICamembertModel cAdaptor;
	CamembertController cController;
	Arc2D arcs[];
	boolean selected[];
	Color colors[];

	public CamembertView(ICamembertModel cAdaptor, CamembertController cController) {
		super();

		this.cAdaptor = cAdaptor;
		this.cController = cController;
		arcs = new Arc2D[cAdaptor.getItems().size()];
		selected = new boolean[cAdaptor.getItems().size()];
		colors = new Color[cAdaptor.getItems().size()];
		for (int i = 0; i < cAdaptor.getItems().size(); i++)
			colors[i] = Color.getHSBColor((float) i / cAdaptor.getItems().size(), 1, 1);

		addMouseListener(this);

	}

	public CamembertController getcController() {
		return cController;
	}

	public void setcController(CamembertController cController) {
		this.cController = cController;
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(rh);

		double total = cAdaptor.totalItem();
		double valueArc = 0;

		for (int i = 0; i < cAdaptor.getItems().size(); i++) {
			if (selected[i] == true) {

				// System.out.println("item" + i + " not selected");
				Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
				// arc.setFrame(50, 10, 150, 150);
				arc.setFrame(150, 50, 150, 150);

				arc.setAngleStart((valueArc * 360) / total);
				arc.setAngleExtent((cAdaptor.getItems().get(i).getValeur() * 360) / total);
				valueArc += cAdaptor.getItems().get(i).getValeur();

				g2.draw(arc);
				// g2.setColor(new Color((int) (Math.random() * 0x1000000)));
				g2.setColor(Color.black);
				g2.fill(arc);

				arcs[i] = arc;

			}

			else {

				// System.out.println("item" + i + " not selected");
				Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
				// arc.setFrame(50, 10, 150, 150);
				arc.setFrame(150, 50, 150, 150);

				arc.setAngleStart((valueArc * 360) / total);
				arc.setAngleExtent((cAdaptor.getItems().get(i).getValeur() * 360) / total);
				valueArc += cAdaptor.getItems().get(i).getValeur();

				g2.draw(arc);

				g2.setColor(colors[i]);
				g2.fill(arc);

				arcs[i] = arc;
			}
			/*
			 * System.out.println("-----------------------");
			 * System.out.println(arc.x); System.out.println(arc.y);
			 * System.out.println(arc.start); System.out.println(arc.extent);
			 * System.out.println(i);
			 * System.out.println("-----------------------");
			 */

		}

		Arc2D.Float arc2 = new Arc2D.Float(Arc2D.OPEN);
		arc2.setArc(175, 75, 100, 100, 90, 360, Arc2D.OPEN);
		g2.setColor(Color.white);
		g2.fill(arc2);

		Arc2D.Float arc3 = new Arc2D.Float(Arc2D.OPEN);
		arc3.setArc(185, 85, 80, 80, 90, 360, Arc2D.OPEN);
		g2.setColor(Color.lightGray);
		g2.fill(arc3);

		g2.setColor(Color.black);
		Font myFont = new Font("Courier New", 1, 14);
		g.setFont(myFont);
		g2.drawString(cAdaptor.getTitre(), 198, 125);
		Font myFont2 = new Font("Courier New", 1, 10);
		g.setFont(myFont2);
		g2.drawString(Double.toString(cAdaptor.totalItem()), 205, 140);
		for (int i = 0; i < selected.length; i++) {
			selected[i] = false;
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		double x = e.getX();
		double y = e.getY();

		for (int i = 0; i < arcs.length; i++) {

			if (this.arcs[i].contains(x, y)) {
				selected[i] = true;
				System.out.println(this.cAdaptor.getItems().get(i).getIntitule());
			}
		}

		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}

}
