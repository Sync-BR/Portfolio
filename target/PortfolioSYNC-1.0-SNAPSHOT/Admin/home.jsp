<%-- 
    Document   : home
    Created on : 2 de jul. de 2024, 23:35:59
    Author     : Eduar
--%>

<%@page import="Beans.usuarioBeans"%>
<%
    System.out.println("Token de autorização" +usuarioBeans.getToken());
    if(usuarioBeans.getToken() == null){
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "  Você não tem permissão para acessar essa pagina");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
