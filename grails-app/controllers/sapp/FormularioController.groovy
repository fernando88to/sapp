package sapp

import grails.converters.JSON

class FormularioController {

    FormularioService formularioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {

        def formulario = formularioService.getFormularioEmTrabalho()
        def opcaoRespostaList = getOpcoesResposta()

        model:[formulario: formulario, opcaoRespostaList: opcaoRespostaList]

    }

    private List getOpcoesResposta() {
        def opcaoRespostaList = []
        opcaoRespostaList += [id: 0, descricao: ""]
        opcaoRespostaList += [id: 1, descricao: "Atende"]
        opcaoRespostaList += [id: 2, descricao: "Não Atende"]
        opcaoRespostaList += [id: 3, descricao: "Não se aplica"]
        return opcaoRespostaList

    }

    def avancarSelecaoSistema() {
        def formulario = formularioService.getFormularioEmTrabalho()
        formulario.sistema = Sistema.get(params.long("sistema"))
        formularioService.salvar(formulario)

        redirect(action: "index", params: [menu: "#menu2"])


    }

    def finalizar() {
        def formulario = formularioService.getFormularioEmTrabalho()


        boolean formularioValido = formularioService.validarFormulario(formulario)






        if (!formularioValido) {
            def opcaoRespostaList = getOpcoesResposta()
            render(view: "index", model:[formulario: formulario, opcaoRespostaList: opcaoRespostaList])
            return
        }


        //salva o formuario
        formulario.dataFinalizacao = new Date()
        formulario.usuario = GestaoDaSessao.usuarioLogado(session)
        formulario.finalizado = true
        formulario.save(flush:true, failOnError:true)
        //formularioService.salvar(formulario)
        flash.message = "Formulário finalizado com sucesso"
        redirect(controller:"dashboard", action: "index")


    }

    def voltar() {
        def menuatual = params.int("menuatual")
        def menu_que_vai = "#menu${menuatual - 1}";
        redirect(action: "index", params: [menu: menu_que_vai])
    }

    def avancar() {
        def menuatual = params.int("menuatual")
        def menu_que_vai = "#menu${menuatual < 14 ? menuatual + 1 : menuatual}"


        redirect(action: "index", params: [menu: menu_que_vai])
    }

    def salvarRegistro() {
        def requisitoSelecionado = params.long("requisito")
        def formulario = formularioService.getFormularioEmTrabalho()
        formularioService.salvarResposta(formulario,  requisitoSelecionado, params.int("resposta"))
        def retorno = ['mensagem': 'oi']
        render retorno as JSON

    }


    def atualizarEmLote(){
        def formulario = formularioService.getFormularioEmTrabalho()
        SubGrupoRequisito subGrupoRequisito = params.long("subgrupo") ? SubGrupoRequisito.get(params.long("subgrupo")) : null
        TipoResposta tipoResposta = params.tiporesposta ? TipoResposta.getEnum(params.int("tiporesposta")) : null


        formularioService.atualizarSubGrupoEmLote(formulario,subGrupoRequisito, tipoResposta )
        render [:] as JSON



    }


}
