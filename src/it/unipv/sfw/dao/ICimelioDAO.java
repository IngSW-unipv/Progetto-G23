package it.unipv.sfw.dao;

import it.unipv.sfw.model.museo.Cimelio;

public interface ICimelioDAO {

	boolean insertCimelio(Cimelio cim);

	boolean updateDescrizione(Cimelio cimelio);

}