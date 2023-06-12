package it.unipv.sfw.exceptions;

import com.github.lgooddatepicker.components.TimePicker;

/**
 * Eccezione utilizzata nel caso in cui l'ora non sia
 * stata selezionata. 
 * 
 * @author Federico Romano
 *
 */
public class EmptyTimeException extends Exception {

	/**
	 * @param input Ora che sarà vuota perchè non selezionata.
	 */
	public EmptyTimeException(TimePicker input) {
		super("Non è stata inserita nessuna ora");
	}
	
	
}
