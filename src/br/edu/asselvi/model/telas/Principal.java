package br.edu.asselvi.model.telas;

import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import br.edu.asselvi.model.utils.Msg;

public class Principal {

	public static void main(String[] args) {
		int liOpcao = -1;
		while (liOpcao != 0) {
			liOpcao = Integer.parseInt(Msg.pergunta("Escolha :" 
									    		+ "\n1 - Cadastro" 
									    		+ "\n2 - Consulta" 
									    		+ "\n0 - Sair"));
			if(liOpcao != 1){
				Msg.erro("Opção escolhida não existe. Verifique!");							
				
			}
		}
	}

}
