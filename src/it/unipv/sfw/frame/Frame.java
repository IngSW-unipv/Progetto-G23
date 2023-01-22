package it.unipv.sfw.frame;

import java.awt.Dimension;

import javax.swing.JFrame;

import it.unipv.sfw.view.AView;

public class Frame extends JFrame {
	
	private AView currentView;

	public Frame(int w, int h) {
		this.currentView = null;
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setSize(w, h);
		this.setVisible(true);
	}
	
	public void loadView(AView v) {
		if (currentView != null) {
			this.remove(currentView);
		}
        this.add(v);
        this.revalidate();
        this.repaint();
		currentView = v;
	}
	
	public Dimension getCurrentSize() {
		return this.getSize();
	}
}
