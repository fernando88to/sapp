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
                        <li>
                            <a href="">
                                <i class="fa fa-area-chart"></i> Charts <i class="fa arrow"></i>
                            </a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="charts-flot.html"> Flot Charts </a>
                                </li>
                                <li>
                                    <a href="charts-morris.html"> Morris Charts </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="">
                                <i class="fa fa-table"></i> Tables <i class="fa arrow"></i>
                            </a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="static-tables.html"> Static Tables </a>
                                </li>
                                <li>
                                    <a href="responsive-tables.html"> Responsive Tables </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="forms.html">
                                <i class="fa fa-pencil-square-o"></i> Forms </a>
                        </li>
                        <li>
                            <a href="">
                                <i class="fa fa-desktop"></i> UI Elements <i class="fa arrow"></i>
                            </a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="buttons.html"> Buttons </a>
                                </li>
                                <li>
                                    <a href="cards.html"> Cards </a>
                                </li>
                                <li>
                                    <a href="typography.html"> Typography </a>
                                </li>
                                <li>
                                    <a href="icons.html"> Icons </a>
                                </li>
                                <li>
                                    <a href="grid.html"> Grid </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="">
                                <i class="fa fa-file-text-o"></i> Pages <i class="fa arrow"></i>
                            </a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="login.html"> Login </a>
                                </li>
                                <li>
                                    <a href="signup.html"> Sign Up </a>
                                </li>
                                <li>
                                    <a href="reset.html"> Reset </a>
                                </li>
                                <li>
                                    <a href="error-404.html"> Error 404 App </a>
                                </li>
                                <li>
                                    <a href="error-404-alt.html"> Error 404 Global </a>
                                </li>
                                <li>
                                    <a href="error-500.html"> Error 500 App </a>
                                </li>
                                <li>
                                    <a href="error-500-alt.html"> Error 500 Global </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="">
                                <i class="fa fa-sitemap"></i> Menu Levels <i class="fa arrow"></i>
                            </a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="#"> Second Level Item <i class="fa arrow"></i>
                                    </a>
                                    <ul class="sidebar-nav">
                                        <li>
                                            <a href="#"> Third Level Item </a>
                                        </li>
                                        <li>
                                            <a href="#"> Third Level Item </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#"> Second Level Item </a>
                                </li>
                                <li>
                                    <a href="#"> Second Level Item <i class="fa arrow"></i>
                                    </a>
                                    <ul class="sidebar-nav">
                                        <li>
                                            <a href="#"> Third Level Item </a>
                                        </li>
                                        <li>
                                            <a href="#"> Third Level Item </a>
                                        </li>
                                        <li>
                                            <a href="#"> Third Level Item <i class="fa arrow"></i>
                                            </a>
                                            <ul class="sidebar-nav">
                                                <li>
                                                    <a href="#"> Fourth Level Item </a>
                                                </li>
                                                <li>
                                                    <a href="#"> Fourth Level Item </a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="screenful.html">
                                <i class="fa fa-bar-chart"></i> Agile Metrics <span class="label label-screenful">by Screenful</span>
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/modularcode/modular-admin-html">
                                <i class="fa fa-github-alt"></i> Theme Docs </a>
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
