package sapp

class Metadados {
    Long id
    String nome
    String definicao
    String numeroReferenciaMoreqJus
    /**
     * Caso o metadado não seja obrigatorio  a nenhum requisito do moreq jus
     * ele é opcional
     */
    Boolean obrigatorio
    TipoMetadado tipoMetadado


    static constraints = {
        nome nullable: false, maxSize: 255, unique: true
        definicao nullable: false, maxSize: 255
        obrigatorio nullable: false
        numeroReferenciaMoreqJus nullable: false, maxSize: 500, unique: true
        tipoMetadado nullable: true
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'METADADOS_SEQ'])


    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Metadados metadados = (Metadados) o

        if (id != metadados.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }
}
