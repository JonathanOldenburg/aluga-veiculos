package edu.asselvi.utils;

import javax.swing.JOptionPane;

public class Msg {
	
	public static void erro(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void informa(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static String perguntaStr(String mensagem){
		return JOptionPane.showInputDialog(mensagem);
	}	
	
	public static int perguntaInt(String mensagem){
		return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
	}
	
	public static double perguntaDouble(String mensagem){
		return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
	}	

}
