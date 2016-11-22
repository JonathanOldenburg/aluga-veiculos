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
import edu.asselvi.bean.Veiculo;

public class VeiculoDAO implements IPadraoDAO {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( " CREATE TABLE VEICULO ( " +
						" ID INT(10)  NOT NULL, " +
						" PLACA VARCHAR(7) NOT NULL, " +
						" MODELO VARCHAR(100) NOT NULL, "+
						" ANO INT(4) NOT NULL, "+
						" ID_COR INT(4) NOT NULL, "+
						" DIARIA FLOAT NOT NULL, "+
						" ATIVO VARCHAR(1) DEFAULT '0', " +
						" PRIMARY KEY (ID) , "+
						" INDEX FK_VEICULO_COR (ID_COR), " +											
						" CONSTRAINT FK_VEICULO_COR FOREIGN KEY (ID_COR) REFERENCES cor (ID) " +
						" );");
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
			st.execute("DROP TABLE veiculo;");
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.DROPA_TABELA);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insere(Veiculo veiculo) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO veiculo (id, placa, modelo, ano, id_cor, diaria, ativo) VALUES (?, ?, ?, ?, ?, ?, ?);");
			pst.setInt(1, 0);
			pst.setString(2, veiculo.getPlaca());
			pst.setString(3, veiculo.getModelo());
			pst.setInt(4, veiculo.getAno());
			pst.setInt(5, veiculo.getId_Cor());
			pst.setDouble(6, veiculo.getDiaria());
			pst.setString(7, veiculo.isAtivo() ? "1" : "0");
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public boolean insere(List<Veiculo> veiculos) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO veiculo (id, placa, modelo, ano, id_cor, diaria, ativo) VALUES (?, ?, ?, ?, ?, ?, ?);");
			for (Veiculo veiculo : veiculos) {				
				pst.setInt(1, veiculo.getId());
				pst.setString(2, veiculo.getPlaca());
				pst.setString(3, veiculo.getModelo());
				pst.setInt(4, veiculo.getAno());
				pst.setInt(5, veiculo.getId_Cor());
				pst.setDouble(6, veiculo.getDiaria());
				pst.setString(7, veiculo.isAtivo() ? "1" : "0");
				pst.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insereTRN(List<Veiculo> veiculos) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO veiculo (id, placa, modelo, ano, id_cor, diaria, ativo) VALUES (?, ?, ?, ?, ?, ?, ?);");
			for (Veiculo veiculo : veiculos) {
				pst.setInt(1, veiculo.getId());
				pst.setString(2, veiculo.getPlaca());
				pst.setString(3, veiculo.getModelo());
				pst.setInt(4, veiculo.getAno());
				pst.setInt(5, veiculo.getId_Cor());
				pst.setDouble(6, veiculo.getDiaria());
				pst.setString(7, veiculo.isAtivo() ? "1" : "0");
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

	public Veiculo consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT v.id, v.placa, v.modelo, v.ano, v.id_cor, v.diaria, v.ativo, c.dsc_cor FROM veiculo v, cor c WHERE v.id = ? and c.id = v.id_cor;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new Veiculo(rs.getInt("id"),
											rs.getString("placa"),
											rs.getString("modelo"),
											rs.getInt("ano"),
											rs.getInt("id_cor"),
											rs.getString("dsc_cor"),
											rs.getDouble("diaria"),
										   	(rs.getString("ativo") == "1"))
							: null;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public List<Veiculo> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT v.id, v.placa, v.modelo, v.ano, v.id_cor, v.diaria, v.ativo, c.dsc_cor FROM veiculo v, cor c where v.id_cor = c.id;");
			List<Veiculo> veiculos = new ArrayList<Veiculo>();
			while (rs.next()) {
				veiculos.add(new Veiculo(rs.getInt("id"),
										rs.getString("placa"),
										rs.getString("modelo"),
										rs.getInt("ano"),
										rs.getInt("id_cor"),
										rs.getString("dsc_cor"),
										rs.getDouble("diaria"),
										(rs.getString("ativo") == "1")));
			}
			return veiculos;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean altera(Veiculo veiculo) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE veiculo SET placa = ?, modelo = ?, ano =? , id_cor = ?, diaria = ?, ativo = ?  WHERE id = ?;");
			pst.setString(1, veiculo.getPlaca());
			pst.setString(2, veiculo.getModelo());
			pst.setInt(3, veiculo.getAno());
			pst.setInt(4, veiculo.getId_Cor());
			pst.setDouble(5, veiculo.getDiaria());
			pst.setString(5, veiculo.isAtivo() ? "1" : "0");
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM veiculo WHERE id = ?;");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.EXCLUI_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

}
