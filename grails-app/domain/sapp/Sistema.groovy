package sapp

class Sistema {
    Long id
    String nome
    String sigla
    String url
    Instituicao instituicao

    static constraints = {
        nome nullable: true, maxSize: 255, unique: true
        sigla nullable: true, maxSize: 255
        url nullable: true, maxSize: 255
        instituicao nullable: false

    }


    static mapping = {
        id (generator:'sequence', params:[sequence:'SISTEMA_SEQ'])

    }
}
