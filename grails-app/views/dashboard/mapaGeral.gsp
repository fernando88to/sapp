<!doctype html>
<html>
<head>
    <title>Mapa</title>
    <style>
    #networkgraphdiv {
        /*min-width: 320px;*/
        /*max-width: 800px;*/
        margin: 0 auto;
        height: 600px;
        width: 100%;
    }
    </style>
</head>

<body>

<div>
    <section class="example">
        <div id="networkgraphdiv"></div>
    </section>
</div>


<div>
            <a href="#" onclick="window.history.back();">Voltar</a>


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



        var options = {
            chart: {
                renderTo: 'networkgraphdiv',
                type: 'networkgraph',
                plotBorderWidth: 1
            },
            title: {
                text: 'Rede de Interação'
            },
            /*subtitle: {
                text: 'Integration: ' + integration
            },*/
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
                        click: function (event) {
                            if(event.point.id==='tjto'){
                                window.location.href = "../dashboard/mapaSistema";
                            }else if(event.point.id==='selo_bronze'){
                            }else if(event.point.id==='selo_prata'){
                            }else if(event.point.id==='selo_ouro'){
                            }else if(event.point.id==='selo_platina'){
                            }else{

                                window.location.href = "../dashboard/detalhaSistema_1?nome="+event.point.name;
                            }

                        }
                    }
                }
            },
            point: {},
            series: [
                {
                    nodes: [
                        {
                        id: 'selo_bronze',
                        name: 'Selo Bronze',
                        dataLabels: {
                            enabled: true,
                            textPath: {
                                enabled: false
                            },
                            linkFormat: '',
                            allowOverlap: false
                        },
                        marker: {
                            fillColor: '#e76f51'
                        }
                    },
                        {
                        id: 'selo_prata',
                        name: 'Selo Prata',
                        dataLabels: {
                            enabled: true
                        },
                        marker: {

                            fillColor: '#264653'
                        }
                    },
                        {
                        id: 'selo_ouro',
                        name: 'Selo Ouro',
                        dataLabels: {
                            enabled: true
                        },
                        marker: {

                            fillColor: '#a8dadc'
                        }
                    },
                        {
                        id: 'selo_platina',
                        name: 'Selo Platina',
                        dataLabels: {
                            enabled: true
                        },
                        marker: {

                            fillColor: '#457b9d'
                        }
                    },
                        {
                        id: 'tjto',
                        name: 'Tribunal de Justiça do Tocantins',
                        dataLabels: {
                            enabled: true

                        },
                        marker: {

                            fillColor: 'brown'

                        }
                    }
                    ],
                    data: [
/*
                        ['selo_bronze', 'tjto'],
                        ['selo_prata', 'tjto']*/

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
        };


        var chart = new Highcharts.Chart(options);

        $.ajax({
            url: "mapaGeralAjax",
            dataType: "json",
            success: function (json) {

                for(let j in json){
                    chart.series[0].addPoint([json[j].id, json[j].to]);
                }


            },
            beforeSend: function () {
                chart.showLoading();
            },
            complete: function () {
                chart.hideLoading();
            }
        });

    })
    ;
</script>

</body>
</html>
