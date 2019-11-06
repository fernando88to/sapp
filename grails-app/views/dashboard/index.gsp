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
        <g:link controller="formulario" action="index" >
            <button type="button" class="btn btn-info">Responder Questionário</button>
        </g:link>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        $( "#menu_bash_board" ).addClass( "active open" );
    });
</script>


</body>
</html>
