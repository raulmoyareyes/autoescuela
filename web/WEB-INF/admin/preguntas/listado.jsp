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

            <ul class="thumbnails">
                <c:forEach var="p" items="${questList}" varStatus="estado">
                    <li class="width95 span9">
                        <div class="thumbnail">
                            <h3>
                                #${p.id} / Tema: ${p.tema}
                                <a class="frigth" href="/autoescuela/pregutnas/elimina"><i class="icon-remove"></i></a>
                                <a class="frigth" href="/autoescuela/preguntas/modifica?id=${p.id}"><i class="icon-pencil"></i></a>
                            </h3>
                            <div>
                                <img class="thumbnail inBl" src="http://www.preguntasfrecuentes.net/wp-files/2011/multas-plazo-prescripcion.jpg" width="20%"alt="">
                                <div class="inBl width60">
                                    <p>${p.enunciado}</p>
                                    <p>> ${p.respuesta1}</p>
                                    <p>> ${p.respuesta2}</p>
                                    <p>> ${p.respuesta3}</p>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>

        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>