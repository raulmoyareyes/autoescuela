<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/admin/cabecera.jsp?op=usuarios"/>

<!-- container -->
<div class="row">

    <jsp:include page="/WEB-INF/admin/usuarios/menu.jsp?op=exam"/>

    <div class="span9 centro">
        <section>
            <div class="page-header">
                <h1>Listado de usuarios preparados para examen</h1>
            </div>
            <table class="table table-striped table-condensed table-hover width100">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>DNI</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${userList}" varStatus="estado">
                        <tr if="fila${u.dni}">
                            <td>${u.nombre}</td>
                            <td>${u.apellidos}</td>
                            <td>${u.dni}</td>
                            <td>${u.direccion}</td>
                            <td>${u.telefono}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
        <!-- Modal para confirmar eliminación -->
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>