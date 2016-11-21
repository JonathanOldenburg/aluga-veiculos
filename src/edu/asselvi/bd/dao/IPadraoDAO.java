package edu.asselvi.bd.dao;

import edu.asselvei.bd.BDException;

public interface IPadraoDAO {
	public abstract boolean criaTabela() throws BDException;
	
	public abstract boolean dropaTabela() throws BDException;
	
}
