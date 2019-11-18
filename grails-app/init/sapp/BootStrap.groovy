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


        def subGrupo_3_1 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("3.1")
        if(!subGrupo_3_1){
            subGrupo_3_1 = new SubGrupoRequisito()
            subGrupo_3_1.numeroReferenciaMoreqJus="3.1"
            subGrupo_3_1.nome ="Captura: procedimentos gerais "
            subGrupo_3_1.grupoRequisito = grupoRequisito_3
            subGrupo_3_1.save(flush:true)

        }

        def requisitoRCA3_1_1 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.1")
        if(!requisitoRCA3_1_1){
            requisitoRCA3_1_1 = new Requisito()
            requisitoRCA3_1_1.numeroReferenciaMoreqJus = "RCA3.1.1"
            requisitoRCA3_1_1.obrigatorio = true
            requisitoRCA3_1_1.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_1.nome = "<p>A captura deve garantir a execu&ccedil;&atilde;o das fun&ccedil;&otilde;es relacionadas a seguir, de acordo com o sistema de classifica&ccedil;&atilde;o do Judici&aacute;rio brasileiro:&nbsp;</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Registrar e gerenciar todos os documentos n&atilde;o-digitais.</li>\n" +
                    "\t<li>&nbsp;Registrar e gerenciar todos os documentos digitais, independentemente do contexto tecnol&oacute;gico.</li>\n" +
                    "\t<li>&nbsp;Classificar todos os documentos de acordo com o plano de classifica&ccedil;&atilde;o ou crit&eacute;rios de guarda.</li>\n" +
                    "\t<li>&nbsp;Controlar e validar a introdu&ccedil;&atilde;o de metadados.</li>\n" +
                    "</ul>"

            requisitoRCA3_1_1.save(flush:true)
        }

        def requisitoRCA3_1_2 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.2")
        if(!requisitoRCA3_1_2){
            requisitoRCA3_1_2 = new Requisito()
            requisitoRCA3_1_2.numeroReferenciaMoreqJus = "RCA3.1.2"
            requisitoRCA3_1_2.obrigatorio = true
            requisitoRCA3_1_2.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_2.nome = "<p>Capturar documentos digitais das seguintes formas:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Documento individual produzido em arquivo digital fora do Gest&atilde;oDoc.</li>\n" +
                    "\t<li>Documento individual produzido em workflow integrado ao Gest&atilde;oDoc.</li>\n" +
                    "\t<li>&nbsp;Documentos em lote.</li>\n" +
                    "</ul>"

            requisitoRCA3_1_2.save(flush:true)
        }


        def requisitoRCA3_1_3 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.3")
        if(!requisitoRCA3_1_3){
            requisitoRCA3_1_3 = new Requisito()
            requisitoRCA3_1_3.numeroReferenciaMoreqJus = "RCA3.1.3"
            requisitoRCA3_1_3.obrigatorio = false
            requisitoRCA3_1_3.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_3.nome = "Automatizar a produção de documentos por meio da\n" +
                    "exibição de formulários e modelos predefinidos pelo programa de\n" +
                    "gestão de processos e documentos."

            requisitoRCA3_1_3.save(flush:true)
        }

        def requisitoRCA3_1_4 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.4")
        if(!requisitoRCA3_1_4){
            requisitoRCA3_1_4 = new Requisito()
            requisitoRCA3_1_4.numeroReferenciaMoreqJus = "RCA3.1.4"
            requisitoRCA3_1_4.obrigatorio = true
            requisitoRCA3_1_4.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_4.nome = "Automatizar a produção de petições eletrônicas por meio da\n" +
                    "exibição de formulários e modelos predefinidos. "

            requisitoRCA3_1_4.save(flush:true)
        }

        def requisitoRCA3_1_5 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.5")
        if(!requisitoRCA3_1_5){
            requisitoRCA3_1_5 = new Requisito()
            requisitoRCA3_1_5.numeroReferenciaMoreqJus = "RCA3.1.5"
            requisitoRCA3_1_5.obrigatorio = true
            requisitoRCA3_1_5.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_5.nome = "Aceitar o conteúdo do documento, bem como as informações que\n" +
                    "definem sua apresentação."

            requisitoRCA3_1_5.save(flush:true)
        }

        def requisitoRCA3_1_6 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.6")
        if(!requisitoRCA3_1_6){
            requisitoRCA3_1_6 = new Requisito()
            requisitoRCA3_1_6.numeroReferenciaMoreqJus = "RCA3.1.6"
            requisitoRCA3_1_6.obrigatorio = true
            requisitoRCA3_1_6.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_6.nome = "Os documentos associados a vários objetos digitais devem ser\n" +
                    "desassociados e capturados individualmente."

            requisitoRCA3_1_6.save(flush:true)
        }

        def requisitoRCA3_1_7 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.7")
        if(!requisitoRCA3_1_7){
            requisitoRCA3_1_7 = new Requisito()
            requisitoRCA3_1_7.numeroReferenciaMoreqJus = "RCA3.1.7"
            requisitoRCA3_1_7.obrigatorio = true
            requisitoRCA3_1_7.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_7.nome = "<p>Permitir a inser&ccedil;&atilde;o de todos os metadados, obrigat&oacute;rios e optativos, definidos em sua configura&ccedil;&atilde;o e garantir que se mantenham associados ao documento. S&atilde;o exemplos de metadados:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Nome do arquivo digital.</li>\n" +
                    "\t<li>&nbsp;N&uacute;mero identificador atribu&iacute;do pelo sistema.</li>\n" +
                    "\t<li>&nbsp;Data e hora de produ&ccedil;&atilde;o e captura.</li>\n" +
                    "\t<li>&nbsp;Data e hora de transmiss&atilde;o e recebimento.</li>\n" +
                    "\t<li>&nbsp;T&iacute;tulo ou descri&ccedil;&atilde;o abreviada.</li>\n" +
                    "\t<li>&nbsp;Formato (g&ecirc;nero / esp&eacute;cie / tipo).</li>\n" +
                    "\t<li>&nbsp;Usu&aacute;rio cadastrador.</li>\n" +
                    "\t<li>&nbsp;Unidade respons&aacute;vel pela execu&ccedil;&atilde;o da a&ccedil;&atilde;o.</li>\n" +
                    "\t<li>&nbsp;Indica&ccedil;&atilde;o de anota&ccedil;&atilde;o.</li>\n" +
                    "\t<li>&nbsp;Restri&ccedil;&atilde;o de acesso.</li>\n" +
                    "\t<li>&nbsp;Registro das migra&ccedil;&otilde;es e data em que ocorreram.</li>\n" +
                    "\t<li>&nbsp;N&uacute;meros das p&aacute;ginas inicial e final do documento.</li>\n" +
                    "\t<li>&nbsp;Tamanho do documento.</li>\n" +
                    "\t<li>Checksum.</li>\n" +
                    "\t<li>&nbsp;Software (nome e vers&atilde;o) sob o qual o documento foi produzido ou no qual foi capturado.</li>\n" +
                    "\t<li>M&aacute;scaras de formata&ccedil;&atilde;o (template) necess&aacute;rias para interpretar a estrutura do documento.</li>\n" +
                    "\t<li>&nbsp;Classifica&ccedil;&atilde;o de acordo com os instrumentos de classifica&ccedil;&atilde;o, temporalidade e destina&ccedil;&atilde;o da pol&iacute;tica de gest&atilde;o documental do Judici&aacute;rio brasileiro.</li>\n" +
                    "</ul>"

            requisitoRCA3_1_7.save(flush:true)
        }


        def requisitoRCA3_1_8 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.8")
        if(!requisitoRCA3_1_8){
            requisitoRCA3_1_8 = new Requisito()
            requisitoRCA3_1_8.numeroReferenciaMoreqJus = "RCA3.1.8"
            requisitoRCA3_1_8.obrigatorio = true
            requisitoRCA3_1_8.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_8.nome = "Permitir a inserção dos metadados obrigatórios, previstos em\n" +
                    "legislação específica do Judiciário brasileiro no momento da\n" +
                    "captura de documentos e processos/dossiês. "

            requisitoRCA3_1_8.save(flush:true)
        }

        def requisitoRCA3_1_9 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.9")
        if(!requisitoRCA3_1_9){
            requisitoRCA3_1_9 = new Requisito()
            requisitoRCA3_1_9.numeroReferenciaMoreqJus = "RCA3.1.9"
            requisitoRCA3_1_9.obrigatorio = true
            requisitoRCA3_1_9.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_9.nome = "Atribuir um número identificador a cada processo/dossiê e\n" +
                    "documento capturado, que serve para identificá-lo desde o\n" +
                    "momento da captura até sua destinação final dentro do\n" +
                    "GestãoDoc a fim de manter a integridade.  "

            requisitoRCA3_1_9.save(flush:true)
        }


        def requisitoRCA3_1_10 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.10")
        if(!requisitoRCA3_1_10){
            requisitoRCA3_1_10 = new Requisito()
            requisitoRCA3_1_10.numeroReferenciaMoreqJus = "RCA3.1.10"
            requisitoRCA3_1_10.obrigatorio = true
            requisitoRCA3_1_10.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_10.nome = "<p>O formato do n&uacute;mero identificador atribu&iacute;do pelo sistema deve ser definido no momento da configura&ccedil;&atilde;o do Gest&atilde;oDoc.</p>\n" +
                    "\n" +
                    "<p>O identificador pode ser num&eacute;rico ou alfanum&eacute;rico, ou pode incluir os identificadores encadeados das entidades superiores no ramo apropriado da hierarquia.</p>"

            requisitoRCA3_1_10.save(flush:true)
        }


        def requisitoRCA3_1_11 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.11")
        if(!requisitoRCA3_1_11){
            requisitoRCA3_1_11 = new Requisito()
            requisitoRCA3_1_11.numeroReferenciaMoreqJus = "RCA3.1.11"
            requisitoRCA3_1_11.obrigatorio = true
            requisitoRCA3_1_11.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_11.nome = "<p>O identificador atribu&iacute;do pelo sistema deve:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Ser &uacute;nico e gerado automaticamente, vedada sua introdu&ccedil;&atilde;o manual e altera&ccedil;&atilde;o posterior</li>\n" +
                    "</ul>\n" +
                    "\n" +
                    "<p>ou</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Ser atribu&iacute;do pelo usu&aacute;rio e validado pelo sistema antes de ser aceito.</li>\n" +
                    "</ul>"

            requisitoRCA3_1_11.save(flush:true)
        }


        def requisitoRCA3_1_12 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.12")
        if(!requisitoRCA3_1_12){
            requisitoRCA3_1_12 = new Requisito()
            requisitoRCA3_1_12.numeroReferenciaMoreqJus = "RCA3.1.12"
            requisitoRCA3_1_12.obrigatorio = true
            requisitoRCA3_1_12.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_12.nome = "Utilizar o sistema de classificação e indexação de assuntos do\n" +
                    "Judiciário brasileiro para apoiar a atribuição do metadado\n" +
                    "assunto/descritor. "

            requisitoRCA3_1_12.save(flush:true)
        }

        def requisitoRCA3_1_13 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.13")
        if(!requisitoRCA3_1_13){
            requisitoRCA3_1_13 = new Requisito()
            requisitoRCA3_1_13.numeroReferenciaMoreqJus = "RCA3.1.13"
            requisitoRCA3_1_13.obrigatorio = false
            requisitoRCA3_1_13.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_13.nome = "Utilizar um tesauro ou vocabulário controlado para apoiar a\n" +
                    "atribuição do metadado assunto/descritor. "

            requisitoRCA3_1_13.save(flush:true)
        }


        def requisitoRCA3_1_14 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.14")
        if(!requisitoRCA3_1_14){
            requisitoRCA3_1_14 = new Requisito()
            requisitoRCA3_1_14.numeroReferenciaMoreqJus = "RCA3.1.14"
            requisitoRCA3_1_14.obrigatorio = true
            requisitoRCA3_1_14.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_14.nome = "Garantir que os metadados associados a um documento sejam\n" +
                    "alterados somente por usuários autorizados. "

            requisitoRCA3_1_14.save(flush:true)
        }

        def requisitoRCA3_1_15 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.15")
        if(!requisitoRCA3_1_15){
            requisitoRCA3_1_15 = new Requisito()
            requisitoRCA3_1_15.numeroReferenciaMoreqJus = "RCA3.1.15"
            requisitoRCA3_1_15.obrigatorio = true
            requisitoRCA3_1_15.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_15.nome = "<p>Inserir automaticamente os metadados previstos no sistema para o maior n&uacute;mero poss&iacute;vel de documentos.</p>\n" +
                    "\n" +
                    "<p>Por exemplo, para diminuir as tarefas do usu&aacute;rio do sistema e garantir maior exatid&atilde;o e efici&ecirc;ncia na inser&ccedil;&atilde;o dos metadados, no caso de documentos com forma padronizada (formul&aacute;rios, modelos de requerimentos, memorandos etc.) alguns metadados podem ser inseridos automaticamente, tais como: n&uacute;mero identificador, t&iacute;tulo, prazo de guarda</p>"

            requisitoRCA3_1_15.save(flush:true)
        }


        def requisitoRCA3_1_16 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.16")
        if(!requisitoRCA3_1_16){
            requisitoRCA3_1_16 = new Requisito()
            requisitoRCA3_1_16.numeroReferenciaMoreqJus = "RCA3.1.16"
            requisitoRCA3_1_16.obrigatorio = true
            requisitoRCA3_1_16.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_16.nome = "<p>Garantir a visualiza&ccedil;&atilde;o do registro de entrada do documento dentro do sistema com todos os metadados que possam ser inseridos automaticamente e os demais a serem atribu&iacute;dos pelo usu&aacute;rio.</p>\n" +
                    "\n" +
                    "<p>Por exemplo, o sistema pode atribuir automaticamente o n&uacute;mero identificador, a data de captura, o t&iacute;tulo, o originador e requerer que o usu&aacute;rio preencha os demais metadados</p>"

            requisitoRCA3_1_16.save(flush:true)
        }


        def requisitoRCA3_1_17 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.17")
        if(!requisitoRCA3_1_17){
            requisitoRCA3_1_17 = new Requisito()
            requisitoRCA3_1_17.numeroReferenciaMoreqJus = "RCA3.1.17"
            requisitoRCA3_1_17.obrigatorio = true
            requisitoRCA3_1_17.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_17.nome = "Garantir a inserção de outros metadados após a captura.\n" +
                    "Por exemplo, data e hora de alteração e mudança de suporte. "

            requisitoRCA3_1_17.save(flush:true)
        }

        def requisitoRCA3_1_18 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.18")
        if(!requisitoRCA3_1_18){
            requisitoRCA3_1_18 = new Requisito()
            requisitoRCA3_1_18.numeroReferenciaMoreqJus = "RCA3.1.18"
            requisitoRCA3_1_18.obrigatorio = false
            requisitoRCA3_1_18.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_18.nome = "Permitir ao usuário o registro de todas as versões de documento\n" +
                    "enquanto não for dada publicidade. "

            requisitoRCA3_1_18.save(flush:true)
        }

        def requisitoRCA3_1_19 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.19")
        if(!requisitoRCA3_1_19){
            requisitoRCA3_1_19 = new Requisito()
            requisitoRCA3_1_19.numeroReferenciaMoreqJus = "RCA3.1.19"
            requisitoRCA3_1_19.obrigatorio = false
            requisitoRCA3_1_19.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_19.nome = "Registrar a versão final do documento institucional após ter sido\n" +
                    "dada publicidade ou assinado digitalmente"

            requisitoRCA3_1_19.save(flush:true)
        }

        def requisitoRCA3_1_20 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.20")
        if(!requisitoRCA3_1_20){
            requisitoRCA3_1_20 = new Requisito()
            requisitoRCA3_1_20.numeroReferenciaMoreqJus = "RCA3.1.20"
            requisitoRCA3_1_20.obrigatorio = false
            requisitoRCA3_1_20.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_20.nome = "<p>Prestar assist&ecirc;ncia aos usu&aacute;rios no que diz respeito &agrave; classifica&ccedil;&atilde;o dos documentos, por meio de algumas ou de todas as a&ccedil;&otilde;es que se seguem:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Tornar acess&iacute;vel ao usu&aacute;rio somente o subconjunto do plano de classifica&ccedil;&atilde;o que diz respeito &agrave; sua atividade.</li>\n" +
                    "\t<li>Indicar as &uacute;ltimas classifica&ccedil;&otilde;es feitas pelo usu&aacute;rio.</li>\n" +
                    "\t<li>Indicar dossi&ecirc;s que contenham documentos institucionais relacionados.</li>\n" +
                    "\t<li>Indicar classifica&ccedil;&otilde;es poss&iacute;veis a partir dos metadados j&aacute; inseridos, como, por exemplo, classe de apela&ccedil;&atilde;o criminal quando se tratar de processo criminal e com apela&ccedil;&atilde;o recebida ou pauta de julgamento.</li>\n" +
                    "\t<li>Indicar classifica&ccedil;&otilde;es poss&iacute;veis a partir do conte&uacute;do do documento.</li>\n" +
                    "</ul>"

            requisitoRCA3_1_20.save(flush:true)
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

        def requisitoRPC2_2_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.1")
        if(!requisitoRPC2_2_1){
            requisitoRPC2_2_1 = new Requisito()
            requisitoRPC2_2_1.numeroReferenciaMoreqJus = "RPC2.2.1"
            requisitoRPC2_2_1.obrigatorio = true
            requisitoRPC2_2_1.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_1.nome = "Permitir a classificação dos processos/dossiês somente nas classes\n" +
                    "autorizadas.\n" +
                    "Ver RPC2.1.11 e RPC2.3.7 "
            requisitoRPC2_2_1.save(flush:true)
        }


        def requisitoRPC2_2_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.2")
        if(!requisitoRPC2_2_2){
            requisitoRPC2_2_2 = new Requisito()
            requisitoRPC2_2_2.numeroReferenciaMoreqJus = "RPC2.2.2"
            requisitoRPC2_2_2.obrigatorio = true
            requisitoRPC2_2_2.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_2.nome = "Permitir a classificação de um número ilimitado de\n" +
                    "processos/dossiês dentro de uma classe. "
            requisitoRPC2_2_2.save(flush:true)
        }

        def requisitoRPC2_2_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.3")
        if(!requisitoRPC2_2_3){
            requisitoRPC2_2_3 = new Requisito()
            requisitoRPC2_2_3.numeroReferenciaMoreqJus = "RPC2.2.3"
            requisitoRPC2_2_3.obrigatorio = true
            requisitoRPC2_2_3.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_3.nome = "Utilizar o termo completo da classe para identificar um\n" +
                    "processo/dossiê, tal como especificado em RPC2.1.12. "
            requisitoRPC2_2_3.save(flush:true)
        }


        def requisitoRPC2_2_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.4")
        if(!requisitoRPC2_2_4){
            requisitoRPC2_2_4 = new Requisito()
            requisitoRPC2_2_4.numeroReferenciaMoreqJus = "RPC2.2.4"
            requisitoRPC2_2_4.obrigatorio = true
            requisitoRPC2_2_4.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_4.nome = "Permitir a associação de metadados aos processos/dossiês e\n" +
                    "restringir a inclusão e alteração desses mesmos metadados\n" +
                    "somente a usuários autorizados. "
            requisitoRPC2_2_4.save(flush:true)
        }


        def requisitoRPC2_2_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.5")
        if(!requisitoRPC2_2_5){
            requisitoRPC2_2_5 = new Requisito()
            requisitoRPC2_2_5.numeroReferenciaMoreqJus = "RPC2.2.5"
            requisitoRPC2_2_5.obrigatorio = true
            requisitoRPC2_2_5.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_5.nome = "Associar os metadados dos processos/dossiês conforme\n" +
                    "estabelecido nos elementos de metadados."
            requisitoRPC2_2_5.save(flush:true)
        }



        def requisitoRPC2_2_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.6")
        if(!requisitoRPC2_2_6){
            requisitoRPC2_2_6 = new Requisito()
            requisitoRPC2_2_6.numeroReferenciaMoreqJus = "RPC2.2.6"
            requisitoRPC2_2_6.obrigatorio = true
            requisitoRPC2_2_6.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_6.nome = "<p>Permitir que um novo processo/dossi&ecirc; herde, da classe na qual foi classificado, determinados metadados predefinidos.</p>\n" +
                    "\n" +
                    "<p>Exemplos desta heran&ccedil;a s&atilde;o: temporalidade prevista e restri&ccedil;&atilde;o de acesso.</p>"
            requisitoRPC2_2_6.save(flush:true)
        }


        def requisitoRPC2_2_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.7")
        if(!requisitoRPC2_2_7){
            requisitoRPC2_2_7 = new Requisito()
            requisitoRPC2_2_7.numeroReferenciaMoreqJus = "RPC2.2.7"
            requisitoRPC2_2_7.obrigatorio = false
            requisitoRPC2_2_7.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_7.nome = "Relacionar os metadados herdados de forma que uma alteração no\n" +
                    "metadado de uma classe seja automaticamente incorporada ao\n" +
                    "processo/dossiê que herdou esse metadado. "
            requisitoRPC2_2_7.save(flush:true)
        }


        def requisitoRPC2_2_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.8")
        if(!requisitoRPC2_2_8){
            requisitoRPC2_2_8 = new Requisito()
            requisitoRPC2_2_8.numeroReferenciaMoreqJus = "RPC2.2.8"
            requisitoRPC2_2_8.obrigatorio = true
            requisitoRPC2_2_8.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_8.nome = "Permitir a alteração conjunta de um determinado metadado em um\n" +
                    "grupo de processos/dossiês previamente selecionado."
            requisitoRPC2_2_8.save(flush:true)
        }



        def subGrupo_2_3 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.3")

        if(!subGrupo_2_3){
            subGrupo_2_3 = new SubGrupoRequisito()
            subGrupo_2_3.numeroReferenciaMoreqJus="2.3"
            subGrupo_2_3.nome ="Gerenciamento dos processos/dossiês"
            subGrupo_2_3.grupoRequisito = grupoRequisito_2
            subGrupo_2_3.save(flush:true)

        }

        def requisitoRPC2_3_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.1")
        if(!requisitoRPC2_3_1){
            requisitoRPC2_3_1 = new Requisito()
            requisitoRPC2_3_1.numeroReferenciaMoreqJus = "RPC2.3.1"
            requisitoRPC2_3_1.obrigatorio = true
            requisitoRPC2_3_1.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_1.nome = "<p>Registrar automaticamente a data de abertura e de encerramento ou baixa do processo/dossi&ecirc;.</p>\n" +
                    "\n" +
                    "<p>Essas datas s&atilde;o par&acirc;metros para aplica&ccedil;&atilde;o dos prazos de guarda e destina&ccedil;&atilde;o do processo/dossi&ecirc;.</p>"
            requisitoRPC2_3_1.save(flush:true)
        }

        def requisitoRPC2_3_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.2")
        if(!requisitoRPC2_3_2){
            requisitoRPC2_3_2 = new Requisito()
            requisitoRPC2_3_2.numeroReferenciaMoreqJus = "RPC2.3.2"
            requisitoRPC2_3_2.obrigatorio = true
            requisitoRPC2_3_2.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_2.nome = "Permitir que um processo/dossiê seja encerrado, reaberto ou\n" +
                    "baixado mediante procedimentos regulamentares. "
            requisitoRPC2_3_2.save(flush:true)
        }


        def requisitoRPC2_3_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.3")
        if(!requisitoRPC2_3_3){
            requisitoRPC2_3_3 = new Requisito()
            requisitoRPC2_3_3.numeroReferenciaMoreqJus = "RPC2.3.3"
            requisitoRPC2_3_3.obrigatorio = true
            requisitoRPC2_3_3.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_3.nome = "Permitir que um processo/dossiê e seus respectivos volumes e\n" +
                    "documentos sejam reclassificados por um usuário autorizado e\n" +
                    "que todos os documentos já inseridos permaneçam nos\n" +
                    "processos/dossiês e volumes que estão sendo reclassificados, de\n" +
                    "modo a conservar a relação entre os documentos, volumes e\n" +
                    "processos/dossiês."
            requisitoRPC2_3_3.save(flush:true)
        }


        def requisitoRPC2_3_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.4")
        if(!requisitoRPC2_3_4){
            requisitoRPC2_3_4 = new Requisito()
            requisitoRPC2_3_4.numeroReferenciaMoreqJus = "RPC2.3.4"
            requisitoRPC2_3_4.obrigatorio = true
            requisitoRPC2_3_4.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_4.nome = "Manter o registro de suas posições anteriores à reclassificação,\n" +
                    "quando um processo/dossiê é reclassificado, de forma a obter-se\n" +
                    "um histórico. "
            requisitoRPC2_3_4.save(flush:true)
        }

        def requisitoRPC2_3_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.5")
        if(!requisitoRPC2_3_5){
            requisitoRPC2_3_5 = new Requisito()
            requisitoRPC2_3_5.numeroReferenciaMoreqJus = "RPC2.3.5"
            requisitoRPC2_3_5.obrigatorio = true
            requisitoRPC2_3_5.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_5.nome = "Permitir que o usuário autorizado introduza as razões para a\n" +
                    "reclassificação, quando um processo/dossiê ou documento é\n" +
                    "reclassificado. "
            requisitoRPC2_3_5.save(flush:true)
        }


        def requisitoRPC2_3_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.6")
        if(!requisitoRPC2_3_6){
            requisitoRPC2_3_6 = new Requisito()
            requisitoRPC2_3_6.numeroReferenciaMoreqJus = "RPC2.3.6"
            requisitoRPC2_3_6.obrigatorio = true
            requisitoRPC2_3_6.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_6.nome = "Permitir a geração de referências cruzadas para\n" +
                    "processos/dossiês afins. "
            requisitoRPC2_3_6.save(flush:true)
        }


        def requisitoRPC2_3_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.7")
        if(!requisitoRPC2_3_7){
            requisitoRPC2_3_7 = new Requisito()
            requisitoRPC2_3_7.numeroReferenciaMoreqJus = "RPC2.3.7"
            requisitoRPC2_3_7.obrigatorio = true
            requisitoRPC2_3_7.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_7.nome = "Registrar múltiplas entradas para um documento digital em mais\n" +
                    "de um processo/dossiê"
            requisitoRPC2_3_7.save(flush:true)
        }

        def requisitoRPC2_3_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.8")
        if(!requisitoRPC2_3_8){
            requisitoRPC2_3_8 = new Requisito()
            requisitoRPC2_3_8.numeroReferenciaMoreqJus = "RPC2.3.8"
            requisitoRPC2_3_8.obrigatorio = true
            requisitoRPC2_3_8.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_8.nome = "<p>Impedir a elimina&ccedil;&atilde;o de um processo/dossi&ecirc; digital ou de qualquer parte de seu conte&uacute;do em qualquer momento, exceto quando se tratar de elimina&ccedil;&atilde;o definitiva, consoante os crit&eacute;rios de classifica&ccedil;&atilde;o e guarda.</p>\n" +
                    "\n" +
                    "<p>A elimina&ccedil;&atilde;o ser&aacute; devidamente registrada em trilha de auditoria.</p>"
            requisitoRPC2_3_8.save(flush:true)
        }


        def requisitoRPC2_3_9 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.9")
        if(!requisitoRPC2_3_9){
            requisitoRPC2_3_9 = new Requisito()
            requisitoRPC2_3_9.numeroReferenciaMoreqJus = "RPC2.3.9"
            requisitoRPC2_3_9.obrigatorio = true
            requisitoRPC2_3_9.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_9.nome = "<p>Impedir o acr&eacute;scimo de novos documentos a processos/dossi&ecirc;s j&aacute; encerrados.</p>\n" +
                    "\n" +
                    "<p>Para receber novos documentos, os processos/dossi&ecirc;s encerrados dever&atilde;o ser reabertos.</p>"
            requisitoRPC2_3_9.save(flush:true)
        }


        def requisitoRPC2_3_10 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.10")
        if(!requisitoRPC2_3_10){
            requisitoRPC2_3_10 = new Requisito()
            requisitoRPC2_3_10.numeroReferenciaMoreqJus = "RPC2.3.10"
            requisitoRPC2_3_10.obrigatorio = true
            requisitoRPC2_3_10.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_10.nome = "Permitir a consulta aos processos/dossiês já encerrados. "
            requisitoRPC2_3_10.save(flush:true)
        }


        def requisitoRPC2_3_11 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.11")
        if(!requisitoRPC2_3_11){
            requisitoRPC2_3_11 = new Requisito()
            requisitoRPC2_3_11.numeroReferenciaMoreqJus = "RPC2.3.11"
            requisitoRPC2_3_11.obrigatorio = true
            requisitoRPC2_3_11.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_11.nome = "<p>Garantir a integridade da rela&ccedil;&atilde;o hier&aacute;rquica entre classe, processo/dossi&ecirc;, volume e documento em todos os momentos, independentemente de atividades de manuten&ccedil;&atilde;o, a&ccedil;&otilde;es do usu&aacute;rio ou falha de componentes do sistema.</p>\n" +
                    "\n" +
                    "<p>Em hip&oacute;tese alguma poder&aacute; ocorrer uma situa&ccedil;&atilde;o em que qualquer a&ccedil;&atilde;o do usu&aacute;rio ou falha do sistema d&ecirc; origem a uma inconsist&ecirc;ncia na base de dados do Gest&atilde;oDoc.</p>"
            requisitoRPC2_3_11.save(flush:true)
        }


        def requisitoRPC2_3_12 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.12")
        if(!requisitoRPC2_3_12){
            requisitoRPC2_3_12 = new Requisito()
            requisitoRPC2_3_12.numeroReferenciaMoreqJus = "RPC2.3.12"
            requisitoRPC2_3_12.obrigatorio = true
            requisitoRPC2_3_12.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_12.nome = "Oferecer ferramentas para a realização de operações em lote,\n" +
                    "tais como: abertura e encerramento de processos/dossiês e seus\n" +
                    "respectivos volumes, reclassificação, citação/intimação,\n" +
                    "sentença/decisão/despacho, etc. "
            requisitoRPC2_3_12.save(flush:true)
        }








        def subGrupo_2_4 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.4")
        if(!subGrupo_2_4){
            subGrupo_2_4 = new SubGrupoRequisito()
            subGrupo_2_4.numeroReferenciaMoreqJus="2.4"
            subGrupo_2_4.nome ="Processos "
            subGrupo_2_4.grupoRequisito = grupoRequisito_2
            subGrupo_2_4.save(flush:true)

        }

        def requisitoRPC2_4_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.1")
        if(!requisitoRPC2_4_1){
            requisitoRPC2_4_1 = new Requisito()
            requisitoRPC2_4_1.numeroReferenciaMoreqJus = "RPC2.4.1"
            requisitoRPC2_4_1.obrigatorio = true
            requisitoRPC2_4_1.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_1.nome = "Prever a formação/autuação de processos conforme estabelecido\n" +
                    "nas leis e regulamentações vigentes. "
            requisitoRPC2_4_1.save(flush:true)
        }


        def requisitoRPC2_4_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.2")
        if(!requisitoRPC2_4_2){
            requisitoRPC2_4_2 = new Requisito()
            requisitoRPC2_4_2.numeroReferenciaMoreqJus = "RPC2.4.2"
            requisitoRPC2_4_2.obrigatorio = true
            requisitoRPC2_4_2.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_2.nome = "<p>Prever que as pe&ccedil;as integrantes do processo recebam pagina&ccedil;&atilde;o contextualizada de acordo com cada processo relacionado.</p>\n" +
                    "\n" +
                    "<p>Uma mesma contesta&ccedil;&atilde;o juntada a v&aacute;rios processos tem numera&ccedil;&atilde;o diferente de acordo com a numera&ccedil;&atilde;o de cada processo.</p>"
            requisitoRPC2_4_2.save(flush:true)
        }


        def requisitoRPC2_4_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.3")
        if(!requisitoRPC2_4_3){
            requisitoRPC2_4_3 = new Requisito()
            requisitoRPC2_4_3.numeroReferenciaMoreqJus = "RPC2.4.3"
            requisitoRPC2_4_3.obrigatorio = true
            requisitoRPC2_4_3.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_3.nome = "<p>Prever procedimentos para reuni&atilde;o de processos por apensa&ccedil;&atilde;o.</p>\n" +
                    "\n" +
                    "<p>Nos processos judiciais, a apensa&ccedil;&atilde;o ocorre por determina&ccedil;&atilde;o legal ou judicial e nos administrativos, por determina&ccedil;&atilde;o da autoridade competente.</p>\n" +
                    "\n" +
                    "<p>Esse procedimento dever&aacute; ser registrado nos metadados do processo. Quando se tratar de processo judicial, deve-se lan&ccedil;ar o evento correspondente da Tabela Unificada de Movimenta&ccedil;&atilde;o Processual do Judici&aacute;rio Brasileiro (apensamento) e seu complemento obrigat&oacute;rio (n&uacute;mero do processo).</p>"
            requisitoRPC2_4_3.save(flush:true)
        }


        def requisitoRPC2_4_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.4")
        if(!requisitoRPC2_4_4){
            requisitoRPC2_4_4 = new Requisito()
            requisitoRPC2_4_4.numeroReferenciaMoreqJus = "RPC2.4.4"
            requisitoRPC2_4_4.obrigatorio = true
            requisitoRPC2_4_4.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_4.nome = "<p>Prever procedimentos para desapensa&ccedil;&atilde;o.</p>\n" +
                    "\n" +
                    "<p>Nos processos judiciais, via de regra, a desapensa&ccedil;&atilde;o ocorre por decis&atilde;o judicial e nos administrativos, por determina&ccedil;&atilde;o da autoridade competente.</p>\n" +
                    "\n" +
                    "<p>Esse procedimento dever&aacute; ser registrado nos metadados do processo. Quando se tratar de processo judicial, deve-se lan&ccedil;ar o evento correspondente da Tabela Unificada de Movimenta&ccedil;&atilde;o Processual do Judici&aacute;rio Brasileiro (desapensamento) e seu complemento obrigat&oacute;rio (n&uacute;mero do processo).</p>"
            requisitoRPC2_4_4.save(flush:true)
        }


        def requisitoRPC2_4_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.5")
        if(!requisitoRPC2_4_5){
            requisitoRPC2_4_5 = new Requisito()
            requisitoRPC2_4_5.numeroReferenciaMoreqJus = "RPC2.4.5"
            requisitoRPC2_4_5.obrigatorio = true
            requisitoRPC2_4_5.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_5.nome = "<p>Prever procedimentos para desentranhamento de pe&ccedil;as dos processos judiciais em aten&ccedil;&atilde;o &agrave; decis&atilde;o judicial ou segundo a legisla&ccedil;&atilde;o espec&iacute;fica, e dos administrativos, por determina&ccedil;&atilde;o da autoridade competente.</p>\n" +
                    "\n" +
                    "<p>Esse procedimento dever&aacute; ser registrado nos metadados do processo. Quando se tratar de processo judicial, deve-se lan&ccedil;ar o evento correspondente da Tabela Unificada de Movimenta&ccedil;&atilde;o Processual do Judici&aacute;rio Brasileiro (cancelamento de juntada &mdash; desentranhamento) e seu complemento obrigat&oacute;rio (especificar documento).</p>"
            requisitoRPC2_4_5.save(flush:true)
        }



        def requisitoRPC2_4_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.6")
        if(!requisitoRPC2_4_6){
            requisitoRPC2_4_6 = new Requisito()
            requisitoRPC2_4_6.numeroReferenciaMoreqJus = "RPC2.4.6"
            requisitoRPC2_4_6.obrigatorio = true
            requisitoRPC2_4_6.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_6.nome = "<p>Prever procedimentos para desmembramento de um processo judicial ou administrativo em dois ou mais processos.</p>\n" +
                    "\n" +
                    "<p>Nos processos judiciais, sempre ocorre por decis&atilde;o judicial, como no exemplo do art. 46, par&aacute;grafo &uacute;nico, do CPC ou do art. 80, CPP.</p>\n" +
                    "\n" +
                    "<p>Esse procedimento dever&aacute; ser registrado nos metadados do processo.</p>"
            requisitoRPC2_4_6.save(flush:true)
        }


        def requisitoRPC2_4_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.7")
        if(!requisitoRPC2_4_7){
            requisitoRPC2_4_7 = new Requisito()
            requisitoRPC2_4_7.numeroReferenciaMoreqJus = "RPC2.4.7"
            requisitoRPC2_4_7.obrigatorio = true
            requisitoRPC2_4_7.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_7.nome = "Prever procedimentos para a anexação de documentos\n" +
                    "organizados em volumes próprios a um determinado processo.\n" +
                    "Esse procedimento deverá ser registrado nos metadados do\n" +
                    "processo. "
            requisitoRPC2_4_7.save(flush:true)
        }



        def subGrupo_2_5 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.5")

        if(!subGrupo_2_5){
            subGrupo_2_5 = new SubGrupoRequisito()
            subGrupo_2_5.numeroReferenciaMoreqJus="2.5"
            subGrupo_2_5.nome ="Volumes: abertura, encerramento e metadados"
            subGrupo_2_5.grupoRequisito = grupoRequisito_2
            subGrupo_2_5.save(flush:true)
        }

        def requisitoRPC2_5_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.1")
        if(!requisitoRPC2_5_1){
            requisitoRPC2_5_1 = new Requisito()
            requisitoRPC2_5_1.numeroReferenciaMoreqJus = "RPC2.5.1"
            requisitoRPC2_5_1.obrigatorio = true
            requisitoRPC2_5_1.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_1.nome = "Gerenciar volumes para subdividir processos/dossiês,\n" +
                    "distinguindo entre processos/dossiês e volumes. "
            requisitoRPC2_5_1.save(flush:true)
        }

        def requisitoRPC2_5_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.2")
        if(!requisitoRPC2_5_2){
            requisitoRPC2_5_2 = new Requisito()
            requisitoRPC2_5_2.numeroReferenciaMoreqJus = "RPC2.5.2"
            requisitoRPC2_5_2.obrigatorio = true
            requisitoRPC2_5_2.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_2.nome = "Permitir a associação de metadados aos volumes e restringir a\n" +
                    "inclusão e a alteração desses mesmos metadados somente a\n" +
                    "usuários autorizados. "
            requisitoRPC2_5_2.save(flush:true)
        }

        def requisitoRPC2_5_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.3")
        if(!requisitoRPC2_5_3){
            requisitoRPC2_5_3 = new Requisito()
            requisitoRPC2_5_3.numeroReferenciaMoreqJus = "RPC2.5.3"
            requisitoRPC2_5_3.obrigatorio = true
            requisitoRPC2_5_3.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_3.nome = "<p>Permitir que um volume herde automaticamente do processo/dossi&ecirc; ao qual pertence determinados metadados predefinidos.</p>\n" +
                    "\n" +
                    "<p>Por exemplo: volume juntado em processo sigiloso tamb&eacute;m &eacute; sigiloso.</p>"
            requisitoRPC2_5_3.save(flush:true)
        }


        def requisitoRPC2_5_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.4")
        if(!requisitoRPC2_5_4){
            requisitoRPC2_5_4 = new Requisito()
            requisitoRPC2_5_4.numeroReferenciaMoreqJus = "RPC2.5.4"
            requisitoRPC2_5_4.obrigatorio = true
            requisitoRPC2_5_4.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_4.nome = "Permitir a abertura de volumes a qualquer processo/dossiê que\n" +
                    "não esteja encerrado. "
            requisitoRPC2_5_4.save(flush:true)
        }

        def requisitoRPC2_5_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.5")
        if(!requisitoRPC2_5_5){
            requisitoRPC2_5_5 = new Requisito()
            requisitoRPC2_5_5.numeroReferenciaMoreqJus = "RPC2.5.5"
            requisitoRPC2_5_5.obrigatorio = true
            requisitoRPC2_5_5.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_5.nome = "<p>Assegurar que, ao abrir um novo volume, o volume precedente seja automaticamente encerrado, registrando a data de encerramento.</p>\n" +
                    "\n" +
                    "<p>Apenas o volume produzido mais recentemente pode estar aberto; todos os outros volumes existentes nesse processo/dossi&ecirc; t&ecirc;m de estar fechados.</p>"
            requisitoRPC2_5_5.save(flush:true)
        }


        def requisitoRPC2_5_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.6")
        if(!requisitoRPC2_5_6){
            requisitoRPC2_5_6 = new Requisito()
            requisitoRPC2_5_6.numeroReferenciaMoreqJus = "RPC2.5.6"
            requisitoRPC2_5_6.obrigatorio = true
            requisitoRPC2_5_6.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_6.nome = "Impedir a reabertura de um volume já encerrado para acréscimo\n" +
                    "de documentos. "
            requisitoRPC2_5_6.save(flush:true)
        }


        def requisitoRPC2_5_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.7")
        if(!requisitoRPC2_5_7){
            requisitoRPC2_5_7 = new Requisito()
            requisitoRPC2_5_7.numeroReferenciaMoreqJus = "RPC2.5.7"
            requisitoRPC2_5_7.obrigatorio = true
            requisitoRPC2_5_7.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_7.nome = "Assegurar que um volume somente conterá documentos. Não é\n" +
                    "permitido que contenha outro volume ou um outro\n" +
                    "processo/dossiê. "
            requisitoRPC2_5_7.save(flush:true)
        }

        def requisitoRPC2_5_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.8")
        if(!requisitoRPC2_5_8){
            requisitoRPC2_5_8 = new Requisito()
            requisitoRPC2_5_8.numeroReferenciaMoreqJus = "RPC2.5.8"
            requisitoRPC2_5_8.obrigatorio = true
            requisitoRPC2_5_8.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_8.nome = "Permitir que um volume seja encerrado por meio de\n" +
                    "procedimentos regulamentares. "
            requisitoRPC2_5_8.save(flush:true)
        }




        def subGrupo_2_6 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.6")

        if(!subGrupo_2_6){
            subGrupo_2_6 = new SubGrupoRequisito()
            subGrupo_2_6.numeroReferenciaMoreqJus="2.6"
            subGrupo_2_6.nome ="Manutenção de documentos institucionais nãodigitais e híbridos "
            subGrupo_2_6.grupoRequisito = grupoRequisito_2
            subGrupo_2_6.save(flush:true)
        }

        def requisitoRPC2_6_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.1")
        if(!requisitoRPC2_6_1){
            requisitoRPC2_6_1 = new Requisito()
            requisitoRPC2_6_1.numeroReferenciaMoreqJus = "RPC2.6.1"
            requisitoRPC2_6_1.obrigatorio = true
            requisitoRPC2_6_1.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_1.nome = "<p>Capturar documentos ou processos/dossi&ecirc;s n&atilde;o-digitais e gerenci&aacute;-los como os digitais.</p>\n" +
                    "\n" +
                    "<p>Para conceito de captura veja cap&iacute;tulo 3.</p>"
            requisitoRPC2_6_1.save(flush:true)
        }

        def requisitoRPC2_6_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.2")
        if(!requisitoRPC2_6_2){
            requisitoRPC2_6_2 = new Requisito()
            requisitoRPC2_6_2.numeroReferenciaMoreqJus = "RPC2.6.2"
            requisitoRPC2_6_2.obrigatorio = true
            requisitoRPC2_6_2.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_2.nome = "Gerenciar as partes dos documentos ou processos/dossiês\n" +
                    "híbridos, associando-as ao mesmo número identificador, atribuído\n" +
                    "pelo sistema, e título, além de indicar que se trata de um\n" +
                    "documento institucional híbrido. "
            requisitoRPC2_6_2.save(flush:true)
        }

        def requisitoRPC2_6_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.3")
        if(!requisitoRPC2_6_3){
            requisitoRPC2_6_3 = new Requisito()
            requisitoRPC2_6_3.numeroReferenciaMoreqJus = "RPC2.6.3"
            requisitoRPC2_6_3.obrigatorio = true
            requisitoRPC2_6_3.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_3.nome = "Permitir que um conjunto específico de metadados seja\n" +
                    "configurado para os documentos ou processos/dossiês nãodigitais e incluir informações sobre o local onde se encontram. "
            requisitoRPC2_6_3.save(flush:true)
        }


        def requisitoRPC2_6_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.4")
        if(!requisitoRPC2_6_4){
            requisitoRPC2_6_4 = new Requisito()
            requisitoRPC2_6_4.numeroReferenciaMoreqJus = "RPC2.6.4"
            requisitoRPC2_6_4.obrigatorio = true
            requisitoRPC2_6_4.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_4.nome = "Possuir mecanismos para acompanhar a movimentação do\n" +
                    "documento, processo/dossiê não-digital, de forma que se\n" +
                    "evidencie ao usuário a localização atual. "
            requisitoRPC2_6_4.save(flush:true)
        }

        def requisitoRPC2_6_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.5")
        if(!requisitoRPC2_6_5){
            requisitoRPC2_6_5 = new Requisito()
            requisitoRPC2_6_5.numeroReferenciaMoreqJus = "RPC2.6.5"
            requisitoRPC2_6_5.obrigatorio = true
            requisitoRPC2_6_5.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_5.nome = "Oferecer ao usuário funcionalidades para solicitar vista, carga ou\n" +
                    "desarquivamento de um documento e/ou processo não-digital."
            requisitoRPC2_6_5.save(flush:true)
        }

        def requisitoRPC2_6_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.6")
        if(!requisitoRPC2_6_6){
            requisitoRPC2_6_6 = new Requisito()
            requisitoRPC2_6_6.numeroReferenciaMoreqJus = "RPC2.6.6"
            requisitoRPC2_6_6.obrigatorio = true
            requisitoRPC2_6_6.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_6.nome = "Incluir mecanismos de impressão e reconhecimento de códigos\n" +
                    "de barra para automatizar a introdução de dados e acompanhar\n" +
                    "as movimentações de documentos ou processos/dossiês nãodigitais. "
            requisitoRPC2_6_6.save(flush:true)
        }

        def requisitoRPC2_6_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.7")
        if(!requisitoRPC2_6_7){
            requisitoRPC2_6_7 = new Requisito()
            requisitoRPC2_6_7.numeroReferenciaMoreqJus = "RPC2.6.7"
            requisitoRPC2_6_7.obrigatorio = true
            requisitoRPC2_6_7.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_7.nome = "Assegurar que a recuperação de um documento ou\n" +
                    "processo/dossiê híbrido permita igualmente a recuperação dos\n" +
                    "metadados tanto da parte digital como da parte não-digital"
            requisitoRPC2_6_7.save(flush:true)
        }


        def requisitoRPC2_6_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.8")
        if(!requisitoRPC2_6_8){
            requisitoRPC2_6_8 = new Requisito()
            requisitoRPC2_6_8.numeroReferenciaMoreqJus = "RPC2.6.8"
            requisitoRPC2_6_8.obrigatorio = true
            requisitoRPC2_6_8.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_8.nome = "Sempre que os documentos ou processos/dossiês híbridos\n" +
                    "estiverem classificados quanto ao grau de sigilo, garantir que o\n" +
                    "grau de sigilo seja estendido ao todo ou à parte,\n" +
                    "independentemente do suporte. "
            requisitoRPC2_6_8.save(flush:true)
        }

        def requisitoRPC2_6_9 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.9")
        if(!requisitoRPC2_6_9){
            requisitoRPC2_6_9 = new Requisito()
            requisitoRPC2_6_9.numeroReferenciaMoreqJus = "RPC2.6.9"
            requisitoRPC2_6_9.obrigatorio = true
            requisitoRPC2_6_9.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_9.nome = "Registrar na trilha de auditoria todas as alterações efetuadas nos\n" +
                    "metadados dos documentos ou processos/dossiês não-digitais ou\n" +
                    "híbridos."
            requisitoRPC2_6_9.save(flush:true)
        }




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
