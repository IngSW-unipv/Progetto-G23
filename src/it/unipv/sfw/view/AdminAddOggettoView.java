package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.ImageFilter;
import java.time.Year;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import it.unipv.sfw.dao.mysql.RiconoscimentoDAO;
import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Cimelio.TipoCimelio;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.model.museo.Riconoscimento.TipoRiconoscimento;

public class AdminAddOggettoView extends AView {

	private JPanel centralContainer;
	private JPanel selectPanel;
	private JComboBox<String> selectNewObjectType;
	private JPanel sottoTipoPanel;
	TipoCimelio[] sottoTipiCimelio = Cimelio.getTipoCimelio();
	TipoRiconoscimento[] sottoTipiRiconoscimento = Riconoscimento.getTipoCimelio();
	private JComboBox<String> selectObjectSubType;
	private boolean cSubTypeShown = false;
	private boolean rSubTypeShown = false;
	private JTextArea descrizioneField;
	private JFileChooser ImageSelectorPanel;
	private JButton addImageButton;
	private JTextField imgPath; 
	private JSpinner anno;
	private JButton aggiungiButton, backButton;
	
	public AdminAddOggettoView() {
		
		Font title_font = new java.awt.Font("Arial", 1, 26);
		Font medium_font = new java.awt.Font("Arial", 1, 16);
		
		this.setLayout(new BorderLayout());
		
		JLabel blue_label_up = new JLabel();
		blue_label_up.setLayout(new BorderLayout());
		blue_label_up.setPreferredSize(new Dimension(100,100));
		blue_label_up.setBackground(Color.YELLOW);
		blue_label_up.setOpaque(true);
		blue_label_up.setHorizontalAlignment(JLabel.CENTER);
		
		ImageIcon backpage = new ImageIcon(getClass().getResource("/backpage1.png"));
		backpage = new ImageIcon(backpage.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		backButton = new JButton("", backpage);
		backButton.setBackground(Color.YELLOW);
		backButton.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		JLabel title = new JLabel("  PAGINA DI INSERIMENTO:");
		title.setPreferredSize(new Dimension(200, 50));
		title.setFont(title_font);
		title.setBackground(Color.YELLOW);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		blue_label_up.add(backButton, BorderLayout.WEST);
		blue_label_up.add(title, BorderLayout.CENTER);
		
		
		centralContainer = new JPanel();
		centralContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		// 1
		selectPanel = new JPanel();
		selectPanel.setLayout(new GridLayout(1, 2, 50, 0));
		
		
		// 1.1
		JPanel tipoPanel = new JPanel();
		tipoPanel.setPreferredSize(new Dimension(400, 75));
		tipoPanel.setLayout(new GridLayout(2, 1)); 
		
		JLabel tipo_label = new JLabel("Selezionare categoria oggetto:");
		tipo_label.setFont(medium_font);
		tipo_label.setOpaque(true);
		
		String[] tipiSelezionabili = {Cimelio.class.getSimpleName(), Riconoscimento.class.getSimpleName()};
		selectNewObjectType = new JComboBox(tipiSelezionabili);
		selectNewObjectType.setSelectedIndex(-1); //initial no selection 
		
		tipoPanel.add(tipo_label);
		tipoPanel.add(selectNewObjectType);
		
		// 1.2
		sottoTipoPanel = new JPanel();
		sottoTipoPanel.setPreferredSize(new Dimension(400, 75));
		sottoTipoPanel.setLayout(new GridLayout(2, 1)); 
		
		JLabel sotto_tipo_label = new JLabel("Selezionare tipo oggetto:");
		sotto_tipo_label.setFont(medium_font);
		sotto_tipo_label.setOpaque(true);
		
		selectObjectSubType = new JComboBox();
		
		sottoTipoPanel.add(sotto_tipo_label);
		sottoTipoPanel.add(selectObjectSubType);
		
		
		selectPanel.add(tipoPanel);
		selectPanel.add(sottoTipoPanel);
		
		
		// 2
		JPanel containerDescription = new JPanel();
		containerDescription.setLayout(new GridLayout(1, 2, 50, 0));
		
		
		// 2.1
		JPanel descrizionePanel = new JPanel();
		descrizionePanel.setPreferredSize(new Dimension(400, 100));
		descrizionePanel.setLayout(new BorderLayout());
		//descrizionePanel.setLayout(new GridLayout(2, 1, 0, 20)); 
		
		JLabel descrizione_label = new JLabel("Inserire descrizione del nuovo oggetto:");
		descrizione_label.setFont(medium_font);
		descrizione_label.setOpaque(true);
		
		descrizioneField = new JTextArea(5, 30);
		
		JScrollPane testo = new JScrollPane(descrizioneField);
		testo.setBorder(BorderFactory.createTitledBorder("Descrizione:"));
		//descrizioneField.setColumns(30);
		//descrizioneField.setRows(5);
		descrizioneField.setLineWrap(true);
		descrizioneField.setWrapStyleWord(true);
		
		descrizionePanel.add(descrizione_label, BorderLayout.NORTH);
		descrizionePanel.add(testo, BorderLayout.CENTER);
		
		
		//2.2
		JPanel selectImagePanel = new JPanel();
		selectImagePanel.setLayout(new BorderLayout());
		//selectImagePanel.setLayout(new GridLayout(3, 1));
		
		JLabel image_label = new JLabel("Premere per selezionare immagine:");
		image_label.setFont(medium_font);
		image_label.setOpaque(true);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		addImageButton = new JButton("SELEZIONA IMMAGINE");
		addImageButton.setBackground(Color.WHITE);
		addImageButton.setPreferredSize(new Dimension(200, 50));
		imagePanel.add(addImageButton);
		
		JPanel pathPanel = new JPanel();
		pathPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		imgPath = new JTextField();
		imgPath.setBackground(Color.white);
		imgPath.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		imgPath.setPreferredSize(new Dimension(250, 25));
		imgPath.setVisible(true);
		imgPath.setEditable(false);
		pathPanel.add(imgPath);
		
		selectImagePanel.add(image_label, BorderLayout.NORTH);
		selectImagePanel.add(imagePanel, BorderLayout.CENTER);
		selectImagePanel.add(pathPanel, BorderLayout.SOUTH);
		
		
		containerDescription.add(descrizionePanel);
		containerDescription.add(selectImagePanel);
		
		// 3
		JPanel annoContenitore = new JPanel();
		annoContenitore.setLayout(new GridLayout(1, 2, 200, 0));
		
		//3.1
		JPanel annoPanel = new JPanel();
		annoPanel.setLayout(new GridLayout(2,1));
		
		JLabel anno_label = new JLabel("Inserire anno:");
		anno_label.setFont(medium_font);
		anno_label.setOpaque(true);
		
		int current = Year.now().getValue();
		int min = current-5;
		int max = current;
		int step = 1;
		anno = new JSpinner(new SpinnerNumberModel(current, min, max, step));
		anno.setPreferredSize(new Dimension(50, 10));
		
		annoPanel.add(anno_label);
		annoPanel.add(anno);
		
		//3.2
		aggiungiButton = new JButton("AGGIUNGI AL MUSEO");
		aggiungiButton.setBackground(Color.WHITE);
		aggiungiButton.setPreferredSize(new Dimension(200, 50));
		
		annoContenitore.add(annoPanel);
		annoContenitore.add(aggiungiButton);
		
		
		centralContainer.add(selectPanel);
		centralContainer.add(containerDescription);
		centralContainer.add(annoContenitore);
		
		this.add(blue_label_up, BorderLayout.NORTH);
		this.add(centralContainer, BorderLayout.CENTER);
		
	}
	
	public void showCimelioSubType() {
		if (!iscSubTypeShown()) {
			if (isrSubTypeShown()) {
				selectObjectSubType.removeAllItems();
				setrSubTypeShown(false);
			}
			for(int i=0; i<sottoTipiCimelio.length; i++) {
				selectObjectSubType.addItem(sottoTipiCimelio[i].toString());
			}
			setcSubTypeShown(true);
			selectObjectSubType.repaint();
		}
	}
	
	public boolean iscSubTypeShown() {
		return cSubTypeShown;
	}

	public void setcSubTypeShown(boolean state) {
		this.cSubTypeShown = state;
	}
	
	public void showRiconoscimentoSubType() {
		if (!isrSubTypeShown()) {
			if (iscSubTypeShown()) {
				selectObjectSubType.removeAllItems();
				setcSubTypeShown(false);
			}
			for(int i=0; i<sottoTipiRiconoscimento.length; i++) {
				selectObjectSubType.addItem(sottoTipiRiconoscimento[i].toString());
			}
			setrSubTypeShown(true);
			selectObjectSubType.repaint();
		}
	}
	
	public boolean isrSubTypeShown() {
		return rSubTypeShown;
	}

	public void setrSubTypeShown(boolean state) {
		this.rSubTypeShown = state;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public JButton getAggiungiButton() {
		return aggiungiButton;
	}
	
	public JButton getAddImageButton() {
		return addImageButton;
	}
	
	public String getImagePath() {
		return imgPath.getText();
	}
	
	public void setImagePath(String path) {
		imgPath.setText(path);
	}
	
	public JComboBox<String> getObjectType() {
		return selectNewObjectType;
	}
	
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
