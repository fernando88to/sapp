package sapp

class AuxiliarTagLib {
    def formularioService
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def textoBotaoResponderFormulraio = { attrs, body ->
        def formulario  = formularioService.getFormularioEmTrabalho()
        out << (formulario.finalizado ? 'Responder Questionário' : 'Continuar Questionário')


    }

}
