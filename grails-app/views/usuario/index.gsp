<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_thema" />
        <g:set var="entityName" value="${message(code: 'usuario.labels', default: 'Usuario')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>

    <div class="title-block">
        <h1 class="title"> <g:message code="usuario.labels" args="[entityName]" /> </h1>
    </div>

%{--            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
    --}%


    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-block">
                    <div class="card-title-block">
                        <h3 class="title"> Basic example </h3>
                    </div>
                    <section class="example">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Nome</th>
                                <th>Login</th>
                                <th>Username</th>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${this.usuarioList}" var="u">
                                <tr>
                                    <th scope="row">${u.id}</th>
                                    <td>${u.nome}</td>
                                    <td>${u.login}</td>
                                    <td>@mdo</td>
                                </tr>
                            </g:each>


                            </tbody>
                        </table>
                    </section>
                </div>
            </div>
        </div>

    </div>




            %{--<f:table collection="${usuarioList}" />--}%

            <div class="pagination">
                <g:paginate total="${usuarioCount ?: 0}" />
            </div>
        </div>
    </body>
</html>