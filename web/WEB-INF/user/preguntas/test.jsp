<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/user/cabecera.jsp?op=test"/>
<!-- container -->
<div class="row">
    <div class="span13 centro">
        <section>
            <c:if test="${corregir != null}">
                <div class="alert alert-info">
                    <div class="progress">
                        <div class="bar bar-success" style="width: ${buenas*100/fn:length(questList)}%;"></div>
                        <div class="bar bar-warning" style="width: ${sin*100/fn:length(questList)}%;"></div>
                        <div class="bar bar-danger" style="width: ${fallidas*100/fn:length(questList)}%;"></div>
                    </div>
                        <span class="text-success">Respuestas correctas: ${buenas} -</span>
                        <span class="text-warning">Respuestas sin contestar: ${sin} -</span>
                        <span class="text-error">Respuestas fallidas: ${fallidas}</span>
                </div>
            </c:if>
            <form method="post">
                <input type="hidden" name="listId" value='<c:forEach var="p" items="${questList}" varStatus="estado">${p.id},</c:forEach>' />
                <input type="hidden" name="tema" value='<%= request.getParameter("tema")%>'/>
                <div class="page-header">
                    <h1>
                        Test -  Tema <%= request.getParameter("tema")%>
                        <div class="frigth">
                            <c:if test="${corregir == null}"><button type="submit" name="corregir" class="btn btn-success">Corregir examen</button></c:if>
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
                    <c:if test="${corregir == null}"><button type="submit" name="corregir" class="btn btn-success">Corregir examen</button></c:if>
                        <button type="submit" class="btn btn-danger">Nuevo examen</button>
                    </div>
                </form>
            </section>
        </div>
    </div>
    <!-- container -->

<jsp:include page="/WEB-INF/user/pie.jsp"/>