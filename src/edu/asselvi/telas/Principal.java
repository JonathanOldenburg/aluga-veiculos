package edu.asselvi.telas;

import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import edu.asselvei.bd.BDException;
import edu.asselvi.utils.Msg;

public class Principal {

	public static void main(String[] args) throws BDException {
		int liOpcao = -1;
		int liOpcaoCadastro;
		while (liOpcao != 0) {
			liOpcao = (Msg.perguntaInt("Escolha :" 
								   + "\n1 - Cadastro" 
								   + "\n2 - Consulta" 
								   + "\n0 - Sair"));
			if(liOpcao != 1){
				Msg.erro("Opção escolhida não existe. Verifique!");							
			} 
			if(liOpcao == 1){
				liOpcaoCadastro = (Msg.perguntaInt("Escolha :"
											   + "\n1 - Cliente"
											   + "\n2 - Locação"
											   + "\n3 - Reserva"
											   + "\n4 - Veiculo"));
				switch(liOpcaoCadastro){
				  case 1 : CadastraCliente.ChamaCadastro();
					  	   break;
				  case 2 : break;
				  case 3 : break;
				  case 4 : CadastraVeiculo.ChamaCadastro(); 
				}
			}
		}
	}
}
