package edu.asselvi.telas;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.CorDAO;
import edu.asselvi.bean.Cor;
import edu.asselvi.utils.Msg;

public class CadastraCor {

	public static void chamaCadastro() throws BDException {

		CorDAO corDAO = new CorDAO();
		// clienteDAO.criaTabela();
		int liOpcao = Msg.perguntaInt("1 - Cadastro \n2 - Exclus�o");
		if (liOpcao == 1) {

			Cor cor = new Cor();
			cor.setDsc_cor(Msg.perguntaStr("Digite a descri��o da cor:"));			

			corDAO.insere(cor);

			Msg.informa("Cor inserida com sucesso!");
		} else {
			if (corDAO.exclui(Msg.perguntaInt("Digite o ID da cor a ser exclu�da"))) {
				Msg.informa("Cor exclu�da com sucesso!");
			} else {
				Msg.informa("Cor n�o existe!");
			}
			;
		}
	}

}
