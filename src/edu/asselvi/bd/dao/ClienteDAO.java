package edu.asselvi.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvei.bd.BDException;
import edu.asselvei.bd.EErrosBD;
import edu.asselvei.bd.conexao.Conexao;
import edu.asselvi.bean.Cliente;

public class ClienteDAO implements IPadraoDAO {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( " CREATE TABLE cliente ( " +
						" ID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
						" NOME VARCHAR(100) NOT NULL, " +
						" ENDERECO VARCHAR(100) NOT NULL, "+
						" CPF INT(11) NOT NULL, "+
						" TELEFONE VARCHAR(30) NOT NULL, "+
						" DIARIA FLOAT NOT NULL "+
						");");
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CRIA_TABELA);
		} finally {
			Conexao.fechaConexao();
		}
	}

	@Override
	public boolean dropaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE cliente;");
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.DROPA_TABELA);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insere(Cliente cliente) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO cliente (id, nome, endereco, cpf, telefone) VALUES (?, ?, ?, ?, ?);");
			pst.setInt(1, 0);
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEndereco());
			pst.setInt(4, cliente.getCpf());
			pst.setString(5, cliente.getTelefone());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public boolean insere(List<Cliente> clientes) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO cliente (id, nome, endereco, cpf, telefone) VALUES (?, ?, ?, ?, ?);");
			for (Cliente cliente : clientes) {				
				pst.setInt(1, cliente.getId());
				pst.setString(2, cliente.getNome());
				pst.setString(3, cliente.getEndereco());
				pst.setInt(4, cliente.getCpf());
				pst.setString(5, cliente.getTelefone());
				pst.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insereTRN(List<Cliente> clientes) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO cliente (id, nome, endereco, cpf, telefone) VALUES (?, ?, ?, ?, ?);");
			for (Cliente cliente : clientes) {
				pst.setInt(1, cliente.getId());
				pst.setString(2, cliente.getNome());
				pst.setString(3, cliente.getEndereco());
				pst.setInt(4, cliente.getCpf());
				pst.setString(5, cliente.getTelefone());
				pst.executeUpdate();
			}
			conexao.commit();
			return true;
		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (Exception re) {
				throw new BDException(re.getMessage(), EErrosBD.ROLLBACK);
			}
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public Cliente consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM cliente WHERE id = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new Cliente(rs.getInt("id"),
											rs.getString("nome"),
											rs.getString("endereco"),
											rs.getInt("cpf"),
											rs.getString("telefone"))
							: null;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public List<Cliente> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cliente;");
			List<Cliente> clientes = new ArrayList<Cliente>();
			while (rs.next()) {
				clientes.add(new Cliente(rs.getInt("id"),
									   	 rs.getString("nome"),
										 rs.getString("endereco"),
										 rs.getInt("cpf"),
										 rs.getString("telefone")));
			}
			return clientes;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean altera(Cliente cliente) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE cliente SET nome = ?, endereco = ?, cpf =? , telefone = ?, WHERE id = ?;");// isso é pra ser assim msm??????????????????????????????????????????????????
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEndereco());
			pst.setInt(3, cliente.getCpf());
			pst.setString(4, cliente.getTelefone()); // "Arrumar" jonathan 2016
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.ATUALIZA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean exclui(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM cliente WHERE id = ?;");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.EXCLUI_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

}

