package edu.asselvi.view;

import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;
import edu.asselvi.view.utils.exception.DuplicateMenuEntryException;

public class Principal {
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.addOption(1, new CadastraCliente());
            menu.addOption(2, new CadastraVeiculo());
            menu.addOption(3, new CadastraReserva());
            menu.addOption(4, new CadastraLocacao());
            menu.addOption(5, new CadastraCor());
        } catch (DuplicateMenuEntryException e) {
            Msg.erro(e.getMessage());
        }
        
        while (!menu.isDisposed()) {
            menu.show();
        }
    }
    
}
