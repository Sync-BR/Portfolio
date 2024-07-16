package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SYNC
 */
public class Conexao {

    private static Connection conexaos = null;

    public static Connection getconnection() throws Exception {
        String urlDB = "jdbc:mysql://127.0.0.1/portfolio?useUnicode=true&characterEncoding=UTF-8";
        String userDB = "root";
        String passDB = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(urlDB, userDB, passDB);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e + "");
        }
        return conexaos;
    }

    //Fechar conexão
    private static void close(Connection conn, PreparedStatement stmt, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    // Fechar conexão Statement & Conjunto de resultado do ResultSet

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }
    //Fechar conexão sem fechar o conjunto do ResultSet

    public static void closeConnection(Connection conn, PreparedStatement stmt) throws Exception {
        close(conn, stmt, null);
    }
    //Fechar apenas a conexão

    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

}
