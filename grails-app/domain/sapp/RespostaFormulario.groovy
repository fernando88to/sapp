package sapp



class RespostaFormulario {
    Long id
    Requisito requisito
    Formulario formulario
    Integer resposta

    static constraints = {
        requisito nullable: false
    }
    static mapping = {
        id (generator:'sequence', params:[sequence:'RESPOSTA_FORMULARIO_SEQ'])

    }
}
