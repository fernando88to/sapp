package sapp

import grails.converters.JSON

class DashboardController {


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


        requisitosAtendidos  = RespostaFormulario.createCriteria().count {
            eq("formulario", formulario)
            eq("resposta",1)

        }

        requisitosNaoAtendidos  = RespostaFormulario.createCriteria().count {
            eq("formulario", formulario)
            eq("resposta",2)

        }

        naoSeAplica  = RespostaFormulario.createCriteria().count {
            eq("formulario", formulario)
            eq("resposta",3)

        }

        lista.add(['Requisitos Atendidos', requisitosAtendidos])
        lista.add(['Requisitos não atendisos', requisitosNaoAtendidos])
        lista.add(['Não se aplica',naoSeAplica])


        render """[{"type" : "pie","name" : "Quantidade","data" : ${lista as JSON}   }]"""


    }
}
