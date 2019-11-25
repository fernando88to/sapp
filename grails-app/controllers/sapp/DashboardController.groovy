package sapp

import grails.converters.JSON

class DashboardController {
    def estatisticaService


    def index() {
        def sistemasList = Sistema.createCriteria().list {
            order("nome")
        }
        model:[sistemasList: sistemasList]
    }

    def json() {
        def questionario= Formulario.createCriteria().get {
            maxResults(1)
        }

        render questionario as JSON
    }

    def chamadaPizzaExtra(){
        def lista = []



        def requisitosAtendidos = 0
        def requisitosNaoAtendidos = 0
        def naoSeAplica = 0


        def sistema = Sistema.get(params.long("id"))

        def formulario = Formulario.createCriteria().get {
            eq("sistema", sistema)
            eq("finalizado", true)
            order("dataFinalizacao","desc")
            maxResults(1)
        }




        requisitosAtendidos= estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.REQUISITO_ATENDIDO, null)
        requisitosNaoAtendidos = estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.REQUISITO_NAO_ATENDIDO, null)
        naoSeAplica = estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.NAO_SE_APLICA, null)
        lista.add(['Requisitos Atendidos', requisitosAtendidos])
        lista.add(['Requisitos não atendisos', requisitosNaoAtendidos])
        lista.add(['Não se aplica',naoSeAplica])


        render """[{"type" : "pie","name" : "Quantidade","data" : ${lista as JSON}   }]"""


    }


    def raioxcoluna(){
        def lista = []


        def sistema = Sistema.get(params.long("id"))

        def formulario = Formulario.createCriteria().get {
            eq("sistema", sistema)
            eq("finalizado", true)
            order("dataFinalizacao","desc")
            maxResults(1)
        }


        def categorias  = RespostaFormulario.createCriteria().list {
            createAlias("requisito","r")
            createAlias("r.subGrupoRequisito", "sr")
            //createAlias("sr.grupoRequisito","gr")
            eq("formulario", formulario)

            projections {
                distinct("sr.grupoRequisito")
            }


        }


        def requisitoAtendidosList = []
        def requisitoNaoAtendidosList = []
        def naoseAplicaList = []

        for(GrupoRequisito gr in categorias){
            requisitoAtendidosList.add  estatisticaService.getQuantidadeRequisitos(formulario,TipoResposta.REQUISITO_ATENDIDO, gr)
            requisitoNaoAtendidosList.add estatisticaService.getQuantidadeRequisitos(formulario,TipoResposta.REQUISITO_NAO_ATENDIDO, gr)
            naoseAplicaList.add estatisticaService.getQuantidadeRequisitos(formulario,TipoResposta.NAO_SE_APLICA, gr)


        }

        lista.add([
                name: 'Requisito Atendidos',
                data: [requisitoAtendidosList]]
        )
        lista.add([name: 'Requisitos Não Atendidos',
                   data: [requisitoNaoAtendidosList]
        ])

        lista.add([
                name: 'Não Se aplica',
                data: [naoseAplicaList]
        ])


        def retorno = [:]
        def categoriasString = []
        for(String c in categorias.numeroReferenciaMoreqJus){
            categoriasString+="Cap. ${c}"
        }

        retorno.categorias= categoriasString
        retorno.dados  = lista
        render retorno as JSON







    }

}
