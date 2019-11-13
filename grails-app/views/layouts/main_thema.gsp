<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <!-- Place favicon.ico in the root directory -->
    <asset:stylesheet src="vendor.css"/>
    <asset:stylesheet src="app-blue.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>



<div class="main-wrapper">
    <div class="app" id="app">
        <header class="header">
            <div class="header-block header-block-collapse d-lg-none d-xl-none">
                <button class="collapse-btn" id="sidebar-collapse-btn">
                    <i class="fa fa-bars"></i>
                </button>
            </div>


            <div class="header-block header-block-nav">
                <ul class="nav-profile">

                    <li class="profile dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                            <span class="name"> ${sapp.GestaoDaSessao.usuarioLogado(session).nome} </span>
                        </a>
                        <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">


                            <g:link controller="usuario" action="editPerfilLogado" class="dropdown-item" href="#">
                                <i class="fa fa-gear icon"></i> Minha Conta </g:link>
                            <div class="dropdown-divider"></div>
                            <g:link controller="usuario" action="editSenhaLogado" class="dropdown-item" href="#">
                                <i class="fa fa-unlock icon"></i> Atualizar Senha </g:link>
                            <div class="dropdown-divider"></div>
                            <g:link controller="login" action="sair" class="dropdown-item">
                                <i class="fa fa-power-off icon"></i> Sair </g:link>
                        </div>
                    </li>
                </ul>
            </div>
        </header>
        <aside class="sidebar">
            <div class="sidebar-container">
                <div class="sidebar-header">
                    <div class="brand">
                        <div class="logo">
                            <span class="l l1"></span>
                            <span class="l l2"></span>
                            <span class="l l3"></span>
                            <span class="l l4"></span>
                            <span class="l l5"></span>
                        </div>${message(code: 'sistema.sigla')}
                    </div>
                </div>
                <nav class="menu">
                    <ul class="sidebar-menu metismenu" id="sidebar-menu">
                        <li id="menu_bash_board">
                            <g:link controller="dashboard" action="index">
                                <i class="fa fa-bar-chart-o"></i> Dashboard </g:link>
                        </li>
                        <li id="menu_usuario" >
                            <g:link controller="usuario" action="index">
                                <i class="fa fa-users"></i> Usuários </g:link>
                        </li>
                        <li id="menu_moreqjusonline">
                            <g:link controller="moreqJusOnline">
                                <i class="fa fa-th-large"></i> Moreq-Jus Online
                            </g:link>

                        </li>
                        <li id="menu_instituicao">
                            <g:link controller="instituicao" action="edit">
                                <i class="fa fa-th-large"></i> Instituição
                            </g:link>

                        </li>
                        <li id="menu_sistemas">
                            <g:link controller="sistema" action="index">
                                <i class="fa fa-th-large"></i> Sistemas
                            </g:link>

                        </li>

                    </ul>
                </nav>
            </div>
            <footer class="sidebar-footer">
            </footer>
        </aside>
        <div class="sidebar-overlay" id="sidebar-overlay"></div>
        <div class="sidebar-mobile-menu-handle" id="sidebar-mobile-menu-handle"></div>
        <div class="mobile-menu-handle"></div>
        <article class="content items-list-page">

            <g:layoutBody/>

        </article>
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




<asset:javascript src="vendor.js"/>
<asset:javascript src="app.js"/>


</body>
</html>
