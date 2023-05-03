package it.unipv.sfw.dao;

import it.unipv.sfw.model.store.Merchandising;

public interface IStoreItemDAO {

	boolean updatePrezzoItem(Merchandising merch, double newPrezzo);

	boolean updateQuantitaItem(Merchandising merch, int newQuantita);

	boolean insertStoreItem(Merchandising merch, int quantita);

}