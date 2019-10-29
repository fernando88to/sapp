<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_thema" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>

       %{-- <div id="create-usuario" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.usuario}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.usuario}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.usuario}" method="POST">
                <fieldset class="form">
                    <f:all bean="usuario"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>--}%



    <div class="card card-block sameheight-item" style="height: 726px;">
        <div class="title-block">
            <h3 class="title"> Criar Usuário </h3>
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
                <input type="text" name="nome" class="form-control underlined" value="${usuario.nome}">
            </div>

            <div class="form-group">
                <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
            </div>



        </g:form>
    </div>


    </body>
</html>
