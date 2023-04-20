package it.unipv.sfw.dao;

import it.unipv.sfw.model.museo.Riconoscimento;

public interface IRiconoscimentoDAO {

	boolean insertRiconoscimento(Riconoscimento riconoscimento);

	boolean updateDescrizione(Riconoscimento riconoscimento);

}