package edu.asselvi.view;

import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.model.bean.Cliente;
import edu.asselvi.model.dao.ClienteDAO;
import edu.asselvi.view.interfaces.IDataHandler;
import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;

public class CadastraCliente implements IDataHandler {

    private static final long serialVersionUID = -7713717686753081868L;

    @Override
    public void run() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Menu menu = new Menu();

        menu.addOption(1, new Runnable() {

            @Override
            public void run() {
                Cliente cliente = obterClienteUsuario();
                try {
                    clienteDAO.insere(cliente);
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
                Msg.informa("Cliente inserido com sucesso!");
            }

            @Override
            public String toString() {
                return "Cadastrar cliente";
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
                return "Excluir cliente";
            }
        })
        .addOption(3, new Runnable() {
            
            @Override
            public void run() {
                Cliente cliente = obterClienteUsuario();
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    List<Cliente> clientes = clienteDAO.consulta(cliente);
                    for (Cliente clienteReg : clientes) {
                        stringBuffer.append(clienteReg.toString()+"\n");
                    }
                    Msg.informa(stringBuffer.toString());
                } catch (BDException e) {
                    Msg.erro(e.getMessage());
                }
            }
            
            @Override
            public String toString() {
                return "Consultar cliente";
            }
        })
        .show();
    }

    @Override
    public String toString() {
        return "Clientes";
    }

    public static String getListaFormadataClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        StringBuffer stringBuffer = new StringBuffer();
        
        try {
            List<Cliente> clientes = clienteDAO.consulta();
            for (Cliente clienteReg : clientes) {
                stringBuffer.append(clienteReg.toString()+"\n");
            }
        } catch (BDException e) {
            Msg.erro(e.getMessage());
        }
        return stringBuffer.toString();
    }
    
    private Cliente obterClienteUsuario() {
        Cliente cliente = new Cliente();
        cliente.setNome(Msg.perguntaStr("Digite o nome:"));
        cliente.setEndereco(Msg.perguntaStr("Digite o endereço:"));
        cliente.setCpf(Msg.perguntaInt("Digite o cpf"));
        return cliente;
    }
    
}
