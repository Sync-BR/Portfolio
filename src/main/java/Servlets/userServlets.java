 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.usuarioBeans;
import Dao.usuarioDao;
import Token.jwtToken;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduar
 */
public class userServlets extends HttpServlet {

    private usuarioDao autenticate = new usuarioDao();
    private usuarioBeans adduser = new usuarioBeans();
    private jwtToken token = new jwtToken();

    /**
     *
     * @author SYNC
     * @param token recebe o valor do token.
     * @param response inicializar os metados do HttpServletResponse
     * @throws java.lang.Exception
     */
    protected void logout(String token, HttpServletResponse response) throws Exception {
        if (token != null) {
            usuarioBeans.setToken(null);
        }
        response.sendRedirect("index.jsp");

    }

    protected void login(usuarioBeans userInfor, HttpServletResponse response) throws ServletException, IOException {
        try {

            if (autenticate.autenticar(adduser)) {
                usuarioBeans.setToken(token.generateToken(adduser.getUser()));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.sendRedirect("index.jsp");
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN );
                System.out.println("Falhou ao autenticar.");
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        String tempToken = usuarioBeans.getToken();
        switch (action) {
            case "login":
                adduser.setUser(request.getParameter("userTXT"));
                adduser.setPass(request.getParameter("passTXT"));
                login(adduser, response);
                break;
            case "logout":
                try {
                    logout(tempToken, response);
                } catch (Exception e) {
                    System.out.println("Erro nessa linha " + e.getMessage());
                }

                break;

            default:
                throw new AssertionError();
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
