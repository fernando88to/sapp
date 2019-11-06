<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main_thema"/>
    <title>Sistemas</title>
</head>

<body>


<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-block">
                <div class="card-title-block">
                    <h3 class="title">Responder Formulário</h3>
                </div>


                <ul class="nav nav-tabs nav-tabs-bordered">
                    <li class="nav-item">
                        <a class="nav-link active"  href="#menu1">1</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="#menu2">2</a>
                    </li>
                    <li class="nav-item">
                        <!--tirei a opção  data-toggle="tab", assim só pode navegar entre com os botoes -->
                        <a class="nav-link" href="#menu3">3</a>
                    </li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane container active" id="menu1">
                        <g:form method="POST">
                            <div class="form-group">
                                <label class="control-label">Selecione o sistema</label>
                                <g:select name="sistema" class="form-control underlined"
                                          from="${formulario.sistemaList}" optionKey="id"
                                    value="${formulario?.sistema?.id}"
                                          optionValue="${{it.nome + " - " + it.sigla}}"
                                    />
                            </div>
                            <g:actionSubmit action="avancarSelecaoSistema"
                                            class="btn btn-info" value="Avançar"></g:actionSubmit>
                        </g:form>


                    </div>
                    <div class="tab-pane container fade" id="menu2">
                        <g:form method="POST">
                            <div class="form-group">
                                <g:actionSubmit action="voltarParaSistemas"
                                                class="btn btn-info" value="Voltar"></g:actionSubmit>
                                <g:actionSubmit action="voltarParaSistemas"
                                                class="btn btn-info" value="Avançar"></g:actionSubmit>
                            </div>
                        </g:form>



                    </div>
                    <div class="tab-pane container fade" id="menu3">3</div>
                </div>




            </div>
        </div>
    </div>
</div>







<script type="text/javascript">
    $(document).ready(function () {
        $("#menu_sistemas").addClass("active open");
        $('.nav-tabs a[href="${params.menu ? params.menu : '#menu1' }"]').tab('show');


    });
</script>
</body>
</html>