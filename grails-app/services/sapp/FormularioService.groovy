package sapp

import grails.gorm.services.Service

@Service(Formulario)
abstract class FormularioService implements IFormularioService {


    Formulario getFormularioEmTrabalho() {
        def formulario = Formulario.createCriteria().get {
            eq("finalizado", false)
        }


        if (!formulario) {
            formulario = new Formulario()
            formulario.finalizado = false
            formulario.save(flush: true)
        }


        carregarDadosDoFormulario(formulario)
        return formulario
    }

    void salvarResposta(Formulario formulario, Long requisitoSelecionado, Integer resposta) {
        for (GrupoRequisito g in formulario.grupoRequisitoList) {
            for (SubGrupoRequisito sub in g.subGrupoRequisitoList) {
                for (Requisito r in sub.requisitoList) {
                    if (r.id == requisitoSelecionado) {
                        //r.resposta = resposta
                        RespostaFormulario respostaBancoDados = RespostaFormulario.createCriteria().get {
                            eq("formulario", formulario)
                            eq("requisito", r)
                        }

                        if (!respostaBancoDados) {
                            //faz um insert
                            respostaBancoDados = new RespostaFormulario()
                            respostaBancoDados.requisito = r
                            respostaBancoDados.formulario = formulario
                            respostaBancoDados.resposta = resposta
                        } else {
                            //faz o update
                            respostaBancoDados.resposta = resposta
                        }
                        respostaBancoDados.save(flush: true)
                    }
                }
            }
        }

    }


    boolean validarFormulario(Formulario formulario) {

        //valida o formulario
        formulario.clearErrors()
        for (GrupoRequisito g in formulario.grupoRequisitoList) {
            for (SubGrupoRequisito sub in g.subGrupoRequisitoList) {

                for (Requisito r in sub.requisitoList) {
                    RespostaFormulario respostaBancoDados = RespostaFormulario.createCriteria().get {
                        eq("formulario", formulario)
                        eq("requisito", r)
                    }
                    if (respostaBancoDados == null || respostaBancoDados.resposta == null ||
                            respostaBancoDados.resposta == 0) {
                        formulario.errors.rejectValue("id", "id.invalido",
                                "Na aba ${r.subGrupoRequisito.id + 1} no item ${r.numeroReferenciaMoreqJus} não foi respondido")
                    }


                }
            }
        }


    }


    /**
     * Carrega todos os requisitos que devem ser preenchidos
     * @param formulario
     */
    void carregarDadosDoFormulario(Formulario formulario) {
        if (!formulario) {
            return
        }

        formulario.grupoRequisitoList = GrupoRequisito.createCriteria().list {
            order("numeroReferenciaMoreqJus")

        }
        formulario.sistemaList = Sistema.createCriteria().list {
            order("nome")
        }

        for (GrupoRequisito g in formulario.grupoRequisitoList) {
            g.subGrupoRequisitoList = SubGrupoRequisito.createCriteria().list {
                eq("grupoRequisito", g)
                order("numeroReferenciaMoreqJus")
            }
        }
        for (GrupoRequisito g in formulario.grupoRequisitoList) {
            for (SubGrupoRequisito sub in g.subGrupoRequisitoList) {
                sub.requisitoList = Requisito.createCriteria().list {
                    eq("subGrupoRequisito", sub)
                }
            }
        }

        for (GrupoRequisito g in formulario.grupoRequisitoList) {
            for (SubGrupoRequisito sub in g.subGrupoRequisitoList) {
                for (Requisito req in sub.requisitoList) {
                    RespostaFormulario respostaBancoDados = RespostaFormulario.createCriteria().get {
                        eq("formulario", formulario)
                        eq("requisito", req)
                    }
                    if (respostaBancoDados) {
                        req.resposta = respostaBancoDados.resposta
                    }
                }

            }
        }

    }


    void salvar(Formulario formulario) {
        formulario.save(flush: true)

    }


}


interface IFormularioService {

    Formulario get(Serializable id)

    List<Formulario> list(Map args)

    Long count()

    void delete(Serializable id)

    Formulario save(Formulario formulario)

}

