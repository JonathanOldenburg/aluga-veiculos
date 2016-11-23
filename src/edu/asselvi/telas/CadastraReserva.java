package edu.asselvi.telas;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.asselvei.bd.BDException;
import edu.asselvi.bd.dao.ReservaDAO;
import edu.asselvi.bean.Reserva;
import edu.asselvi.interfaces.IPadraoCadastra;
import edu.asselvi.utils.Msg;

public class CadastraReserva implements IPadraoCadastra {

	public static void chamaCadastro() throws BDException, ParseException {

		ReservaDAO reservaDAO = new ReservaDAO();
		//reservaDAO.criaTabela();
		int liOpcao = Msg.perguntaInt("1 - Cadastro \n2 - Exclusão");
		if (liOpcao == 1) {

			Reserva reserva = new Reserva();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date dataInicio = new java.sql.Date(format.parse(Msg.perguntaStr("Digite a data de inicio")).getTime());
			reserva.setInicio(dataInicio);
			java.sql.Date dataFim= new java.sql.Date(format.parse(Msg.perguntaStr("Digite a data final")).getTime());
			reserva.setFim(dataFim);

			reservaDAO.insere(reserva);

			Msg.informa("Reserva inserida com sucesso!");
		} else {
			if (reservaDAO.exclui(Msg.perguntaInt("Digite o ID da reserva a ser excluída"))) {
				Msg.informa("Reserva excluída com sucesso!");
			} else {
				Msg.informa("Reserva não existente!");
			}
			;
		}
	}


}
