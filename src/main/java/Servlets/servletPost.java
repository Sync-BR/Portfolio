package Servlets;

import Beans.postBean;
import Dao.postDao;
import config.production;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SYNC
 * @Classe responsavel pelas operações das postagem
 */
@MultipartConfig
public class servletPost extends HttpServlet {

    production config = new production();

    protected void addPost() {
    }

    ;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String action = request.getParameter("action");
        switch (action) {
            case "addPost":
                try {
                    postBean addpost = new postBean();
                    postDao cadpost = new postDao();
                    addpost.setRepository(config.urlRepository + "txtRepository");
                    addpost.setTitle(request.getParameter("txtTitulo"));
                    addpost.setDescription(request.getParameter("txtDescription"));
                    addpost.setArchiveName(request.getPart("fileIMG").getSubmittedFileName());
                    if (request.getParameter("frontEnd") != null && request.getParameter("backEnd") != null) {
                        addpost.setFrontendProject(true);
                        addpost.setBackendProject(true);
                    } else if (request.getParameter("frontEnd") != null) {
                        addpost.setFrontendProject(true);
                    } else if (request.getParameter("backEnd") != null) {
                        addpost.setBackendProject(true);
                    }
                    if(addpost.getArchiveName() != null){
                        //Operação com ftp
                    }
                    int state = cadpost.addPost(addpost);
                    switch (state) {
                        case 0:
                            System.out.println("Falhou");
                            break;
                        case 200:
                            System.out.println("OK");
                            break;
                        case 1062:
                            System.out.println("Chave duplicada");
                            break;
                        default:
                            throw new AssertionError();
                    }
                } catch (Exception e) {
                    e.getMessage();
                }

                break;
            case "teste":

                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("Admin/home.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
