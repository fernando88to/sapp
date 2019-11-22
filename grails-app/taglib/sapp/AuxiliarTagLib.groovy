package sapp

class AuxiliarTagLib {
    def formularioService
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def textoBotaoResponderFormulraio = { attrs, body ->
        def formulario  = Formulario.createCriteria().get {
            eq("finalizado", false)
            maxResults(1)
        }
        out << (formulario==null  ? 'Responder Questionário' : 'Continuar Questionário')


    }

}
