<%-- 
    Document   : index
    Created on : 15-mar-2013, 22:49:14
    Author     : dev-linux
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.getParameter("enviar");
%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="es"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>Autoescuela</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="css/main.css">

    <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>
    <!--[if lt IE 7]>
        <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
    <![endif]-->

    <!-- container -->

    <div id="error" class="alert alert-error modal hide">
        <button id="closeAlert" type="button" class="close">&times;</button>
        <strong>¡Error al iniciar sesión!</strong> Compruebe sus datos.
    </div>
    
    <div class="container">

        <form class="form-signin" method="post">
            <h2 class="form-signin-heading">Iniciar sesión</h2>
            <input id="user" type="text" class="input-block-level" placeholder="Nombre de usuario" name="usuario"/>
            <input id="pass" type="password" class="input-block-level" placeholder="Contraseña"/>
            <label id="remember" class="checkbox">
                <input type="checkbox" value="remember-me"> Recordarme
            </label>
            <button type="submit" id="btnEnter" name="enviar" class="btn btn-large btn-primary">Entrar</button>
        </form>

    </div>
    <%
        if(request.getParameter("enviar")!=null){
     %>
     <strong>hola</strong>
    <%   
        }
    %>

    <!-- container -->

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.js"><\/script>');</script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>

