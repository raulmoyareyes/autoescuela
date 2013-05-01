<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/admin/cabecera.jsp?op=preguntas"/>
<!-- container -->
<div class="row">

    <jsp:include page="/WEB-INF/admin/preguntas/menu.jsp?op=new"/>

    <div class="span9 centro">
        <section>
            <div class="page-header">
                <h1>Nueva pregunta</h1>
            </div>
            <c:if test="${noCreada == 'true'}">
                <div class="alert alert-error">
                    La pregunta no ha sido creada. Intentelo de nuevo.
                </div>
            </c:if>
            <form class="form-horizontal" method="post">
                <div class="control-group margin-bottom-10">
                    <label class="control-label" for="inputNombre">Nombre</label>
                    <div class="controls">
                        <input class="span5" type="text" id="inputNombre" name="nombre" placeholder="Escriba su nombre" />
                    </div>
                </div>

                <div class="form-actions">
                    <button type="submit" name="crear" class="btn btn-primary">Crear pregunta</button>
                    <button type="reset" class="btn">Limpiar</button>
                </div>

            </form>

        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>