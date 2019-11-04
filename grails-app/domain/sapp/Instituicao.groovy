package sapp

class Instituicao {
    Long id
    String nome
    String endereco
    String sigla


    static constraints = {
        nome nullable: false, maxSize: 255
        endereco nullable: true, maxSize: 255
        sigla nullable: false
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'INSTITUICAO_SEQ'])
    }
}
