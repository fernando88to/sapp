<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main_thema" />
    <title>Moreq-JUS</title>
</head>
<body>


<div class="title-block">
    <h1 class="title"> Moreq-JUS   - Capítulos </h1>
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

                    <g:each in="${grupoRequisitosList}" var="r">
                        <li class="item">
                            <div class="item-row">

                                <div class="item-col fixed item-col-img md">
                                    <g:link action="subGrupo" params="[id:r.id]" >
                                        ${r.numeroReferenciaMoreqJus}
                                    </g:link>
                                </div>
                                <div class="item-col fixed pull-left item-col-title">
                                    <div class="item-heading">Name</div>
                                    <div>
                                        <g:link action="subGrupo" params="[id:r.id]" >
                                            <h4 class="item-title"> ${r.nome}</h4>
                                        </g:link>
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
