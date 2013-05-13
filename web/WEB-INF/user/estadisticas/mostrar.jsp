<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/user/cabecera.jsp?op=stats"/>
<!-- container -->
<div class="row">
    <section>
        <div class="centro">
            <div class="page-header">
                <h1>Sus estadísticas</h1>
            </div>
            <div>
                <h3>Progreso</h3>
                <div class="progress">
                    <div class="bar bar-success" style="width: 25%;"></div>
                </div>
            </div>
            <div class="page-header">
                <h3>Número de exámenes realizados: 49</h3>
            </div>
            <div>
                <h3>Progreso por temas</h3>
                <div class="progress">
                    Tema 1 <div class="bar bar-success" style="width: 25%;"></div>
                </div>
                <div class="progress">
                    Tema 2 <div class="bar bar-success" style="width: 65%;"></div>
                </div>
                <div class="progress">
                    Tema 3 <div class="bar bar-success" style="width: 35%;"></div>
                </div>
                <div class="progress">
                    Tema 4 <div class="bar bar-success" style="width: 55%;"></div>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/user/pie.jsp"/>


