package sapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SistemaController {

    SistemaService sistemaService
    InstituicaoService instituicaoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sistemaService.list(params), model:[sistemaCount: sistemaService.count()]
    }

    def show(Long id) {
        respond sistemaService.get(id)
    }

    def create() {
        respond new Sistema(params)
    }

    def save(Sistema sistema) {
        if (sistema == null) {
            notFound()
            return
        }

        try {
            sistema.instituicao = instituicaoService.getInstituicaoPrincipal()
            sistemaService.save(sistema)
        } catch (ValidationException e) {
            respond sistema.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sistema.label', default: 'Sistema'), sistema.id])
                redirect sistema
            }
            '*' { respond sistema, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sistemaService.get(id)
    }

    def update(Sistema sistema) {
        if (sistema == null) {
            notFound()
            return
        }

        try {
            sistemaService.save(sistema)
        } catch (ValidationException e) {
            respond sistema.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = "Sistema atualizado com sucesso"
                redirect sistema
            }
            '*'{ respond sistema, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sistemaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sistema.label', default: 'Sistema'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sistema.label', default: 'Sistema'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
