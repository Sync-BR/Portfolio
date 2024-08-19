package Dao;

import Beans.postBean;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SYNC
 */
public class postDao {

    public List<postBean> returnPostFrontEnd() throws Exception, SQLException {
        List<postBean> listPostagem = new ArrayList<>();
        listPostagem.clear();
        String sql = "SELECT * FROM portfolio.posts where frontendProject = 1";
        try (Connection connection = Conexao.getconnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            postBean addPost = new postBean();
            while (rs.next()) {
                addPost.setId(rs.getInt("id"));
                addPost.setTitle(rs.getString("title"));
                addPost.setDescription(rs.getString("description"));
                addPost.setRepository(rs.getString("repository"));
                addPost.setArchiveName(rs.getString("archiveName"));
                addPost.setBackendProject(rs.getBoolean("backendProject"));
                addPost.setFrontendProject(rs.getBoolean("frontendProject"));
                listPostagem.add(new postBean(addPost.getId(), addPost.getTitle(), addPost.getDescription(), addPost.getRepository(), addPost.getArchiveName(), addPost.isBackendProject(),addPost.isFrontendProject()));

            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return listPostagem;
    }

    public List<postBean> returnPostBackEnd() throws Exception, SQLException {
        List<postBean> listPostagem = new ArrayList<>();
        listPostagem.clear();
        String sql = "SELECT * FROM portfolio.posts where backendProject = 1";
        try (Connection connection = Conexao.getconnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            postBean addPost = new postBean();
            while (rs.next()) {
                addPost.setId(rs.getInt("id"));
                addPost.setTitle(rs.getString("title"));
                addPost.setDescription(rs.getString("description"));
                addPost.setRepository(rs.getString("repository"));
                addPost.setArchiveName(rs.getString("archiveName"));
                addPost.setBackendProject(rs.getBoolean("backendProject"));
                addPost.setFrontendProject(rs.getBoolean("frontendProject"));
                listPostagem.add(new postBean(addPost.getId(), addPost.getTitle(), addPost.getDescription(), addPost.getRepository(), addPost.getArchiveName(), addPost.isBackendProject(),addPost.isFrontendProject()));

            }
        }
        return listPostagem;
    }

    public static void main(String[] args) throws Exception {
        postDao returnPost = new postDao();
        List<postBean> list = returnPost.returnPostFrontEnd();
        for (postBean postagem : list) {
            System.out.println("Nome: " + postagem.getTitle());
            System.out.println("descrição: " + postagem.getDescription());
            System.out.println("repositorio: " + postagem.getRepository());
            System.out.println("Arquivo de imagem: " + postagem.getArchiveName());
            System.out.println("BackEnd" + postagem.isBackendProject());
            System.out.println("FrontEnd" + postagem.isFrontendProject());
        }
    }

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
