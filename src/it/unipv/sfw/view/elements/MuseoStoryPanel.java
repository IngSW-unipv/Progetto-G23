package it.unipv.sfw.view.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Classe che rappresenta il pannello contenente la storia del club.
 * 
 * @author Federico Romano
 *
 */
public class MuseoStoryPanel extends JPanel {

	public MuseoStoryPanel(Dimension dim, String storia) {
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 500));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel storyPanel = new JPanel();
		storyPanel.setLayout(new FlowLayout());
		JLabel titolo_storia = new JLabel("STORIA DEL CLUB");
		titolo_storia.setFont(new java.awt.Font("Arial", 1, 18));
		storyPanel.add(titolo_storia);
		
		JTextArea descrizioneStory = new JTextArea("" + storia);
		descrizioneStory.setLineWrap(true);
		descrizioneStory.setWrapStyleWord(true);
		descrizioneStory.setEditable(false);
		
		this.add(storyPanel, BorderLayout.NORTH);
		this.add(descrizioneStory, BorderLayout.CENTER);
	
	}
	
}
