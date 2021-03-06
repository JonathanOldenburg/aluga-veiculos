package edu.asselvi.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Reserva;
import edu.asselvi.model.dao.ReservaDAO;
import edu.asselvi.view.interfaces.IDataHandler;
import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;

public class CadastraReserva implements IDataHandler {

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
                    Msg.erro("Favor informar uma data v�lida.");
                }
                reserva.setFim(dataFim);
                reserva.setInicio(dataInicio);
                reserva.setIdCliente(Msg.perguntaInt(CadastraCliente.getListaFormadataClientes()+"\nInforme o id do cliente :"));
                reserva.setIdCarro(Msg.perguntaInt(CadastraVeiculo.getListaFormadataVeiculos()+"\nInforme o id do veiculo desejado :"));
                
                try {
                    reservaDAO.insere(reserva);
                    Msg.informa("Reserva inserida com sucesso!");                
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
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
                    if (reservaDAO.exclui(Msg.perguntaInt("Digite o ID da reserva a ser exclu�da"))) {
                        Msg.informa("Reserva exclu�da com sucesso!");
                    } else {
                        Msg.informa("Reserva n�o existente!");
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
		.addOption(3, new Runnable() {
            
            @Override
            public void run() {
                StringBuffer stringBuffer = new StringBuffer();
                
                try {
                    List<Reserva> reservas = reservaDAO.consulta();
                    for (Reserva reservaReg : reservas) {
                        stringBuffer.append(reservaReg.toString()+"\n");
                    }
                    Msg.informa(stringBuffer.toString());
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
            }
            
            @Override
            public String toString() {
                return "Consultar reserva";
            }
        })
		.show();
	}

	@Override
	public String toString() {
	    return "Reservas";
	}
}
