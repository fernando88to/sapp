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


        cargaGrupo2()

        cargaGrupo3()

        def grupoRequisito_4 = GrupoRequisito.findByNumeroReferenciaMoreqJus("4")
        if(!grupoRequisito_4){
            grupoRequisito_4 = new GrupoRequisito()
            grupoRequisito_4.nome = "Armazenamento"
            grupoRequisito_4.resumo = ""
            grupoRequisito_4.numeroReferenciaMoreqJus=4
            grupoRequisito_4.save(flush:true)

        }

        def grupoRequisito_5 = GrupoRequisito.findByNumeroReferenciaMoreqJus("5")
        if(!grupoRequisito_5){
            grupoRequisito_5 = new GrupoRequisito()
            grupoRequisito_5.nome = "Preservação"
            grupoRequisito_5.resumo = ""
            grupoRequisito_5.numeroReferenciaMoreqJus=5
            grupoRequisito_5.save(flush:true)

        }

        def grupoRequisito_6 = GrupoRequisito.findByNumeroReferenciaMoreqJus("6")
        if(!grupoRequisito_6){
            grupoRequisito_6 = new GrupoRequisito()
            grupoRequisito_6.nome = "Segurança"
            grupoRequisito_6.resumo = ""
            grupoRequisito_6.numeroReferenciaMoreqJus=6
            grupoRequisito_6.save(flush:true)

        }

        def grupoRequisito_7 = GrupoRequisito.findByNumeroReferenciaMoreqJus("7")
        if(!grupoRequisito_7){
            grupoRequisito_7 = new GrupoRequisito()
            grupoRequisito_7.nome = "Tramitação e fluxo de trabalho"
            grupoRequisito_7.resumo = ""
            grupoRequisito_7.numeroReferenciaMoreqJus=7
            grupoRequisito_7.save(flush:true)

        }

        def grupoRequisito_8 = GrupoRequisito.findByNumeroReferenciaMoreqJus("8")
        if(!grupoRequisito_8){
            grupoRequisito_8 = new GrupoRequisito()
            grupoRequisito_8.nome = "Avaliação e destinação"
            grupoRequisito_8.resumo = ""
            grupoRequisito_8.numeroReferenciaMoreqJus=8
            grupoRequisito_8.save(flush:true)

        }


        def grupoRequisito_9 = GrupoRequisito.findByNumeroReferenciaMoreqJus("9")
        if(!grupoRequisito_9){
            grupoRequisito_9 = new GrupoRequisito()
            grupoRequisito_9.nome = "Pesquisa, localização e apresentação de documentos"
            grupoRequisito_9.resumo = ""
            grupoRequisito_9.numeroReferenciaMoreqJus=9
            grupoRequisito_9.save(flush:true)

        }


        def grupoRequisito_10 = GrupoRequisito.findByNumeroReferenciaMoreqJus("10")
        if(!grupoRequisito_10){
            grupoRequisito_10 = new GrupoRequisito()
            grupoRequisito_10.nome = "Funções administrativas"
            grupoRequisito_10.resumo = ""
            grupoRequisito_10.numeroReferenciaMoreqJus=10
            grupoRequisito_10.save(flush:true)

        }

        def grupoRequisito_11 = GrupoRequisito.findByNumeroReferenciaMoreqJus("11")
        if(!grupoRequisito_11){
            grupoRequisito_11 = new GrupoRequisito()
            grupoRequisito_11.nome = "Usabilidade"
            grupoRequisito_11.resumo = ""
            grupoRequisito_11.numeroReferenciaMoreqJus=11
            grupoRequisito_11.save(flush:true)

        }

        def grupoRequisito_12 = GrupoRequisito.findByNumeroReferenciaMoreqJus("12")
        if(!grupoRequisito_12){
            grupoRequisito_12 = new GrupoRequisito()
            grupoRequisito_12.nome = "Interoperabilidade"
            grupoRequisito_12.resumo = ""
            grupoRequisito_12.numeroReferenciaMoreqJus=12
            grupoRequisito_12.save(flush:true)

        }

        def grupoRequisito_13 = GrupoRequisito.findByNumeroReferenciaMoreqJus("13")
        if(!grupoRequisito_13){
            grupoRequisito_13 = new GrupoRequisito()
            grupoRequisito_13.nome = "Disponibilidade"
            grupoRequisito_13.resumo = ""
            grupoRequisito_13.numeroReferenciaMoreqJus=13
            grupoRequisito_13.save(flush:true)

        }

        def grupoRequisito_14 = GrupoRequisito.findByNumeroReferenciaMoreqJus("14")
        if(!grupoRequisito_14){
            grupoRequisito_14 = new GrupoRequisito()
            grupoRequisito_14.nome = "Desempenho e escalabilidade"
            grupoRequisito_14.resumo = ""
            grupoRequisito_14.numeroReferenciaMoreqJus=14
            grupoRequisito_14.save(flush:true)

        }


        cargaTJTO()

    }


    def destroy = {
    }

    def cargaGrupo3() {
        def grupoRequisito_3 = GrupoRequisito.findByNumeroReferenciaMoreqJus("3")
        if (!grupoRequisito_3) {
            grupoRequisito_3 = new GrupoRequisito()
            grupoRequisito_3.nome = "Captura"
            grupoRequisito_3.resumo = ""
            grupoRequisito_3.numeroReferenciaMoreqJus = 3
            grupoRequisito_3.save(flush: true)

        }
    }

    def cargaGrupo2(){
        def grupoRequisito_2 = GrupoRequisito.findByNumeroReferenciaMoreqJus("2")
        if(!grupoRequisito_2){
            grupoRequisito_2 = new GrupoRequisito()
            grupoRequisito_2.nome = "Organização dos documentos institucionais: plano de classificação e manutenção dos documentos"
            grupoRequisito_2.resumo = "Os documentos institucionais podem ser agregados em processos/dossiês, de\n" +
                    "forma estruturada. Essa estrutura reflete as funções e atividades da organização,\n" +
                    "representadas no plano de classificação.\n" +
                    "O Judiciário comumente organiza seus documentos institucionais em documentos\n" +
                    "e processos: judiciais e administrativos."

            grupoRequisito_2.numeroReferenciaMoreqJus=2
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


        def requisitoRPC2_1_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.3")
        if(!requisitoRPC2_1_3){
            requisitoRPC2_1_3 = new Requisito()
            requisitoRPC2_1_3.numeroReferenciaMoreqJus = "RPC2.1.3"
            requisitoRPC2_1_3.obrigatorio = true
            requisitoRPC2_1_3.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_3.nome = "Garantir a criação de classes, subclasses, grupos e subgrupos nos níveis do plano de classificação e de outros instrumentos de classificação de documentos e processos de acordo com o método de codificação adotado."
            requisitoRPC2_1_3.save(flush:true)
        }

        def requisitoRPC2_1_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.4")
        if(!requisitoRPC2_1_4){
            requisitoRPC2_1_4 = new Requisito()
            requisitoRPC2_1_4.numeroReferenciaMoreqJus = "RPC2.1.4"
            requisitoRPC2_1_4.obrigatorio = true
            requisitoRPC2_1_4.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_4.nome = "Registrar as datas de abertura de uma nova classe, reclassificação, movimentação e modificação da classe no respectivo metadado."
            requisitoRPC2_1_4.save(flush:true)
        }

        def requisitoRPC2_1_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.5")
        if(!requisitoRPC2_1_5){
            requisitoRPC2_1_5 = new Requisito()
            requisitoRPC2_1_5.numeroReferenciaMoreqJus = "RPC2.1.5"
            requisitoRPC2_1_5.obrigatorio = true
            requisitoRPC2_1_5.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_5.nome = "Registrar a mudança de nome de uma classe já existente no respectivo metadado"
            requisitoRPC2_1_5.save(flush:true)
        }


        def requisitoRPC2_1_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.6")
        if(!requisitoRPC2_1_6){
            requisitoRPC2_1_6 = new Requisito()
            requisitoRPC2_1_6.numeroReferenciaMoreqJus = "RPC2.1.6"
            requisitoRPC2_1_6.obrigatorio = true
            requisitoRPC2_1_6.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_6.nome = "Permitir o deslocamento de uma classe inteira, incluindo as subclasses, grupos, subgrupos e os documentos ali classificados, para outra localização no plano de classificação. Nesse caso, é necessário fazer o registro do deslocamento nos metadados desses instrumentos."
            requisitoRPC2_1_6.save(flush:true)
        }


        def requisitoRPC2_1_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.7")
        if(!requisitoRPC2_1_7){
            requisitoRPC2_1_7 = new Requisito()
            requisitoRPC2_1_7.numeroReferenciaMoreqJus = "RPC2.1.7"
            requisitoRPC2_1_7.obrigatorio = true
            requisitoRPC2_1_7.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_7.nome = "Permitir que o gestor do sistema torne inativa e inacessível aos demais usuários uma classe em que não serão mais classificados documentos."
            requisitoRPC2_1_7.save(flush:true)
        }

        def requisitoRPC2_1_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.8")
        if(!requisitoRPC2_1_8){
            requisitoRPC2_1_8 = new Requisito()
            requisitoRPC2_1_8.numeroReferenciaMoreqJus = "RPC2.1.8"
            requisitoRPC2_1_8.obrigatorio = true
            requisitoRPC2_1_8.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_8.nome = "Impedir a eliminação de uma classe ativa ou inativa."
            requisitoRPC2_1_8.save(flush:true)
        }


        def requisitoRPC2_1_9 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.9")
        if(!requisitoRPC2_1_9){
            requisitoRPC2_1_9 = new Requisito()
            requisitoRPC2_1_9.numeroReferenciaMoreqJus = "RPC2.1.9"
            requisitoRPC2_1_9.obrigatorio = true
            requisitoRPC2_1_9.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_9.nome = "Permitir a associação de metadados às classes e restringir a inclusão e alteração desses mesmos metadados somente a usuários autorizados."
            requisitoRPC2_1_9.save(flush:true)
        }



        def requisitoRPC2_1_10 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.10")
        if(!requisitoRPC2_1_10){
            requisitoRPC2_1_10 = new Requisito()
            requisitoRPC2_1_10.numeroReferenciaMoreqJus = "RPC2.1.10"
            requisitoRPC2_1_10.obrigatorio = true
            requisitoRPC2_1_10.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_10.nome = "<p>Disponibilizar pelo menos dois mecanismos de atribui&ccedil;&atilde;o de identificadores &agrave;s classes do plano de classifica&ccedil;&atilde;o, prevendo a possibilidade de se utilizar ambos, separadamente ou em conjunto, na mesma aplica&ccedil;&atilde;o:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>\n" +
                    "\t<p>&nbsp;Atribui&ccedil;&atilde;o de um c&oacute;digo num&eacute;rico ou alfanum&eacute;rico.</p>\n" +
                    "\t</li>\n" +
                    "\t<li>\n" +
                    "\t<p>&nbsp;Atribui&ccedil;&atilde;o de um termo que identifique cada classe.</p>\n" +
                    "\t</li>\n" +
                    "</ul>"
            requisitoRPC2_1_10.save(flush:true)
        }


        def requisitoRPC2_1_11 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.11")
        if(!requisitoRPC2_1_11){
            requisitoRPC2_1_11 = new Requisito()
            requisitoRPC2_1_11.numeroReferenciaMoreqJus = "RPC2.1.11"
            requisitoRPC2_1_11.obrigatorio = true
            requisitoRPC2_1_11.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_11.nome = "<p>Prever atributos associados aos instrumentos de classifica&ccedil;&atilde;o e indexa&ccedil;&atilde;o por assuntos, de modo a n&atilde;o permitir classifica&ccedil;&otilde;es gen&eacute;ricas, nos casos em que a classifica&ccedil;&atilde;o por assuntos n&atilde;o atender ao caso espec&iacute;fico.</p>\n" +
                    "\n" +
                    "<p>Com exce&ccedil;&atilde;o do usu&aacute;rio autorizado, em algumas classes n&atilde;o &eacute; permitido incluir documentos. Nesses casos os documentos devem ser classificados apenas nos n&iacute;veis subordinados.</p>\n" +
                    "\n" +
                    "<p>Ex.1 &ndash; Na Tabela Unificada de Assuntos do Judici&aacute;rio brasileiro os processos devem ser classificados no &uacute;ltimo n&iacute;vel dispon&iacute;vel para cada assunto e quando se tratar de um novo assunto, os usu&aacute;rios autorizados podem classificar o processo, apenas provisoriamente, no &uacute;ltimo n&iacute;vel pertinente, at&eacute; que se crie o novo assunto solicitado.</p>"
            requisitoRPC2_1_11.save(flush:true)
        }


        def requisitoRPC2_1_12 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.12")
        if(!requisitoRPC2_1_12){
            requisitoRPC2_1_12 = new Requisito()
            requisitoRPC2_1_12.numeroReferenciaMoreqJus = "RPC2.1.12"
            requisitoRPC2_1_12.obrigatorio = true
            requisitoRPC2_1_12.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_12.nome = "<p>Utilizar o termo completo para identificar uma classe. Entende-se por termo completo toda a hierarquia referente &agrave;quela classe.</p>\n" +
                    "\n" +
                    "<p>Ex: Tabela Unificada de Assuntos do Judici&aacute;rio</p>\n" +
                    "\n" +
                    "<p>Termo de Ades&atilde;o da LC 110/2001 &ndash; Atualiza&ccedil;&atilde;o de Conta FGTS/Fundo de Garantia por Tempo de Servi&ccedil;o &ndash; Entidades Administrativas /Administra&ccedil;&atilde;o P&uacute;blica &ndash; Direito Administrativo e outras mat&eacute;rias do Direito P&uacute;blico.</p>"
            requisitoRPC2_1_12.save(flush:true)
        }


        def requisitoRPC2_1_13 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.13")
        if(!requisitoRPC2_1_13){
            requisitoRPC2_1_13 = new Requisito()
            requisitoRPC2_1_13.numeroReferenciaMoreqJus = "RPC2.1.13"
            requisitoRPC2_1_13.obrigatorio = true
            requisitoRPC2_1_13.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_13.nome = "Assegurar que os termos completos, que identificam cada classe,\n" +
                    "sejam únicos em um instrumento de classificação de processos\n" +
                    "ou documentos. "
            requisitoRPC2_1_13.save(flush:true)
        }

        def requisitoRPC2_1_14 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.1.14")
        if(!requisitoRPC2_1_14){
            requisitoRPC2_1_14 = new Requisito()
            requisitoRPC2_1_14.numeroReferenciaMoreqJus = "RPC2.1.14"
            requisitoRPC2_1_14.obrigatorio = false
            requisitoRPC2_1_14.subGrupoRequisito = subGrupo_2_1
            requisitoRPC2_1_14.nome = "<p>Prover funcionalidades com vistas &agrave; elabora&ccedil;&atilde;o de relat&oacute;rios para apoiar a gest&atilde;o de um instrumento de classifica&ccedil;&atilde;o de processos ou documentos, incluindo a capacidade de gerar relat&oacute;rio:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>\n" +
                    "\t<p>Completo de todo o instrumento de classifica&ccedil;&atilde;o de processos ou documentos.</p>\n" +
                    "\t</li>\n" +
                    "\t<li>\n" +
                    "\t<p>&nbsp;Parcial do instrumento de classifica&ccedil;&atilde;o de processos ou documentos a partir de um ponto determinado na hierarquia.&nbsp;</p>\n" +
                    "\t</li>\n" +
                    "\t<li>\n" +
                    "\t<p>&nbsp;Dos documentos ou processos/dossi&ecirc;s classificados em uma ou mais classes do plano de classifica&ccedil;&atilde;o.</p>\n" +
                    "\t</li>\n" +
                    "\t<li>\n" +
                    "\t<p>&nbsp;De documentos classificados por unidade administrativa.</p>\n" +
                    "\t</li>\n" +
                    "</ul>\n" +
                    "\n" +
                    "<p>&nbsp;</p>"
            requisitoRPC2_1_14.save(flush:true)
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





    }

    def cargaTJTO(){
        def instituicao = Instituicao.get(1l)
        if(!instituicao){
            instituicao = new Instituicao()
            instituicao.nome ="Tribunal de Justiça do Tocantins"
            instituicao.sigla = "TJTO"
            instituicao.endereco = "sem endereço"
            instituicao.save(flush:true)

            def sistemaEprc = new Sistema()
            sistemaEprc.nome = "Processo Eletrônico"
            sistemaEprc.sigla ="EPROC"
            sistemaEprc.url = "http://eproc.tjto.jus.br/"
            sistemaEprc.instituicao = instituicao
            sistemaEprc.save(flush:true)


            def sistemaSei = new Sistema()
            sistemaSei.nome = "Sistema Eletrônicio Administrativo"
            sistemaSei.sigla ="SEI"
            sistemaSei.url = "http://sei.tjto.jus.br/"
            sistemaSei.instituicao = instituicao
            sistemaSei.save(flush:true)


            def sistemaGise = new Sistema()
            sistemaGise.nome = "Sistema de Gestão das Serventias ExtraJudiciais"
            sistemaGise.sigla ="GISE"
            sistemaGise.url = "http://gise.tjto.jus.br/Gise"
            sistemaGise.instituicao = instituicao
            sistemaGise.save(flush:true)

        }
    }
}
