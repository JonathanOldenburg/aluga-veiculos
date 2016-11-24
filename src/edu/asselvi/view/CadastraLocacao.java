package edu.asselvi.view;

import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Locacao;
import edu.asselvi.model.dao.LocacaoDAO;
import edu.asselvi.view.interfaces.IDataHandler;
import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;

public class CadastraLocacao implements IDataHandler {

    private static final long serialVersionUID = 7150726174612008790L;

    public void run() {
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        Menu menu = new Menu();

        menu.addOption(1, new Runnable() {

            @Override
            public void run() {
                Locacao locacao = new Locacao();
                locacao.setIdReserva(Msg.perguntaInt("Qual o id da reserva?"));

                try {
                    locacaoDAO.insere(locacao);
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
                Msg.informa("Locacao inserida com sucesso!");

            }
            
            @Override
            public String toString() {
                return "Cadastrar locação.";
            }
        }).addOption(2, new Runnable() {

            @Override
            public void run() {
                try {
                    if (locacaoDAO.exclui(Msg.perguntaInt("Digite o ID da locacao a ser excluída"))) {
                        Msg.informa("Locacao excluída com sucesso!");
                    } else {
                        Msg.informa("Locacao não existente!");
                    }
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
            }
            
            @Override
            public String toString() {
                return "Excluir locacao";
            }
        })
        .addOption(3, new Runnable() {
            
            @Override
            public void run() {
                StringBuffer stringBuffer = new StringBuffer();
                
                try {
                    List<Locacao> locacoes = locacaoDAO.consulta();
                    for (Locacao locacaoReg : locacoes) {
                        stringBuffer.append(locacaoReg.toString()+"\n");
                    }
                    Msg.informa(stringBuffer.toString());
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
            }
            
            @Override
            public String toString() {
                return "Consultar locacao";
            }
        })
        .show();
    }

    @Override
    public String toString() {
        return "Locacao";
    }
}
