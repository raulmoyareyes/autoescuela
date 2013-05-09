<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Admin - Autoescuela</title>
        <meta charset="UTF-8">

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="shortcut icon" href="../img/favicon.png" />

        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="../css/admin/main.css">

        <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <div class="navbar navbar-inverse">
            <div class="navbar-inner">
                <div class="container">

                    <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <!-- Be sure to leave the brand out there if you want it shown -->
                    <a class="brand" href="/autoescuela/usuarios">Autoescuela</a>

                    <!-- Everything you want hidden at 940px or less, place within here -->
                    <div class="nav-collapse collapse">
                        <!-- .nav, .navbar-search, .navbar-form, etc -->
                        <ul class="nav">
                            <li class="${(param.op == 'usuarios')?'active':''}"><a href="/autoescuela/usuarios">Usuarios</a></li>
                            <li class="${(param.op == 'preguntas')?'active':''}"><a href="/autoescuela/preguntas">Preguntas</a></li>
                        </ul>

                        <ul class="nav pull-right">
                            <li class="divider-vertical"></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.currentUser.nombre} ${sessionScope.currentUser.apellidos} <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li class="disabled">> Última conexión: <a href="#"><%=new Date(session.getCreationTime())%></a></li>
                                    <li class="divider"></li>
                                    <li><a href="/autoescuela/usuarios/listado">Zona administración</a></li>
                                    <li><a href="/autoescuela/estadisticas/mostrar">Zona usuario</a></li>
                                    <li><a href="/autoescuela/login?op=close">Cerrar sesión</a></li>
                                </ul>
                            </li>
                        </ul>
                                    
                    </div>

                </div>
            </div>
        </div>