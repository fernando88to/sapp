package sapp

import javax.servlet.http.HttpSession

class GestaoDaSessao {

    private static final KEY_USUARIO_LOGADO = "KEY_USUARIO_LOGADO"

    static boolean  isLogado(HttpSession session){
        if(session.getAttribute(KEY_USUARIO_LOGADO)){
            return true
        }else{
            return false
        }
    }


    static void logarUsuario(Usuario usuario, HttpSession session){
        session.setAttribute(KEY_USUARIO_LOGADO, usuario)
    }

    static Usuario usuarioLogado(session){
        session.getAttribute(KEY_USUARIO_LOGADO)
    }

    static void limparSessao(HttpSession session){
        session.setAttribute(KEY_USUARIO_LOGADO, null)
    }



}
