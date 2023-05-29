package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;

import it.unipv.sfw.exceptions.EmptyDateException;
import it.unipv.sfw.exceptions.EmptyTimeException;


public class BigliettoMuseoView extends AView {

	private JPanel box_contenitore;
	private JPanel contenitore;
	private JPanel emailError;
	private JPanel dataError;
	private JLabel d_error;
	private JButton acquistaButton;
	private JButton backButton;
	private JTextField email_box;
	private DateTimePicker chDate;
	private JMenuBar i;
	private JMenu info;
	
	
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
		
		
		
		//
		JPanel visitaPanel = new JPanel();
		visitaPanel.setPreferredSize(new Dimension(400, 75));
		visitaPanel.setLayout(new GridLayout(3, 1));
		//
		
		JLabel visita_label = new JLabel("Selezionare data e ora di visita:");
		visita_label.setFont(medium_font);
		visita_label.setOpaque(true);
		
		DatePickerSettings dateSettings = new DatePickerSettings();
		TimePickerSettings timeSettings = new TimePickerSettings();
		chDate = new DateTimePicker(dateSettings, timeSettings);
		LocalDate today = LocalDate.now();
		dateSettings.setDateRangeLimits(today.minusDays(0), today.plusDays(70));
		dateSettings.setAllowKeyboardEditing(false);
		timeSettings.generatePotentialMenuTimes(TimeIncrement.ThirtyMinutes, LocalTime.of(14, 0), LocalTime.of(18, 0));
		timeSettings.setAllowKeyboardEditing(false);
		
		dataError = new JPanel();
		dataError.setLayout(new FlowLayout(FlowLayout.LEFT));
		d_error = new JLabel();
		d_error.setForeground(Color.RED);
		dataError.add(d_error);
		dataError.setVisible(false);
		
		
		i=new JMenuBar();		
		info=new JMenu("i");
		JLabel infoOrario=new JLabel("<html> La visita al museo ha una durata di <br>"
							+ " un'ora e prevede la visione dei trofei e dei cimeli <br> "
							+ " facenti parte dell'intera storia del club.<br>");
		info.add(infoOrario);
		i.add(info);
		
		//
		visitaPanel.add(visita_label);
		visitaPanel.add(chDate);
		visitaPanel.add(dataError);
		//visitaPanel.add(i, -1);
		//
		
		/*
		JPanel visitaPanel=new JPanel();
		visitaPanel.setLayout(new GridBagLayout());		
		GridBagConstraints infoConstraints = new GridBagConstraints();
		infoConstraints.fill = GridBagConstraints.HORIZONTAL;
		infoConstraints.insets = new Insets(2, 0, 0, 15);
		
		
		infoConstraints.weightx = 0.5;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 1;
		visitaPanel.add(visita_label, infoConstraints);
		infoConstraints.gridwidth = GridBagConstraints.RELATIVE;
		infoConstraints.weightx = 0.5;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 2;
		visitaPanel.add(chDate, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 2;
		visitaPanel.add(i, infoConstraints);
		*/	
		
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
	
	public void upEmailError() {
		emailError.setVisible(true);
		dataError.setVisible(false);
		email_box.setText("");
		chDate.setDateTimeStrict(null);
		contenitore.repaint();
	}
	
	public void upDateError() {
		d_error.setText("Data non inserita!");
		dataError.setVisible(true);
		emailError.setVisible(false);
		email_box.setText("");
		chDate.setDateTimeStrict(null);
		contenitore.repaint();
	}
	
	public void upTimeError() {
		d_error.setText("Ora non inserita!");
		dataError.setVisible(true);
		emailError.setVisible(false);
		email_box.setText("");
		chDate.setDateTimeStrict(null);
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
	
	public void checkEnteredDate() throws EmptyDateException {
		if (chDate.getDatePicker().getDateStringOrEmptyString().equals("")) {
			throw new EmptyDateException(chDate.getDatePicker());
		}
	}
	
	public void checkEnteredTime() throws EmptyTimeException {
		if (chDate.getTimePicker().getTimeStringOrEmptyString().equals("")) {
			throw new EmptyTimeException(chDate.getTimePicker());
		}
	}
	
	@Override
	public Type getType() {
		return Type.BIGLIETTOMUSEO;
	}
	
	public void onLoad() {
		email_box.setText("");
		chDate.setDateTimeStrict(null);
		dataError.setVisible(false);
		emailError.setVisible(false);
	}

}
