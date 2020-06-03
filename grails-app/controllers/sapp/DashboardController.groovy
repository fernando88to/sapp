package sapp

import grails.converters.JSON
import groovy.time.TimeCategory

class DashboardController {
    def estatisticaService


    def index() {

    }

    def estatistica() {
        def sistemasList = Formulario.createCriteria().list {
            eq "finalizado", true
            projections {
                distinct("sistema")
            }


        }
        model:
        [sistemasList: sistemasList]
    }

    def json() {
        def questionario = Formulario.createCriteria().get {
            maxResults(1)
        }

        render questionario as JSON
    }

    def chamadaPizzaExtra() {
        def lista = []


        def requisitosAtendidos = 0
        def requisitosNaoAtendidos = 0
        def naoSeAplica = 0


        def sistema = Sistema.get(params.long("id"))

        def formulario = Formulario.createCriteria().get {
            eq("sistema", sistema)
            eq("finalizado", true)
            order("dataFinalizacao", "desc")
            maxResults(1)
        }


        requisitosAtendidos = estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.REQUISITO_ATENDIDO, null)
        requisitosNaoAtendidos = estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.REQUISITO_NAO_ATENDIDO, null)
        //naoSeAplica = estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.NAO_SE_APLICA, null)
        lista.add(['Requisitos Atendidos', requisitosAtendidos])
        lista.add(['Requisitos não atendisos', requisitosNaoAtendidos])
        //lista.add(['Não se aplica',naoSeAplica])


        render """[{"type" : "pie","name" : "Quantidade","data" : ${lista as JSON}   }]"""


    }


    def raioxcoluna() {
        def lista = []


        def sistema = Sistema.get(params.long("id"))

        def formulario = Formulario.createCriteria().get {
            eq("sistema", sistema)
            eq("finalizado", true)
            order("dataFinalizacao", "desc")
            maxResults(1)
        }


        def categorias = RespostaFormulario.createCriteria().list {
            createAlias("requisito", "r")
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

        for (GrupoRequisito gr in categorias) {
            requisitoAtendidosList.add estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.REQUISITO_ATENDIDO, gr)
            requisitoNaoAtendidosList.add estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.REQUISITO_NAO_ATENDIDO, gr)
            naoseAplicaList.add estatisticaService.getQuantidadeRequisitos(formulario, TipoResposta.NAO_SE_APLICA, gr)


        }

        lista.add([
                name: 'Requisito Atendidos',
                data: requisitoAtendidosList]
        )
        lista.add([name: 'Requisitos Não Atendidos',
                   data: requisitoNaoAtendidosList
        ])

        lista.add([
                name: 'Não Se aplica',
                data: naoseAplicaList
        ])


        def retorno = [:]
        def categoriasString = []
        for (String c in categorias.numeroReferenciaMoreqJus) {
            categoriasString += "Cap. ${c}"
        }

        retorno.categorias = categoriasString
        retorno.dados = lista
        render retorno as JSON


    }

    def evolucao() {
        def sistema = Sistema.get(params.long("id"))
        def lista = []

        Set<Integer> anos = new TreeSet<Integer>()
        def anoInicial = 2016
        def anoAtual = new Integer(new Date().format("yyyy"))
        anoAtual++
        while (anoAtual > anoInicial) {
            anos += anoAtual
            anoAtual--
        }


        /*def requisitoAtendidos = [0, 0, 50, 55]
        def naoseAPlica = [0, 0, 10, 10]
        def requisitoNaoAtendidos = [0, 0, 40, 35]*/

        def requisitoAtendidos = []
        def naoseAPlica = []
        def requisitoNaoAtendidos = []


        for (ano in anos) {
            def formularioList = Formulario.executeQuery("select f from Formulario f where f.sistema=:sistema and year(f.dataFinalizacao) =:ano ", [sistema: sistema, ano: ano])
            def formulario = formularioList ? formularioList.get(0) : null
            if (formulario) {
                requisitoAtendidos.add estatisticaService.getQuantidadeRequisitos(formulario,
                        TipoResposta.REQUISITO_ATENDIDO, null)
                requisitoNaoAtendidos.add estatisticaService.getQuantidadeRequisitos(formulario,
                        TipoResposta.REQUISITO_NAO_ATENDIDO, null)
                naoseAPlica.add estatisticaService.getQuantidadeRequisitos(formulario,
                        TipoResposta.NAO_SE_APLICA, null)
            } else {
                requisitoAtendidos.add(0)
                requisitoNaoAtendidos.add(0)
                naoseAPlica.add(0)


            }
        }


        lista.add([name: 'Requisitos Atendidos', data: requisitoAtendidos])

        lista.add([name: 'Requisitos Não Atendidos', data: requisitoNaoAtendidos])

        lista.add([name: 'Não Se Aplica', data: naoseAPlica])
        render lista as JSON

    }

    def metadados() {
        def sistema = Sistema.get(params.long("id"))
        def formularioMaisRecente = Formulario.createCriteria().get {
            eq("sistema", sistema)
            eq("finalizado", true)
            order("dataFinalizacao", "desc")
            maxResults(1)
        }
        def metadados = estatisticaService.getMetadados(formularioMaisRecente)
        render metadados as JSON

    }

    def formularios() {
        def sistema = params.id ? Sistema.get(params.long("id")) : null

        if (!sistema) {
            render[] as JSON
        }

        def formulariosList = Formulario.createCriteria().list {
            eq("sistema", sistema)
        }


        render formulariosList as JSON
    }

    def mudardata() {
        def formulario = params.id ? Formulario.get(params.id) : null
        use(TimeCategory) {
            formulario.dataFinalizacao = formulario.dataFinalizacao - 1.year
            formulario.save(flush: true)

        }
        render "ok"
    }


    def mapaGeral() {

    }

    def mapaGeralAjax(){



        def sistemas = new ArrayList<Sistema>()
        for(sistemaBanco in Sistema.list()){
            def formularioRespondido = Formulario.createCriteria().get {
                eq("sistema", sistemaBanco)
                eq("finalizado", true)
                order("dataFinalizacao", "desc")
                maxResults(1)
            }

            if(formularioRespondido){
                sistemas +=sistemaBanco
            }
        }


        for (sistema in sistemas) {



            def requisitosAtendidos = sistema.getQuantidadeRequisitos( TipoResposta.REQUISITO_ATENDIDO, null)
            def requisitosNaoAtendidos = sistema.getQuantidadeRequisitos(TipoResposta.REQUISITO_NAO_ATENDIDO, null)
            def totalRequisitos = requisitosAtendidos + requisitosNaoAtendidos
            sistema.porcentagemConformidade = requisitosAtendidos * 100 / totalRequisitos
            if(sistema.porcentagemConformidade >= 0.0d && sistema.porcentagemConformidade <=40.00d){
                sistema.seloMoreqJus = SeloMoreqJus.BRONZE
            }else if(sistema.porcentagemConformidade > 40.00d && sistema.porcentagemConformidade <=70.00d){
                sistema.seloMoreqJus = SeloMoreqJus.PRATA
            }else if(sistema.porcentagemConformidade > 70.00d && sistema.porcentagemConformidade <=90.00d){
                sistema.seloMoreqJus = SeloMoreqJus.OURO
            }else if(sistema.porcentagemConformidade > 90.00d && sistema.porcentagemConformidade <=100.00d){
                sistema.seloMoreqJus = SeloMoreqJus.PLATINA
            }

        }









       def lista = []

       lista+= [id:'selo_bronze', to:'tjto']
        lista+=[id:'selo_prata', to: 'tjto']
        lista+=[id:'selo_ouro', to:'tjto']
        lista+=[id:'selo_platina', to:'tjto']


        for(sistema in sistemas){
            def selo  = ""


            if(sistema.seloMoreqJus== SeloMoreqJus.BRONZE){
                selo = "selo_bronze"
            }else if(sistema.seloMoreqJus== SeloMoreqJus.PRATA){
                selo = "selo_prata"
            }else if(sistema.seloMoreqJus== SeloMoreqJus.OURO){
                selo = "selo_ouro"
            }else if(sistema.seloMoreqJus== SeloMoreqJus.PLATINA){
                selo = "selo_platina"
            }





            lista+=[id:sistema.nome, to:selo]
        }




      /*  lista+=[id:'Sistema 1', to:'selo_bronze']
        lista+=[id:'Sistema 2', to:'selo_bronze']


        lista+=[id:'Sistema 3', to:'selo_prata']
        lista+=[id:'Sistema 7', to:'selo_prata']
        lista+=[id:'Sistema 8', to:'selo_prata']

        lista+=[id:'Sistema 9', to:'selo_ouro']
        lista+=[id:'Sistema 4', to:'selo_ouro']
        lista+=[id:'Sistema 5', to:'selo_ouro']
        lista+=[id:'Sistema 6', to:'selo_ouro']*/

        render lista as JSON


    }

    def mapaSistema() {

    }

    def detalhaSistema_1() {

    }

    def detalheSistema_2() {

    }

    def abrirSelos() {

    }

    def gerarProbalidadeSelos() {
        def categoriaInstance = CategoriaSistema.findById(params.id)



        def categorias = CategoriaSistema.list()



        def teorema = new TeoremaBayes(categorias)
         [
                probabilidadeBronze : teorema.probabilidadeSistema(categoriaInstance, SeloMoreqJus.BRONZE),
                probabilidadePrata : teorema.probabilidadeSistema(categoriaInstance, SeloMoreqJus.PRATA),
                probabilidadeOuro : teorema.probabilidadeSistema(categoriaInstance, SeloMoreqJus.OURO),
                probabilidadePlatina : teorema.probabilidadeSistema(categoriaInstance, SeloMoreqJus.PLATINA)
         ]


    }

    /*def gerarProbalidadeSelos(){
        def categoriaInstance = CategoriaSistema.findById(params.id)


        def categoriasList = CategoriaSistema.list()
        def categoriasPorcentagemList = []

        def totalSistemas = Sistema.count()


        for(c in categoriasList){
            def totalDaCategoria = Sistema.createCriteria().count {
                eq("categoriaSistema", c)
            }
            def sistemasList = Sistema.createCriteria().list {
                eq("categoriaSistema", c)
            }



            categoriasPorcentagemList+=[categoria:c, porcentagem: (100*totalDaCategoria/totalSistemas), sistemas:sistemasList]





        }



        println ""








    }*/


}
