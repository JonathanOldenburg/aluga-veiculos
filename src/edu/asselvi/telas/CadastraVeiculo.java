package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.VeiculoDAO;
import edu.asselvi.bean.Veiculo;
import edu.asselvi.interfaces.IPadraoCadastra;
import edu.asselvi.utils.Msg;

public class CadastraVeiculo implements IPadraoCadastra {

	public static void chamaCadastro() throws BDException {

		VeiculoDAO veiculoDAO = new VeiculoDAO();
		//veiculoDAO.criaTabela();
		int liOpcao = Msg.perguntaInt("1 - Cadastro \n2 - Exclusão");
		if (liOpcao == 1) {

			Veiculo veiculo = new Veiculo();
			veiculo.setPlaca(Msg.perguntaStr("Digite a placa:"));
			veiculo.setModelo(Msg.perguntaStr("Digite o modelo:"));
			veiculo.setAno(Msg.perguntaInt("Digite o ano"));
			veiculo.setId_Cor(Msg.perguntaInt("Escolha a cor no combo")); // arrumar essa caralho
			
			veiculo.setDiaria((Msg.perguntaDouble("Digite a diaria")));
			veiculo.setAtivo(true);

			veiculoDAO.insere(veiculo);

			Msg.informa("Veiculo inserido com sucesso!");
		} else {
			if (veiculoDAO.exclui(Msg.perguntaInt("Digite o ID do carro a ser excluído"))) {
				Msg.informa("Veiculo excluído com sucesso!");
			}
			else{
				Msg.informa("Veiculo não existe!");
			}
			;
		}
	}

}
