package br.edu.asselvi.model.telas;

import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import br.edu.asselvi.model.utils.Msg;

public class Principal {

	public static void main(String[] args) {
		int liOpcao = -1;
		int liOpcaoCadastro;
		while (liOpcao != 0) {
			liOpcao = Integer.parseInt(Msg.pergunta("Escolha :" 
									    		+ "\n1 - Cadastro" 
									    		+ "\n2 - Consulta" 
									    		+ "\n0 - Sair"));
			if(liOpcao != 1){
				Msg.erro("Op��o escolhida n�o existe. Verifique!");							
			} 
			if(liOpcao == 1){
				liOpcao = Integer.parseInt(Msg.pergunta("Cliente :"
														+ "\n1 - Cliente"
														+ "\n2 - Loca��o"
														+ "\n3 - Reserva"
														+ "\n4 - Veiculo"));
			}
		}
	}
}
