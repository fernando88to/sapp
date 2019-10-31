package sapp

class Usuario implements Serializable {
    Long id
    String login
    String nome
    String senha
    Date dataCriacao
    String email
    String senhaConfirmacao

    /**
     * Campo que não é persistido, ele é apenas utilizado no formulario de atualizar senha
     */
    static transients = ['senhaConfirmacao']

    static constraints = {
        login nullable: false, maxSize: 50, unique: true
        nome nullable: false, maxSize: 255
        senha nullable: false, maxSize: 255
        dataCriacao nullable: false
        email nullable: false, maxSize: 255, email: true, unique: true
    }

    static mapping = {
            id (generator:'sequence', params:[sequence:'USUARIO_SEQ'])

    }
}
