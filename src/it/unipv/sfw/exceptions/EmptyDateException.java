package it.unipv.sfw.exceptions;

import com.github.lgooddatepicker.components.DatePicker;

public class EmptyDateException extends Exception {

	public EmptyDateException(DatePicker input) {
		super("Non è stata inserita alcuna data e/o ora!");
	}
	
}
