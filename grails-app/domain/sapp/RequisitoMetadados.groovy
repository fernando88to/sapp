package sapp

class RequisitoMetadados implements Serializable {
    Long id
    Metadados metadados
    Requisito requisito

    static constraints = {
        metadados nullable: false
        requisito nullable: false, unique: 'metadados'
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'REQUISITO_METADADO_SEQ'])

    }
}
