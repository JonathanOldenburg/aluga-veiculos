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
import edu.asselvi.model.bean.Locacao;

public class LocacaoDAO implements IPadraoDAO<Locacao> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( " CREATE TABLE locacao ( " +
						" ID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
						" ID_RESERVA INT NOT NULL, " +
						" ENTREGE VARCHAR(1) NOT NULL, "+ 
						" CONSTRAINT FK_LOCACAO_RESERVA FOREIGN KEY (id_reserva) REFERENCES reserva (ID));");
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
			st.execute("DROP TABLE locacao;");
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.DROPA_TABELA);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insere(Locacao locacao) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO locacao (id, id_reserva, entrege) VALUES (?, ?, ?);");
			pst.setInt(1, 0);
			pst.setInt(2, locacao.getIdReserva());
			pst.setString(3, locacao.isEntrege()? "1" : "0");  // como faz aqui? isEntrege() ta serto isso? 
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public boolean insere(List<Locacao> locacoes) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO locacao (id, id_reserva, entrege) VALUES (?, ?, ?);");
			for (Locacao locacao : locacoes) {				
				pst.setInt(1, 0);
				pst.setInt(2, locacao.getIdReserva());
				pst.setString(3, locacao.isEntrege()? "1" : "0");  // como faz aqui? isEntrege() ta serto isso? 
				pst.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insereTRN(List<Locacao> locacoes) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO locacao (id, id_reserva, entrege) VALUES (?, ?, ?);");
			for (Locacao locacao : locacoes) {
				pst.setInt(1, locacao.getId());
				pst.setInt(2, locacao.getIdReserva());
				pst.setString(3, locacao.isEntrege()? "1" : "0");  // como faz aqui? isEntrege() ta serto isso? 
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

	public Locacao consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM locacao l, reserva r WHERE id = ? and l.id_Cliente = r.id_Cliente;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new Locacao(rs.getInt("id"),
											rs.getInt("id_Reserva"),
											rs.getString("entrege") == "1")  // aqui rodou o boolean mas n sei se ta procedivel
							: null;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public List<Locacao> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM locacao;");
			List<Locacao> locacoes = new ArrayList<Locacao>();
			while (rs.next()) {
				locacoes.add(new Locacao(rs.getInt("id"),
									     rs.getInt("id_Reserva"),
									     rs.getString("entrege") == "1"));  // aqui rodou o boolean mas n sei se ta procedivel));
			}
			return locacoes;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean altera(Locacao locacao) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE locacao SET entrege = ? WHERE id = ?;");
			pst.setString(1, locacao.isEntrege() ? "1" : "0"); 
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM locacao WHERE id = ?;");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.EXCLUI_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

    @Override
    public List<Locacao> consulta(Locacao locacao) throws BDException {
        Connection conexao = Conexao.getConexao();
        try {
            PreparedStatement st = conexao.prepareStatement("SELECT * FROM locacao"
                                                          + "WHERE id_reserva = ?;");
            ResultSet rs = st.executeQuery();
            List<Locacao> locacoes = new ArrayList<Locacao>();
            while (rs.next()) {
                locacoes.add(new Locacao(rs.getInt("id"),
                                         rs.getInt("id_Reserva"),
                                         rs.getString("entrege") == "1"));
            }
            return locacoes;
        } catch (Exception e) {
            throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
        } finally {
            Conexao.fechaConexao();
        }
    }

}
