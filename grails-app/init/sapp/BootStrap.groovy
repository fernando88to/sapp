package sapp

class BootStrap {

    def init = { servletContext ->

        def usuario = Usuario.findByLogin("admin")
        //caso o usuário adminstrador não exista na base ele é criado
        if(!usuario){
            usuario = new Usuario()
            usuario.nome = "admin"
            usuario.login="admin"
            usuario.senha = "admin".encodeAsSHA256()
            usuario.dataCriacao = new Date()
            usuario.email = "email@teste.com.br"
            usuario.save(flush:true)
        }

    }
    def destroy = {
    }
}
