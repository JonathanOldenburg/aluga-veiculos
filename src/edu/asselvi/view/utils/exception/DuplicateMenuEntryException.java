package edu.asselvi.view.utils.exception;

public class DuplicateMenuEntryException extends RuntimeException {

    private static final long serialVersionUID = 9134540403167454728L;
    private static final String DEFAULT_MESSAGE = "Entrada de menu duplicada";

    public DuplicateMenuEntryException() {
        this(DEFAULT_MESSAGE);
    }

    public DuplicateMenuEntryException(String msg) {
        super(msg);
    }
}
