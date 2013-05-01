<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/admin/cabecera.jsp?op=preguntas"/>
<!-- container -->
<div class="row">

    <jsp:include page="/WEB-INF/admin/preguntas/menu.jsp?op=list"/>

    <div class="span9 centro">
        <section>
            <div class="page-header">
                <h1>Listado de preguntas</h1>
            </div>
            <table class="table table-striped table-condensed table-hover width100">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${userList}" varStatus="estado"></c:forEach>
                        <tr>
                            <td>#####</td>
                            <td>Pregunta titulo que sea</td>
                            <td>
                                <a href="/autoescuela/usuarios/elimina"><i class="icon-remove"></i></a>
                                <a href="/autoescuela/usuarios/modifica?id=${u.dni}"><i class="icon-pencil"></i></a>
                            </td>
                        </tr>
                </tbody>
            </table>
        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>