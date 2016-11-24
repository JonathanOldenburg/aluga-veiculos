package edu.asselvi.view.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import edu.asselvi.view.utils.exception.DuplicateMenuEntryException;
import edu.asselvi.view.utils.exception.InvalidOptionException;

public class Menu {

    private boolean disposed;
    private int defaultClosingOption;
    private Map<Integer, Runnable> options;

    public Menu() {
        disposed = false;
        setDefaultClosingOption(0);
        options = new HashMap<>();
    }

    public boolean show() {
        try {
            executeOption(Msg.perguntaInt(mountMenu() + "\nInforme a opção desejada..:"));
        } catch (Exception e) {
            Msg.erro(e.getMessage());
        }
        return isDisposed();
    }

    public Menu addOption(int optionKey, Runnable action) throws DuplicateMenuEntryException {
        if (options.containsKey(optionKey)) {
            throw new DuplicateMenuEntryException("Entrada de menu duplicada.");
        }
        options.put(optionKey, action);
        return this;
    }
    
    private String mountMenu() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry<Integer, Runnable> entry : options.entrySet()) {
            stringBuffer.append(entry.getKey() + " - " + entry.getValue().toString() + "\n");
        }
        return stringBuffer.toString();
    }
    
    private void executeOption(int opcaoUsuario) throws InvalidOptionException {
        disposed = opcaoUsuario == getDefaultClosingOption();
        if (options.containsKey(opcaoUsuario) && !isDisposed()) {
            Runnable opcaoModulo = options.get(opcaoUsuario);
            opcaoModulo.run();
        } else {
            throw new InvalidOptionException("A opção de menu selecionada não existe.");
        }
    }

    public boolean isDisposed() {
        return disposed;
    }

    public int getDefaultClosingOption() {
        return defaultClosingOption;
    }

    public void setDefaultClosingOption(int defaultClosingOption) {
        this.defaultClosingOption = defaultClosingOption;
    }
}
