package sapp

class Usuario implements Serializable {
    Long id
    String login
    String nome
    String senha

    static constraints = {
        login nullable: false, maxSize: 50
        nome nullable: false, maxSize: 255
        senha nullable: false, maxSize: 255
    }
}
