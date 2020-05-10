package sapp

class CategoriaSistema {
    Long id
    String nome

    static constraints = {
        nome nullable: true, maxSize: 255, unique: true
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'CATEGORIA_SISTEMA_SEQ'])

    }
}
