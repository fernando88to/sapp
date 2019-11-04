package sapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InstituicaoController {

    InstituicaoService instituicaoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def edit() {
        def instituicao = Instituicao.get(1l)
        if(!instituicao){
            instituicao = new Instituicao()
            instituicao.id= 1l
        }


        model:[instituicao:instituicao]
    }

    def update() {

        def instituicao  = Instituicao.get(1l)
        if(!instituicao){
            instituicao = new Instituicao(params)
        }

        try {
            instituicaoService.save(instituicao)
        } catch (ValidationException e) {
            respond instituicao.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = "Dados atualizado com sucesso."
                redirect action:"edit", params:[id:instituicao.id]
            }
            '*'{ respond instituicao, [status: OK] }
        }
    }


}
