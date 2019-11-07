package sapp

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FormularioController {

    FormularioService formularioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {

        def formulario = GestaoDaSessao.getFormulario(session)

        if(!formulario){
            formulario = new Formulario()

            formulario.finalizado=false
            formulario.grupoRequisitoList = GrupoRequisito.createCriteria().list {
                order("numeroReferenciaMoreqJus")

            }
            formulario.sistemaList = Sistema.createCriteria().list {
                order("nome")
            }

            for(GrupoRequisito g in formulario.grupoRequisitoList){
                g.subGrupoRequisitoList = SubGrupoRequisito.createCriteria().list {
                    eq("grupoRequisito", g)
                    order("numeroReferenciaMoreqJus")
                }
            }
            for(GrupoRequisito g in formulario.grupoRequisitoList){
                for(SubGrupoRequisito sub in g.subGrupoRequisitoList){
                    sub.requisitoList = Requisito.createCriteria().list {
                        eq("subGrupoRequisito", sub)
                    }
                }
            }

            GestaoDaSessao.salvarFormulario(session,formulario)
        }







        def opcaoRespostaList =[]
        opcaoRespostaList+=[id:0,descricao:""]
        opcaoRespostaList+=[id:1,descricao:"Atende"]
        opcaoRespostaList+=[id:2,descricao:"Não Atende"]
        opcaoRespostaList+=[id:3,descricao:"Não se aplica"]

        model:[formulario:formulario,opcaoRespostaList:opcaoRespostaList]

    }

    def avancarSelecaoSistema(){
        def formulario = GestaoDaSessao.getFormulario(session)
        formulario.sistema = Sistema.get(params.long("sistema"))

        GestaoDaSessao.salvarFormulario(session,formulario )
        redirect(action:"index", params:[menu:"#menu2"])



    }

    def voltar(){
        def menuatual = params.int("menuatual")
        def menu_que_vai = "#menu${menuatual-1}";
        redirect(action:"index", params:[menu:menu_que_vai])
    }

    def avancar(){
        def menuatual = params.int("menuatual")
        def menu_que_vai = "#menu${menuatual < 14 ? menuatual+1 : menuatual}"


        redirect(action:"index", params:[menu:menu_que_vai])
    }

    def salvarRegistro(){
        def requisitoSelecionado = params.long("requisito")
        def formulario = GestaoDaSessao.getFormulario(session)
        for(GrupoRequisito g in formulario.grupoRequisitoList){
            for(SubGrupoRequisito sub in g.subGrupoRequisitoList){
                for(Requisito r in sub.requisitoList){
                    if(r.id==requisitoSelecionado){
                        r.resposta = params.int("resposta")
                    }
                }
            }
        }
        GestaoDaSessao.salvarFormulario(session,formulario )
        def retorno = ['mensagem':'oi']
        render retorno as JSON

    }


}
