
package Dao;

import Beans.usuarioBeans;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SYNC
 */
public class usuarioDao {
    
    public boolean autenticar(usuarioBeans user) throws Exception{
        boolean status = false;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM portfolio.login where usuario = ?  and password =  ?";
        try{
            connection = Conexao.getconnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUser());
            ps.setString(2, user.getPass());
            rs = ps.executeQuery();
            if(rs.next()){
                status = true;
            }
            
        
        } catch(SQLException e){
            e.getMessage();
        } finally{
            Conexao.closeConnection(connection, ps, rs);
        }
        
        return status;
    
    }
    
}
