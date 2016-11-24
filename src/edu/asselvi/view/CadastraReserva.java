package edu.asselvi.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Reserva;
import edu.asselvi.model.dao.ReservaDAO;
import edu.asselvi.view.interfaces.IPadraoCadastra;
import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;

public class CadastraReserva implements IPadraoCadastra {

    private static final long serialVersionUID = -3845458824137037051L;

    public void run() {
		ReservaDAO reservaDAO = new ReservaDAO();
		Menu menu = new Menu();
		
		menu.addOption(1, new Runnable() {
            
            @Override
            public void run() {
                Reserva reserva = new Reserva();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dataFim = null;
                java.sql.Date dataInicio = null;
                
                try {
                    dataInicio = new java.sql.Date(format.parse(Msg.perguntaStr("Digite a data de inicio")).getTime());
                    dataFim = new java.sql.Date(format.parse(Msg.perguntaStr("Digite a data final")).getTime());
                } catch (ParseException e1) {
                    Msg.erro("Favor informar uma data válida.");
                }
                reserva.setFim(dataFim);
                reserva.setInicio(dataInicio);
                
                try {
                    reservaDAO.insere(reserva);
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
                
                Msg.informa("Reserva inserida com sucesso!");                
            }
            
            @Override
            public String toString() {
                return "Cadastrar reserva";
            }
        })
		.addOption(2, new Runnable() {
		    
		    @Override
		    public void run() {
		        try {
                    if (reservaDAO.exclui(Msg.perguntaInt("Digite o ID da reserva a ser excluída"))) {
                        Msg.informa("Reserva excluída com sucesso!");
                    } else {
                        Msg.informa("Reserva não existente!");
                    }
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
		    }
		    
		    @Override
		    public String toString() {
		        return "Excluir reserva";
		    }
		})
		.show();
	}

	@Override
	public String toString() {
	    return "Reservas";
	}
}
