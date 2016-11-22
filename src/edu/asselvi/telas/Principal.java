package edu.asselvi.telas;

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
			if (liOpcao != 1 && liOpcao != 2){
				Msg.erro("Opção escolhida não existe. Verifique!");							
			} 
			if(liOpcao == 1){
				liOpcaoCadastro = (Msg.perguntaInt("Escolha :"
											   + "\n1 - Cliente"
											   + "\n2 - Locação"
											   + "\n3 - Reserva"
											   + "\n4 - Veiculo"
											   + "\n5 - Cor"));
				switch(liOpcaoCadastro){
				  case 1 : CadastraCliente.chamaCadastro();
					  	   break;
				  case 2 : break;
				  case 3 : break;
				  case 4 : CadastraVeiculo.chamaCadastro(); 
				  		   break;
				  case 5 : CadastraCor.chamaCadastro();
				  		   break;
				}
			}else{
				liOpcaoCadastro = (Msg.perguntaInt("Escolha :"
											   + "\n1 - Cliente"
											   + "\n2 - Locação"
											   + "\n3 - Reserva"
											   + "\n4 - Veiculo"
											   + "\n5 - Cor"));
				switch(liOpcaoCadastro){
				  case 1 : CadastraCliente.chamaCadastro();
					  	   break;
				  case 2 : break;
				  case 3 : break;
				  case 4 : ConsultaVeiculos.ChamaConsulta(); 
				  		   break;
				  case 5 : CadastraCor.chamaCadastro();
				  		   break;
				
				}	
			}
		}
	}
}
