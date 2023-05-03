package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.model.utente.Cliente;

public interface IClienteDAO {

	ArrayList<Cliente> selectAll();

	Cliente selectByEmail(String email);

	boolean insertCliente(Cliente clienteInput);

}