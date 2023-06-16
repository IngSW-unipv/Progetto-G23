package it.unipv.sfw.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.Timer;

/**
 * Event listener del resize del frame ma solo dopo un delay;
 *
 * @author Gabriele Invernizzi
 */
public abstract class ComponentResizeEndListener extends ComponentAdapter implements ActionListener {
	private final Timer timer;

	public ComponentResizeEndListener(int delay) {
		timer = new Timer(delay, this);
		timer.setRepeats(false);
		timer.setCoalesce(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.onResizedTimedOut();
	}

	@Override
	public void componentResized(ComponentEvent e) {
		timer.restart();
	}

	public abstract void onResizedTimedOut();
}
