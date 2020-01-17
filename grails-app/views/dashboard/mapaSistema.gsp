<!doctype html>
<html>
<head>
    <title>Mapa</title>
    <style>
    #networkgraphdiv {
        min-width: 320px;
        max-width: 800px;
        margin: 0 auto;
        height: 500px;
    }
    </style>
</head>

<body>








<div>
    <section class="example">
        <div id="networkgraphdiv" ></div>
    </section>
</div>






<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/networkgraph.js"></script>
<script type="text/javascript">
    $(document).ready(function () {



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

        let integration = "verlet";
        //let integration = "euler";
        //let linkLength = 10;
        let linkLength = 100;
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
                            //window.location.href = "../dashboard";
                            if(event.point.id==='sistema'){
                                console.log("nó de sistemas");
                            }
                            //console.log(event.point);
                            //console.log(event.point.id);

                        }
                    }
                }
            },
            point:{

            },
            series: [
                {
                    nodes: [{
                        id: 'tjto',
                        name:'Tribunal de Justiça',
                        dataLabels: {
                            enabled: true,
                            textPath: {
                                enabled: false
                            },
                            linkFormat: '',
                            allowOverlap: false
                        },
                    },{
                        id: 'judicial',
                        name:'Judicial',
                        dataLabels: {
                            enabled: true
                        }

                    },{
                        id: 'extrajudicial',
                        name: 'Extra-Judicial',
                        dataLabels: {
                            enabled: true

                        }

                    },
                        {
                            id: 'administrativo',
                            name: 'Administrativo',
                            dataLabels: {
                                enabled: true

                            }

                        }
                    ],
                    data: [
                        ['judicial', 'tjto'],
                        ['extrajudicial', 'tjto'],
                        ['administrativo', 'tjto']


                    ],


                    marker: {
                        radius: 13
                    },
                    dataLabels: {
                        enabled: true,
                        textPath: {
                            enabled: false
                        },
                        linkFormat: '',
                        allowOverlap: true
                    }



                }]
        });
















    });
</script>

</body>
</html>
