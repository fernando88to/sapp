<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main_thema"/>
    <g:set var="entityName" value="${message(code: 'sistema.label', default: 'Sistema')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<g:if test="${flash.message}">
    <div class="text-success" role="status">${flash.message}</div>
</g:if>


<div class="title-block">
    <h3 class="title">Dados do  Sistema</h3>
</div>
<g:form role="form" resource="${this.sistema}" method="POST">

    <g:hasErrors bean="${this.sistema}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.sistema}" var="error">
                <li class="has-error"
                    <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <div class="form-group">
        <label class="control-label">Nome</label>
        <input type="text" name="nome" class="form-control underlined" value="${sistema.nome}" maxlength="255"
               readonly="readonly">
    </div>

    <div class="form-group">
        <label class="control-label">Sigla</label>
        <input type="text" name="sigla" class="form-control underlined" value="${sistema.sigla}" maxlength="255"
               readonly="readonly">
    </div>

    <div class="form-group">
        <label class="control-label">URL</label>
        <input type="text" name="url" class="form-control underlined" value="${sistema.url}" maxlength="255"
               readonly="readonly">
    </div>

    <div class="form-group">
        <label class="control-label">Categoria</label>
        <input type="text" name="url" class="form-control underlined" value="${sistema.categoriaSistema.nome}" maxlength="255"
               readonly="readonly">
    </div>


    <div class="form-group">
        <g:actionSubmit action="edit" name="edit" class="btn btn-primary"
                        value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
        <g:actionSubmit action="delete" class="btn btn-danger"
                        value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        <g:actionSubmit action="index" name="cancelar" class="btn btn-secondary" value="Voltar"/>

    </div>

</g:form>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#menu_sistemas").addClass("active open");
    });
</script>
</body>
</html>
