
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span3 bs-docs-sidebar">
    <ul class="nav nav-tabs  bs-docs-sidenav nav-stacked nav-left-bgcolor">
        <li class="${(param.op == 'list')?'active':''}"><a href="/autoescuela-master/usuarios/listado"><c:if test="${param.op == 'list'}"><i class="icon-chevron-right"></i> </c:if>Listado de usuarios</a></li>
        <li class="${(param.op == 'new')?'active':''}"><a href="/autoescuela-master/usuarios/nuevo"><c:if test="${param.op == 'new'}"><i class="icon-chevron-right"></i> </c:if>Nuevo usuario</a></li>
        <li class="${(param.op == 'exam')?'active':''}"><a href="/autoescuela-master/usuarios/preparados"><c:if test="${param.op == 'exam'}"><i class="icon-chevron-right"></i> </c:if>Usuarios para examen</a></li>
    </ul>
</div>
