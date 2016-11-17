
package br.edu.asselvi.util.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

    private static Connection conn = null;

    /**
     * Obtem uma conexão com o banco de dados.
     * 
     * @return a conexão obtida.
     */
    public static Connection getConnection() throws DBException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 10.32.
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inf24_jhmold", "alunos", "social");
            return conn;
        } catch (Exception e) {
            throw new DBException("Não foi possível conectar com o banco de dados.\n", e);
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     */
    public static void closeConnection() {
        try {
            if (conn != null)
                conn.close();
            conn = null;
        } catch (Exception e) {
        }
    }

}
