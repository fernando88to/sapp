package sapp


class ConfiguracaoInicialInterceptor {
    def instituicaoService

    ConfiguracaoInicialInterceptor() {
        /*matchAll()
                .excludes(controller:"login").
                excludes(controller:"instituicao")*/


    }

    boolean before() {
        //println "configuração inicial"

        def instituicao = instituicaoService.getInstituicaoPrincipal()
        if(!instituicao){
            flash.message = "Para começar a utiliza o sistema informe os dados da Instituição"
            redirect(controller: 'instituicao', action: 'edit')
            false
        }

        true




    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
