package edu.asselvi.view.utils;

import javax.swing.JOptionPane;

import com.mysql.jdbc.StringUtils;

public class Msg {

    public static void erro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void informa(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String perguntaStr(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static int perguntaInt(String mensagem) {
        String userInputStr = JOptionPane.showInputDialog(mensagem);
        userInputStr = userInputStr.isEmpty() ? "0" : userInputStr;
        return StringUtils.isStrictlyNumeric(userInputStr) ? Integer.parseInt(userInputStr) : perguntaInt(mensagem);
    }

    public static double perguntaDouble(String mensagem) {
        String userInputStr = JOptionPane.showInputDialog(mensagem);
        userInputStr = userInputStr.isEmpty() ? "0" : userInputStr;
        return StringUtils.isStrictlyNumeric(userInputStr) ? Double.parseDouble(userInputStr) : perguntaDouble(mensagem);
    }
}
