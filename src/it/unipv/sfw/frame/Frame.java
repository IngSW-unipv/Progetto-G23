package it.unipv.sfw.frame;

import java.awt.AWTKeyStroke;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.KeyStroke;

import it.unipv.sfw.view.AView;

/**
 * Classe che gestisce il frame dell'applicazione.
 *
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

		// Add enter as a focus traversal forward key
		Set<AWTKeyStroke> forwardKeys = getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
		Set<AWTKeyStroke> newForwardKeys = new HashSet<>(forwardKeys);
		newForwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, newForwardKeys);

		this.setVisible(true);
	}

	/**
	 * @return Le dimensioni correnti della finestra.
	 */
	public Dimension getCurrentSize() {
		return this.getSize();
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
}
