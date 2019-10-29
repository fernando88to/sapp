package sapp

class Usuario implements Serializable {
    Long id
    String login
    String nome
    String senha
    Date dataCriacao
    String email

    static constraints = {
        login nullable: false, maxSize: 50
        nome nullable: false, maxSize: 255
        senha nullable: false, maxSize: 255
        dataCriacao nullable: false
        email nullable: false, maxSize: 255, email: true
    }

    static mapping = {
            id (generator:'sequence', params:[sequence:'USUARIO_SEQ'])

    }
}
