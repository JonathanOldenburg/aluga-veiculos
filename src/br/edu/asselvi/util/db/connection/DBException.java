package br.edu.asselvi.util.db.connection;

/**
 * 
 * @author jonathan
 *
 */
public class DBException extends Exception {

    private static final long serialVersionUID = 7781446290408960986L;

    /**
     * Mensagem de erro padrão.
     */
    private static String DEFAULT_ERROR_MESSAGE = "Erro na conexão com o banco de dados.";

    public DBException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DBException() {
        this(DEFAULT_ERROR_MESSAGE, null);
    }
}
