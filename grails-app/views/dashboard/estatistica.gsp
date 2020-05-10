<!doctype html>
<html>
<head>
    <meta name="layout" content="main_thema"/>
    <title>DashBoard</title>
</head>

<body>

%{--<div class="row">
    <div class="col-md-10"></div>

    <div class="col-md-1">
        <g:link controller="formulario" action="index">
            <button type="button" class="btn btn-info"><g:textoBotaoResponderFormulraio /> </button>
        </g:link>
    </div>
</div>--}%


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




<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-block">
                <section class="example">
                    <div id="networkgraphdiv" style="width:100%; height:400px;"></div>
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
                    <h3 class="title"> Metadados </h3>
                </div>
                <section class="example">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Código</th>
                            <th>Metadado</th>

                        </tr>
                        </thead>
                        <tbody id="tbodymetadados">


                        </tbody>
                    </table>
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
<script src="https://code.highcharts.com/modules/networkgraph.js"></script>
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



            $("#tbodymetadados").empty();


            $.getJSON('${request.contextPath}/dashboard/metadados/'+sistema, function(json) {
                for(i=0; i<json.length; i++){
                    $("#tbodymetadados").append(
                        "<tr scope=\"row\">" +
                        "<td>"+ json[i].numeroReferenciaMoreqJus + "</td>" +
                        "<td>"+json[i].definicao+"</td>" +
                        " </tr>"
                    );

                };

            });



            let integration = "euler";
            let linkLength = 10;
            Highcharts.chart("networkgraphdiv", {
                chart: {
                    type: 'networkgraph',
                    plotBorderWidth: 1
                },
                title: {
                    text: 'Phrasal verbs'
                },
                subtitle: {
                    text: 'Integration: ' + integration
                },
                plotOptions: {
                    networkgraph: {
                        layoutAlgorithm: {
                            enableSimulation: true,
                            integration: integration,
                            linkLength: linkLength
                        },
                        keys: ['from', 'to'],
                        marker: {
                            radius: 5,
                            lineWidth: 1
                        }
                    },
                    series: {
                        cursor: 'pointer',
                        events: {
                            click: function(event) {
                                console.log(event.point);
                                console.log(event.point.id);

                            }
                        }
                    }
                },
                point:{

                },
                series: [
                    {
                        nodes: [{
                            id: 'for',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 2,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'up',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 15,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'back',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 2.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'away',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 2.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'down',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 5.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'on',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 7.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'out',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 13.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'off',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 6.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'break',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 3
                            }
                        }, {
                            id: 'into',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 2,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'in',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 4,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'get',
                            marker: {
                                radius: 8.5
                            }
                        }, {
                            id: 'over',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 1.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'look',
                            marker: {
                                radius: 3
                            }
                        }, {
                            id: 'put',
                            marker: {
                                radius: 2
                            }
                        }, {
                            id: 'run',
                            marker: {
                                radius: 1.5
                            }
                        }, {
                            id: 'take',
                            marker: {
                                radius: 2.5
                            }
                        }, {
                            id: 'down on',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 1.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'keep',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 1.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'fun of',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 1.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'care of',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 1.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'by',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 1.5,
                                fillColor: 'red'
                            }
                        }, {
                            id: 'out of',
                            dataLabels: {
                                enabled: true
                            },
                            marker: {
                                radius: 1.5,
                                fillColor: 'red'
                            }
                        }],
                        data: [
                            ['abide', 'by'],
                            ['account', 'for'],
                            ['add', 'up'],
                            ['allow', 'for'],
                            ['apply', 'for'],
                            ['back', 'away'],
                            ['back', 'down'],
                            ['back', 'up'],
                            ['bank', 'on'],
                            ['black', 'out'],
                            ['block', 'off'],
                            ['blow', 'up'],
                            ['boot', 'up'],
                            ['break', 'away'],
                            ['break', 'down'],
                            ['break', 'into'],
                            ['break', 'out'],
                            ['break', 'up'],
                            ['bring', 'up'],
                            ['brush', 'up'],
                            ['bump', 'into'],
                            ['burn', 'out'],
                            ['call', 'back'],
                            ['call', 'off'],
                            ['calm', 'down'],
                            ['carry', 'on'],
                            ['carry', 'out'],
                            ['check', 'in'],
                            ['check', 'out'],
                            ['clam', 'up'],
                            ['clamp', 'down on'],
                            ['count', 'on'],
                            ['cut', 'down on'],
                            ['cut', 'out'],
                            ['die', 'down'],
                            ['drag', 'on'],
                            ['draw', 'up'],
                            ['dress', 'up'],
                            ['ease', 'off'],
                            ['end', 'in'],
                            ['end', 'up'],
                            ['figure', 'out'],
                            ['fill', 'out'],
                            ['find', 'out'],
                            ['focus', 'on'],
                            ['get', 'along'],
                            ['get', 'at'],
                            ['get', 'away'],
                            ['get', 'by'],
                            ['get', 'in'],
                            ['get', 'into'],
                            ['get', 'off'],
                            ['get', 'on'],
                            ['get', 'out'],
                            ['get', 'over'],
                            ['get', 'rid of'],
                            ['get', 'together'],
                            ['get', 'up'],
                            ['give', 'in'],
                            ['give', 'up'],
                            ['grow', 'up'],
                            ['hand', 'in'],
                            ['hand', 'out'],
                            ['hang', 'out'],
                            ['hang', 'up'],
                            ['hold', 'on'],
                            ['hurry', 'up'],
                            ['iron', 'out'],
                            ['join', 'in'],
                            ['join', 'up'],
                            ['keep', 'on'],
                            ['keep', 'up with'],
                            ['kick', 'off'],
                            ['leave', 'out'],
                            ['let', 'down'],
                            ['look', 'after'],
                            ['look', 'down on'],
                            ['look', 'on'],
                            ['look', 'for'],
                            ['look', 'forward to'],
                            ['look', 'up to'],
                            ['make', 'fun of'],
                            ['make', 'up'],
                            ['mix', 'up'],
                            ['move', 'in'],
                            ['move', 'out'],
                            ['nod', 'off'],
                            ['own', 'up'],
                            ['pass', 'away'],
                            ['pass', 'out'],
                            ['pay', 'back'],
                            ['put', 'off'],
                            ['put', 'on'],
                            ['put', 'out'],
                            ['put', 'up'],
                            ['pick', 'up'],
                            ['point', 'out'],
                            ['rely', 'on'],
                            ['rule', 'out'],
                            ['run', 'away'],
                            ['run', 'into'],
                            ['run', 'out of'],
                            ['set', 'off'],
                            ['set', 'up'],
                            ['show', 'off'],
                            ['show', 'up'],
                            ['shut', 'up'],
                            ['sit', 'down'],
                            ['stand', 'up'],
                            ['take', 'after'],
                            ['take', 'care of'],
                            ['take', 'off'],
                            ['take', 'on'],
                            ['take', 'out'],
                            ['tell', 'off'],
                            ['think', 'over'],
                            ['try', 'on'],
                            ['turn', 'down'],
                            ['use', 'up'],
                            ['watch', 'out'],
                            ['wear', 'out'],
                            ['work', 'out'],
                            ['wipe', 'off']
                        ]



                    }]
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
