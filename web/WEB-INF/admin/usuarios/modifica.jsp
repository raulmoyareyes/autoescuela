<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/admin/cabecera.jsp"/>

<!-- container -->
<div class="row">

    <jsp:include page="/WEB-INF/admin/usuarios/menu.jsp"/>

    <div class="span9 centro">
        <section>
            <div class="page-header">
                <h1>Modificar usuario</h1>
            </div>
            <c:if test="${noModificado == 'true'}">
                <div class="alert alert-error">
                    El usuario no se ha modificado. Intentelo de nuevo.
                </div>
            </c:if>
            <form class="form-horizontal" method="post">
                <div class="control-group margin-bottom-10">
                    <label class="control-label" for="inputNombre">Nombre</label>
                    <div class="controls">
                        <input class="span5" type="text" id="inputNombre" name="nombre" placeholder="Escriba su nombre" value="${user.nombre}" />
                    </div>

                    <label class="control-label" for="inputApellidos">Apellidos</label>
                    <div class="controls">
                        <input class="span5" type="text" id="inputApellidos" name="apellidos" placeholder="Escriba sus apellidos" value="${user.apellidos}" />
                    </div>

                    <label class="control-label" for="inputDNI">DNI</label>
                    <div class="controls">
                        <input class="span5" type="text" id="inputDNI" name="dni" placeholder="Escriba su DNI" value="${user.dni}" />
                    </div>

                    <label class="control-label" for="inputPass">Contraseña</label>
                    <div class="controls">
                        <input class="span5" type="password" id="inputPass" name="pass" placeholder="Escriba su contraseña" value="${user.password}" />
                    </div>

                    <label class="control-label" for="inputPass2">Confirmar contraseña</label>
                    <div class="controls">
                        <input class="span5" type="password" id="inputPass2" name="pass2" placeholder="Confirme su contraseña" value="${user.password}" />
                    </div>
                </div>

                <div class="control-group margin-bottom-10">
                    <label class="control-label" for="inputDireccion">Dirección</label>
                    <div class="controls">
                        <input class="span5" type="text" id="inputDireccion" name="direccion" placeholder="Escriba su dirección" value="${user.direccion}" />
                    </div>

                    <label class="control-label" for="inputTelefono">Teléfono</label>
                    <div class="controls">
                        <input class="span5" type="text" id="inputTelefono" name="telefono" placeholder="Escriba su teléfono" value="${user.telefono}" />
                    </div>

                    <label class="control-label" for="inputTipo">Tipo de usuario</label>
                    <div class="controls">
                        <select id="inputTipo" class="span5" name="tipo">
                            <option id="alumno" ${(user.grupo == 0)?'selected':''}>Alumno</option>
                            <option id="administrador"${(user.grupo == 1)?'selected':''}>Administrador</option>
                        </select>
                    </div>
                </div>

                <div class="form-actions">
                    <button type="submit" name="guardar" class="btn btn-primary">Guardar</button>
                    <button type="reset" class="btn">Restaurar</button>
                </div>

            </form>

        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>