<jsp:include page="/WEB-INF/admin/cabecera.jsp"/>

<!-- container -->
<div class="row">

    <jsp:include page="/WEB-INF/admin/usuarios/menu.jsp?op=list"/>

    <div class="span9 centro">
        <section>
            <div class="page-header">
                <h1>Listado de usuarios</h1>
            </div>
            <table class="table-condensed table-bordered table-hover">
                <caption>...</caption>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>DNI</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Grupo</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Hola</td>
                        <td>Adios</td>
                        <td>Hola</td>
                        <td>Adios</td>
                        <td>Hola</td>
                        <td>Adios</td>
                    </tr>
                </tbody>
            </table>
        </section>
    </div>
</div>
<!-- container -->

<jsp:include page="/WEB-INF/admin/pie.jsp"/>