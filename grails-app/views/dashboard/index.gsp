<!doctype html>
<html>
<head>
    <meta name="layout" content="main_thema"/>
    <title>DashBoard</title>
</head>

<body>

<div class="title-block">
    <h3 class="title">Sapp - Tela Inicial</h3>

    <p class="title-description">Acesse aqui as principais  funcionalidades do sistema</p>
</div>


<section class="section">
    <div class="row">

        <div class="col-xl-4">
            <div class="card card-primary">
                <div class="card-header">
                    <div class="header-block">
                        <p class="title">Responder Questionário</p>
                    </div>
                </div>

                <div class="card-block">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                </div>


                <div class="card-footer">
                    <g:link controller="formulario" action="index">

                        Acessar
                    </g:link>
                </div>
            </div>
        </div>


        <!-- /.col-xl-4 -->
        <div class="col-xl-4">
            <div class="card card-primary">
                <div class="card-header">
                    <div class="header-block">
                        <p class="title">Estatística</p>
                    </div>
                </div>
                <div class="card-block">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                </div>

                <div class="card-footer">
                    <g:link controller="dashboard" action="estatistica">
                        Acessar
                    </g:link>
                </div>
            </div>
        </div>
        <!-- /.col-xl-4 -->
        <div class="col-xl-4">
            <div class="card card-success">
                <div class="card-header">
                    <div class="header-block">
                        <p class="title">Grafos</p>
                    </div>
                </div>

                <div class="card-block">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                </div>

                <div class="card-footer">Acessar</div>
            </div>
        </div>
        <!-- /.col-xl-4 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-4">
            <div class="card card-warning">
                <div class="card-header">
                    <div class="header-block">
                        <p class="title">Selos</p>
                    </div>
                </div>
                <div class="card-block">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                </div>

                <div class="card-footer">
                    <g:link controller="dashboard" action="abrirSelos">
                        Acessar
                    </g:link>

                </div>
            </div>
        </div>
        <!-- /.col-xl-4 -->

    </div>
    <!-- /.row -->
</section>



<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/networkgraph.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#menu_bash_board").addClass("active open");


    });
</script>

</body>
</html>
