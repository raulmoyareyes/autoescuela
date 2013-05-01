<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span3 bs-docs-sidebar">
    <ul class="nav nav-tabs  bs-docs-sidenav nav-stacked nav-left-bgcolor">
        <li class="${(param.op == 'list')?'active':''}"><a href="/autoescuela/preguntas/listado"><c:if test="${param.op == 'list'}"><i class="icon-chevron-right"></i> </c:if>Listado de preguntas</a></li>
        <li class="${(param.op == 'new')?'active':''}"><a href="/autoescuela/preguntas/nueva"><c:if test="${param.op == 'new'}"><i class="icon-chevron-right"></i> </c:if>Nueva pregunta</a></li>
    </ul>
</div>
