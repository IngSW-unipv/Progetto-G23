package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.utilities.ImageFilter;
import it.unipv.sfw.view.AdminAddOggettoView;
import it.unipv.sfw.view.AdminMuseoView;

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
	            
	            fileChooser.setCurrentDirectory(new File(helper+"\\img"));

	            int option = fileChooser.showOpenDialog(null);
	            if(option == JFileChooser.APPROVE_OPTION){
	               File file = fileChooser.getSelectedFile();
	               mview.setImagePath(file.getName());
	            }else{
	            	mview.setImagePath("Nessuna immagine selezionata");
	            }
			}
			
		});
		
		view = mview;
		
	}

	@Override
	public Type getType() {
		return AController.Type.AADDOGGETTO;
	}

}
