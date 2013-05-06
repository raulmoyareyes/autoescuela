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
            <c:if test="${noEliminada == 'true'}">
                <div class="alert alert-error">
                    La pregunta no ha sido eliminada.
                </div>
            </c:if>
            <ul class="thumbnails">
                <c:forEach var="p" items="${questList}" varStatus="estado">
                    <li class="width95 span9">
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
            <!-- Modal para confirmar eliminación -->
            <div class="modal hide fade" id="modalElimina">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3>Eliminar pregunta</h3>
                </div>
                <div class="modal-body">
                    <p>Se eliminará la siguiente pregunta (id): <span id="idPregunta">xxx</span></p>
                    <p>Esta operación no tendrá vuelta atrás. ¿Desea continuar?</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
                    <a href="#" id="confirmaElimina" class="btn btn-danger">Eliminar</a>
                </div>
            </div>
        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>