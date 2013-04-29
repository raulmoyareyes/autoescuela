<jsp:include page="/WEB-INF/admin/cabecera.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- container -->
<div class="row">

    <jsp:include page="/WEB-INF/admin/usuarios/menu.jsp?op=list"/>

    <div class="span9 centro">
        <section>
            <div class="page-header">
                <h1>Listado de usuarios</h1>
            </div>
            <table class="table-condensed table-bordered table-hover">
                <caption>Alumnado</caption>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>DNI</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Grupo</th>
                        <th>&nbsp;</th>
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
                            <td>${u.grupo}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>