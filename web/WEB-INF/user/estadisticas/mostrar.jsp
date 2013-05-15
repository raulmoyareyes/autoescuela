<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/user/cabecera.jsp?op=stats"/>
<!-- container -->
<div class="row">
    <section>
        <div class="centro">
            <div class="page-header">
                <h1>Sus estadísticas</h1>
            </div>
            <div>
                <c:if test="${progresoG>90}">
                    <div class="alert alert-info">
                        Enhorabuena, puede que ya seas apto para realizar el examen oficial.
                    </div>
                </c:if>
                <h3>Progreso</h3>
                <div class="progress">
                    <div class="bar bar-success" style="width: ${progresoG}%;">${progresoG}%</div>
                    <div class="bar bar-danger" style="width: ${100-progresoG}%;"></div>
                </div>
            </div>
            <div class="page-header">
                <h3>Número de exámenes realizados: ${numExam}</h3>
            </div>
            <div>
                <h5>Progreso por temas</h5>
                <c:forEach var="u" items="${unitList}" varStatus="estado">
                    <div class="progress">
                        <div class="bar bar-success" style="width: ${progressT[estado.count-1]}%;">
                            Tema ${u} - ${progressT[estado.count-1]}%
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/user/pie.jsp"/>


