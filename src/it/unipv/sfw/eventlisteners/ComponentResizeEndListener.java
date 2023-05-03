package it.unipv.sfw.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.Timer;

public abstract class ComponentResizeEndListener 
extends ComponentAdapter implements ActionListener {
	private final Timer timer;

    public ComponentResizeEndListener(int delay) {
        timer = new Timer(delay, this);
        timer.setRepeats(false);
        timer.setCoalesce(false);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        timer.restart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	this.onResizedTimedOut();
    }

    public abstract void onResizedTimedOut();
}
