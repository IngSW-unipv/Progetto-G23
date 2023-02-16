package it.unipv.sfw.DAO;

import java.util.ArrayList;

import it.unipv.sfw.model.utente.Admin;

public interface IAdminDAO {

	ArrayList<Admin> selectAll();

	Admin selectByEmail(String email);

	boolean insertAdmin(Admin adminInput);

}