<!doctype html>
<html>
<head>
    <meta name="layout" content="main_thema"/>
    <title>DashBoard</title>
</head>

<body>

<div class="row">
    <div class="col-md-10"></div>

    <div class="col-md-1">
        <g:link controller="formulario" action="index">
            <button type="button" class="btn btn-info"><g:textoBotaoResponderFormulraio /> </button>
        </g:link>
    </div>
</div>


<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-block">
                <div class="card-title-block">
                    <h3 class="title">Selecione um Sistema</h3>
                </div>
                <section class="example">

                    <div class="row form-group">

                        <div class="col-12">
                            <g:select class="form-control form-control-sm campo_resposta"
                                      name="sistema" from="${sistemasList}" optionKey="id"
                                      value="" noSelection="${['': 'Selecione...']}"
                                      optionValue="nome"/>
                        </div>
                    </div>

                </section>
            </div>
        </div>
    </div>

</div>


<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-block">
                %{--<div class="card-title-block">
                    <h3 class="title"> Bar Chart Example </h3>
                </div>--}%
                <section class="example">
                    <div id="container" style="width:100%; height:400px;"></div>
                </section>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-block">
                <section class="example">
                    <div id="containerGraficoQuantidadeAtendidoNaoAtendido" style="width:100%; height:400px;"></div>
                </section>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-block">
                <div class="card-title-block">
                    <h3 class="title"> Título </h3>
                </div>
                <section class="example">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Capitulos</th>
                            <th>Em conformidade</th>
                            <th>Não Conforme</th>
                            <th>Não se aplica</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>Organização dos documentos (plano de classificação)</th>
                            <td>X</td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Captura</th>
                            <td></td>
                            <td>X</td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Armazenamento</th>
                            <td></td>
                            <td></td>
                            <td>X</td>
                        </tr>
                        <tr>
                            <th>Preservação</th>
                            <td></td>
                            <td>X</td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Segurança</th>
                            <td>X</td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Tramitação</th>
                            <td>X</td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Destinação</th>
                            <td>X</td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Pesquisa, localização e apresentação das informações</th>
                            <td></td>
                            <td>X</td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Funções administrativas</th>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Usabilidade</th>
                            <td>X</td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Interoperabilidade</th>
                            <td>X</td>
                            <td></td>
                            <td></td>
                        </tr>

                        <tr>
                            <th>Disponibilidade</th>
                            <td>X</td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>Desempenho</th>
                            <td></td>
                            <td></td>
                            <td>X</td>
                        </tr>

                        </tbody>
                    </table>
                </section>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-block">
                <section class="example">
                    <div id="containerGraficoEvolucao" style="width:100%; height:400px;"></div>
                </section>
            </div>
        </div>
    </div>
</div>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#menu_bash_board").addClass("active open");


        Highcharts.setOptions({
            lang: {
                decimalPoint: ',',
                thousandsSep: '.',
                loading: 'Carregando Gráfico, Aguarde....'
            },

            tooltip: {
                yDecimals: 2 // If you want to add 2 decimals
            },
            exporting: {
                buttons: {
                    contextButton: {
                        enabled: false
                    },
                    printButton: {
                        text: 'Imprimir',
                        onclick: function () {
                            this.print();
                        }
                    }
                }
            },
            credits: {
                text: 'sdsdf',
                href: 'http://site'
            }
        });


        var myChart = Highcharts.chart('container', {
            chart: {
                type: 'pie'
            },
            title: {
                text: 'Porcentagem de Conformidade Atual'
            },
            yAxis: {
                title: {
                    text: 'Fruit eaten'
                }
            },
            series: [{
                type: 'pie',
                name: 'Porcentagem de conformidade do sistema',
                data: [
                    ['Requisitos Atendidos', 50.0],
                    ['Requisitos não atendisos', 40.0],
                    ['Não se aplica', 10.0]
                ]
            }]
        });


        Highcharts.chart('containerGraficoQuantidadeAtendidoNaoAtendido', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Raio X'
            },
            xAxis: {
                categories: ['Organização dos documentos (plano de classificação)',
                    'Capitulo 3', 'Capitulo 4']
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Porcentagem'
                },
                stackLabels: {
                    enabled: true,
                    style: {
                        fontWeight: 'bold',
                        color: ( // theme
                            Highcharts.defaultOptions.title.style &&
                            Highcharts.defaultOptions.title.style.color
                        ) || 'gray'
                    }
                }
            },
            legend: {
                align: 'right',
                x: -30,
                verticalAlign: 'top',
                y: 25,
                floating: true,
                backgroundColor:
                    Highcharts.defaultOptions.legend.backgroundColor || 'white',
                borderColor: '#CCC',
                borderWidth: 1,
                shadow: false
            },
            tooltip: {
                headerFormat: '<b>{point.x}</b><br/>',
                pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
            },
            plotOptions: {
                column: {
                    stacking: 'normal',
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            series: [{
                name: 'Requisito Atendidos',
                data: [25, 35, 80]
            }, {
                name: 'Requisitos Não Atendidos',
                data: [50, 50, 20]
            }, {
                name: 'Não Se aplica',
                data: [25, 15, 10]
            }]
        });


        Highcharts.chart('containerGraficoEvolucao', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Histórico de Conformidade'
            },
            xAxis: {
                categories: ['2017', '2018', '2019']
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Porcentagem'
                },
                stackLabels: {
                    enabled: true,
                    style: {
                        fontWeight: 'bold',
                        color: ( // theme
                            Highcharts.defaultOptions.title.style &&
                            Highcharts.defaultOptions.title.style.color
                        ) || 'gray'
                    }
                }
            },
            legend: {
                align: 'right',
                x: -30,
                verticalAlign: 'top',
                y: 25,
                floating: true,
                backgroundColor:
                    Highcharts.defaultOptions.legend.backgroundColor || 'white',
                borderColor: '#CCC',
                borderWidth: 1,
                shadow: false
            },
            tooltip: {
                headerFormat: '<b>{point.x}</b><br/>',
                pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
            },
            plotOptions: {
                column: {
                    stacking: 'normal',
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            series: [{
                name: 'Requisito Atendidos',
                data: [25, 35, 80]
            }, {
                name: 'Requisitos Não Atendidos',
                data: [50, 50, 20]
            }, {
                name: 'Não Se aplica',
                data: [25, 15, 10]
            }]
        });


    });
</script>

</body>
</html>
