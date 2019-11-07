<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main_thema"/>
    <title>Sistemas</title>
    <style type="text/css">
    .bd-example-modal-lg .modal-dialog {
        display: table;
        position: relative;
        margin: 0 auto;
        top: calc(50% - 24px);
    }

    .bd-example-modal-lg .modal-dialog .modal-content {
        background-color: transparent;
        border: none;
    }
    </style>
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
                        <a class="nav-link active" href="#menu1">1</a>
                    </li>
                    <g:each in="${formulario.grupoRequisitoList}" var="grupoRequisito" status="i">
                        <li class="nav-item">
                            <!--tirei a opção  data-toggle="tab", assim só pode navegar entre com os botoes -->
                            <a class="nav-link" href="#menu${i + 2}">${i + 2}</a>
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
                                          optionValue="${{ it.nome + " - " + it.sigla }}"/>
                            </div>
                            <g:actionSubmit action="avancarSelecaoSistema"
                                            class="btn btn-info" value="Avançar"></g:actionSubmit>
                        </g:form>

                    </div>
                    <g:each in="${formulario.grupoRequisitoList}" var="grupoRequisito" status="i">
                        <div class="tab-pane container fade" id="menu${i + 2}">

                            <div class="form-group">
                                <h5>${grupoRequisito.nome} - ${grupoRequisito.numeroReferenciaMoreqJus}</h5>
                            </div>

                            <g:each in="${grupoRequisito.subGrupoRequisitoList}" var="subGrupo">
                                <p>${subGrupo.numeroReferenciaMoreqJus} ${subGrupo.nome}</p>

                                <g:each in="${subGrupo.requisitoList}" var="r">

                                    <g:form class="formulario_envio_requisito" action="salvarRegistro" method="POST">
                                        <g:hiddenField name="requisito" value="${r.id}"/>
                                        <div class="row form-group">
                                        <div class="col-7">
                                            <textarea rows="4" class="form-control"
                                                      readonly="readonly">${r.numeroReferenciaMoreqJus} - ${r.nome}</textarea>
                                        </div>

                                        <div class="col-3">
                                            <input type="text" class="form-control" readonly="readonly"
                                                   value="${r.obrigatorio ? 'Obrigatório' : 'Opcional'}"/>
                                        </div>

                                        <div class="col-2">
                                            <g:select class="form-control form-control-sm campo_resposta"
                                                      name="resposta" from="${opcaoRespostaList}" optionKey="id"
                                                value="${r.resposta}"
                                                optionValue="descricao"

                                             />
                                            %{--<select class="form-control form-control-sm campo_resposta" name="resposta">
                                                <option value="0"></option>
                                                <option value="1">Atende</option>
                                                <option value="2">Não Atende</option>
                                                <option value="3">Não se aplica</option>

                                            </select>--}%
                                        </div>
                                    </div>
                                    </g:form>
                                </g:each>

                            </g:each>

                            <g:form method="POST">
                                <g:hiddenField name="menuatual" value="${i + 2}"/>
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

<div  id="carregando" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered justify-content-center" role="document">
        <span class="fa fa-spinner fa-spin fa-3x"></span>
    </div>
</div>






<script type="text/javascript">


    $(document).ready(function () {
        $("#menu_sistemas").addClass("active open");
        $('.nav-tabs a[href="${params.menu ? params.menu : '#menu1' }"]').tab('show');


        $('#carregando').modal({
            backdrop: 'static',
            keyboard: false,
            show:false
        });



        //quando mudar o campo do select ele envia automaticamente o formulario
        $(".campo_resposta").change(function () {
            var requisito = this.form.requisito.value;
            var resposta = this.form.resposta.value;


            $.ajax({
                type: "POST",
                url: "${request.contextPath}/formulario/salvarRegistro",
                data: {
                    requisito: requisito,
                    resposta: resposta
                },
                success: function(dado){
                   //$('#carregando').modal('hide');


                }, beforeSend: function(){
                    //$('#carregando').modal('show');
                }

            }).done(function (dado) {
                //$('.modal').modal('hide');
            });


        });




    });
</script>
</body>
</html>