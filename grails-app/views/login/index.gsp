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
                <form id="login-form" action="/index.html" method="GET" novalidate="">
                    <div class="form-group">
                        <label for="username">Login</label>
                        <input type="email" class="form-control underlined" name="username" id="username"
                               placeholder="Your email address" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Senha</label>
                        <input type="password" class="form-control underlined" name="password" id="password"
                               placeholder="Your password" required>
                    </div>

                    <div class="form-group">
                        <a href="reset.html" class="forgot-btn pull-right">Esqueceu a senha?</a>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-block btn-primary">Login</button>
                    </div>
                </form>
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
