<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/user/cabecera.jsp?op=test"/>
<!-- container -->
<div class="row">

    <!--Cosas por hacer
    
    Eliminar boton de corregir cuando se corrija
    Poner más bonita la parte de los resultados
    Crear el Dao para guardar resultados 
    
    -->
    <div class="span13 centro">
        <section>
            <c:if test="${corregir != null}">
                <div>
                    Respuestas correctas: ${buenas}
                    Respuestas fallidas: ${fallidas}
                    Respuestas sin contestar: ${sin}
                </div>
            </c:if>
            <form method="post">
                <input type="hidden" name="listId" value='<c:forEach var="p" items="${questList}" varStatus="estado">${p.id},</c:forEach>' />
                <input type="hidden" name="tema" value='<%= request.getParameter("tema")%>'/>
                <div class="page-header">
                    <h1>
                        Test -  Tema <%= request.getParameter("tema")%>
                        <div class="frigth">
                            <button type="submit" name="corregir" class="btn btn-success">Corregir examen</button>
                            <button type="submit" class="btn btn-danger">Nuevo examen</button>
                        </div>
                    </h1>
                </div>
                <ul class="thumbnails">
                    <c:forEach var="p" items="${questList}" varStatus="estado">
                        <li class="width95 span12">
                            <div class="thumbnail">
                                <div class="margin-top-bottom">
                                    <img class="thumbnail inBl" src="../img/${p.imagen}" width="20%"alt="">
                                    <div class="inBl width60">
                                        <p>${p.enunciado}</p>
                                        <div class="controls">
                                            <label for="radioRespuesta1" class="radio">${p.respuesta1}<input type="radio" name="${p.id}" value="1" ${(corregir!=null && p.respuestaCorrecta==1)?'checked':''} /></label>
                                            <label for="radioRespuesta2" class="radio">${p.respuesta2}<input type="radio" name="${p.id}" value="2" ${(corregir!=null && p.respuestaCorrecta==2)?'checked':''} /></label>
                                            <label for="radioRespuesta3" class="radio">${p.respuesta3}<input type="radio" name="${p.id}" value="3" ${(corregir!=null && p.respuestaCorrecta==3)?'checked':''} /></label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div class="frigth" method="post">
                    <button type="submit" name="corregir" class="btn btn-success">Corregir examen</button>
                    <button type="submit" class="btn btn-danger">Nuevo examen</button>
                </div>
            </form>
        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/user/pie.jsp"/>