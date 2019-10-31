package sapp

class MoreqJusOnlineController {

    /**
     * Mostra todos os grupos de requisitos
     */
    def index() {

        def grupoRequisitos = GrupoRequisito.createCriteria().list {
            order("id", "asc")
        }


        model:[grupoRequisitosList:grupoRequisitos]
    }


    /**
     * Mostra todos
     * @param id
     */
    def subGrupo(Long id){
        def grupoRequisito = GrupoRequisito.findById(id)
        def subGruposList = SubGrupoRequisito.createCriteria().list {
            eq("grupoRequisito", grupoRequisito)
        }

        model:[subGruposList:subGruposList]

    }

    def requisito(Long id){
        def subGrupo = SubGrupoRequisito.findById(id)
        def requisitosList = Requisito.createCriteria().list {
            eq("subGrupoRequisito", subGrupo)
        }

        model:[requisitosList:requisitosList, subGrupoInstance:subGrupo]

    }
}
