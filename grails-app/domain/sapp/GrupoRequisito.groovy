package sapp

class GrupoRequisito implements Serializable {
    Long id
    String nome
    Integer numeroReferenciaMoreqJus
    String resumo
    List<SubGrupoRequisito> subGrupoRequisitoList


    static transients = ['subGrupoRequisitoList']


    static constraints = {
        nome nullable: false, maxSize: 255
        numeroReferenciaMoreqJus nullable: false, unique: true, maxSize: 255
        resumo nullable: true, maxSize: 10000
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'GRUPO_REQUISITO_SEQ'])


    }
}
