package sapp

class SubGrupoRequisito {
    Long id
    /**
     * Código de referencia que é utilizado no moreq jus
     */
    String numeroReferenciaMoreqJus
    String resumo
    String nome
    GrupoRequisito grupoRequisito





    static constraints = {
        numeroReferenciaMoreqJus maxSize: 255, unique: true, nullable: false
        resumo nullable: true
        nome nullable: false, maxSize: 255
        grupoRequisito nullable: false
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'SUB_GRUPO_REQUISITO_SEQ'])


    }
}
