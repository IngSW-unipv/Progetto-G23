package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.xml.crypto.Data;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;

import it.unipv.sfw.exceptions.EmptyDateException;
import it.unipv.sfw.exceptions.EmptyTimeException;


public class BigliettoMuseoView extends AView {

	
	private final double headPrice = 15;
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
	private JComboBox<Integer> numero; 
	private JLabel prezzotot;
	
	
	public BigliettoMuseoView(Dimension dim) {
		
		Font price_font = new java.awt.Font("Arial", 1, 10);
		Font medium_font = new java.awt.Font("Arial", 1, 16);
		Font button_font = new java.awt.Font("Arial", 2, 13);
		Font title_font = new java.awt.Font("Arial", 1, 26);
		
		this.setLayout(new BorderLayout());
	
		
		contenitore = new JPanel();
		contenitore.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		contenitore.setAlignmentY(LEFT_ALIGNMENT);
		
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
		
		//1
		JPanel visitaPanel = new JPanel();
		visitaPanel.setPreferredSize(new Dimension(400, 75));
		visitaPanel.setLayout(new GridLayout(3, 1));
		
		//1.1
		JLabel visita_label = new JLabel("Selezionare data e ora di visita:");
		visita_label.setFont(medium_font);
		visita_label.setOpaque(true);
		
		//1.2
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		DatePickerSettings dateSettings = new DatePickerSettings();
		TimePickerSettings timeSettings = new TimePickerSettings();
		chDate = new DateTimePicker(dateSettings, timeSettings);
		chDate.setPreferredSize(new Dimension(300, 20));
		LocalDate today = LocalDate.now();
		dateSettings.setDateRangeLimits(today.minusDays(0), today.plusDays(70));
		dateSettings.setAllowKeyboardEditing(false);
		timeSettings.generatePotentialMenuTimes(TimeIncrement.ThirtyMinutes, LocalTime.of(14, 0), LocalTime.of(18, 0));
		timeSettings.setAllowKeyboardEditing(false);
		
		i=new JMenuBar();
		i.setBorder(BorderFactory.createLineBorder(Color.lightGray));	
		info=new JMenu("i");
		JLabel infoOrario=new JLabel("<html> La visita al museo ha una durata di <br>"
							+ " un'ora e prevede la visione dei trofei e dei cimeli <br> "
							+ " facenti parte dell'intera storia del club.<br>");
		info.add(infoOrario);
		i.add(info);

		dataPanel.add(chDate);
		dataPanel.add(i);
		
		//1.3
		dataError = new JPanel();
		dataError.setLayout(new FlowLayout(FlowLayout.LEFT));
		d_error = new JLabel();
		d_error.setForeground(Color.RED);
		dataError.add(d_error);
		dataError.setVisible(false);
		
		
		visitaPanel.add(visita_label);
		visitaPanel.add(dataPanel);
		visitaPanel.add(dataError);
		
		
		JPanel numeroPanel = new JPanel();
		numeroPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		numeroPanel.setAlignmentY(LEFT_ALIGNMENT);
		numeroPanel.setPreferredSize(new Dimension(400, 55));
		
		JLabel numero_label = new JLabel("Selezionare numero biglietti:");
		numero_label.setFont(medium_font);
		numero_label.setOpaque(true);
		
		Integer[] nbiglietti = {1, 2, 3, 4};
		numero = new JComboBox(nbiglietti);
		numero.setSelectedIndex(0);
		
		numeroPanel.add(numero_label);
		numeroPanel.add(numero);
		
		JPanel prezzoPanel = new JPanel();
		prezzoPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel prezzo_label = new JLabel("Prezzo totale:");
		numero_label.setFont(medium_font);
		numero_label.setOpaque(true);
		
		prezzotot = new JLabel("€0");
		prezzotot.setFont(medium_font);
		prezzotot.setOpaque(true);
		
		prezzoPanel.add(prezzo_label);
		prezzoPanel.add(prezzotot);
		
		
		JPanel acquistaPanel = new JPanel();
		acquistaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		acquistaButton = new JButton("ACQUISTA BIGLIETTO");
		acquistaButton.setBackground(Color.WHITE);
		acquistaButton.setPreferredSize(new Dimension(300,50));
		acquistaButton.setFont(button_font);
		acquistaPanel.add(acquistaButton);	
	
		
		contenitore.add(emailPanel);
		contenitore.add(visitaPanel);
		contenitore.add(numeroPanel);
		contenitore.add(prezzoPanel);
		contenitore.add(acquistaPanel);	
		
		
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
		numero.setSelectedIndex(0);
		setPrice(0);
		contenitore.repaint();
	}
	
	public void upDateError() {
		d_error.setText("Data non inserita!");
		dataError.setVisible(true);
		emailError.setVisible(false);
		email_box.setText("");
		chDate.setDateTimeStrict(null);
		numero.setSelectedIndex(0);
		setPrice(0);
		contenitore.repaint();
	}
	
	public void upTimeError() {
		d_error.setText("Ora non inserita!");
		dataError.setVisible(true);
		emailError.setVisible(false);
		email_box.setText("");
		chDate.setDateTimeStrict(null);
		numero.setSelectedIndex(0);
		setPrice(0);
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
	
	public LocalDate getEnteredData() {
		return chDate.getDatePicker().getDate();
	}
	
	public LocalTime getEnteredTime() {
		return chDate.getTimePicker().getTime();
	}
	
	public JComboBox<Integer> getTotalPeople() {
		return numero;
	}
	
	public int getNumeroBiglietti() {
		return (int) numero.getSelectedItem();
	}
	
	public void setPrice(double price) {
		prezzotot.setText("€" + price);
		prezzotot.repaint();
	}
	
	public double getPrice() {
		return Double.parseDouble(prezzotot.getText().split("€")[1]);
	}
	
	public double getHeadPrice() {
		return headPrice;
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
		numero.setSelectedIndex(0);
		setPrice(0);
	}

}
