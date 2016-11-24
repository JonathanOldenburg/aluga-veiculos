package edu.asselvi.bd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.asselvi.bd.BDException;
import edu.asselvi.bd.EErrosBD;

public class Conexao {

	private static Connection conn = null;

	public static Connection getConexao() throws BDException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locadora?useSSL=true", "root", "social");
			return conn;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.ABRE_CONEXAO);
		}
	}
	
	public static void fechaConexao() throws BDException {
		try {
			if (conn != null) conn.close();
			conn = null;
		} catch (Exception e) {
			throw new BDException(e.getMessage(), EErrosBD.FECHA_CONEXAO);
		}
	}
}