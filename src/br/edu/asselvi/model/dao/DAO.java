package br.edu.asselvi.model.dao;

import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.List;

import br.edu.asselvi.model.TesteBean;

/**
 * 
 * @author jonathan
 *
 * @param <E>
 */
public class DAO<E> implements IDAO<E> {

    private static final String SELECT = "SELECT ";
    private static final String COMMA_SPACE = ", ";
    private static final String FROM = " FROM ";
    private static final String WHERE = " WHERE ";
    
    private Class<E> typeParameterClass;
    
    /**
     * Campos da classe referentes aos campos da tabela.
     */
    private List<Field> fields;
    
    /**
     * Nome da tabela referente à classe.
     */
    private String tableName;
    
    /**
     * 
     * @param typeParameterClass
     */
    public DAO(Class<E> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
        fields = getClassFields(typeParameterClass);
        tableName = getTableName(typeParameterClass);
    }
    
    private List<Field> getClassFields(Class<E> typeParameterClass) {
        
        return null;
    }

    /**
     * Retorna o nome da tabela que 
     * @return
     */
    private String getTableName(Class<E> typeParameterClass) throws InvalidParameterException {
        if (typeParameterClass.getClass().isAnnotationPresent(Table.class)) {
            typeParameterClass.getAnnotations();
            //TODO: pegar as annotations e encontrar @Table
            return null;
        } else {
            throw new InvalidParameterException("A classe deve conter a anotação @Table");
        }
    }
    
    /**
     * Retorna o nome dos campos da tabela em que a DAO representa.
     * @return
     */
//    protected abstract String[] getFields();
    
    private String buildString(String... strings) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    @Override
    public List<E> consultar(E filtro) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void inserir(E reg) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void inserir(List<E> regs) {
        // TODO Auto-generated method stub
        
    }
}
