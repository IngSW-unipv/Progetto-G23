package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Cimelio.TipoCimelio;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.model.museo.Riconoscimento.TipoRiconoscimento;
import it.unipv.sfw.utilities.ImageFilter;
import it.unipv.sfw.view.AdminAddOggettoView;
import it.unipv.sfw.view.AdminMuseoView;

/**
 * Controller che si occupa della AdminAddOggettoView.
 * 
 * @author Federico Romano
 * @see AController
 * @see it.unipv.sfw.view.AdminAddOggettoView
 */
public class AdminAddOggettoController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		AdminAddOggettoView mview = new AdminAddOggettoView();
		
		mview.getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(AController.Type.AMUSEO);
			}
			
		});
		
		mview.getObjectType().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mview.getObjectType().getSelectedItem().equals(Cimelio.class.getSimpleName())) {
					mview.showCimelioSubType();
				}
				else if (mview.getObjectType().getSelectedItem().equals(Riconoscimento.class.getSimpleName())){
					mview.showRiconoscimentoSubType();
				}		
			}
			
		});
		
		mview.getAddImageButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            fileChooser.addChoosableFileFilter(new ImageFilter());
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            
	            File currentDirFile = new File(".");
	            String helper = currentDirFile.getAbsolutePath();
	            
	            fileChooser.setCurrentDirectory(new File(helper+"\\img\\museo"));

	            int option = fileChooser.showOpenDialog(null);
	            if(option == JFileChooser.APPROVE_OPTION){
	               File file = fileChooser.getSelectedFile();
	               mview.setImagePath(file.getName());
	            }else{
	            	mview.setImagePath("Nessuna immagine selezionata");
	            }
			}
			
		});
		
		mview.getAggiungiButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tipo = (String) mview.getObjectSubType().getSelectedItem();
				int anno = mview.getAnno();
				String descrizione = mview.getDescrizioneField();
				String image = mview.getNomeImg();
				
				if (mview.getObjectType().getSelectedItem().equals(Cimelio.class.getSimpleName())) {
					Cimelio c = new Cimelio(descrizione, TipoCimelio.valueOf(tipo), anno, image);
					DAOFactory.createICimelioDAO().insertCimelio(c);
					c.setId(DAOFactory.createICimelioDAO().selectId(c));	
				}
				else if (mview.getObjectType().getSelectedItem().equals(Riconoscimento.class.getSimpleName())){
					Riconoscimento r = new Riconoscimento(anno, descrizione, TipoRiconoscimento.valueOf(tipo), image);
					DAOFactory.createIRiconoscimentoDAO().insertRiconoscimento(r);
					r.setId(DAOFactory.createIRiconoscimentoDAO().selectId(r));
				}
				ControllerManager.getInstance().loadController(AController.Type.AMUSEO);
			}
		});
		
		view = mview;
		
	}

	@Override
	public Type getType() {
		return AController.Type.AADDOGGETTO;
	}

}
