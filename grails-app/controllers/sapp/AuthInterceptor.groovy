package sapp


class AuthInterceptor {


    AuthInterceptor() {
        matchAll()
                .excludes(controller:"login")
    }

    boolean before() {
        if( GestaoDaSessao.isLogado(session)){
            true
        }else{
            redirect(controller: 'login', action: 'index')
            false

        }



         }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
