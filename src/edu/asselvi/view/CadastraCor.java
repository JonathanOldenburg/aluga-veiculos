package edu.asselvi.view;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Cor;
import edu.asselvi.model.dao.CorDAO;
import edu.asselvi.view.interfaces.IPadraoCadastra;
import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;

public class CadastraCor implements IPadraoCadastra {

    private static final long serialVersionUID = -3171436764627069491L;

    public void run() {
        CorDAO corDAO = new CorDAO();
        Menu menu = new Menu();

        menu.addOption(1, new Runnable() {

            @Override
            public void run() {
                Cor cor = new Cor();
                cor.setDsc_cor(Msg.perguntaStr("Digite a descrição da cor:"));

                try {
                    corDAO.insere(cor);
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
            }
            
            @Override
            public String toString() {
                return "Cadastrar cor";
            }
        }).addOption(2, new Runnable() {

            @Override
            public void run() {
                try {
                    if (corDAO.exclui(Msg.perguntaInt("Digite o ID da cor a ser excluída"))) {
                        Msg.informa("Cor excluída com sucesso!");
                    } else {
                        Msg.informa("Cor não existe!");
                    }
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
            }
            
            @Override
            public String toString() {
                return "Excluir cor";
            }
        })
        .show();
    }

    @Override
    public String toString() {
        return "Cores";
    }

}
