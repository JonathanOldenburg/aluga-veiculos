package edu.asselvi.view;

import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;
import edu.asselvi.view.utils.exception.DuplicateMenuEntryException;

public class Principal {
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.addOption(1, new CadastraCliente());
            menu.addOption(2, new CadastraCor());
            menu.addOption(3, new CadastraLocacao());
        } catch (DuplicateMenuEntryException e) {
            Msg.erro(e.getMessage());
        }
        
        while (!menu.isDisposed()) {
            menu.show();
        }
    }
    
}
