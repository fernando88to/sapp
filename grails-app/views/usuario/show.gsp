<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_thema" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <title>Dados do Usuário</title>
    </head>
    <body>
    <div class="card card-block sameheight-item" style="height: 726px;">

        <g:if test="${flash.message}">
            <div class="text-success" role="status">${flash.message}</div>
        </g:if>


        <div class="title-block">
            <h3 class="title"> Dados do  Usuário </h3>
        </div>
        <g:form  role="form" resource="${this.usuario}" method="POST">

            <g:hasErrors bean="${this.usuario}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.usuario}" var="error">
                        <li class="has-error" <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>

            <div class="form-group">
                <label class="control-label">Nome</label>
                <input type="text" name="nome" class="form-control underlined" value="${usuario.nome}" maxlength="255"
                readonly="readonly">
            </div>
            <div class="form-group">
                <label class="control-label">Login</label>
                <input type="text" name="login" class="form-control underlined" value="${usuario.login}" maxlength="255" readonly="readonly">
            </div>

            <div class="form-group">
                <label class="control-label">Email</label>
                <input type="text" name="email" class="form-control underlined" value="${usuario.email}" maxlength="255" readonly="readonly">
            </div>

            <div class="form-group">
                <label class="control-label">Data de Criação</label>
                <input type="text" name="email" class="form-control underlined" value="${usuario.dataCriacao.format("dd/MM/yyyy HH:mm")}" maxlength="255" readonly="readonly">
            </div>

            <div class="form-group">
                <g:actionSubmit action="edit"  name="edit" class="btn btn-primary" value="${message(code: 'default.button.edit.label', default: 'Edit')}" />
                <g:actionSubmit action="delete"  class="btn btn-danger" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                <g:actionSubmit action="index" name="cancelar" class="btn btn-secondary" value="Voltar"   />







            </div>



        </g:form>
    </div>
    <script type="text/javascript">
        $(document).ready(function(){
            $( "#menu_usuario" ).addClass( "active open" );
        });
    </script>
    </body>
</html>
