package it.unipv.sfw.exceptions;

/**
 * Eccezione utilizzata nel caso in cui la data non sia
 * stata selezionata. 
 * 
 * @author Federico Romano
 *
 */
import com.github.lgooddatepicker.components.DatePicker;

public class EmptyDateException extends Exception {

	/**
	 * @param input Data che sarà vuota perchè non selezionata.
	 */
	public EmptyDateException(DatePicker input) {
		super("Non è stata inserita alcuna data e/o ora!");
	}
	
}
