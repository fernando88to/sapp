<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_thema" />
        <g:set var="entityName" value="${message(code: 'instituicao.label', default: 'Instituicao')}" />
        <title>Instituição</title>
    </head>
    <body>



    <div class="card card-block sameheight-item" style="height: 726px;">
        <div class="title-block">
            <h3 class="title"> Instituição </h3>
            <p>Informe os dados da sua instituição</p>
        </div>


        <g:if test="${flash.message}">
            <div class="text-success" role="status">${flash.message}</div>
        </g:if>


        <g:form  role="form" resource="${instituicao}" method="PUT">
            <g:hiddenField name="id" value="${instituicao.id}" />
            <g:hasErrors bean="${this.instituicao}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${instituicao}" var="error">
                        <li class="has-error" <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>

            <div class="form-group">
                <label class="control-label">Nome</label>
                <input type="text" name="nome" class="form-control underlined" value="${instituicao.nome}" maxlength="255">
            </div>


            <div class="form-group">
                <label class="control-label">Sigla</label>
                <input type="text" name="sigla" class="form-control underlined" value="${instituicao.sigla}" maxlength="255">
            </div>

            <div class="form-group">
                <label class="control-label">Endereço</label>
                <input type="text" name="endereco" class="form-control underlined" value="${instituicao.endereco}" maxlength="255">
            </div>


            <div class="form-group">
                <g:actionSubmit action="update" name="create" class="btn btn-primary" value="${message(code: 'default.button.update.label', default: 'Update')}" />
            </div>



        </g:form>




        <script type="text/javascript">
            $(document).ready(function(){
                $( "#menu_instituicao" ).addClass( "active open" );
            });
        </script>


    </body>
</html>
