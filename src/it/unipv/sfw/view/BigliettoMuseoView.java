package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;


public class BigliettoMuseoView extends AView {

	private JPanel box_contenitore;
	private JPanel contenitore;
	private JPanel emailError;
	private JButton acquistaButton;
	private JButton backButton;
	private JTextField email_box;
	
	public BigliettoMuseoView(Dimension dim) {
		
		Font medium_font = new java.awt.Font("Arial", 1, 16);
		Font button_font = new java.awt.Font("Arial", 2, 13);
		Font title_font = new java.awt.Font("Arial", 1, 26);
		
		this.setLayout(new BorderLayout());
	
		
		contenitore = new JPanel();
		contenitore.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		//contenitore.setLayout(new GridLayout(3, 1));
		
		JPanel emailPanel = new JPanel();
		emailPanel.setPreferredSize(new Dimension(400, 75));
		emailPanel.setLayout(new GridLayout(3, 1));
		JLabel email_label = new JLabel("Inserire email:");
		email_label.setFont(medium_font);
		email_label.setOpaque(true);
		email_box = new JTextField();
		emailError = new JPanel();
		emailError.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel e_error = new JLabel("Formato email inserito non valido!");
		e_error.setForeground(Color.RED);
		emailError.add(e_error);
		emailError.setVisible(false);
		emailPanel.add(email_label);
		emailPanel.add(email_box);
		emailPanel.add(emailError);
		
		JPanel visitaPanel = new JPanel();
		visitaPanel.setPreferredSize(new Dimension(400, 75));
		visitaPanel.setLayout(new GridLayout(2, 1));
		JLabel visita_label = new JLabel("Selezionare data e ora di visita:");
		visita_label.setFont(medium_font);
		visita_label.setOpaque(true);
		DatePickerSettings dateSettings = new DatePickerSettings();
		TimePickerSettings timeSettings = new TimePickerSettings();
		DateTimePicker chDate = new DateTimePicker(dateSettings, timeSettings);
		LocalDate today = LocalDate.now();
		dateSettings.setDateRangeLimits(today.minusDays(0), today.plusDays(70));
		dateSettings.setAllowKeyboardEditing(false);
		timeSettings.generatePotentialMenuTimes(TimeIncrement.ThirtyMinutes, LocalTime.of(14, 0), LocalTime.of(18, 0));
		timeSettings.setAllowKeyboardEditing(false);
		
		visitaPanel.add(visita_label);
		visitaPanel.add(chDate);
		
		acquistaButton = new JButton("ACQUISTA BIGLIETTO");
		acquistaButton.setBackground(Color.WHITE);
		acquistaButton.setPreferredSize(new Dimension(300,50));
		acquistaButton.setFont(button_font);
		
		contenitore.add(emailPanel);
		contenitore.add(visitaPanel);
		contenitore.add(acquistaButton);	
		
		
		this.add(contenitore, BorderLayout.CENTER);
		
		ImageIcon scudettobasso = new ImageIcon(getClass().getResource("/scudettointer.png"));
		scudettobasso = new ImageIcon(scudettobasso.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		JLabel scudetto = new JLabel();
		scudetto.setPreferredSize(new Dimension(100,125));
		scudetto.setBackground(Color.BLUE);
		scudetto.setOpaque(true);
		scudetto.setHorizontalAlignment(JLabel.CENTER);
		scudetto.setIcon(scudettobasso);
		
		this.add(scudetto, BorderLayout.SOUTH);
		
		JLabel blue_label_dx = new JLabel();
		blue_label_dx.setPreferredSize(new Dimension(200,200));
		blue_label_dx.setBackground(Color.BLACK);
		blue_label_dx.setOpaque(true);
		
		JLabel blue_label_sx= new JLabel();
		blue_label_sx.setPreferredSize(new Dimension(200,200));
		blue_label_sx.setBackground(Color.BLACK);
		blue_label_sx.setOpaque(true);
		
		this.add(blue_label_sx, BorderLayout.WEST);
		this.add(blue_label_dx, BorderLayout.EAST);
		
		JLabel blue_label_up = new JLabel();
		blue_label_up.setLayout(new BorderLayout());
		blue_label_up.setPreferredSize(new Dimension(100,100));
		blue_label_up.setBackground(Color.BLUE);
		blue_label_up.setOpaque(true);
		blue_label_up.setHorizontalAlignment(JLabel.CENTER);
		
		ImageIcon backpage = new ImageIcon(getClass().getResource("/backpage1.png"));
		backpage = new ImageIcon(backpage.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		backButton = new JButton("", backpage);
		backButton.setBackground(Color.BLUE);
		
		JLabel title = new JLabel("  MUSEUM TICKET STORE");
		title.setFont(title_font);
		title.setBackground(Color.BLUE);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		blue_label_up.add(backButton, BorderLayout.WEST);
		blue_label_up.add(title, BorderLayout.CENTER);
		
		this.add(blue_label_up, BorderLayout.NORTH);	
		
	}
	
	public void upError() {
		emailError.setVisible(true);
		email_box.setText("");
		contenitore.repaint();
	}
	
	public JButton getAcquistaButton() {
		return acquistaButton;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public String getEnteredEmail() {
		return email_box.getText();
	}
	
	@Override
	public Type getType() {
		return Type.BIGLIETTOMUSEO;
	}

}
