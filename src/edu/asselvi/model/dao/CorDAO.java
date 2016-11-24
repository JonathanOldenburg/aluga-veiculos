package edu.asselvi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.bd.EErrosBD;
import edu.asselvi.bd.conexao.Conexao;
import edu.asselvi.model.bean.Cor;

public class CorDAO implements IPadraoDAO<Cor> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( " CREATE TABLE COR ( " +
						" ID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
						" DSC_COR VARCHAR(100) NOT NULL " +						
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
			st.execute("DROP TABLE cor;");
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.DROPA_TABELA);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insere(Cor cor) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO cor (id, dsc_cor) VALUES (?, ?);");
			pst.setInt(1, 0);
			pst.setString(2, cor.getDscCor());			
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	@Override
	public boolean insere(List<Cor> cores) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO cor (id, dsc_cor) VALUES (?, ?);");
			for (Cor cor : cores) {				
				pst.setInt(1, cor.getId());
				pst.setString(2, cor.getDscCor());				
				pst.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insereTRN(List<Cor> cores) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO cor (id, dsc_cor) VALUES (?, ?);");
			for (Cor cor : cores) {
				pst.setInt(1, cor.getId());
				pst.setString(2, cor.getDscCor());				
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

	public Cor consulta(int codigo) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM cor WHERE id = ?;");
			pst.setInt(1, codigo);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new Cor(rs.getInt("id"),
										rs.getString("dsc_cor"))										
							: null;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public List<Cor> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cor;");
			List<Cor> cores = new ArrayList<Cor>();
			while (rs.next()) {
				cores.add(new Cor(rs.getInt("id"),
								  rs.getString("dsc_cor")));
			}
			return cores;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean altera(Cor cor) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE cor SET placa = ?, modelo = ?, ano =? , id_cor = ?, diaria = ?, ativo = ?  WHERE id = ?;");
			pst.setString(1, cor.getDscCor());			
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM cor WHERE id = ?;");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.EXCLUI_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

    @Override
    public List<Cor> consulta(Cor cor) throws BDException {
        Connection conexao = Conexao.getConexao();
        try {
            PreparedStatement st = conexao.prepareStatement("SELECT * FROM cor"
                                                          + "WHERE dsc_cor like ?;");
            st.setString(1, cor.getDscCor());
            ResultSet rs = st.executeQuery();
            List<Cor> cores = new ArrayList<Cor>();
            while (rs.next()) {
                cores.add(new Cor(rs.getInt("id"),
                                  rs.getString("dsc_cor")));
            }
            return cores;
        } catch (Exception e) {
            throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
        } finally {
            Conexao.fechaConexao();
        }
    }
}
