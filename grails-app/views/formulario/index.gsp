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

                <g:hasErrors bean="${this.formulario}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${this.formulario}" var="error">
                            <li class="has-error" <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                </g:hasErrors>


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
                            <g:actionSubmit action="importarDadosDaUltimoFormulario"
                                            class="btn btn-info" value="Importar Dados da última avaliação"></g:actionSubmit>
                        </g:form>

                    </div>
                    <g:each in="${formulario.grupoRequisitoList}" var="grupoRequisito" status="i">
                        <div class="tab-pane container fade" id="menu${i + 2}">

                            <g:form method="POST">
                                <g:hiddenField name="menuatual" value="${i + 2}"/>
                                <div class="form-group">
                                    <g:actionSubmit action="voltar"
                                                    class="btn btn-info" value="Voltar"></g:actionSubmit>
                                    <g:actionSubmit action="avancar"
                                                    class="btn btn-info" value="Avançar"></g:actionSubmit>
                                    <g:actionSubmit action="finalizar"
                                                    class="btn btn-info" value="Finalizar"></g:actionSubmit>
                                </div>
                            </g:form>

                            <div class="form-group">
                                <h3>${grupoRequisito.nome} - ${grupoRequisito.numeroReferenciaMoreqJus}</h3>
                            </div>

                            <g:each in="${grupoRequisito.subGrupoRequisitoList}" var="subGrupo" status="j">

                                <g:form method="POST" action="#">
                                    <h5>${subGrupo.numeroReferenciaMoreqJus} ${subGrupo.nome}
                                    <input type="hidden" name="subGrupo" id="subGrupo"  value="${subGrupo.id}" />
                                        <a href="#" class="clickable" data-target="#tabela${j}"
                                           title="Maximizar/Minimizar o Grupo"
                                           data-toggle="collapse">
                                            <em class="fa fa-unsorted"></em>
                                        </a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="#" class="marcarGrupoAtende" title="Marca o grupo todo como Atende" data-value="${subGrupo.id}">
                                            <em class="fa fa-thumbs-up"></em>
                                        </a>
                                        <a href="#" title="Marca o grupo todo como Não Atende" class="marcarGrupoNaoAtende" data-value="${subGrupo.id}">
                                            <em class="fa fa-thumbs-down"></em>
                                        </a>
                                        <a href="#" title="Marca o grupo todo como Não se aplica">
                                            <em class="fa fa-times"></em>
                                        </a>
                                </g:form>

                                </h5>

                                <table class="table table-striped">
                                    <tbody class="collapse show" id="tabela${j}">
                                    <g:each in="${subGrupo.requisitoList}" var="r">
                                        <g:form class="formulario_envio_requisito" action="salvarRegistro"
                                                method="POST">
                                            <g:hiddenField name="requisito" value="${r.id}"/>
                                            <tr>
                                                <td style="width: 70%;">
                                                    ${r.numeroReferenciaMoreqJus} - ${r.nome.encodeAsRaw()}
                                                </td>
                                                <td style="width: 10%;"
                                                    class="align-middle">${r.obrigatorio ? 'Obrigatório' : 'Opcional'}</td>
                                                <td style="width: 20%;" class="align-middle"><g:select
                                                        class="form-control form-control-sm campo_resposta grupo_resposta${subGrupo.id}"
                                                        name="resposta" from="${opcaoRespostaList}" optionKey="id"
                                                        value="${r.resposta}"
                                                        optionValue="descricao"/></td>
                                            </tr>
                                        </g:form>
                                    </g:each>
                                    </tbody>
                                </table>

                            </g:each>

                            <g:form method="POST">
                                <g:hiddenField name="menuatual" value="${i + 2}"/>
                                <div class="form-group">
                                    <g:actionSubmit action="voltar"
                                                    class="btn btn-info" value="Voltar"></g:actionSubmit>
                                    <g:actionSubmit action="avancar"
                                                    class="btn btn-info" value="Avançar"></g:actionSubmit>
                                    <g:actionSubmit action="finalizar"
                                                    class="btn btn-info" value="Finalizar"></g:actionSubmit>
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
        $("#menu_bash_board").addClass("active open");
        $('.nav-tabs a[href="${params.menu ? params.menu : '#menu1' }"]').tab('show');


        $('#carregando').modal({
            backdrop: 'static',
            keyboard: false,
            show:false
        });


        $(".marcarGrupoAtende").click(function () {

            var subgrupo = $(this).attr("data-value")
            var selectDoGrupo = '.grupo_resposta'+ subgrupo ;
            var tiporesposta = "1";

            $.ajax({
                type: "POST",
                url: "${request.contextPath}/formulario/atualizarEmLote",
                data: {
                    subgrupo: subgrupo,
                    tiporesposta: tiporesposta
                },
                success: function(dado){
                    $(selectDoGrupo).val(tiporesposta);




                }, beforeSend: function(){

                }

            }).done(function (dado) {

            });



            return;

        });

        $(".marcarGrupoNaoAtende").click(function () {

            var subgrupo = $(this).attr("data-value")
            var selectDoGrupo = '.grupo_resposta'+ subgrupo ;
            var tiporesposta = "2";

            $.ajax({
                type: "POST",
                url: "${request.contextPath}/formulario/atualizarEmLote",
                data: {
                    subgrupo: subgrupo,
                    tiporesposta: tiporesposta
                },
                success: function(dado){
                    $(selectDoGrupo).val(tiporesposta);




                }, beforeSend: function(){

                }

            }).done(function (dado) {

            });



            return;

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