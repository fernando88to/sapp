package sapp


class ConfiguracaoInicialInterceptor {

    ConfiguracaoInicialInterceptor() {
        matchAll()
                .excludes(controller:"login").
                excludes(controller:"instituicao")

    }

    boolean before() {
        //println "configuração inicial"

        def instituicao = Instituicao.get(1l)
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
