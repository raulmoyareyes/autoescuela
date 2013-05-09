<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Autoescuela -  User</title>
        <meta charset="UTF-8">

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="shortcut icon" href="../img/favicon.png" />

        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="../css/user/main.css">

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
                    <a class="brand" href="/autoescuela/estadisticas/mostrar">Autoescuela</a>

                    <!-- Everything you want hidden at 940px or less, place within here -->
                    <div class="nav-collapse collapse">
                        <!-- .nav, .navbar-search, .navbar-form, etc -->
                        <ul class="nav">
                            <li class="${(param.op == 'stats')?'active':''}"><a href="/autoescuela/estadisticas/mostrar">Estadísticas</a></li>
                            <li class="dropdown ${(param.op == 'test')?'active':''}">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Test <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <c:forEach var="u" items="${unitList}" varStatus="estado">
                                        <li><a href="/autoescuela/preguntas/test?tema=${u}">Tema ${u}</a></li>
                                    </c:forEach>
                                        <li class="divider"></li>
                                        <li><a href="/autoescuela/preguntas/test?tema=global">Global</a></li>
                                </ul>
                            </li>
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