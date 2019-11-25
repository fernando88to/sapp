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

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        GrupoRequisito that = (GrupoRequisito) o

        if (id != that.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }
}
