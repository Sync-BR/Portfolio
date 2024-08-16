package Dao;

import Beans.postBean;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author SYNC
 */
public class postDao {

    /**
     *
     * @author SYNC
     * @param addpost instancia os metados da classe postBean.
     * @throws java.lang.Exception Tratar os possiveis erros.
     *
     */
    public int addPost(postBean addpost) throws Exception {
 
        int codeState = 0;

        String sql = "insert into portfolio.posts  (title ,description, archiveName, repository, frontendProject"
                + ",backendProject,author) value (?, ?, ?, ?, ?, ?, ? ) ";
        try (Connection connection = Conexao.getconnection(); PreparedStatement ps = connection.prepareCall(sql);) {
            ps.setString(1, addpost.getTitle());
            ps.setString(2, addpost.getDescription());
            ps.setString(3, addpost.getArchiveName());
            ps.setString(4, addpost.getRepository());
            ps.setBoolean(5, addpost.isFrontendProject());
            ps.setBoolean(6, addpost.isBackendProject());
            ps.setString(7, addpost.getAuthor());
            int status = ps.executeUpdate();
            if (status > 0) {
                codeState = 200;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
            codeState = e.getErrorCode();
            System.out.println(codeState);
        }
        
        return codeState;

    }

    
}
