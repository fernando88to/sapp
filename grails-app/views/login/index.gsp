<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>ModularAdmin - Free Dashboard Theme | HTML Version</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <!-- Place favicon.ico in the root directory -->
    <asset:stylesheet src="vendor.css"/>
    <asset:stylesheet src="app-blue.css"/>
    <!-- Theme initialization -->
    %{--<script>
        var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
            {};
        var themeName = themeSettings.themeName || '';
        if (themeName) {

            document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
        } else {
            document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
        }
    </script>--}%
</head>

<body>

<div class="auth">
    <div class="auth-container">
        <div class="card">
            <header class="auth-header">
                <h1 class="auth-title">
                     SAPP - ${message(code: 'sistema.nome')}
                </h1>
            </header>

            <div class="auth-content">


                <g:if test="${flash.message}">
                    <div class="form-group has-error">
                        <span id="username-error" class="has-error">${flash.message}</span>
                    </div>

                </g:if>




                <g:form id="login-form"  method="POST" >
                    <div class="form-group">
                        <label for="login">Login</label>
                        <input  class="form-control underlined" name="login"  autofocus id="login"
                               placeholder="Informe seu login" required>
                    </div>

                    <div class="form-group">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control underlined" name="senha" id="senha"
                               placeholder="Informe sua senha" required>
                    </div>

                    <div class="form-group">
                        <a href="reset.html" class="forgot-btn pull-right">Esqueceu a senha?</a>
                    </div>

                    <div class="form-group">
                        <g:actionSubmit action="logar" value="Login" class="btn btn-block btn-primary"></g:actionSubmit>
                    </div>
                </g:form>
            </div>
        </div>


    </div>
</div>
<!-- Reference block for JS -->
<div class="ref" id="ref">
    <div class="color-primary"></div>

    <div class="chart">
        <div class="color-primary"></div>

        <div class="color-secondary"></div>
    </div>
</div>
<script>

</script>

<asset:javascript src="vendor.js"/>
<asset:javascript src="app.js"/>


</body>
</html>
