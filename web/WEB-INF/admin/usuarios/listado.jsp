<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/admin/cabecera.jsp"/>
<!-- container -->
<div class="row">

    <jsp:include page="/WEB-INF/admin/usuarios/menu.jsp?op=list"/>

    <div class="span9 centro">
        <section>
            <div class="page-header">
                <h1>Listado de usuarios</h1>
            </div>
            <table class="table table-striped table-condensed table-hover width100">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>DNI</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Grupo</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${userList}" varStatus="estado">
                        <tr>
                            <td>${u.nombre}</td>
                            <td>${u.apellidos}</td>
                            <td>${u.dni}</td>
                            <td>${u.direccion}</td>
                            <td>${u.telefono}</td>
                            <td>${u.grupo==0?'Usuario':'Administrador/a'}</td>
                            <td>
                                <a href="/autoescuela/usuarios/elimina"><i class="icon-remove"></i></a>
                                <a href="/autoescuela/usuarios/modifica?id=${u.dni}"><i class="icon-pencil"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>