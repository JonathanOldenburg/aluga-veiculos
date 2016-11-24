package edu.asselvi.view;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Cliente;
import edu.asselvi.model.dao.ClienteDAO;
import edu.asselvi.view.interfaces.IPadraoCadastra;
import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;

public class CadastraCliente implements IPadraoCadastra {

    private static final long serialVersionUID = -7713717686753081868L;

    @Override
    public void run() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Menu menu = new Menu();

        menu.addOption(1, new Runnable() {

            @Override
            public void run() {
                Cliente cliente = new Cliente();
                cliente.setNome(Msg.perguntaStr("Digite a nome:"));
                cliente.setEndereco(Msg.perguntaStr("Digite o endereço:"));
                cliente.setCpf(Msg.perguntaInt("Digite o cpf"));

                try {
                    clienteDAO.insere(cliente);
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
                Msg.informa("Cliente inserido com sucesso!");
            }

            @Override
            public String toString() {
                return "Cadastrar novo";
            }
        }).addOption(2, new Runnable() {

            @Override
            public void run() {
                try {
                    if (clienteDAO.exclui(Msg.perguntaInt("Digite o ID do carro a ser excluído"))) {
                        Msg.informa("Cliente excluído com sucesso!");
                    } else {
                        Msg.informa("Cliente não existe!");
                    }
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
            }

            @Override
            public String toString() {
                return "Excluir";
            }
        })
        .show();
    }

    @Override
    public String toString() {
        return "Clientes";
    }

}
