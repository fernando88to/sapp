package sapp

class BootStrap {

    def init = { servletContext ->

        def usuario = Usuario.findByLogin("admin")
        //caso o usuário adminstrador não exista na base ele é criado
        if(!usuario){
            usuario = new Usuario()
            usuario.nome = "admin"
            usuario.login="admin"
            usuario.senha = "admin".encodeAsSHA256()
            usuario.dataCriacao = new Date()
            usuario.email = "email@teste.com.br"
            usuario.save(flush:true)
        }
        def grupoRequisito_2 = GrupoRequisito.findByNumeroReferenciaMoreqJus("2")
        if(!grupoRequisito_2){
            grupoRequisito_2 = new GrupoRequisito()
            grupoRequisito_2.nome = "Organização dos documentos institucionais: plano de classificação e manutenção dos documentos"
            grupoRequisito_2.resumo = "Os documentos institucionais podem ser agregados em processos/dossiês, de\n" +
                    "forma estruturada. Essa estrutura reflete as funções e atividades da organização,\n" +
                    "representadas no plano de classificação.\n" +
                    "O Judiciário comumente organiza seus documentos institucionais em documentos\n" +
                    "e processos: judiciais e administrativos."

            grupoRequisito_2.numeroReferenciaMoreqJus="2"
            grupoRequisito_2.save(flush:true)

        }

        def subGrupo_2_1 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.1")
        if(!subGrupo_2_1){
            subGrupo_2_1 = new SubGrupoRequisito()
            subGrupo_2_1.numeroReferenciaMoreqJus="2.1"
            subGrupo_2_1.nome ="Configuração e administração do plano de classificação no GestãoDoc"
            subGrupo_2_1.grupoRequisito = grupoRequisito_2
            subGrupo_2_1.save(flush:true)

        }

        def requisitoRPC2_1_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.1")
        if(!requisitoRPC2_1_1){
            requisitoRPC2_1_1 = new Requisito()
            requisitoRPC2_1_1.numeroReferenciaMoreqJus = "RPC2.1.1"
            requisitoRPC2_1_1.obrigatorio = true
            requisitoRPC2_1_1.nome = "Incluir os instrumentos de classificação de documentos e processos judiciais e administrativos de acordo com as normas vigentes compatíveis com o programa de gestão documental."
            requisitoRPC2_1_1.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_1.save(flush:true)
        }

        def requisitoRPC2_1_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.2")
        if(!requisitoRPC2_1_2){
            requisitoRPC2_1_2 = new Requisito()
            requisitoRPC2_1_2.numeroReferenciaMoreqJus = "RPC2.1.2"
            requisitoRPC2_1_2.obrigatorio = true
            requisitoRPC2_1_2.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_2.nome = "Garantir a criação de classes, subclasses, grupos e subgrupos nos níveis do plano de classificação e de outros instrumentos de classificação de documentos e processos de acordo com o método de codificação adotado"
            requisitoRPC2_1_2.save(flush:true)
        }




        def subGrupo_2_2 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.2")
        if(!subGrupo_2_2){
            subGrupo_2_2 = new SubGrupoRequisito()
            subGrupo_2_2.numeroReferenciaMoreqJus="2.2"
            subGrupo_2_2.nome ="Classificacao e metadados dos processos/dossiês"
            subGrupo_2_2.grupoRequisito = grupoRequisito_2
            subGrupo_2_2.save(flush:true)

        }



        def subGrupo_2_3 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.3")
        def subGrupo_2_4 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.4")
        def subGrupo_2_5 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.5")
        def subGrupo_2_6 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.6")






        def grupoRequisito_3 = GrupoRequisito.findByNumeroReferenciaMoreqJus("3")
        if(!grupoRequisito_3){
            grupoRequisito_3 = new GrupoRequisito()
            grupoRequisito_3.nome = "Captura"
            grupoRequisito_3.resumo = ""
            grupoRequisito_3.numeroReferenciaMoreqJus="3"
            grupoRequisito_3.save(flush:true)

        }

        def grupoRequisito_4 = GrupoRequisito.findByNumeroReferenciaMoreqJus("4")
        if(!grupoRequisito_4){
            grupoRequisito_4 = new GrupoRequisito()
            grupoRequisito_4.nome = "Armazenamento"
            grupoRequisito_4.resumo = ""
            grupoRequisito_4.numeroReferenciaMoreqJus="4"
            grupoRequisito_4.save(flush:true)

        }

        def grupoRequisito_5 = GrupoRequisito.findByNumeroReferenciaMoreqJus("5")
        if(!grupoRequisito_5){
            grupoRequisito_5 = new GrupoRequisito()
            grupoRequisito_5.nome = "Preservação"
            grupoRequisito_5.resumo = ""
            grupoRequisito_5.numeroReferenciaMoreqJus="5"
            grupoRequisito_5.save(flush:true)

        }

        def grupoRequisito_6 = GrupoRequisito.findByNumeroReferenciaMoreqJus("6")
        if(!grupoRequisito_6){
            grupoRequisito_6 = new GrupoRequisito()
            grupoRequisito_6.nome = "Segurança"
            grupoRequisito_6.resumo = ""
            grupoRequisito_6.numeroReferenciaMoreqJus="6"
            grupoRequisito_6.save(flush:true)

        }

        def grupoRequisito_7 = GrupoRequisito.findByNumeroReferenciaMoreqJus("7")
        if(!grupoRequisito_7){
            grupoRequisito_7 = new GrupoRequisito()
            grupoRequisito_7.nome = "Tramitação e fluxo de trabalho"
            grupoRequisito_7.resumo = ""
            grupoRequisito_7.numeroReferenciaMoreqJus="7"
            grupoRequisito_7.save(flush:true)

        }

        def grupoRequisito_8 = GrupoRequisito.findByNumeroReferenciaMoreqJus("8")
        if(!grupoRequisito_8){
            grupoRequisito_8 = new GrupoRequisito()
            grupoRequisito_8.nome = "Avaliação e destinação"
            grupoRequisito_8.resumo = ""
            grupoRequisito_8.numeroReferenciaMoreqJus="8"
            grupoRequisito_8.save(flush:true)

        }


        def grupoRequisito_9 = GrupoRequisito.findByNumeroReferenciaMoreqJus("9")
        if(!grupoRequisito_9){
            grupoRequisito_9 = new GrupoRequisito()
            grupoRequisito_9.nome = "Pesquisa, localização e apresentação de documentos"
            grupoRequisito_9.resumo = ""
            grupoRequisito_9.numeroReferenciaMoreqJus="9"
            grupoRequisito_9.save(flush:true)

        }


        def grupoRequisito_10 = GrupoRequisito.findByNumeroReferenciaMoreqJus("10")
        if(!grupoRequisito_10){
            grupoRequisito_10 = new GrupoRequisito()
            grupoRequisito_10.nome = "Funções administrativas"
            grupoRequisito_10.resumo = ""
            grupoRequisito_10.numeroReferenciaMoreqJus="10"
            grupoRequisito_10.save(flush:true)

        }

        def grupoRequisito_11 = GrupoRequisito.findByNumeroReferenciaMoreqJus("11")
        if(!grupoRequisito_11){
            grupoRequisito_11 = new GrupoRequisito()
            grupoRequisito_11.nome = "Usabilidade"
            grupoRequisito_11.resumo = ""
            grupoRequisito_11.numeroReferenciaMoreqJus="11"
            grupoRequisito_11.save(flush:true)

        }

        def grupoRequisito_12 = GrupoRequisito.findByNumeroReferenciaMoreqJus("12")
        if(!grupoRequisito_12){
            grupoRequisito_12 = new GrupoRequisito()
            grupoRequisito_12.nome = "Interoperabilidade"
            grupoRequisito_12.resumo = ""
            grupoRequisito_12.numeroReferenciaMoreqJus="12"
            grupoRequisito_12.save(flush:true)

        }

        def grupoRequisito_13 = GrupoRequisito.findByNumeroReferenciaMoreqJus("13")
        if(!grupoRequisito_13){
            grupoRequisito_13 = new GrupoRequisito()
            grupoRequisito_13.nome = "Disponibilidade"
            grupoRequisito_13.resumo = ""
            grupoRequisito_13.numeroReferenciaMoreqJus="13"
            grupoRequisito_13.save(flush:true)

        }

        def grupoRequisito_14 = GrupoRequisito.findByNumeroReferenciaMoreqJus("14")
        if(!grupoRequisito_14){
            grupoRequisito_14 = new GrupoRequisito()
            grupoRequisito_14.nome = "Desempenho e escalabilidade"
            grupoRequisito_14.resumo = ""
            grupoRequisito_14.numeroReferenciaMoreqJus="14"
            grupoRequisito_14.save(flush:true)

        }



    }
    def destroy = {
    }
}
