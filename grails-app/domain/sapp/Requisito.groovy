package sapp

class Requisito {
    Long id
    /**
     * Código de referencia que é utilizado no moreq jus
     */
    String numeroReferenciaMoreqJus
    String nome
    Boolean obrigatorio
    SubGrupoRequisito subGrupoRequisito

    static constraints = {
        numeroReferenciaMoreqJus nullable: false, maxSize: 255
        nome nullable: false, maxSize: 4000
        obrigatorio nullable: false
        subGrupoRequisito nullable: false
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'REQUISITO_SEQ'])


    }
}
