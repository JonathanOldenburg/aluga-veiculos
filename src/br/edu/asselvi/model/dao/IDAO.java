package br.edu.asselvi.model.dao;

import java.util.List;

public interface IDAO<E> {

    /**
     * Realiza uma consulta no banco de acordo com o filtro passado por parametro.
     * @param filtro
     * @return o resultado da consulta.
     */
    public List<E> consultar(E filtro);
    
    /**
     * Insere um registro no banco de dados.
     * @param reg - registro a ser inserido.
     */
    public void inserir(E reg);
    
    /**
     * 
     * @param regs
     */
    public void inserir(List<E> regs);
}
