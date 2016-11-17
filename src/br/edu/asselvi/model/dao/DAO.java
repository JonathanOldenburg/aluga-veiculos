package br.edu.asselvi.model.dao;

import java.util.List;

public abstract class DAO<E> {

    private static final String SELECT = "SELECT ";
    private static final String COMMA_SPACE = ", ";
    private static final String FROM = " FROM ";
    private static final String WHERE = " WHERE ";
    
    /**
     * Retorna o nome da tabela que 
     * @return
     */
    protected abstract String getTableName();
    
    /**
     * Retorna o nome dos campos da tabela em que a DAO representa.
     * @return
     */
    protected abstract String[] getFields();
    
    public List<E> consultar(E filtro) {
        
        return null;
    }
    
    private String buildString(String... strings) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }
}
