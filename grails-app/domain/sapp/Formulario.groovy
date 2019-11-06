package sapp

class Formulario {
    Long id
    Date dataFinalizacao
    Boolean finalizado
    Sistema sistema
    Usuario usuario


    List<Sistema> sistemaList
    List<GrupoRequisito>  grupoRequisitoList

    static transients = ['grupoRequisitoList','sistemaList']

    static constraints = {
        dataFinalizacao nullable: true
        finalizado nullable: false
        sistema nullable: false
        usuario nullable: true
    }

    static mapping = {
        id (generator:'sequence', params:[sequence:'FORMULARIO_SEQ'])

    }

}
