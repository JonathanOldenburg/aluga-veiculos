package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.LocacaoDAO;
import edu.asselvi.bean.Locacao;
import edu.asselvi.interfaces.IPadraoCadastra;
import edu.asselvi.utils.Msg;

public class CadastraLocacao implements IPadraoCadastra {

	public static void chamaCadastro() throws BDException {

		LocacaoDAO locacaoDAO = new LocacaoDAO();
		//locacaoDAO.criaTabela();
		int liOpcao = Msg.perguntaInt("1 - Cadastro \n2 - Exclusão");
		if (liOpcao == 1) {

			Locacao locacao = new Locacao();
			locacao.setId_Reserva(Msg.perguntaInt("Qual o id da reserva?"));

			locacaoDAO.insere(locacao);

			Msg.informa("Locacao inserida com sucesso!");
		} else {
			if (locacaoDAO.exclui(Msg.perguntaInt("Digite o ID da locacao a ser excluída"))) {
				Msg.informa("Locacao excluída com sucesso!");
			} else {
				Msg.informa("Locacao não existente!");
			}
			;
		}
	}



}
