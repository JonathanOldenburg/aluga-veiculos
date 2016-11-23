package edu.asselvi.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asselvei.bd.BDException;
import edu.asselvei.bd.EErrosBD;
import edu.asselvei.bd.conexao.Conexao;
import edu.asselvi.bean.Reserva;

public class ReservaDAO implements IPadraoDAO{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( " CREATE TABLE reserva ( " +
						" ID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
						" INICIO DATE NOT NULL, " +  
						" FIM DATE NOT NULL, "+
						" ID_CLIENTE INT NOT FOREIGN KEY NULL, "+
						" ID_CARRO INT NOT FOREIGN KEY NULL, "+
						" RESERVOU VARCHAR(1) NOT NULL "+  
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
			st.execute("DROP TABLE reserva;");
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.DROPA_TABELA);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insere(Reserva reserva) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO reserva (id, inicio, fim, id_cliente, id_carro) VALUES (?, ?, ?, ?, ?);");
			pst.setInt(1, 0);
//			pst.setDate(2,  new Java.sql.date());    // n sei
//			pst.setDate(3,  new Java.sql.date());
			pst.setInt(4, reserva.getId_Cliente());
			pst.setInt(5, reserva.getId_Carro());
			pst.setString(6, reserva.isReservou() ? "1" : "0");  // aq ta wrong tbm
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public boolean insere(List<Reserva> reservas) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO reserva (id, inicio, fim, id_cliente, id_carro) VALUES (?, ?, ?, ?, ?);");
			for (Reserva reserva : reservas) {				
				pst.setInt(1, reserva.getId());
//				pst.setDate(2,  new Java.sql.date());    ??????EAE MANO COMO QUE FICA ESSA POUCA VERGONHA AQUI?????
//				pst.setDate(3,  new Java.sql.date());
				pst.setInt(4, reserva.getId_Cliente());
				pst.setInt(5, reserva.getId_Carro());
//				pst.setBoolean(6, reserva.setReservou();  // aq ta wrong tbm
				pst.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.INSERE_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean insereTRN(List<Reserva> reservas) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO reserva (id, inicio, fim, id_cliente, id_carro) VALUES (?, ?, ?, ?, ?);");
			for (Reserva reserva : reservas) {
				pst.setInt(1, reserva.getId());
//				pst.setDate(2,  new Java.sql.date());    ??????EAE MANO COMO QUE FICA ESSA POUCA VERGONHA AQUI?????
//				pst.setDate(3,  new Java.sql.date());
				pst.setInt(4, reserva.getId_Cliente());
				pst.setInt(5, reserva.getId_Carro());
//				pst.setBoolean(6, reserva.setReservou();  // aq ta wrong tbm
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

	public Reserva consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT r.id, r.inicio, r.fim, r.id_cliente, r.id_carro, r.reservou, ci.nome, v.modelo FROM reserva r, cliente ci, veiculo v WHERE id = ? and r.id_Cliente = ci.id and r.id_carro = v.id;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new Reserva(rs.getInt("id"),
											rs.getDate("inicio"),
											rs.getDate("fim"),
											rs.getInt("id_cliente"),
											rs.getString("nome"),
											rs.getInt("id_carro"),
											rs.getString("modelo"),
											rs.getString("reservou") == "1")
							: null;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public List<Reserva> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT r.id, r.inicio, r.fim, r.id_cliente, r.id_carro, r.reservou, ci.nome, v.modelo FROM reserva r, cliente ci, veiculo v where r.id_cliente = c.id and r.id_carro = v.id;");
			List<Reserva> reservas = new ArrayList<Reserva>();
			while (rs.next()) {
				reservas.add(new Reserva(rs.getInt("id"),
										rs.getDate("inicio"),
										rs.getDate("fim"),
										rs.getInt("id_cliente"),
										rs.getString("nome"),
										rs.getInt("id_carro"),
										rs.getString("modelo"),
										rs.getString("reservou") == "1"));
			}
			return reservas;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.CONSULTA_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

	public boolean altera(Reserva reserva) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE reserva SET reservou = ? WHERE id = ?;"); 				
			pst.setString(1, reserva.isReservou() ? "0" : "1");
			pst.setInt(2, reserva.getId());  // Só da pra mudar se a reserva foi feita ou não, ativa e desativa
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM reserva WHERE id = ?;");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.EXCLUI_DADO);
		} finally {
			Conexao.fechaConexao();
		}
	}

}
