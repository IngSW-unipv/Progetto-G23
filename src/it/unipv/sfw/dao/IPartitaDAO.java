package it.unipv.sfw.dao;

import java.util.ArrayList;
import java.util.Calendar;

import it.unipv.sfw.model.partita.Partita;

public interface IPartitaDAO {

	ArrayList<Partita> selectAll();

	Partita selectPartitaByData(Calendar dataPartita);

	boolean insertPartita(Partita newPartita);

	boolean updatePartita(Partita newPartita);

}