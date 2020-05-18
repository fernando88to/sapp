package sapp

class Sistema {
    Long id
    String nome
    String sigla
    String url
    Instituicao instituicao
    CategoriaSistema categoriaSistema
    SeloMoreqJus seloMoreqJus
    Double porcentagemConformidade



    static transients = ['seloMoreqJus','porcentagemConformidade']


    static constraints = {
        nome nullable: true, maxSize: 255, unique: true
        sigla nullable: true, maxSize: 255
        url nullable: true, maxSize: 255
        instituicao nullable: false
        categoriaSistema nullable: false

    }


    static mapping = {
        id(generator: 'sequence', params: [sequence: 'SISTEMA_SEQ'])

    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Sistema sistema = (Sistema) o

        if (id != sistema.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }


    Integer getQuantidadeRequisitos(TipoResposta resposta, GrupoRequisito grupoRequisito){

        def formulario = Formulario.createCriteria().get {
            eq("sistema", this)
            eq("finalizado", true)
            order("dataFinalizacao", "desc")
            maxResults(1)
        }


        RespostaFormulario.createCriteria().count {
            createAlias("requisito","r")
            createAlias("r.subGrupoRequisito", "sr")
            eq("formulario", formulario)

            if(resposta){
                eq("resposta",resposta.getValue())
            }


            if(grupoRequisito){
                eq "sr.grupoRequisito", grupoRequisito
            }

        }
    }
}
