package br.edu.asselvi.model.utils;

import javax.swing.JOptionPane;

public class Msg {
	
	public static void erro(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem, "Aten��o", JOptionPane.ERROR_MESSAGE);
	}
	
	public static String pergunta(String mensagem){
		return JOptionPane.showInputDialog(mensagem);
	}

}
