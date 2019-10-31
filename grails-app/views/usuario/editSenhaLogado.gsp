<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main_thema" />
    <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
    <title>Editar Usuário</title>
</head>
<body>



<div class="card card-block sameheight-item" style="height: 726px;">

    <g:if test="${flash.message}">
        <div class="text-success" role="status">${flash.message}</div>
    </g:if>

    <div class="title-block">
        <h3 class="title"> Editar Usuário </h3>
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
            <label class="control-label">Login</label>
            <input type="text" name="login2"
                   class="form-control underlined"
                   value="${usuario.login}" maxlength="255" readonly="readonly">
        </div>

        <div class="form-group">
            <label class="control-label">Senha</label>
            <input type="password" name="senha" class="form-control underlined"
                    maxlength="255">
        </div>
        <div class="form-group">
            <label class="control-label">Repita a senha</label>
            <input type="password" name="senhaConfirmacao" class="form-control underlined"
                    maxlength="255">
        </div>




        <div class="form-group">
            <g:actionSubmit action="updateSenhaLogado" name="create" class="btn btn-primary" value="${message(code: 'default.button.update.label', default: 'Update')}" />

        </div>



    </g:form>



</body>
</html>
