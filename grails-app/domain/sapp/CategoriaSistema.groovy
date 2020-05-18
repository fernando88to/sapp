package sapp

class CategoriaSistema {
    Long id
    String nome
    /**
     * Não é armazenado no banco de dados, é utilizado
     * no teorema de bayes
     */
    Double porcentagem
    Integer totalSistemas
    static transients = ['porcentagem', 'totalSistemas']

    static constraints = {
        nome nullable: true, maxSize: 255, unique: true
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'CATEGORIA_SISTEMA_SEQ'])

    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        CategoriaSistema that = (CategoriaSistema) o

        if (id != that.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }
}
