package it.unipv.sfw.dao;

import java.util.ArrayList;
import java.util.Calendar;

import it.unipv.sfw.model.partita.Posto;

public interface IPostoDAO {

	int selectCount(Calendar dataPartita);

	ArrayList<Posto> selectAllOrderBydata();

}