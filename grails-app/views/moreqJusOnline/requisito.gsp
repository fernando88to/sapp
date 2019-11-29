<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main_thema" />
    <title>Moreq-JUS - Requisitos</title>
</head>
<body>


<div class="title-block">
    <h1 class="title"> Moreq-JUS - Requisitos </h1>
</div>

<div class="row">
    <div class="col-md-8"></div>
    <div class="col-md-4">

        <g:form>
            <g:hiddenField name="id" value="${subGrupoInstance.grupoRequisito.id}" />
            <section class="section">
                <button type="button" class="btn btn-primary">Mostrar Resumo</button>
                <g:actionSubmit action="subGrupo"  type="button" class="btn btn-secondary" value="Voltar"></g:actionSubmit>
            </section>
        </g:form>
    %{--<g:link action="index" >
        <button type="button" class="btn btn-secondary">Mostrar Resumo</button>
        <button type="button" class="btn btn-secondary">Voltar</button>
    </g:link>--}%
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card items">
                <ul class="item-list striped">
                    <li class="item item-list-header">
                        <div class="item-row">

                            <div class="item-col item-col-header fixed item-col-img md">
                                <div>
                                    <span>Número Moreq-Jus</span>
                                </div>
                            </div>
                            <div class="item-col item-col-header item-col-title">
                                <div>
                                    <span>Nome</span>
                                </div>
                            </div>


                        </div>
                    </li>

                    <g:each in="${requisitosList}" var="r">
                        <li class="item">
                            <div class="item-row">

                                <div class="item-col fixed item-col-img md">

                                        ${r.numeroReferenciaMoreqJus}

                                </div>
                                <div class="item-col fixed pull-left item-col-title">
                                    <div class="item-heading">Nome</div>
                                    <div>

                                            <h4 class="item-title"> ${r.nome.encodeAsRaw()}</h4>

                                    </div>
                                </div>






                            </div>
                        </li>
                    </g:each>


                </ul>
            </div>
        </div>
    </div>

</div>




<script type="text/javascript">
    $(document).ready(function(){
        $( "#menu_moreqjusonline" ).addClass( "active open" );
    });
</script>


</body>
</html>
