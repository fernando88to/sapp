package sapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FormularioController {

    FormularioService formularioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {

        def formulario = GestaoDaSessao.getFormulario(session)

        if(!formulario){
            formulario = new Formulario()
        }

        formulario.finalizado=false
        formulario.grupoRequisitoList = GrupoRequisito.createCriteria().list {
            order("numeroReferenciaMoreqJus")
        }
        formulario.sistemaList = Sistema.createCriteria().list {
            order("nome")
        }
        GestaoDaSessao.salvarFormulario(session,formulario)



        model:[formulario:formulario]

    }

    def avancarSelecaoSistema(){
        def formulario = GestaoDaSessao.getFormulario(session)
        formulario.sistema = Sistema.get(params.long("sistema"))

        GestaoDaSessao.salvarFormulario(session,formulario )
        redirect(action:"index", params:[menu:"#menu2"])



    }

    def voltarParaSistemas(){
        redirect(action:"index", params:[menu:"#menu1"])
    }


}
