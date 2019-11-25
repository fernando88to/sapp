package sapp



class RespostaFormulario {
    Long id
    Requisito requisito
    Formulario formulario
    /**
     *  1 - Atende
     *  2 - Não atende
     *  3 - Não se aplica
     */
    Integer resposta

    static constraints = {
        requisito nullable: false
    }
    static mapping = {
        id (generator:'sequence', params:[sequence:'RESPOSTA_FORMULARIO_SEQ'])

    }
}
