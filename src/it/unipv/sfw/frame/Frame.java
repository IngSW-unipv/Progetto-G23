package it.unipv.sfw.frame;

import java.awt.Dimension;

import javax.swing.JFrame;

import it.unipv.sfw.view.AView;

/**
 * Classe che gestisce il frame dell'applicazione.
 * @author Gabriele Invernizzi
 * @see it.unipv.sfw.view.AView
 */
public class Frame extends JFrame {
	
	private AView currentView;

	/**
	 * @param w Larghezza della finestra.
	 * @param h Altezza della finestra.
	 */
	public Frame(int w, int h) {
		this.currentView = null;
		this.setSize(w, h);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setTitle("StadiumSystem");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * @param v AView da caricare.
	 * @see it.unipv.sfw.view.AView
	 */
	public void loadView(AView v) {
		if (currentView != null) {
			this.remove(currentView);
		}
        this.add(v);
        this.revalidate();
        this.repaint();
		currentView = v;
	}
	
	/**
	 * @return Le dimensioni correnti della finestra.
	 */
	public Dimension getCurrentSize() {
		return this.getSize();
	}
}
