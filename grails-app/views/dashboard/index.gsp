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
                    <h3 class="title">Gerar estatística</h3>
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

                <section class="example">
                    <div id="containerPizza" style="width:100%; height:400px;"></div>
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
                <section class="example">
                    <div id="containerGraficoEvolucao" style="width:100%; height:400px;"></div>
                </section>
            </div>
        </div>
    </div>
</div>





%{--<div class="row">
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
</div>--}%


%{--<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-block">
                <section class="example">
                    <div id="containerGraficoEvolucao" style="width:100%; height:400px;"></div>
                </section>
            </div>
        </div>
    </div>
</div>--}%

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
                text: 'Sistema de Acompanhamento de Políticas de Preservação de Documentos Digitais ',
            }
        });


        $("#sistema").change(function () {

            var optionPizza =  {
                chart: {
                    type: 'pie',
                    renderTo: 'containerPizza',
                },
                title: {
                    text: 'Porcentagem de Conformidade Atual'
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            color: '#000000',
                            connectorColor: '#000000',
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: 'Porcentagem de conformidade do sistema',
                    data: [

                    ]
                }]
            };

            var sistema = this.value;
            $.getJSON('${request.contextPath}/dashboard/chamadaPizzaExtra/'+sistema, function(json) {
                optionPizza.series = json;
                optionPizza.title =  {
                    text: 'Porcentagem de Conformidade em 2019'
                }
                var chartpizza = new Highcharts.Chart(optionPizza);
                //chartpizza.redraw();
            });


            var optionsColuna = {
                chart: {
                    renderTo: 'containerGraficoQuantidadeAtendidoNaoAtendido',
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
                        text: 'Quantidade de Requisitos'
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

                series: []

            };

            var chartColuna = new Highcharts.Chart(optionsColuna);
            $.getJSON('${request.contextPath}/dashboard/raioxcoluna/'+sistema, function(json) {
                var dados =json.dados;
                for(i=0; i<dados.length; i++){
                    chartColuna.addSeries({
                        name: dados[i].name,
                        data: dados[i].data
                    }, true);
                    console.log(json.categorias);
                    chartColuna.xAxis[0].setCategories(json.categorias);

                };
                chartColuna.redraw();
            });



            var optionGraficoEvolucao =  {
                chart: {
                    renderTo: 'containerGraficoEvolucao',
                },
                title: {
                    text: 'Evolução Anual dos Requisitos'
                },



                yAxis: {
                    title: {
                        text: 'Porcentagem'
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                plotOptions: {
                    series: {
                        label: {
                            connectorAllowed: false
                        },
                        pointStart: 2017
                    }
                },
                series: [],
            };



            var chartEvolucao = new Highcharts.Chart(optionGraficoEvolucao);
            $.getJSON('${request.contextPath}/dashboard/evolucao/'+sistema, function(json) {
                for(i=0; i<json.length; i++){
                    chartEvolucao.addSeries({
                        name: json[i].name,
                        data: json[i].data
                    }, true);
                };
                chartEvolucao.redraw();
            });
        });





        /*Highcharts.chart('containerGraficoQuantidadeAtendidoNaoAtendido', {
            chart: {
                type: 'column',
                renderTo: 'containerGraficoQuantidadeAtendidoNaoAtendido',
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
            series: []
        });*/


        /*Highcharts.chart('containerGraficoEvolucao', {
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
        });*/


    });
</script>

</body>
</html>
