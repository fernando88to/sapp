package seguranca

import sapp.GestaoDaSessao
import sapp.Usuario

class LoginController {

    def index() {

    }

    def logar(){
        def login = params.login
        def senha = params.senha

        def senhaCriptograda = senha ? senha.encodeAsSHA256() : ""

        def usuarioBanco = Usuario.findByLoginAndSenha(login, senhaCriptograda)

        if(usuarioBanco){
            GestaoDaSessao.logarUsuario(usuarioBanco, session)
            redirect action:"index", method:"GET", controller:"dashboard"
            return
        }else{
            flash.message = "Erro no login, verifique sua senha e login"
            redirect(action:"index")
        }



    }

    def sair(){
        GestaoDaSessao.limparSessao(session)
        redirect action:"index", method:"GET", controller:"login"
        return
    }
}
