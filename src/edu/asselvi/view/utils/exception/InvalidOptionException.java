package edu.asselvi.view.utils.exception;

public class InvalidOptionException extends Exception {

    private static final long serialVersionUID = -6555195893108235389L;
    
    private static final String DEFAULT_MESSAGE = "Opção inválida.";
    
    public InvalidOptionException() {
        this(DEFAULT_MESSAGE);
    }
    
    public InvalidOptionException(String msg) {
        super(msg);
    }

}
