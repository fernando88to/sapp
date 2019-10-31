package sapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UsuarioController {

    UsuarioService usuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        //params.max = Math.min(max ?: 10, 100)
        model:[usuarioCount: usuarioService.count(), usuarioList: usuarioService.list(params)]
    }

    def show(Long id) {
        respond usuarioService.get(id)
    }

    def create() {
        respond new Usuario(params)
    }

    def save(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }

        usuario.dataCriacao = new Date()
        usuario.senha= "1234".encodeAsSHA256()
        try {
            usuarioService.save(usuario)
        } catch (ValidationException e) {
            respond usuario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                redirect usuario
            }
            '*' { respond usuario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond usuarioService.get(id)
    }

    def update(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }

        try {
            usuarioService.save(usuario)
        } catch (ValidationException e) {
            respond usuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                redirect usuario
            }
            '*'{ respond usuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        usuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usuario.label', default: 'Usuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }


    /**
     * Editar o perfil logado
     */
    def editPerfilLogado(){
        respond usuarioService.get(GestaoDaSessao.usuarioLogado(session).id)



    }


    def updatePerfilLogado(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }

        try {
            usuarioService.save(usuario)
        } catch (ValidationException e) {
            respond usuario.errors, view:'editPerfilLogado'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = 'Usuário atualizado com sucesso'
                redirect action: 'editPerfilLogado'
            }
            '*'{ respond usuario, [status: OK, action: 'editPerfilLogado'] }
        }
    }


    def editSenhaLogado(){
        def usuario = usuarioService.get(GestaoDaSessao.usuarioLogado(session).id)

        respond usuario



    }


    def updateSenhaLogado(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }
        usuario.senhaConfirmacao= params.senhaConfirmacao

        if (usuario.senha!=usuario.senhaConfirmacao){
            usuario.errors.rejectValue("senha","senhainvalida","A senha de confirmação deve ser igual a senha")
            respond usuario.errors, view:'editSenhaLogado'
            return
        }

        try {
            usuario.senha = usuario.senha.encodeAsSHA256()
            usuarioService.save(usuario)
        } catch (ValidationException e) {
            respond usuario.errors, view:'editSenhaLogado'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = 'Senha atualizada com sucessso'
                redirect action: 'editSenhaLogado'
            }
            '*'{ respond usuario, [status: OK, action: 'editSenhaLogado'] }
        }
    }
}
