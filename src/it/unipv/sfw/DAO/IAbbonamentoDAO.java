package it.unipv.sfw.DAO;

import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.utente.Cliente;

public interface IAbbonamentoDAO {

	boolean insertAbbonamento(Cliente nuovoAbbonato);

	boolean updateAbbonamento(Cliente nuovoAbbonato, TipoAbb livello);

}