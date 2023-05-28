package it.unipv.sfw.exceptions;

import com.github.lgooddatepicker.components.TimePicker;

public class EmptyTimeException extends Exception {

	public EmptyTimeException(TimePicker input) {
		super("Non è stata inserita nessuna ora");
	}
	
	
}
