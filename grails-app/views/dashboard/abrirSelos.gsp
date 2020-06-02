<!doctype html>
<html>
<head>
    <meta name="layout" content="main_thema"/>
    <title>Selos</title>
</head>

<body>

<g:form controller="dashboard" action="gerarProbalidadeSelos" id="target" method="POST">
<div class="row">

        <div class="col-md-12">
            <div class="card">
                <div class="card-block">
                    <div class="card-title-block">
                        <h3 class="title">Analisar Probabilidade</h3>
                    </div>
                    <section class="example">

                        <div class="row form-group">

                            <div class="col-12">
                                <g:select class="form-control form-control-sm campo_resposta"
                                          name="sistema" from="${sapp.CategoriaSistema.list()}" optionKey="id"
                                          value="" noSelection="${['': 'Selecione...']}"
                                          optionValue="nome"/>
                            </div>
                        </div>

                    </section>

                    <section class="example" >
                        <div id="retornoAjax"></div>
                    </section>


                    <section class="example2" >
                        <p>Observação*: Os selos foram foram instituidos pelo CNJ</p>
                        <p>Observação**: A probabilidade vai de 0 a 1, quanto mais próxima de 1, maior a chance do evento ocorrer.</p>
                    </section>


                </div>
            </div>
        </div>
</div>
</g:form>




























<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/networkgraph.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#menu_bash_board").addClass("active open");

        $(".example2").hide();
        $("#sistema").change(function () {

            $.post('${request.contextPath}/dashboard/gerarProbalidadeSelos/'+this.value, function(date) {
               //$("#retornoAjax").append(json);
                //console.log("teste")
                //console.log(json);
                //$("#retornoAjax").append("<p>Foi</p>");
                $("#retornoAjax").html(date);
                $(".example2").show();
            });

        });
    });
</script>

</body>
</html>
