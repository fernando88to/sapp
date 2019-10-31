package sapp

class Metadados {
    Long id
    String nome
    String definicao


    static constraints = {
        nome nullable: false, maxSize: 255
        definicao nullable: false, maxSize: 255
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'METADADOS_SEQ'])


    }
}
