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
        <div >

            <a href="#" onclick="window.history.back();">Voltar</a>
        </div>
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


        let options = {
            chart: {
                renderTo: 'networkgraphdiv',
                type: 'networkgraph',
                plotBorderWidth: 1
            },
            title: {
                text: 'Sistema 2'
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
                        click: function(event) {
                            /*if(event.point.id==='sistema'){
                                window.location.href = "../dashboard/mapaSistema";
                            }else if(event.point.id==='atende'){

                            }else if(event.point.id==='nao_atende'){

                            }else{
                                window.location.href = "../dashboard/detalhaSistema_1";
                            }*/

                        }
                    }
                }
            },
            point:{

            },
            series: [
                {
                    nodes: [{
                        id: 'nao_atende',
                        name:'Não Atende',
                        dataLabels: {
                            enabled: true,
                            textPath: {
                                enabled: false
                            },
                            linkFormat: '',
                            allowOverlap: true
                        },
                        marker: {

                            fillColor: 'red'
                        }
                    }, {
                        id: 'atende',
                        name:'Atende',
                        dataLabels: {
                            enabled: true,
                            allowOverlap: true
                        },
                        marker: {

                            fillColor: 'green'
                        }
                    }, {
                        id: 'sistema',
                        name:'E-Proc',
                        dataLabels: {
                            enabled: true,
                            allowOverlap: true

                        },
                        marker: {

                            fillColor:'brown'

                        }
                    }
                    ],
                    data: [
                        ['nao_atende', 'sistema'],
                        ['atende', 'sistema']





                    ],


                    marker: {
                        radius: 13
                    },
                    dataLabels: {
                        enabled: true,
                        textPath: {
                            enabled: true
                        },
                        linkFormat: '',
                        allowOverlap: false
                    }



                }]
        };

        var chart = new Highcharts.Chart(options);

        $.ajax({
            url: "detalhaSistema_2_ajax",
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

















    });
</script>

</body>
</html>
