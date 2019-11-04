package sapp


class AuthInterceptor {
    InstituicaoService instituicaoService


    AuthInterceptor() {
        matchAll()
                .excludes(controller: "login")
    }

    boolean before() {
        if (GestaoDaSessao.isLogado(session)) {

            def instituicao = instituicaoService.getInstituicaoPrincipal()
            //está logado, mas não cadastrou os dados da instituição
            if (instituicao == null && !getControllerName().equalsIgnoreCase("instituicao")) {
                flash.message = "Para começar a utiliza o sistema informe os dados da Instituição"
                redirect(controller: 'instituicao', action: 'edit')
                false
            }


            true
        } else {
            redirect(controller: 'login', action: 'index')
            false

        }


    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
