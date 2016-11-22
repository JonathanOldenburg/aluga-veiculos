package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.ClienteDAO;
import edu.asselvi.bean.Cliente;
import edu.asselvi.utils.Msg;

public class CadastraCliente {

	public static void ChamaCadastro() throws BDException {

		ClienteDAO clienteDAO = new ClienteDAO();
		//clienteDAO.criaTabela();
		int liOpcao = Msg.perguntaInt("1 - Cadastro \n2 - Exclus�o");
		if (liOpcao == 1) {

			Cliente cliente = new Cliente();
			cliente.setNome(Msg.perguntaStr("Digite a nome:"));
			cliente.setEndereco(Msg.perguntaStr("Digite o endere�o:"));
			cliente.setCpf(Msg.perguntaInt("Digite o cpf"));

			clienteDAO.insere(cliente);

			Msg.informa("Cliente inserido com sucesso!");
		} else {
			if (clienteDAO.exclui(Msg.perguntaInt("Digite o ID do carro a ser exclu�do"))) {
				Msg.informa("Cliente exclu�do com sucesso!");
			} else {
				Msg.informa("Cliente n�o existe!");
			}
			;
		}
	}

}
