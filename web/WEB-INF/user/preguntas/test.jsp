<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/user/cabecera.jsp?op=test"/>
<!-- container -->
<div class="row">

    <div class="span12 centro">
        <section>
            <div class="page-header">
                <h1>Test -  Tema ${p_Variable.tema}¿?</h1> 
            </div>
            <ul class="thumbnails">
                <c:forEach var="p" items="${questList}" varStatus="estado">
                    <li class="width95 span12">
                        <div class="thumbnail">
                            <h3 class="padding5">
                                #<span>${p.id}</span> / Tema: ${p.tema}
                                <a class="frigth" href="/autoescuela/preguntas/modifica?id=${p.id}"><i class="icon-pencil"></i></a>
                                <a class="eliminap frigth"href="#modalElimina" data-toggle="modal"><i class="icon-remove"></i></a>
                            </h3>
                            <div>
                                <img class="thumbnail inBl" src="../img/${p.imagen}" width="20%"alt="">
                                <div class="inBl width60">
                                    <p>${p.enunciado}</p>
                                    <ul>
                                        <li class=${(p.respuestaCorrecta == "1")?"text-success":"text-error"}>${p.respuesta1}</li>
                                        <li class=${(p.respuestaCorrecta == "2")?"text-success":"text-error"}>${p.respuesta2}</li>
                                        <li class=${(p.respuestaCorrecta == "3")?"text-success":"text-error"}>${p.respuesta3}</li>
                                    </ul>
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

<jsp:include page="/WEB-INF/user/pie.jsp"/>