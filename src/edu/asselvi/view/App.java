package edu.asselvi.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.asselvi.bd.BDException;
import edu.asselvi.bd.conexao.Conexao;
import edu.asselvi.model.dao.ClienteDAO;
import edu.asselvi.model.dao.CorDAO;
import edu.asselvi.model.dao.LocacaoDAO;
import edu.asselvi.model.dao.ReservaDAO;
import edu.asselvi.model.dao.VeiculoDAO;
import edu.asselvi.view.utils.Menu;
import edu.asselvi.view.utils.Msg;
import edu.asselvi.view.utils.exception.DuplicateMenuEntryException;

public class App {

    public static boolean isFirstRun() {
        try {
            Connection connection = Conexao.getConexao("mysql");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'locadora'");
            return !rs.next();
        } catch (BDException | SQLException e) {
            e.printStackTrace();
            Msg.erro(e.getMessage());
            return true;
        }
    }

    public static void install() {
        Msg.informa("Instalando aplicação");
        try {
            Connection connection = Conexao.getConexao("mysql");
            Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE locadora");
            
            new ClienteDAO().criaTabela();
            new CorDAO().criaTabela();
            new VeiculoDAO().criaTabela();
            new ReservaDAO().criaTabela();
            new LocacaoDAO().criaTabela();
            
            Msg.informa("Instalação concluida");
        } catch (SQLException | BDException e) {
            e.printStackTrace();
            Msg.erro("Erro ao instalar a aplicação. Verifique no console.");
        }
    }

    public static void run() {
        Menu menu = new Menu();
        try {
            menu.addOption(1, new CadastraCliente());
            menu.addOption(2, new CadastraVeiculo());
            menu.addOption(3, new CadastraReserva());
            menu.addOption(4, new CadastraLocacao());
            menu.addOption(5, new CadastraCor());
        } catch (DuplicateMenuEntryException e) {
            Msg.erro(e.getMessage());
        }
        
        while (!menu.isDisposed()) {
            menu.show();
        }
    }

}
