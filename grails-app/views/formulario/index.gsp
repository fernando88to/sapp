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
                    <g:each in="${formulario.grupoRequisitoList}" var="grupoRequisito" status="i">
                    <li class="nav-item">
                        <!--tirei a opção  data-toggle="tab", assim só pode navegar entre com os botoes -->
                        <a class="nav-link" href="#menu${i+2}">${i+2}</a>
                    </li>
                    </g:each>
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
                    <g:each in="${formulario.grupoRequisitoList}" var="grupoRequisito" status="i">
                        <div class="tab-pane container fade" id="menu${i+2}">
                            <g:form method="POST">
                                <g:hiddenField name="menuatual" value="${i+2}" />
                                <div class="form-group">
                                    <h5>${grupoRequisito.nome} - ${grupoRequisito.numeroReferenciaMoreqJus}</h5>
                                </div>

                                <g:each in="${grupoRequisito.subGrupoRequisitoList}" var="subGrupo">
                                        <p>${subGrupo.numeroReferenciaMoreqJus} ${subGrupo.nome}</p>

                                        <g:each in="${subGrupo.requisitoList}" var="r">


                                            <div class="row form-group">
                                                <div class="col-7">
                                                    <textarea rows="4" class="form-control"  readonly="readonly" >${r.numeroReferenciaMoreqJus} - ${r.nome}</textarea>
                                                </div>
                                                <div class="col-3">
                                                    <input type="text" class="form-control"  readonly="readonly" value="${r.obrigatorio ? 'Obrigatório' : 'Opcional'}" />
                                                </div>
                                                <div class="col-2">
                                                    <select class="form-control form-control-sm">
                                                        <option></option>
                                                        <option>Atende</option>
                                                        <option>Não Atende</option>
                                                        <option>Não se aplica</option>

                                                    </select>
                                                </div>
                                            </div>
                                        </g:each>


                                </g:each>

                                <div class="form-group">
                                    <g:actionSubmit action="voltar"
                                                    class="btn btn-info" value="Voltar"></g:actionSubmit>
                                    <g:actionSubmit action="avancar"
                                                    class="btn btn-info" value="Avançar"></g:actionSubmit>
                                </div>
                            </g:form>



                        </div>

                    </g:each>


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