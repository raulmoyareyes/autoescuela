<%-- 
    Document   : index
    Created on : 21-mar-2013, 17:42:31
    Author     : dev-linux
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Autoescuela -  User</title>
        <meta charset="UTF-8">

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">

                    <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <!-- Be sure to leave the brand out there if you want it shown -->
                    <a class="brand" href="#">Autoescuela</a>

                    <!-- Everything you want hidden at 940px or less, place within here -->
                    <div class="nav-collapse collapse">
                        <!-- .nav, .navbar-search, .navbar-form, etc -->
                        <ul class="nav">
                            <li class="active"><a href="#">Estadisticas</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Test <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Tema 1</a></li>
                                    <li><a href="#">Tema 2</a></li>
                                    <li><a href="#">Tema 3</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Global</a></li>
                                </ul>
                            </li>
                        </ul>

                        <ul class="nav pull-right">
                            <li class="divider-vertical"></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuario <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li class="disabled"><a href="#">none</a></li>
                                    <li class="divider"></li>
                                    <li><a href="../index.jsp">Cerrar sesión</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>

        <!-- container -->
        <div id="container">
            
<jsp:include page="jsp/estadisticas.jsp"/>
            
        </div>
        <!-- container -->

        <footer class="well well-large">
            <p>&COPY; 2013 - Todos los derechos reservados.</p>
            <ul class="nav nav-pills">
                <li><a href="#">Castro Damas, Manuel J.</a></li>
                <li><a href="#">Fernández Moral, Gabriel</a></li>
                <li><a href="#">Moya Reyes, Raúl</a></li>
                <li><a href="#">Ruiz Linares, Agustín</a></li>
            </ul>
        </footer>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
        <script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.9.1.js"><\/script>');</script>
        <script src="../js/vendor/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>