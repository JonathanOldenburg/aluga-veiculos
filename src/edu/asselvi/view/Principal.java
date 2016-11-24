package edu.asselvi.view;

public class Principal {
    
    public static void main(String[] args) {
        if (App.isFirstRun()) {
            App.install();
        }
        App.run();
    }
    
}
