package edu.asselvi.model.dao;

import java.util.List;

import edu.asselvi.bd.BDException;

public interface IPadraoDAO<E> {
	public boolean criaTabela() throws BDException;
	
	public boolean dropaTabela() throws BDException;
	
	public boolean insere(E e) throws BDException;
	
	public boolean insere(List<E> e) throws BDException;
	
	public boolean altera(E e) throws BDException;
	
	public E consulta(int id) throws BDException;
	
	public List<E> consulta(E e) throws BDException;
	
	public List<E> consulta() throws BDException;
	
	public boolean exclui(int id) throws BDException;
}
