<%-- 
    Document   : home
    Created on : 2 de jul. de 2024, 23:35:59
    Author     : Eduar
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="Util.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@page import="Beans.usuarioBeans"%>
<%

    try {
        Connection connection = Conexao.getconnection();
        if (connection != null) {
            Conexao.closeConnection(connection);
            System.out.println("Token de autorização" + usuarioBeans.getToken());
            if (usuarioBeans.getToken() == null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "  Você não tem permissão para acessar essa pagina");
            }
        }
    } catch (Exception e) {
        response.sendRedirect("../500.html");
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
        <title>Painel de controle</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    </head>

    <body>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
        <header>
            <!-- <img src="./img/lOGO.png" alt="Logo"> -->
            <h1>Painel de controle</h1>
        </header>
        <main>
            <div class="d-flex align-items-start">
                <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home"
                            type="button" role="tab" aria-controls="v-pills-home" aria-selected="true">INICIO</button>

                    <button class="nav-link" id="v-pills-cadastrar-Projetos" data-bs-toggle="pill" data-bs-target="#v-cadastrar-Projetos"
                            type="button" role="tab" aria-controls="v-cadastrar-Projetos" aria-selected="false">Adicionar Projeto</button>

                    <button class="nav-link" id="v-pills-gerenciar-Projetos-tab" data-bs-toggle="pill" data-bs-target="#v-gerenciar-Projeto"
                            type="button" role="tab" aria-controls="v-gerenciar-Projeto" aria-selected="false">Gerenciar Projetos</button>

                    <button class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-messages"
                            type="button" role="tab" aria-controls="v-pills-messages" aria-selected="false">Messages</button>

                    <button class="nav-link" id="v-pills-settings-tab" data-bs-toggle="pill" data-bs-target="#v-pills-settings"
                            type="button" role="tab" aria-controls="v-pills-settings" aria-selected="false">Settings</button>
                </div>

                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <!-- INICIO-->



                    </div>
                    <div class="tab-pane fade" id="v-cadastrar-Projetos" role="tabpanel" aria-labelledby="v-cadastrar-Projetos-tab">
                        <form action="${pageContext.request.contextPath}/servletPost" method="post" class="formApresetacao" enctype="multipart/form-data">
                            <label for="basic-url" class="form-label">Nome do repositorio</label>
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon3">https://github.com/Sync-BR/</span>
                                <input type="text" name="txtRepository" class="form-control" id="basic-url" aria-describedby="basic-addon3">
                            </div>
                            <label>Titulo:</label><br>
                            <input type="text" name="txtTitulo" class="form-control txtTitulo ">
                            <br>
                            <label>Descrição</label><br>
                            <textarea name="txtDescription" class="form-control"></textarea>
                            <label for="">Imagem</label>
                            <input type="file" name="fileIMG" class="form-control" accept="image/png, image/jpeg, image/png">
                            <br>
                            <div class="form-check form-switch">
                                <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault" name="frontEnd" value="true">
                                <label class="form-check-label" for="flexSwitchCheckDefault">BackEnd</label>
                            </div>
                            <div class="form-check form-switch">
                                <input class="form-check-input" type="checkbox" id="flexSwitchCheckChecked" name="backEnd" value="true">
                                <label class="form-check-label" for="flexSwitchCheckChecked">FrontEnd</label>
                            </div>
                            <input type="hidden" name="action" value="addPost">
                            <button type="submit" name="" class="btn-secondary btn-lg">Enviar</button>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="v-gerenciar-Projeto" role="tabpanel" aria-labelledby="v-pills-gerenciar-Projetos-tab">

                        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Voluptas soluta, adipisci neque quasi officia sapiente nihil quam inventore dicta est dignissimos corporis reprehenderit voluptatem dolor molestiae libero repudiandae explicabo laboriosam?

                    </div>
                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">



                    </div>
                    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">



                    </div>
                </div>
            </div>
        </main>

    </body>

</html>
