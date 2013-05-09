<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/user/cabecera.jsp?op=test"/>
<!-- container -->
<div class="row">

    <div class="span13 centro">
        <section>
            <form>
                <div class="page-header">
                    <h1>
                        Test -  Tema <%= request.getParameter("tema")%>
                        <div class="frigth">
                            <button type="submit" name="corregir" class="btn btn-success">Corregir examen</button>
                            <button type="submit" class="btn btn-danger">Comenzar de nuevo</button>
                        </div>
                    </h1>
                </div>
                <ul class="thumbnails">
                    <c:forEach var="p" items="${questList}" varStatus="estado">
                        <li id="${p.id}" class="width95 span12">
                            <form class="thumbnail">
                                <div class="margin-top-bottom">
                                    <img class="thumbnail inBl" src="../img/${p.imagen}" width="20%"alt="">
                                    <div class="inBl width60">
                                        <p>${p.enunciado}</p>
                                        <div class="controls">
                                            <label for="radioRespuesta1" class="radio">${p.respuesta1}<input type="radio" name="radioRespuesta${p.id}" value="1"/></label>
                                            <label for="radioRespuesta2" class="radio">${p.respuesta2}<input type="radio" name="radioRespuesta${p.id}" value="2"/></label>
                                            <label for="radioRespuesta3" class="radio">${p.respuesta3}<input type="radio" name="radioRespuesta${p.id}" value="3"/></label>
                                        </div>
                                        <div class="frigth">
                                            <button type="reset" class="btn">Limpiar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
                <div class="frigth">
                    <button type="submit" name="corregir" class="btn btn-success">Corregir examen</button>
                    <button type="submit" class="btn btn-danger">Comenzar de nuevo</button>
                </div>
            </form>
        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/user/pie.jsp"/>