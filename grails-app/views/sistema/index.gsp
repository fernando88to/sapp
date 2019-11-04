<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_thema" />
        <g:set var="entityName" value="${message(code: 'sistema.label', default: 'Sistema')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>

        %{--<a href="#list-sistema" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-sistema" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${sistemaList}" />

            <div class="pagination">
                <g:paginate total="${sistemaCount ?: 0}" />
            </div>
        </div>--}%
    <div class="row">
        <div class="col-md-10"></div>
        <div class="col-md-1">
            <g:link action="create" >
                <button type="button" class="btn btn-info">Cadastrar</button>
            </g:link>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-block">
                    <div class="card-title-block">
                        <h3 class="title"> Sistemas Cadastrados </h3>

                    </div>
                    <section class="example">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Nome</th>
                                <th>Sigla</th>
                                <th>Url</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${sistemaList}" var="u">
                                <tr>
                                    <th scope="row">${u.id}</th>
                                    <td>${u.nome}</td>
                                    <td>${u.sigla}</td>
                                    <td>${u.url}</td>
                                    <td>
                                        <g:link controller="sistema" action="edit" params="[id:u.id]"><i class="fa fa-pencil"></i> </g:link>&nbsp;&nbsp;&nbsp;&nbsp;
                                        <g:link controller="sistema" action="show" params="[id:u.id]"><i class="fa fa-eye"></i> </g:link>
                                    </td>
                                </tr>
                            </g:each>


                            </tbody>
                        </table>
                    </section>
                </div>
            </div>
        </div>

    </div>






    <div class="pagination">
        <g:paginate total="${sistemaCount ?: 0}" />
    </div>
    </div>


    <script type="text/javascript">
        $(document).ready(function(){
            $( "#menu_sistemas" ).addClass( "active open" );
        });
    </script>
    </body>
</html>