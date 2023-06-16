package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.github.lgooddatepicker.components.DatePicker;

import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.view.buttons.SquadraButton;

public class AdminAddPartiteView extends AView {

	private String[] opzioni = { "12:30", "15:00", "18:00", "18:30", "20:45", "21:00" };

	private ArrayList<JLabel> nomesquadra;
	private ArrayList<ImageIcon> imgStemma;
	private ArrayList<SquadraButton> sceltasquadra;
	private ArrayList<JPanel> squadra;
	private JComboBox<String> orario;
	private JButton aggiungi, home;
	private JLabel errorLabel;
	private DatePicker data;

	public AdminAddPartiteView(Dimension dim) {

		Font medium = new Font("Arial", 1, 18);
		Font large = new Font("Arial", 1, 24);

		nomesquadra = new ArrayList<>();
		squadra = new ArrayList<>();
		imgStemma = new ArrayList<>();
		sceltasquadra = new ArrayList<>();
		data = new DatePicker();
		data.setDateToToday();
		orario = new JComboBox<>(opzioni);

		JLabel titolo = new JLabel("AGGIUNGI UNA PARTITA");
		titolo.setFont(large);
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBackground(Color.BLUE);
		titolo.setOpaque(true);

		home = new JButton("");
		ImageIcon imgHome = new ImageIcon((new ImageIcon(this.getClass().getResource("/home.png"))).getImage());
		home.setIcon(imgHome);

		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add(titolo, BorderLayout.CENTER);
		top.add(home, BorderLayout.EAST);

		for (Squadre s : Squadre.values()) {
			if (s != Squadre.Inter) {
				nomesquadra.add(new JLabel("" + s));
				imgStemma.add(new ImageIcon((new ImageIcon(getClass().getResource("/Stemma_" + s + ".png"))).getImage()
						.getScaledInstance(dim.width / 15, dim.height / 12, java.awt.Image.SCALE_SMOOTH)));
			}
		}

		JPanel selezionesquadra = new JPanel();

		selezionesquadra.setPreferredSize(new Dimension(dim.width, dim.height / 3));
		selezionesquadra.setLayout(new GridLayout(2, 10));

		for (int i = 0; i < 19; i++) {
			nomesquadra.get(i).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			sceltasquadra.add(new SquadraButton(imgStemma.get(i), false));
			squadra.add(new JPanel());
			squadra.get(i).setLayout(new BorderLayout());
			squadra.get(i).add(sceltasquadra.get(i), BorderLayout.CENTER);
			squadra.get(i).add(nomesquadra.get(i), BorderLayout.SOUTH);
			squadra.get(i).setBorder(BorderFactory.createLineBorder(Color.black, 5));
			selezionesquadra.add(squadra.get(i));
		}

		selezionesquadra.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		selezionesquadra.setBackground(Color.black);

		JPanel info = new JPanel();

		JLabel d = new JLabel("Data:");
		d.setFont(medium);

		JLabel h = new JLabel("Ora:");
		h.setFont(medium);
		errorLabel = new JLabel(" ");
		errorLabel.setForeground(Color.RED);

		aggiungi = new JButton("AGGIUNGI");
		aggiungi.setFont(medium);

		info.setLayout(new GridBagLayout());
		GridBagConstraints infoConstraints = new GridBagConstraints();
		infoConstraints.insets = new Insets(3, 3, 20, 15);

		infoConstraints.gridwidth = 1;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 0;
		info.add(d, infoConstraints);
		infoConstraints.gridwidth = 1;
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 0;
		info.add(data, infoConstraints);
		infoConstraints.gridwidth = 1;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 1;
		info.add(h, infoConstraints);
		infoConstraints.gridwidth = 1;
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 1;
		info.add(orario, infoConstraints);
		infoConstraints.gridwidth = 2;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 2;
		info.add(errorLabel, infoConstraints);
		infoConstraints.gridwidth = 2;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 3;
		info.add(aggiungi, infoConstraints);

		JPanel middle = new JPanel();

		middle.setPreferredSize(new Dimension(dim.width, dim.height / 2));
		middle.setLayout(new GridLayout(2, 1));
		middle.add(selezionesquadra);
		middle.add(info);

		this.setLayout(new BorderLayout());
		this.add(top, BorderLayout.NORTH);
		this.add(middle, BorderLayout.CENTER);
	}

	public Collection<SquadraButton> getButtons() {
		return sceltasquadra;
	}

	public JButton getAggiungiButton() {
		return aggiungi;
	}

	public void setUso() {
		for (int i = 0; i < 19; i++) {
			sceltasquadra.get(i).setUso(false);
		}
	}

	public JButton getAggiungi() {
		return aggiungi;
	}

	public String getSquadraScelta() {
		for (int i = 0; i < 19; i++) {
			if (sceltasquadra.get(i).getUso()) {

				return nomesquadra.get(i).getText();
			}
		}
		return null;
	}

	public LocalDate getData() {
		return data.getDate();
	}

	public String getOra() {
		return (String) orario.getSelectedItem();
	}

	public JButton getHome() {
		return home;
	}

	public void setSquadra() {
		for (int i = 0; i < 19; i++) {
			if (sceltasquadra.get(i).getUso()) {
				sceltasquadra.get(i).setBackground(Color.GREEN);
			} else {
				sceltasquadra.get(i).setBackground(Color.WHITE);
			}
		}

	}

	public void onSquadError(String errore) {
		errorLabel.setText(errore);
	}

	public void onAddError(String errore) {
		errorLabel.setText(errore);
	}

	public void success(String string) {
		errorLabel.setForeground(Color.GREEN);
		errorLabel.setText(string);
	}

	@Override
	public void onWindowResized(Dimension dim) {

		imgStemma.clear();
		for (Squadre s : Squadre.values()) {
			if (s != Squadre.Inter) {
				imgStemma.add(new ImageIcon((new ImageIcon(getClass().getResource("/Stemma_" + s + ".png"))).getImage()
						.getScaledInstance(dim.width / 15, dim.height / 12, java.awt.Image.SCALE_SMOOTH)));
			}
		}
		for (int i = 0; i < 19; i++) {
			sceltasquadra.get(i).modificaImg(imgStemma.get(i));
			squadra.get(i).revalidate();
			squadra.get(i).repaint();
		}

		this.revalidate();
		this.repaint();

	}

}
