<%@page import="java.sql.SQLException"%>
<%@page import="Util.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@page import="Beans.usuarioBeans"%>

<%

    /*
    *@Sobre Verificar se possuir conexão com banco de dados.
    *@Exception Caso não tenha conexão redirecionar para pagina de erro
    *
     */
    try {
        Connection connection = Conexao.getconnection();
        if (connection != null) {
            //Se possuir conexão fechar a conexão.
            Conexao.closeConnection(connection);
        }
    } catch (Exception e) {
        response.sendRedirect("500.html");
    }

%>
<%    
    System.out.println("Token autenticado: " + usuarioBeans.getToken());
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="./src/css/reset.css">
        <link rel="stylesheet" href="./src/css/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200..700&display=swap" rel="stylesheet">
        <title>Portfolio</title>
    </head>

    <body>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>


        <header>

            <nav class="navbar navbar-expand-lg navbar-dark ">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#"><h1>SYNC DEV</h1></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                            aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarScroll">
                        <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#paginaInicial">INICIO</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#paginaProjetos">PROJETOS</a>


                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <%
                                        try {

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    %>
                                    Conta
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown" style="min-width: 7vw;">
                                    <%
                                        if (usuarioBeans.getToken() != null) {
                                            out.print("<li><a class=\"dropdown-item\" href=\"#\"  data-bs-toggle=\"modal\" data-bs-target=\"#exampleModa2\">Sair</a></li>");
                                        } else {
                                            out.print("<li><a class=\"dropdown-item\" href=\"#\" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Entrar</a></li>");
                                        }
                                    %>

                                </ul>
                            </li>
                            <li class="nav-item">
                                <%
                                    if (usuarioBeans.getToken() == null) {
                                        out.print("<a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Painel</a>");
                                    } else {
                                        out.print("<a class=\"nav-link \" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Painel</a>");
                                    }
                                %>
                            </li>
                        </ul>

                    </div>
                </div>
            </nav>
        </header>
        <main>
            <section class="inicio" id="paginaInicial">
                <div class="descricao">
                    <h2>Olá, eu sou o <span>SYNC</span></h2>
                    <br>
                    <p>Sou Eduardo Freitas da Silva Santos, tenho 26 anos e atualmente estou cursando o 5º semestre de
                        Análise e Desenvolvimento de Sistemas na Faculdade Visconde de Cairu. Com um sólido conhecimento em
                        HTML, CSS, JavaScript e Java, tenho experiência no desenvolvimento de softwares Java desktop e
                        sistemas web, além da manipulação e integração de banco de dados.</p>
                    <br>
                    <button class="btn-perfil"><a href="">Exibir projetos</a></button>
                </div>
                <div class="perfil">
                    <img src="./src/img/perfil.jpg" class="img-fluid" alt="...">
                </div>
            </section>
            <section class="projetos" id="paginaProjetos">
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill"
                                data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home"
                                aria-selected="true">Front-End</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill"
                                data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile"
                                aria-selected="false">Back-End</button>
                    </li>

                </ul>
                <div class="tab-content" id="pills-tabContent">
                    <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                        <!-- FrontEnd -->
                        <div class="card">
                            <img src="./src/img/site1.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">FrontEnd Mentor</h5>
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                    of the card's content.</p>
                                <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                        </div>

                    </div>
                    <!-- Backend -->
                    <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                        <div class="card">
                            <img src="./src/img/site1.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">FrontEnd Mentor</h5>
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                    of the card's content.</p>
                                <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                        </div>

                    </div>


            </section>
        </main>
        <!-- Modal de login-->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Painel administrador</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.request.contextPath}/userServlets" method="post">
                            <input type="hidden" name="action" value="login">
                            <div class="mb-3 row">
                                <label for="staticEmail" class="col-sm-2 col-form-label">Usuario</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="staticEmail" name="userTXT" value="Usuario">
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword" name="passTXT" value="">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Conectar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal de encerrar sessão-->
        <div class="modal fade" id="exampleModa2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirmar operação</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Tem certezar que deseja encerrar sua conta
                    </div>
                    <form action="${pageContext.request.contextPath}/userServlets" method="post">      
                        <input type="hidden" name="action" value="logout">
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                            <button type="submit" class="btn btn-danger">Sair</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <footer>

            <p>@Todos direitos reservados SYNC</p>
        </footer>
    </body>

</html>