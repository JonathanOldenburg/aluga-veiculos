package edu.asselvi.model.dao;

import edu.asselvi.bd.BDException;

public interface IPadraoDAO {
	public abstract boolean criaTabela() throws BDException;
	
	public abstract boolean dropaTabela() throws BDException;
	
}
