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


        //concluido
        cargaGrupo2()

        cargaGrupo3()

        cargaGrupo4()

        cargaGrupo5()

        cargaGrupo6()

        cargaGrupo7()

        cargaGrupo8()


        cargaGrupo9()


        cargaGrupo10()

        cargaGrupo11()

        cargaGrupo12()

        cargaGrupo13()

        cargaGrupo14()


        cargaTJTO()

    }

    def cargaGrupo14() {
        def grupoRequisito_14 = GrupoRequisito.findByNumeroReferenciaMoreqJus("14")
        if (!grupoRequisito_14) {
            grupoRequisito_14 = new GrupoRequisito()
            grupoRequisito_14.nome = "Desempenho e escalabilidade"
            grupoRequisito_14.resumo = ""
            grupoRequisito_14.numeroReferenciaMoreqJus = 14
            grupoRequisito_14.save(flush: true)

        }
    }

    def cargaGrupo13() {
        def grupoRequisito_13 = GrupoRequisito.findByNumeroReferenciaMoreqJus("13")
        if (!grupoRequisito_13) {
            grupoRequisito_13 = new GrupoRequisito()
            grupoRequisito_13.nome = "Disponibilidade"
            grupoRequisito_13.resumo = ""
            grupoRequisito_13.numeroReferenciaMoreqJus = 13
            grupoRequisito_13.save(flush: true)

        }
    }

    def cargaGrupo12() {
        def grupoRequisito_12 = GrupoRequisito.findByNumeroReferenciaMoreqJus("12")
        if (!grupoRequisito_12) {
            grupoRequisito_12 = new GrupoRequisito()
            grupoRequisito_12.nome = "Interoperabilidade"
            grupoRequisito_12.resumo = ""
            grupoRequisito_12.numeroReferenciaMoreqJus = 12
            grupoRequisito_12.save(flush: true)

        }
    }

    def cargaGrupo11() {
        def grupoRequisito_11 = GrupoRequisito.findByNumeroReferenciaMoreqJus("11")
        if (!grupoRequisito_11) {
            grupoRequisito_11 = new GrupoRequisito()
            grupoRequisito_11.nome = "Usabilidade"
            grupoRequisito_11.resumo = ""
            grupoRequisito_11.numeroReferenciaMoreqJus = 11
            grupoRequisito_11.save(flush: true)

        }
    }

    def cargaGrupo10() {
        def grupoRequisito_10 = GrupoRequisito.findByNumeroReferenciaMoreqJus("10")
        if (!grupoRequisito_10) {
            grupoRequisito_10 = new GrupoRequisito()
            grupoRequisito_10.nome = "Funções administrativas"
            grupoRequisito_10.resumo = ""
            grupoRequisito_10.numeroReferenciaMoreqJus = 10
            grupoRequisito_10.save(flush: true)

        }
    }

    def cargaGrupo9() {
        def grupoRequisito_9 = GrupoRequisito.findByNumeroReferenciaMoreqJus("9")
        if (!grupoRequisito_9) {
            grupoRequisito_9 = new GrupoRequisito()
            grupoRequisito_9.nome = "Pesquisa, localização e apresentação de documentos"
            grupoRequisito_9.resumo = ""
            grupoRequisito_9.numeroReferenciaMoreqJus = 9
            grupoRequisito_9.save(flush: true)

        }
    }

    def cargaGrupo8() {
        def grupoRequisito_8 = GrupoRequisito.findByNumeroReferenciaMoreqJus("8")
        if (!grupoRequisito_8) {
            grupoRequisito_8 = new GrupoRequisito()
            grupoRequisito_8.nome = "Avaliação e destinação"
            grupoRequisito_8.resumo = ""
            grupoRequisito_8.numeroReferenciaMoreqJus = 8
            grupoRequisito_8.save(flush: true)

        }
    }

    def cargaGrupo7() {
        def grupoRequisito_7 = GrupoRequisito.findByNumeroReferenciaMoreqJus("7")
        if (!grupoRequisito_7) {
            grupoRequisito_7 = new GrupoRequisito()
            grupoRequisito_7.nome = "Tramitação e fluxo de trabalho"
            grupoRequisito_7.resumo = ""
            grupoRequisito_7.numeroReferenciaMoreqJus = 7
            grupoRequisito_7.save(flush: true)

        }
    }

    def cargaGrupo6() {
        def grupoRequisito_6 = GrupoRequisito.findByNumeroReferenciaMoreqJus("6")
        if (!grupoRequisito_6) {
            grupoRequisito_6 = new GrupoRequisito()
            grupoRequisito_6.nome = "Segurança"
            grupoRequisito_6.resumo = ""
            grupoRequisito_6.numeroReferenciaMoreqJus = 6
            grupoRequisito_6.save(flush: true)

        }

        def subGrupo_6_1 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("6.1")
        if(!subGrupo_6_1){
            subGrupo_6_1 = new SubGrupoRequisito()
            subGrupo_6_1.numeroReferenciaMoreqJus="6.1"
            subGrupo_6_1.nome ="Cópias de segurança"
            subGrupo_6_1.grupoRequisito = grupoRequisito_6
            subGrupo_6_1.save(flush:true)

        }

        def requisitoRSE_6_1_1 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.1.1")
        if(!requisitoRSE_6_1_1){
            requisitoRSE_6_1_1 = new Requisito()
            requisitoRSE_6_1_1.numeroReferenciaMoreqJus = "RSE6.1.1"
            requisitoRSE_6_1_1.obrigatorio = true
            requisitoRSE_6_1_1.subGrupoRequisito = subGrupo_6_1
            requisitoRSE_6_1_1.nome = "Cumprir a política de segurança da informação das instituições do\n" +
                    "Judiciário. "
            requisitoRSE_6_1_1.save(flush:true)
        }

        def requisitoRSE_6_1_2 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.1.2")
        if(!requisitoRSE_6_1_2){
            requisitoRSE_6_1_2 = new Requisito()
            requisitoRSE_6_1_2.numeroReferenciaMoreqJus = "RSE6.1.2"
            requisitoRSE_6_1_2.obrigatorio = false
            requisitoRSE_6_1_2.subGrupoRequisito = subGrupo_6_1
            requisitoRSE_6_1_2.nome = "Possibilitar o acompanhamento das ações efetivadas de backup e\n" +
                    "restore."
            requisitoRSE_6_1_2.save(flush:true)
        }


        def subGrupo_6_2 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("6.2")
        if(!subGrupo_6_2){
            subGrupo_6_2 = new SubGrupoRequisito()
            subGrupo_6_2.numeroReferenciaMoreqJus="6.2"
            subGrupo_6_2.nome ="Controle de acesso"
            subGrupo_6_2.grupoRequisito = grupoRequisito_6
            subGrupo_6_2.save(flush:true)

        }

        def requisitoRSE_6_2_1 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.1")
        if(!requisitoRSE_6_2_1){
            requisitoRSE_6_2_1 = new Requisito()
            requisitoRSE_6_2_1.numeroReferenciaMoreqJus = "RSE6.2.1"
            requisitoRSE_6_2_1.obrigatorio = true
            requisitoRSE_6_2_1.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_1.nome = "<p>Implementar o controle de acesso, mantendo pelo menos os seguintes atributos dos usu&aacute;rios, de acordo com a pol&iacute;tica de seguran&ccedil;a da informa&ccedil;&atilde;o das institui&ccedil;&otilde;es do Judici&aacute;rio:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Identificador do usu&aacute;rio.</li>\n" +
                    "\t<li>Autoriza&ccedil;&otilde;es de acesso.</li>\n" +
                    "\t<li>Credenciais de autentica&ccedil;&atilde;o.</li>\n" +
                    "\t<li>&nbsp;</li>\n" +
                    "</ul>\n" +
                    "\n" +
                    "<p>Senha, chave criptogr&aacute;fica e biometria s&atilde;o exemplos de credenciais de autentica&ccedil;&atilde;o</p>"
            requisitoRSE_6_2_1.save(flush:true)
        }

        def requisitoRSE_6_2_2 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.2")
        if(!requisitoRSE_6_2_2){
            requisitoRSE_6_2_2 = new Requisito()
            requisitoRSE_6_2_2.numeroReferenciaMoreqJus = "RSE6.2.2"
            requisitoRSE_6_2_2.obrigatorio = false
            requisitoRSE_6_2_2.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_2.nome = "Utilizar, para efeito de autenticação, um sistema de\n" +
                    "gerenciamento de identidade externo . "
            requisitoRSE_6_2_2.save(flush:true)
        }


        def requisitoRSE_6_2_3 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.3")
        if(!requisitoRSE_6_2_3){
            requisitoRSE_6_2_3 = new Requisito()
            requisitoRSE_6_2_3.numeroReferenciaMoreqJus = "RSE6.2.3"
            requisitoRSE_6_2_3.obrigatorio = true
            requisitoRSE_6_2_3.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_3.nome = "Exigir que o usuário esteja devidamente identificado e autenticado\n" +
                    "antes que este inicie qualquer operação no sistema."
            requisitoRSE_6_2_3.save(flush:true)
        }


        def requisitoRSE_6_2_4 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.4")
        if(!requisitoRSE_6_2_4){
            requisitoRSE_6_2_4 = new Requisito()
            requisitoRSE_6_2_4.numeroReferenciaMoreqJus = "RSE6.2.4"
            requisitoRSE_6_2_4.obrigatorio = true
            requisitoRSE_6_2_4.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_4.nome = "Garantir que os valores dos atributos de segurança e controle de\n" +
                    "acesso, associados ao usuário estejam dentro de conjuntos de\n" +
                    "valores válidos. "
            requisitoRSE_6_2_4.save(flush:true)
        }


        def requisitoRSE_6_2_5 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.5")
        if(!requisitoRSE_6_2_5){
            requisitoRSE_6_2_5 = new Requisito()
            requisitoRSE_6_2_5.numeroReferenciaMoreqJus = "RSE6.2.5"
            requisitoRSE_6_2_5.obrigatorio = true
            requisitoRSE_6_2_5.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_5.nome = "Garantir que as tecnologias de credenciais de autenticação só\n" +
                    "possam ser modificadas pelo administrador, em conformidade\n" +
                    "com a política de segurança da informação das instituições do\n" +
                    "Judiciário."
            requisitoRSE_6_2_5.save(flush:true)
        }

        def requisitoRSE_6_2_6 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.6")
        if(!requisitoRSE_6_2_6){
            requisitoRSE_6_2_6 = new Requisito()
            requisitoRSE_6_2_6.numeroReferenciaMoreqJus = "RSE6.2.6"
            requisitoRSE_6_2_6.obrigatorio = true
            requisitoRSE_6_2_6.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_6.nome = "Permitir avaliação periódica dos direitos de acesso dos usuários\n" +
                    "do sistema"
            requisitoRSE_6_2_6.save(flush:true)
        }

        def requisitoRSE_6_2_7 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.7")
        if(!requisitoRSE_6_2_7){
            requisitoRSE_6_2_7 = new Requisito()
            requisitoRSE_6_2_7.numeroReferenciaMoreqJus = "RSE6.2.7"
            requisitoRSE_6_2_7.obrigatorio = true
            requisitoRSE_6_2_7.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_7.nome = "Permitir avaliação periódica dos direitos de acesso dos usuários\n" +
                    "do sistema"
            requisitoRSE_6_2_7.save(flush:true)
        }

        def requisitoRSE_6_2_8 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.8")
        if(!requisitoRSE_6_2_8){
            requisitoRSE_6_2_8 = new Requisito()
            requisitoRSE_6_2_8.numeroReferenciaMoreqJus = "RSE6.2.8"
            requisitoRSE_6_2_8.obrigatorio = true
            requisitoRSE_6_2_8.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_8.nome = "<p>Fornecer uma das seguintes respostas (estabelecidas durante a configura&ccedil;&atilde;o) se o usu&aacute;rio solicitar o acesso ou pesquisa em um documento institucional, volume ou processo/dossi&ecirc; espec&iacute;ficos aos quais n&atilde;o tenha o direito de acesso:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Mostrar determinados dados cadastrais do documento ou processo.</li>\n" +
                    "\t<li>Demonstrar a exist&ecirc;ncia do processo/dossi&ecirc; ou documento mas n&atilde;o seu conte&uacute;do (exemplo: informa&ccedil;&otilde;es pessoais).</li>\n" +
                    "\t<li>&nbsp;N&atilde;o mostrar qualquer informa&ccedil;&atilde;o constante do documento, nem indicar sua exist&ecirc;ncia (exemplo: quebra de sigilo telef&ocirc;nico).</li>\n" +
                    "</ul>"
            requisitoRSE_6_2_8.save(flush:true)
        }

        def requisitoRSE_6_2_9 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.9")
        if(!requisitoRSE_6_2_9){
            requisitoRSE_6_2_9 = new Requisito()
            requisitoRSE_6_2_9.numeroReferenciaMoreqJus = "RSE6.2.9"
            requisitoRSE_6_2_9.obrigatorio = true
            requisitoRSE_6_2_9.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_9.nome = "Garantir que somente o gestor seja capaz de criar, alterar,\n" +
                    "remover ou revogar as permissões associadas a perfis de\n" +
                    "usuários, grupos de usuários ou usuários individuais."
            requisitoRSE_6_2_9.save(flush:true)
        }

        def requisitoRSE_6_2_10 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.10")
        if(!requisitoRSE_6_2_10){
            requisitoRSE_6_2_10 = new Requisito()
            requisitoRSE_6_2_10.numeroReferenciaMoreqJus = "RSE6.2.10"
            requisitoRSE_6_2_10.obrigatorio = false
            requisitoRSE_6_2_10.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_10.nome = "Implementar imediatamente alterações ou revogações dos\n" +
                    "atributos de segurança de usuários e de documentos digitais. "
            requisitoRSE_6_2_10.save(flush:true)
        }

        def requisitoRSE_6_2_11 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.11")
        if(!requisitoRSE_6_2_11){
            requisitoRSE_6_2_11 = new Requisito()
            requisitoRSE_6_2_11.numeroReferenciaMoreqJus = "RSE6.2.11"
            requisitoRSE_6_2_11.obrigatorio = true
            requisitoRSE_6_2_11.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_11.nome = "Oferecer ferramentas de aumento de produtividade ao\n" +
                    "gestor, tais como: realização de operações sobre lotes ou grupos\n" +
                    "de usuários e lotes de documentos digitais, agenda de tarefas,\n" +
                    "análises de trilhas e geração de alarmes. "
            requisitoRSE_6_2_11.save(flush:true)
        }

        def requisitoRSE_6_2_12 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.12")
        if(!requisitoRSE_6_2_12){
            requisitoRSE_6_2_12 = new Requisito()
            requisitoRSE_6_2_12.numeroReferenciaMoreqJus = "RSE6.2.12"
            requisitoRSE_6_2_12.obrigatorio = false
            requisitoRSE_6_2_12.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_12.nome = "Quando um GestãoDoc controlar o acesso por grupos de\n" +
                    "usuários, perfis de usuários e usuários individuais obedecer a\n" +
                    "uma hierarquia de permissões preestabelecida na política de\n" +
                    "segurança da informação das instituições do Judiciário. "
            requisitoRSE_6_2_12.save(flush:true)
        }


        def requisitoRSE_6_2_13 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.13")
        if(!requisitoRSE_6_2_13){
            requisitoRSE_6_2_13 = new Requisito()
            requisitoRSE_6_2_13.numeroReferenciaMoreqJus = "RSE6.2.13"
            requisitoRSE_6_2_13.obrigatorio =
            requisitoRSE_6_2_13.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_13.nome = "<p>Utilizar os seguintes atributos do usu&aacute;rio ao implementar a pol&iacute;tica de controle de acesso por perfis de usu&aacute;rios sobre documentos:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Identifica&ccedil;&atilde;o do usu&aacute;rio.</li>\n" +
                    "\t<li>&nbsp;Perfis associados ao usu&aacute;rio.</li>\n" +
                    "</ul>"
            requisitoRSE_6_2_13.save(flush:true)
        }

        def requisitoRSE_6_2_14 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.14")
        if(!requisitoRSE_6_2_14){
            requisitoRSE_6_2_14 = new Requisito()
            requisitoRSE_6_2_14.numeroReferenciaMoreqJus = "RSE6.2.14"
            requisitoRSE_6_2_14.obrigatorio =
            requisitoRSE_6_2_14.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_14.nome = "<p>Utilizar os seguintes atributos dos documentos ao implementar a pol&iacute;tica de controle de acesso por perfis:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Identifica&ccedil;&atilde;o do documento.</li>\n" +
                    "\t<li>&nbsp;Opera&ccedil;&otilde;es permitidas para os v&aacute;rios perfis de usu&aacute;rios, sobre as unidades a que pertence o documento.</li>\n" +
                    "</ul>"
            requisitoRSE_6_2_14.save(flush:true)
        }

        def requisitoRSE_6_2_15 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.15")
        if(!requisitoRSE_6_2_15){
            requisitoRSE_6_2_15 = new Requisito()
            requisitoRSE_6_2_15.numeroReferenciaMoreqJus = "RSE6.2.15"
            requisitoRSE_6_2_15.obrigatorio =
                    requisitoRSE_6_2_15.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_15.nome = "Conceder acesso a documentos, processos/dossiês\n" +
                    "somente se a permissão requerida para a operação estiver\n" +
                    "presente em pelo menos um dos perfis associados ao usuário."
            requisitoRSE_6_2_15.save(flush:true)
        }

        def requisitoRSE_6_2_16 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.16")
        if(!requisitoRSE_6_2_16){
            requisitoRSE_6_2_16 = new Requisito()
            requisitoRSE_6_2_16.numeroReferenciaMoreqJus = "RSE6.2.16"
            requisitoRSE_6_2_16.obrigatorio =
                    requisitoRSE_6_2_16.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_16.nome = "Impedir que um usuário assuma perfis com direitos\n" +
                    "conflitantes. Em caso de conflito, prevalece o perfil mais restritivo. "
            requisitoRSE_6_2_16.save(flush:true)
        }


        def requisitoRSE_6_2_17 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.2.17")
        if(!requisitoRSE_6_2_17){
            requisitoRSE_6_2_17 = new Requisito()
            requisitoRSE_6_2_17.numeroReferenciaMoreqJus = "RSE6.2.17"
            requisitoRSE_6_2_17.obrigatorio =
                    requisitoRSE_6_2_17.subGrupoRequisito = subGrupo_6_2
            requisitoRSE_6_2_17.nome = "Permitir a criação de hierarquias de perfis e o conceito de\n" +
                    "herança de permissões entre eles."
            requisitoRSE_6_2_17.save(flush:true)
        }


        def subGrupo_6_3 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("6.3")
        if(!subGrupo_6_3){
            subGrupo_6_3 = new SubGrupoRequisito()
            subGrupo_6_3.numeroReferenciaMoreqJus="6.3"
            subGrupo_6_3.nome ="Classificação da informação quanto ao grau de\n" +
                    "sigilo e restrição de acesso à informação sensível"
            subGrupo_6_3.grupoRequisito = grupoRequisito_6
            subGrupo_6_3.save(flush:true)

        }

        def requisitoRSE_6_3_1 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.1")
        if(!requisitoRSE_6_3_1){
            requisitoRSE_6_3_1 = new Requisito()
            requisitoRSE_6_3_1.numeroReferenciaMoreqJus = "RSE6.3.1"
            requisitoRSE_6_3_1.obrigatorio = true
                    requisitoRSE_6_3_1.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_1.nome = "Aceitar a definição de graus de sigilo e de perfis de usuários de\n" +
                    "acordo com as necessidades das instituições do Judiciário. "
            requisitoRSE_6_3_1.save(flush:true)
        }


        def requisitoRSE_6_3_2 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.2")
        if(!requisitoRSE_6_3_2){
            requisitoRSE_6_3_2 = new Requisito()
            requisitoRSE_6_3_2.numeroReferenciaMoreqJus = "RSE6.3.2"
            requisitoRSE_6_3_2.obrigatorio = true
                    requisitoRSE_6_3_2.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_2.nome = "<p>Implementar a classifica&ccedil;&atilde;o de grau de sigilo baseando-se nos seguintes atributos de seguran&ccedil;a para documentos e para usu&aacute;rios:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Grau de sigilo do documento.</li>\n" +
                    "\t<li>&nbsp;Credencial de seguran&ccedil;a do usu&aacute;rio.</li>\n" +
                    "</ul>"
            requisitoRSE_6_3_2.save(flush:true)
        }

        def requisitoRSE_6_3_3 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.3")
        if(!requisitoRSE_6_3_3){
            requisitoRSE_6_3_3 = new Requisito()
            requisitoRSE_6_3_3.numeroReferenciaMoreqJus = "RSE6.3.3"
            requisitoRSE_6_3_3.obrigatorio = true
            requisitoRSE_6_3_3.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_3.nome = "Recusar o acesso de usuários a documentos que possuam um\n" +
                    "grau de sigilo superior à sua credencial de segurança. "
            requisitoRSE_6_3_3.save(flush:true)
        }

        def requisitoRSE_6_3_4 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.4")
        if(!requisitoRSE_6_3_4){
            requisitoRSE_6_3_4 = new Requisito()
            requisitoRSE_6_3_4.numeroReferenciaMoreqJus = "RSE6.3.4"
            requisitoRSE_6_3_4.obrigatorio = true
            requisitoRSE_6_3_4.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_4.nome = "Garantir que os documentos sem atribuição de grau de sigilo,\n" +
                    "importados a partir de fontes externas ao GestãoDoc, estejam\n" +
                    "sujeitos às políticas de controle de acesso e de sigilo. "
            requisitoRSE_6_3_4.save(flush:true)
        }

        def requisitoRSE_6_3_5 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.5")
        if(!requisitoRSE_6_3_5){
            requisitoRSE_6_3_5 = new Requisito()
            requisitoRSE_6_3_5.numeroReferenciaMoreqJus = "RSE6.3.5"
            requisitoRSE_6_3_5.obrigatorio = true
            requisitoRSE_6_3_5.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_5.nome = "Manter a marcação de sigilo original durante a importação de\n" +
                    "documentos marcados com graus de sigilo, a partir de fontes\n" +
                    "externas ao GestãoDoc."
            requisitoRSE_6_3_5.save(flush:true)
        }


        def requisitoRSE_6_3_6 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.6")
        if(!requisitoRSE_6_3_6){
            requisitoRSE_6_3_6 = new Requisito()
            requisitoRSE_6_3_6.numeroReferenciaMoreqJus = "RSE6.3.6"
            requisitoRSE_6_3_6.obrigatorio = false
            requisitoRSE_6_3_6.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_6.nome = "Garantir a não-ambigüidade na associação entre as marcações\n" +
                    "de grau de sigilo e os outros atributos de segurança (permissões)\n" +
                    "do documento importado"
            requisitoRSE_6_3_6.save(flush:true)
        }

        def requisitoRSE_6_3_7 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.7")
        if(!requisitoRSE_6_3_7){
            requisitoRSE_6_3_7 = new Requisito()
            requisitoRSE_6_3_7.numeroReferenciaMoreqJus = "RSE6.3.7"
            requisitoRSE_6_3_7.obrigatorio = true
            requisitoRSE_6_3_7.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_7.nome = "Garantir que nos casos em que grau de sigilo e atributos de\n" +
                    "segurança incidam sobre um mesmo documento, o critério de\n" +
                    "acesso seja o de maior restrição."
            requisitoRSE_6_3_7.save(flush:true)
        }


        def requisitoRSE_6_3_8 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.8")
        if(!requisitoRSE_6_3_8){
            requisitoRSE_6_3_8 = new Requisito()
            requisitoRSE_6_3_8.numeroReferenciaMoreqJus = "RSE6.3.8"
            requisitoRSE_6_3_8.obrigatorio = true
            requisitoRSE_6_3_8.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_8.nome = "Permitir que o usuário autorizado seja capaz de alterar o grau de\n" +
                    "sigilo de todos os documentos institucionais de um\n" +
                    "processo/dossiê ou documento, em caso de erro, reavaliação,\n" +
                    "reclassificação ou redução do grau de sigilo. "
            requisitoRSE_6_3_8.save(flush:true)
        }


        def requisitoRSE_6_3_9 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.9")
        if(!requisitoRSE_6_3_9){
            requisitoRSE_6_3_9 = new Requisito()
            requisitoRSE_6_3_9.numeroReferenciaMoreqJus = "RSE6.3.9"
            requisitoRSE_6_3_9.obrigatorio = true
            requisitoRSE_6_3_9.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_9.nome = "Garantir que o grau de sigilo de um documento importado esteja\n" +
                    "associado a um usuário autorizado com a credencial de\n" +
                    "segurança pertinente para receber o documento."
            requisitoRSE_6_3_9.save(flush:true)
        }


        def requisitoRSE_6_3_10 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.10")
        if(!requisitoRSE_6_3_10){
            requisitoRSE_6_3_10 = new Requisito()
            requisitoRSE_6_3_10.numeroReferenciaMoreqJus = "RSE6.3.10"
            requisitoRSE_6_3_10.obrigatorio = true
            requisitoRSE_6_3_10.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_10.nome = "Permitir somente ao gestor a possibilidade de alterar a\n" +
                    "configuração dos valores predefinidos (default) para os atributos\n" +
                    "de segurança e marcações de graus de sigilo, quando necessário\n" +
                    "e apropriado. "
            requisitoRSE_6_3_10.save(flush:true)
        }

        def requisitoRSE_6_3_11 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.11")
        if(!requisitoRSE_6_3_11){
            requisitoRSE_6_3_11 = new Requisito()
            requisitoRSE_6_3_11.numeroReferenciaMoreqJus = "RSE6.3.11"
            requisitoRSE_6_3_11.obrigatorio = true
            requisitoRSE_6_3_11.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_11.nome = "Permitir somente aos usuários autorizados realizar as ações:\n" +
                    "criar, alterar, conceder ou revogar credenciais de segurança aos\n" +
                    "usuários. "
            requisitoRSE_6_3_11.save(flush:true)
        }

        def requisitoRSE_6_3_12 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.12")
        if(!requisitoRSE_6_3_12){
            requisitoRSE_6_3_12 = new Requisito()
            requisitoRSE_6_3_12.numeroReferenciaMoreqJus = "RSE6.3.12"
            requisitoRSE_6_3_12.obrigatorio = true
            requisitoRSE_6_3_12.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_12.nome = "<p>Prover mecanismos de prote&ccedil;&atilde;o que permitam c&oacute;pias de seguran&ccedil;a de documentos confidenciais, preservando a inviolabilidade da informa&ccedil;&atilde;o.</p>\n" +
                    "\n" +
                    "<p>Tais c&oacute;pias poder&atilde;o migrar para sites remotos, fora do controle do Gest&atilde;oDoc. Por isso, os mecanismos citados dever&atilde;o lan&ccedil;ar m&atilde;o de t&eacute;cnicas de criptografia</p>"
            requisitoRSE_6_3_12.save(flush:true)
        }



        def requisitoRSE_6_3_13 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.3.13")
        if(!requisitoRSE_6_3_13){
            requisitoRSE_6_3_13 = new Requisito()
            requisitoRSE_6_3_13.numeroReferenciaMoreqJus = "RSE6.3.13"
            requisitoRSE_6_3_13.obrigatorio = true
            requisitoRSE_6_3_13.subGrupoRequisito = subGrupo_6_3
            requisitoRSE_6_3_13.nome = "Impedir que um documento sigiloso seja eliminado, antes de se\n" +
                    "tornar ostensivo e ser submetido ao processo de avaliação para\n" +
                    "definição de sua destinação final, salvo as exceções legais. "
            requisitoRSE_6_3_13.save(flush:true)
        }


        def subGrupo_6_4 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("6.4")
        if(!subGrupo_6_4){
            subGrupo_6_4 = new SubGrupoRequisito()
            subGrupo_6_4.numeroReferenciaMoreqJus="6.4"
            subGrupo_6_4.nome ="Trilha de auditoria"
            subGrupo_6_4.grupoRequisito = grupoRequisito_6
            subGrupo_6_4.save(flush:true)

        }

        def requisitoRSE_6_4_1 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.1")
        if(!requisitoRSE_6_4_1){
            requisitoRSE_6_4_1 = new Requisito()
            requisitoRSE_6_4_1.numeroReferenciaMoreqJus = "RSE6.4.1"
            requisitoRSE_6_4_1.obrigatorio = true
            requisitoRSE_6_4_1.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_1.nome = "Assegurar que as informações da trilha de auditoria estejam\n" +
                    "disponíveis para inspeção a fim de que uma ocorrência específica\n" +
                    "possa ser identificada e que todas as respectivas informações\n" +
                    "sejam claras e compreensíveis. "
            requisitoRSE_6_4_1.save(flush:true)
        }

        def requisitoRSE_6_4_2 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.2")
        if(!requisitoRSE_6_4_2){
            requisitoRSE_6_4_2 = new Requisito()
            requisitoRSE_6_4_2.numeroReferenciaMoreqJus = "RSE6.4.2"
            requisitoRSE_6_4_2.obrigatorio = true
            requisitoRSE_6_4_2.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_2.nome = "<p>Registrar na trilha de auditoria as informa&ccedil;&otilde;es:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Data e hora da captura de todos os documentos.</li>\n" +
                    "\t<li>Respons&aacute;vel pela captura.</li>\n" +
                    "\t<li>Altera&ccedil;&atilde;o do grau de sigilo de um documento ou de um processo/dossi&ecirc;, registrando as modifica&ccedil;&otilde;es efetuadas.</li>\n" +
                    "\t<li>Qualquer altera&ccedil;&atilde;o nos instrumentos de classifica&ccedil;&atilde;o, temporalidade e destina&ccedil;&atilde;o da pol&iacute;tica de gest&atilde;o documental do Judici&aacute;rio brasileiro.</li>\n" +
                    "\t<li>Qualquer a&ccedil;&atilde;o de reavalia&ccedil;&atilde;o de documentos.</li>\n" +
                    "\t<li>Qualquer altera&ccedil;&atilde;o nos metadados associados a processos/dossi&ecirc;s ou documentos.</li>\n" +
                    "\t<li>Data e hora de produ&ccedil;&atilde;o, aditamento e exclus&atilde;o de metadados.</li>\n" +
                    "\t<li>Usu&aacute;rio, data e hora de acesso ou tentativa de acesso a documentos e ao Gest&atilde;oDoc.&nbsp;</li>\n" +
                    "\t<li>Tentativas de acesso negado a qualquer documento.</li>\n" +
                    "\t<li>A&ccedil;&otilde;es de exclus&atilde;o de qualquer documento e seus metadados.</li>\n" +
                    "\t<li>Todas as a&ccedil;&otilde;es administrativas sobre os atributos de seguran&ccedil;a (pap&eacute;is, grupos, permiss&otilde;es etc.).</li>\n" +
                    "\t<li>Todas as a&ccedil;&otilde;es administrativas sobre dados de usu&aacute;rios (cadastro, ativa&ccedil;&atilde;o, bloqueio, atualiza&ccedil;&atilde;o de dados e permiss&otilde;es, troca de senha etc.).</li>\n" +
                    "\t<li>Todos os eventos de administra&ccedil;&atilde;o de manuten&ccedil;&atilde;o das trilhas de auditoria (alarmes, c&oacute;pias, configura&ccedil;&atilde;o de par&acirc;metros etc.).</li>\n" +
                    "</ul>"
            requisitoRSE_6_4_2.save(flush:true)
        }



        def requisitoRSE_6_4_3 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.3")
        if(!requisitoRSE_6_4_3){
            requisitoRSE_6_4_3 = new Requisito()
            requisitoRSE_6_4_3.numeroReferenciaMoreqJus = "RSE6.4.3"
            requisitoRSE_6_4_3.obrigatorio = true
            requisitoRSE_6_4_3.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_3.nome = "Registrar, em cada evento auditado, informações sobre a\n" +
                    "identidade do usuário. "
            requisitoRSE_6_4_3.save(flush:true)
        }


        def requisitoRSE_6_4_4 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.4")
        if(!requisitoRSE_6_4_4){
            requisitoRSE_6_4_4 = new Requisito()
            requisitoRSE_6_4_4.numeroReferenciaMoreqJus = "RSE6.4.4"
            requisitoRSE_6_4_4.obrigatorio = true
            requisitoRSE_6_4_4.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_4.nome = "Permitir a leitura das trilhas de auditoria apenas ao administrador\n" +
                    "e ao auditor. "
            requisitoRSE_6_4_4.save(flush:true)
        }


        def requisitoRSE_6_4_5 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.5")
        if(!requisitoRSE_6_4_5){
            requisitoRSE_6_4_5 = new Requisito()
            requisitoRSE_6_4_5.numeroReferenciaMoreqJus = "RSE6.4.5"
            requisitoRSE_6_4_5.obrigatorio = true
            requisitoRSE_6_4_5.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_5.nome = "Possuir mecanismos para a realização de buscas nos eventos\n" +
                    "das trilhas de auditoria."
            requisitoRSE_6_4_5.save(flush:true)
        }

        def requisitoRSE_6_4_6 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.6")
        if(!requisitoRSE_6_4_6){
            requisitoRSE_6_4_6 = new Requisito()
            requisitoRSE_6_4_6.numeroReferenciaMoreqJus = "RSE6.4.6"
            requisitoRSE_6_4_6.obrigatorio = true
            requisitoRSE_6_4_6.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_6.nome = "Impedir qualquer modificação de conteúdo da trilha de auditoria"
            requisitoRSE_6_4_6.save(flush:true)
        }

        def requisitoRSE_6_4_7 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.7")
        if(!requisitoRSE_6_4_7){
            requisitoRSE_6_4_7 = new Requisito()
            requisitoRSE_6_4_7.numeroReferenciaMoreqJus = "RSE6.4.7"
            requisitoRSE_6_4_7.obrigatorio = true
            requisitoRSE_6_4_7.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_7.nome = "Permitir somente aos administradores a exportação e a\n" +
                    "transferência das trilhas de um suporte de armazenamento para\n" +
                    "outro, garantindo que em tais casos as informações não sejam\n" +
                    "comprometidas."
            requisitoRSE_6_4_7.save(flush:true)
        }


        def requisitoRSE_6_4_8 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.8")
        if(!requisitoRSE_6_4_8){
            requisitoRSE_6_4_8 = new Requisito()
            requisitoRSE_6_4_8.numeroReferenciaMoreqJus = "RSE6.4.8"
            requisitoRSE_6_4_8.obrigatorio = true
            requisitoRSE_6_4_8.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_8.nome = "Gerar um alarme, para os administradores, se o tamanho da trilha\n" +
                    "de auditoria exceder um limite preestabelecido"
            requisitoRSE_6_4_8.save(flush:true)
        }


        def requisitoRSE_6_4_9 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.9")
        if(!requisitoRSE_6_4_9){
            requisitoRSE_6_4_9 = new Requisito()
            requisitoRSE_6_4_9.numeroReferenciaMoreqJus = "RSE6.4.9"
            requisitoRSE_6_4_9.obrigatorio = true
            requisitoRSE_6_4_9.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_9.nome = "<p>Aplicar um conjunto de regras na monitora&ccedil;&atilde;o de eventos auditados e, com base nessas regras indicar a poss&iacute;vel viola&ccedil;&atilde;o da seguran&ccedil;a, como, por exemplo:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Acumula&ccedil;&atilde;o de um n&uacute;mero predeterminado de tentativas consecutivas de login com erro (autentica&ccedil;&atilde;o mal sucedida), conforme especificado pela pol&iacute;tica de seguran&ccedil;a das institui&ccedil;&otilde;es do Judici&aacute;rio.</li>\n" +
                    "\t<li>Ocorr&ecirc;ncia de v&aacute;rios logins simult&acirc;neos do mesmo usu&aacute;rio em locais (computadores) diferentes.</li>\n" +
                    "\t<li>Login do usu&aacute;rio fora do hor&aacute;rio autorizado, ap&oacute;s logoff no per&iacute;odo normal.</li>\n" +
                    "</ul>"
            requisitoRSE_6_4_9.save(flush:true)
        }


        def requisitoRSE_6_4_10 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.10")
        if(!requisitoRSE_6_4_10){
            requisitoRSE_6_4_10 = new Requisito()
            requisitoRSE_6_4_10.numeroReferenciaMoreqJus = "RSE6.4.10"
            requisitoRSE_6_4_10.obrigatorio = true
            requisitoRSE_6_4_10.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_10.nome = "Fornecer relatórios, em ordem cronológica, sobre as ações que\n" +
                    "afetam processos/dossiês e documentos. "
            requisitoRSE_6_4_10.save(flush:true)
        }

        def requisitoRSE_6_4_11 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.11")
        if(!requisitoRSE_6_4_11){
            requisitoRSE_6_4_11 = new Requisito()
            requisitoRSE_6_4_11.numeroReferenciaMoreqJus = "RSE6.4.11"
            requisitoRSE_6_4_11.obrigatorio = true
            requisitoRSE_6_4_11.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_11.nome = "Garantir que somente administradores sejam capazes de\n" +
                    "configurar o conjunto de eventos auditáveis e seus atributos. "
            requisitoRSE_6_4_11.save(flush:true)
        }


        def requisitoRSE_6_4_12 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.4.12")
        if(!requisitoRSE_6_4_12){
            requisitoRSE_6_4_12 = new Requisito()
            requisitoRSE_6_4_12.numeroReferenciaMoreqJus = "RSE6.4.12"
            requisitoRSE_6_4_12.obrigatorio = true
            requisitoRSE_6_4_12.subGrupoRequisito = subGrupo_6_4
            requisitoRSE_6_4_12.nome = "Documentar em trilha de auditoria as configurações do\n" +
                    "GestãoDoc que redefinam o conjunto de eventos auditáveis."
            requisitoRSE_6_4_12.save(flush:true)
        }



        def subGrupo_6_5 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("6.5")
        if(!subGrupo_6_5){
            subGrupo_6_5 = new SubGrupoRequisito()
            subGrupo_6_5.numeroReferenciaMoreqJus="6.5"
            subGrupo_6_5.nome ="Assinaturas digitais"
            subGrupo_6_5.grupoRequisito = grupoRequisito_6
            subGrupo_6_5.save(flush:true)
        }


        def requisitoRSE_6_5_1 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.5.1")
        if(!requisitoRSE_6_5_1){
            requisitoRSE_6_5_1 = new Requisito()
            requisitoRSE_6_5_1.numeroReferenciaMoreqJus = "RSE6.5.1"
            requisitoRSE_6_5_1.obrigatorio = true
            requisitoRSE_6_5_1.subGrupoRequisito = subGrupo_6_5
            requisitoRSE_6_5_1.nome = "Garantir a origem e a integridade dos documentos com assinatura\n" +
                    "digital."
            requisitoRSE_6_5_1.save(flush:true)
        }


        def requisitoRSE_6_5_2 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.5.2")
        if(!requisitoRSE_6_5_2){
            requisitoRSE_6_5_2 = new Requisito()
            requisitoRSE_6_5_2.numeroReferenciaMoreqJus = "RSE6.5.2"
            requisitoRSE_6_5_2.obrigatorio = true
            requisitoRSE_6_5_2.subGrupoRequisito = subGrupo_6_5
            requisitoRSE_6_5_2.nome = "Utilizar o padrão ICP-Brasil quando houver necessidade de\n" +
                    "emprego de assinatura digital. "
            requisitoRSE_6_5_2.save(flush:true)
        }


        def requisitoRSE_6_5_3 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.5.3")
        if(!requisitoRSE_6_5_3){
            requisitoRSE_6_5_3 = new Requisito()
            requisitoRSE_6_5_3.numeroReferenciaMoreqJus = "RSE6.5.3"
            requisitoRSE_6_5_3.obrigatorio = true
            requisitoRSE_6_5_3.subGrupoRequisito = subGrupo_6_5
            requisitoRSE_6_5_3.nome = "Verificar a validade da assinatura digital no momento da captura\n" +
                    "do documento, e caso não esteja válida, recusar a captura"
            requisitoRSE_6_5_3.save(flush:true)
        }

        def requisitoRSE_6_5_4 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.5.4")
        if(!requisitoRSE_6_5_4){
            requisitoRSE_6_5_4 = new Requisito()
            requisitoRSE_6_5_4.numeroReferenciaMoreqJus = "RSE6.5.4"
            requisitoRSE_6_5_4.obrigatorio = true
            requisitoRSE_6_5_4.subGrupoRequisito = subGrupo_6_5
            requisitoRSE_6_5_4.nome = "<p>No processo de verifica&ccedil;&atilde;o da assinatura digital, registrar nos metadados do documento:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Validade da assinatura verificada.</li>\n" +
                    "\t<li>Autoridade certificadora do certificado digital.</li>\n" +
                    "\t<li>&nbsp;Data e hora em que a verifica&ccedil;&atilde;o ocorreu.</li>\n" +
                    "</ul>"
            requisitoRSE_6_5_4.save(flush:true)
        }


        def requisitoRSE_6_5_5 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.5.5")
        if(!requisitoRSE_6_5_5){
            requisitoRSE_6_5_5 = new Requisito()
            requisitoRSE_6_5_5.numeroReferenciaMoreqJus = "RSE6.5.5"
            requisitoRSE_6_5_5.obrigatorio = true
            requisitoRSE_6_5_5.subGrupoRequisito = subGrupo_6_5
            requisitoRSE_6_5_5.nome = "<p>Armazenar juntamente com o documento as informa&ccedil;&otilde;es de certifica&ccedil;&atilde;o:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Assinatura digital.</li>\n" +
                    "\t<li>&nbsp;Certificado digital (cadeia de certifica&ccedil;&atilde;o) usado na verifica&ccedil;&atilde;o da assinatura.</li>\n" +
                    "</ul>"
            requisitoRSE_6_5_5.save(flush:true)
        }


        def requisitoRSE_6_5_6 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.5.6")
        if(!requisitoRSE_6_5_6){
            requisitoRSE_6_5_6 = new Requisito()
            requisitoRSE_6_5_6.numeroReferenciaMoreqJus = "RSE6.5.6"
            requisitoRSE_6_5_6.obrigatorio = true
            requisitoRSE_6_5_6.subGrupoRequisito = subGrupo_6_5
            requisitoRSE_6_5_6.nome = "Receber atualizações tecnológicas quanto à plataforma\n" +
                    "criptográfica e padrões de assinatura digital. "
            requisitoRSE_6_5_6.save(flush:true)
        }

        def requisitoRSE_6_5_7 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.5.7")
        if(!requisitoRSE_6_5_7){
            requisitoRSE_6_5_7 = new Requisito()
            requisitoRSE_6_5_7.numeroReferenciaMoreqJus = "RSE6.5.7"
            requisitoRSE_6_5_7.obrigatorio = true
            requisitoRSE_6_5_7.subGrupoRequisito = subGrupo_6_5
            requisitoRSE_6_5_7.nome = "Acessar relógios e carimbador de tempo oficiais para o seu\n" +
                    "próprio uso. "
            requisitoRSE_6_5_7.save(flush:true)
        }


        def subGrupo_6_6 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("6.6")
        if(!subGrupo_6_6){
            subGrupo_6_6 = new SubGrupoRequisito()
            subGrupo_6_6.numeroReferenciaMoreqJus="6.6"
            subGrupo_6_6.nome ="Criptografia"
            subGrupo_6_6.grupoRequisito = grupoRequisito_6
            subGrupo_6_6.save(flush:true)
        }

        def requisitoRSE_6_6_1 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.6.1")
        if(!requisitoRSE_6_6_1){
            requisitoRSE_6_6_1 = new Requisito()
            requisitoRSE_6_6_1.numeroReferenciaMoreqJus = "RSE6.6.1"
            requisitoRSE_6_6_1.obrigatorio = true
            requisitoRSE_6_6_1.subGrupoRequisito = subGrupo_6_6
            requisitoRSE_6_6_1.nome = "Utilizar a criptografia no armazenamento e na transmissão\n" +
                    "de documentos digitais sigilosos."
            requisitoRSE_6_6_1.save(flush:true)
        }

        def requisitoRSE_6_6_2 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.6.2")
        if(!requisitoRSE_6_6_2){
            requisitoRSE_6_6_2 = new Requisito()
            requisitoRSE_6_6_2.numeroReferenciaMoreqJus = "RSE6.6.2"
            requisitoRSE_6_6_2.obrigatorio = true
            requisitoRSE_6_6_2.subGrupoRequisito = subGrupo_6_6
            requisitoRSE_6_6_2.nome = "Limitar o acesso aos documentos cifrados àqueles usuários\n" +
                    "portadores da chave de decifração. "
            requisitoRSE_6_6_2.save(flush:true)
        }

        def requisitoRSE_6_6_3 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.6.3")
        if(!requisitoRSE_6_6_3){
            requisitoRSE_6_6_3 = new Requisito()
            requisitoRSE_6_6_3.numeroReferenciaMoreqJus = "RSE6.6.3"
            requisitoRSE_6_6_3.obrigatorio = true
            requisitoRSE_6_6_3.subGrupoRequisito = subGrupo_6_6
            requisitoRSE_6_6_3.nome = "<p>Registrar os seguintes metadados sobre um documento cifrado:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Indica&ccedil;&atilde;o se est&aacute; cifrado ou n&atilde;o.</li>\n" +
                    "\t<li>&nbsp;Algoritmos usados na cifra&ccedil;&atilde;o.</li>\n" +
                    "</ul>"
            requisitoRSE_6_6_3.save(flush:true)
        }


        def requisitoRSE_6_6_4 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.6.4")
        if(!requisitoRSE_6_6_4){
            requisitoRSE_6_6_4 = new Requisito()
            requisitoRSE_6_6_4.numeroReferenciaMoreqJus = "RSE6.6.4"
            requisitoRSE_6_6_4.obrigatorio = false
            requisitoRSE_6_6_4.subGrupoRequisito = subGrupo_6_6
            requisitoRSE_6_6_4.nome = "Permitir a captura de documentos cifrados. "
            requisitoRSE_6_6_4.save(flush:true)
        }

        def requisitoRSE_6_6_5 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.6.5")
        if(!requisitoRSE_6_6_5){
            requisitoRSE_6_6_5 = new Requisito()
            requisitoRSE_6_6_5.numeroReferenciaMoreqJus = "RSE6.6.5"
            requisitoRSE_6_6_5.obrigatorio = true
            requisitoRSE_6_6_5.subGrupoRequisito = subGrupo_6_6
            requisitoRSE_6_6_5.nome = "<p>Garantir que somente o administrador seja capaz de alterar caracter&iacute;sticas dos mecanismos criptogr&aacute;ficos internos. Em tais casos, dever&atilde;o obrigatoriamente ser registradas, em trilha de auditoria, as seguintes informa&ccedil;&otilde;es:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Descri&ccedil;&atilde;o t&eacute;cnica da altera&ccedil;&atilde;o.</li>\n" +
                    "\t<li>Data e hora da altera&ccedil;&atilde;o.</li>\n" +
                    "\t<li>Identifica&ccedil;&atilde;o do executor da opera&ccedil;&atilde;o.</li>\n" +
                    "\t<li>Motivo da altera&ccedil;&atilde;o.</li>\n" +
                    "</ul>"
            requisitoRSE_6_6_5.save(flush:true)
        }

        def requisitoRSE_6_6_6 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.6.6")
        if(!requisitoRSE_6_6_6){
            requisitoRSE_6_6_6 = new Requisito()
            requisitoRSE_6_6_6.numeroReferenciaMoreqJus = "RSE6.6.6"
            requisitoRSE_6_6_6.obrigatorio = true
            requisitoRSE_6_6_6.subGrupoRequisito = subGrupo_6_6
            requisitoRSE_6_6_6.nome = "Nos casos de aplicação do item anterior, prover\n" +
                    "mecanismos para convivência temporária de dois sistemas de\n" +
                    "criptografia distintos.\n" +
                    "O objetivo é viabilizar a transição para o novo sistema sem\n" +
                    "indisponibilizar a operação do GestãoDoc. "
            requisitoRSE_6_6_6.save(flush:true)
        }

        def requisitoRSE_6_6_7 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.6.7")
        if(!requisitoRSE_6_6_7){
            requisitoRSE_6_6_7 = new Requisito()
            requisitoRSE_6_6_7.numeroReferenciaMoreqJus = "RSE6.6.7"
            requisitoRSE_6_6_7.obrigatorio = true
            requisitoRSE_6_6_7.subGrupoRequisito = subGrupo_6_6
            requisitoRSE_6_6_7.nome = "<p>Impedir a abertura (disclosure) de senhas, bem como a remo&ccedil;&atilde;o de criptografia de documentos, mesmo para o administrador.</p>\n" +
                    "\n" +
                    "<p>Casos de conting&ecirc;ncia, no impedimento de recupera&ccedil;&atilde;o de informa&ccedil;&atilde;o sigilosa (por exemplo, pela morte do usu&aacute;rio detentor da senha) poder&atilde;o ser tratados em sistemas de cust&oacute;dia de senhas, externos ao Gest&atilde;oDoc.</p>"
            requisitoRSE_6_6_7.save(flush:true)
        }


        def requisitoRSE_6_6_8 = Requisito.findByNumeroReferenciaMoreqJus("RSE6.6.8")
        if(!requisitoRSE_6_6_8){
            requisitoRSE_6_6_8 = new Requisito()
            requisitoRSE_6_6_8.numeroReferenciaMoreqJus = "RSE6.6.8"
            requisitoRSE_6_6_8.obrigatorio = true
            requisitoRSE_6_6_8.subGrupoRequisito = subGrupo_6_6
            requisitoRSE_6_6_8.nome = "Possuir uma arquitetura capaz de receber atualizações\n" +
                    "tecnológicas quanto à plataforma criptográfica."
            requisitoRSE_6_6_8.save(flush:true)
        }

    }

    def cargaGrupo5() {
        def grupoRequisito_5 = GrupoRequisito.findByNumeroReferenciaMoreqJus("5")
        if (!grupoRequisito_5) {
            grupoRequisito_5 = new GrupoRequisito()
            grupoRequisito_5.nome = "Preservação"
            grupoRequisito_5.resumo = ""
            grupoRequisito_5.numeroReferenciaMoreqJus = 5
            grupoRequisito_5.save(flush: true)

        }

        def subGrupo_5_1 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("5.1")
        if(!subGrupo_5_1){
            subGrupo_5_1 = new SubGrupoRequisito()
            subGrupo_5_1.numeroReferenciaMoreqJus="5.1"
            subGrupo_5_1.nome ="Aspectos físicos"
            subGrupo_5_1.grupoRequisito = grupoRequisito_5
            subGrupo_5_1.save(flush:true)

        }

        def requisitoRPR_5_1_1 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.1.1")
        if(!requisitoRPR_5_1_1){
            requisitoRPR_5_1_1 = new Requisito()
            requisitoRPR_5_1_1.numeroReferenciaMoreqJus = "RPR5.1.1"
            requisitoRPR_5_1_1.obrigatorio = true
            requisitoRPR_5_1_1.subGrupoRequisito = subGrupo_5_1
            requisitoRPR_5_1_1.nome = "Os suportes de armazenamento devem ser acondicionados,\n" +
                    "manipulados e utilizados em condições ambientais compatíveis\n" +
                    "com sua vida útil prevista e/ou pretendida, dentro das\n" +
                    "especificações técnicas de seu fabricante e de entidades isentas\n" +
                    "e com base em estatísticas de utilização"
            requisitoRPR_5_1_1.save(flush:true)
        }

        def requisitoRPR_5_1_2 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.1.2")
        if(!requisitoRPR_5_1_2){
            requisitoRPR_5_1_2 = new Requisito()
            requisitoRPR_5_1_2.numeroReferenciaMoreqJus = "RPR5.1.2"
            requisitoRPR_5_1_2.obrigatorio = true
            requisitoRPR_5_1_2.subGrupoRequisito = subGrupo_5_1
            requisitoRPR_5_1_2.nome = "Permitir ao administrador especificar a vida útil\n" +
                    "prevista/pretendida dos suportes."
            requisitoRPR_5_1_2.save(flush:true)
        }


        def requisitoRPR_5_1_3 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.1.3")
        if(!requisitoRPR_5_1_3){
            requisitoRPR_5_1_3 = new Requisito()
            requisitoRPR_5_1_3.numeroReferenciaMoreqJus = "RPR5.1.3"
            requisitoRPR_5_1_3.obrigatorio = true
            requisitoRPR_5_1_3.subGrupoRequisito = subGrupo_5_1
            requisitoRPR_5_1_3.nome = "Permitir o controle da vida útil dos suportes para auxiliar no\n" +
                    "processo de rejuvenescimento. "
            requisitoRPR_5_1_3.save(flush:true)
        }

        def requisitoRPR_5_1_4 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.1.4")
        if(!requisitoRPR_5_1_4){
            requisitoRPR_5_1_4 = new Requisito()
            requisitoRPR_5_1_4.numeroReferenciaMoreqJus = "RPR5.1.4"
            requisitoRPR_5_1_4.obrigatorio = true
            requisitoRPR_5_1_4.subGrupoRequisito = subGrupo_5_1
            requisitoRPR_5_1_4.nome = "Informar automaticamente quais são os suportes que se\n" +
                    "encontram próximos do fim de sua vida útil. "
            requisitoRPR_5_1_4.save(flush:true)
        }

        def subGrupo_5_2 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("5.2")
        if(!subGrupo_5_2){
            subGrupo_5_2 = new SubGrupoRequisito()
            subGrupo_5_2.numeroReferenciaMoreqJus="5.2"
            subGrupo_5_2.nome ="Aspectos lógicos"
            subGrupo_5_2.grupoRequisito = grupoRequisito_5
            subGrupo_5_2.save(flush:true)

        }

        def requisitoRPR_5_2_1 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.2.1")
        if(!requisitoRPR_5_2_1){
            requisitoRPR_5_2_1 = new Requisito()
            requisitoRPR_5_2_1.numeroReferenciaMoreqJus = "RPR5.2.1"
            requisitoRPR_5_2_1.obrigatorio = true
            requisitoRPR_5_2_1.subGrupoRequisito = subGrupo_5_2
            requisitoRPR_5_2_1.nome = "<p>Manter c&oacute;pias de seguran&ccedil;a que devem ser guardadas em ambientes adequados segundo a pol&iacute;tica de seguran&ccedil;a da informa&ccedil;&atilde;o.O armazenamento das c&oacute;pias de seguran&ccedil;a deve ser realizado em local diferente de onde se encontra a informa&ccedil;&atilde;o original.</p>\n" +
                    "\n" +
                    "<p>As informa&ccedil;&otilde;es mantidas em m&iacute;dia terci&aacute;ria devem ser duplicadas e armazenadas em locais diferentes.</p>"
            requisitoRPR_5_2_1.save(flush:true)
        }


        def requisitoRPR_5_2_2 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.2.2")
        if(!requisitoRPR_5_2_2){
            requisitoRPR_5_2_2 = new Requisito()
            requisitoRPR_5_2_2.numeroReferenciaMoreqJus = "RPR5.2.2"
            requisitoRPR_5_2_2.obrigatorio = true
            requisitoRPR_5_2_2.subGrupoRequisito = subGrupo_5_2
            requisitoRPR_5_2_2.nome = "<p>Possuir funcionalidades para a verifica&ccedil;&atilde;o peri&oacute;dica dos dados armazenados, visando detec&ccedil;&atilde;o, repara&ccedil;&atilde;o e informa&ccedil;&atilde;o de poss&iacute;veis erros.</p>\n" +
                    "\n" +
                    "<p>Nesse caso, recomenda-se a utiliza&ccedil;&atilde;o de um checksum robusto, que permita a constata&ccedil;&atilde;o da integridade dos dados e seja seguro quanto a fraudes.</p>"
            requisitoRPR_5_2_2.save(flush:true)
        }

        def requisitoRPR_5_2_3 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.2.3")
        if(!requisitoRPR_5_2_3){
            requisitoRPR_5_2_3 = new Requisito()
            requisitoRPR_5_2_3.numeroReferenciaMoreqJus = "RPR5.2.3"
            requisitoRPR_5_2_3.obrigatorio = true
            requisitoRPR_5_2_3.subGrupoRequisito = subGrupo_5_2
            requisitoRPR_5_2_3.nome = "Permitir ao administrador a reparação dos dados armazenados\n" +
                    "que apresentarem erros."
            requisitoRPR_5_2_3.save(flush:true)
        }

        def requisitoRPR_5_2_4 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.2.4")
        if(!requisitoRPR_5_2_4){
            requisitoRPR_5_2_4 = new Requisito()
            requisitoRPR_5_2_4.numeroReferenciaMoreqJus = "RPR5.2.4"
            requisitoRPR_5_2_4.obrigatorio = true
            requisitoRPR_5_2_4.subGrupoRequisito = subGrupo_5_2
            requisitoRPR_5_2_4.nome = "Manter um histórico dos resultados da verificação periódica dos\n" +
                    "dados armazenados. "
            requisitoRPR_5_2_4.save(flush:true)
        }


        def requisitoRPR_5_2_5 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.2.5")
        if(!requisitoRPR_5_2_5){
            requisitoRPR_5_2_5 = new Requisito()
            requisitoRPR_5_2_5.numeroReferenciaMoreqJus = "RPR5.2.5"
            requisitoRPR_5_2_5.obrigatorio = true
            requisitoRPR_5_2_5.subGrupoRequisito = subGrupo_5_2
            requisitoRPR_5_2_5.nome = "Efetivar ações de preservação sempre que verificada\n" +
                    "obsolescência tecnológica ou quando favoreça a padronização da\n" +
                    "plataforma tecnológica do Judiciário brasileiro"
            requisitoRPR_5_2_5.save(flush:true)
        }

        def requisitoRPR_5_2_6 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.2.6")
        if(!requisitoRPR_5_2_6){
            requisitoRPR_5_2_6 = new Requisito()
            requisitoRPR_5_2_6.numeroReferenciaMoreqJus = "RPR5.2.6"
            requisitoRPR_5_2_6.obrigatorio = true
            requisitoRPR_5_2_6.subGrupoRequisito = subGrupo_5_2
            requisitoRPR_5_2_6.nome = "Suportar a transferência em bloco de documentos e metadados\n" +
                    "para outros sistemas. "
            requisitoRPR_5_2_6.save(flush:true)
        }


        def subGrupo_5_3 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("5.3")
        if(!subGrupo_5_3){
            subGrupo_5_3 = new SubGrupoRequisito()
            subGrupo_5_3.numeroReferenciaMoreqJus="5.3"
            subGrupo_5_3.nome ="Aspectos gerais"
            subGrupo_5_3.grupoRequisito = grupoRequisito_5
            subGrupo_5_3.save(flush:true)

        }

        def requisitoRPR_5_3_1 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.3.1")
        if(!requisitoRPR_5_3_1){
            requisitoRPR_5_3_1 = new Requisito()
            requisitoRPR_5_3_1.numeroReferenciaMoreqJus = "RPR5.3.1"
            requisitoRPR_5_3_1.obrigatorio = true
            requisitoRPR_5_3_1.subGrupoRequisito = subGrupo_5_3
            requisitoRPR_5_3_1.nome = "Registrar as operações de preservação realizadas em trilhas de\n" +
                    "auditoria."
            requisitoRPR_5_3_1.save(flush:true)
        }

        def requisitoRPR_5_3_2 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.3.2")
        if(!requisitoRPR_5_3_2){
            requisitoRPR_5_3_2 = new Requisito()
            requisitoRPR_5_3_2.numeroReferenciaMoreqJus = "RPR5.3.2"
            requisitoRPR_5_3_2.obrigatorio = false
            requisitoRPR_5_3_2.subGrupoRequisito = subGrupo_5_3
            requisitoRPR_5_3_2.nome = "Utilizar suportes de armazenamento, recursos de hardware e de\n" +
                    "software que sejam estáveis no mercado e amplamente\n" +
                    "disponíveis e que contribuam para a padronização e\n" +
                    "uniformização da plataforma tecnológica do Judiciário brasileiro"
            requisitoRPR_5_3_2.save(flush:true)
        }

        def requisitoRPR_5_3_3 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.3.3")
        if(!requisitoRPR_5_3_3){
            requisitoRPR_5_3_3 = new Requisito()
            requisitoRPR_5_3_3.numeroReferenciaMoreqJus = "RPR5.3.3"
            requisitoRPR_5_3_3.obrigatorio = true
            requisitoRPR_5_3_3.subGrupoRequisito = subGrupo_5_3
            requisitoRPR_5_3_3.nome = "As modificações em um GestãoDoc e em sua base tecnológica\n" +
                    "devem ser verificadas em um ambiente exclusivo para essa\n" +
                    "finalidade, de modo a garantir que, após a implantação das\n" +
                    "alterações, os dados continuem sendo acessados sem alteração\n" +
                    "de conteúdo."
            requisitoRPR_5_3_3.save(flush:true)
        }

        def requisitoRPR_5_3_4 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.3.4")
        if(!requisitoRPR_5_3_4){
            requisitoRPR_5_3_4 = new Requisito()
            requisitoRPR_5_3_4.numeroReferenciaMoreqJus = "RPR5.3.4"
            requisitoRPR_5_3_4.obrigatorio = false
            requisitoRPR_5_3_4.subGrupoRequisito = subGrupo_5_3
            requisitoRPR_5_3_4.nome = "Utilizar normas amplamente aceitas, descritas em especificações\n" +
                    "abertas e disponíveis publicamente, no que refere a estruturas\n" +
                    "para codificação, armazenamento e banco de dados. "
            requisitoRPR_5_3_4.save(flush:true)
        }

        def requisitoRPR_5_3_5 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.3.5")
        if(!requisitoRPR_5_3_5){
            requisitoRPR_5_3_5 = new Requisito()
            requisitoRPR_5_3_5.numeroReferenciaMoreqJus = "RPR5.3.5"
            requisitoRPR_5_3_5.obrigatorio = false
            requisitoRPR_5_3_5.subGrupoRequisito = subGrupo_5_3
            requisitoRPR_5_3_5.nome = "Evitar a utilização de estruturas proprietárias, para codificação,\n" +
                    "armazenamento ou banco de dados."
            requisitoRPR_5_3_5.save(flush:true)
        }



        def requisitoRPR_5_3_6 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.3.6")
        if(!requisitoRPR_5_3_6){
            requisitoRPR_5_3_6 = new Requisito()
            requisitoRPR_5_3_6.numeroReferenciaMoreqJus = "RPR5.3.6"
            requisitoRPR_5_3_6.obrigatorio = true
            requisitoRPR_5_3_6.subGrupoRequisito = subGrupo_5_3
            requisitoRPR_5_3_6.nome = "Nos caso em que se utilize estruturas proprietárias, para\n" +
                    "codificação, armazenamento ou banco de dados, elas devem\n" +
                    "estar plenamente documentadas (incluindo o motivo para a\n" +
                    "utilização dessas estruturas proprietárias) e essa documentação,\n" +
                    "disponível para o administrador."
            requisitoRPR_5_3_6.save(flush:true)
        }


        def requisitoRPR_5_3_7 = Requisito.findByNumeroReferenciaMoreqJus("RPR5.3.7")
        if(!requisitoRPR_5_3_7){
            requisitoRPR_5_3_7 = new Requisito()
            requisitoRPR_5_3_7.numeroReferenciaMoreqJus = "RPR5.3.7"
            requisitoRPR_5_3_7.obrigatorio = true
            requisitoRPR_5_3_7.subGrupoRequisito = subGrupo_5_3
            requisitoRPR_5_3_7.nome = "Gerir metadados relativos à preservação dos documentos e seus\n" +
                    "respectivos componentes. "
            requisitoRPR_5_3_7.save(flush:true)
        }
    }

    def cargaGrupo4() {
        def grupoRequisito_4 = GrupoRequisito.findByNumeroReferenciaMoreqJus("4")
        if (!grupoRequisito_4) {
            grupoRequisito_4 = new GrupoRequisito()
            grupoRequisito_4.nome = "Armazenamento"
            grupoRequisito_4.resumo = ""
            grupoRequisito_4.numeroReferenciaMoreqJus = 4
            grupoRequisito_4.save(flush: true)

        }


        def subGrupo_4_1 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("4.1")
        if(!subGrupo_4_1){
            subGrupo_4_1 = new SubGrupoRequisito()
            subGrupo_4_1.numeroReferenciaMoreqJus="4.1"
            subGrupo_4_1.nome ="Durabilidade "
            subGrupo_4_1.grupoRequisito = grupoRequisito_4
            subGrupo_4_1.save(flush:true)

        }

        def requisitoRAR4_1_1 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.1.1")
        if(!requisitoRAR4_1_1){
            requisitoRAR4_1_1 = new Requisito()
            requisitoRAR4_1_1.numeroReferenciaMoreqJus = "RAR4.1.1"
            requisitoRAR4_1_1.obrigatorio = true
            requisitoRAR4_1_1.subGrupoRequisito = subGrupo_4_1
            requisitoRAR4_1_1.nome = "<p>Utilizar dispositivos e padr&otilde;es est&aacute;veis no mercado.</p>\n" +
                    "\n" +
                    "<p>Utilizar preferencialmente padr&otilde;es abertos de armazenamento (como exemplo: ISO 9660:1988 &mdash; defini&ccedil;&atilde;o do formato de sistema de arquivos para CD-Rom).</p>\n" +
                    "\n" +
                    "<p>A escolha dos dispositivos de armazenamento deve contemplar padr&otilde;es est&aacute;veis de mercado e fornecedores consolidados.</p>"
            requisitoRAR4_1_1.save(flush:true)
        }

        def requisitoRAR4_1_2 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.1.2")
        if(!requisitoRAR4_1_2){
            requisitoRAR4_1_2 = new Requisito()
            requisitoRAR4_1_2.numeroReferenciaMoreqJus = "RAR4.1.2"
            requisitoRAR4_1_2.obrigatorio = true
            requisitoRAR4_1_2.subGrupoRequisito = subGrupo_4_1
            requisitoRAR4_1_2.nome = "Avaliar periodicamente a escolha de dispositivos sempre que a\n" +
                    "evolução tecnológica indicar mudanças importantes. "
            requisitoRAR4_1_2.save(flush:true)
        }

        def requisitoRAR4_1_3 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.1.3")
        if(!requisitoRAR4_1_3){
            requisitoRAR4_1_3 = new Requisito()
            requisitoRAR4_1_3.numeroReferenciaMoreqJus = "RAR4.1.3"
            requisitoRAR4_1_3.obrigatorio = true
            requisitoRAR4_1_3.subGrupoRequisito = subGrupo_4_1
            requisitoRAR4_1_3.nome = "Efetuar migrações preventivas sempre que se tornar patente ou\n" +
                    "previsível a obsolescência do padrão corrente. "
            requisitoRAR4_1_3.save(flush:true)
        }

        def requisitoRAR4_1_4 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.1.4")
        if(!requisitoRAR4_1_4){
            requisitoRAR4_1_4 = new Requisito()
            requisitoRAR4_1_4.numeroReferenciaMoreqJus = "RAR4.1.4"
            requisitoRAR4_1_4.obrigatorio = true
            requisitoRAR4_1_4.subGrupoRequisito = subGrupo_4_1
            requisitoRAR4_1_4.nome = "<p>Manter o registro de MTBF (Mean Time Between Failures) 2 , MTTR (Mean Time To Repair)3 e MTBSI (Mean Time Between Service Incidents)4 para as mem&oacute;rias secund&aacute;rias, bem como as datas de sua aquisi&ccedil;&atilde;o.</p>"
            requisitoRAR4_1_4.save(flush:true)
        }

        def requisitoRAR4_1_5 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.1.5")
        if(!requisitoRAR4_1_5){
            requisitoRAR4_1_5 = new Requisito()
            requisitoRAR4_1_5.numeroReferenciaMoreqJus = "RAR4.1.5"
            requisitoRAR4_1_5.obrigatorio = true
            requisitoRAR4_1_5.subGrupoRequisito = subGrupo_4_1
            requisitoRAR4_1_5.nome = "<p>Realizar o gerenciamento das m&iacute;dias por meio do registro de durabilidade prevista, data de aquisi&ccedil;&atilde;o e hist&oacute;rico de utiliza&ccedil;&atilde;o das mem&oacute;rias secund&aacute;ria e terci&aacute;ria.</p>\n" +
                    "\n" +
                    "<p>Informa&ccedil;&otilde;es t&eacute;cnicas sobre previsibilidade de dura&ccedil;&atilde;o de m&iacute;dias referidas em RAR4.1.4 devem ser obtidas preferencialmente a partir de &oacute;rg&atilde;os independentes. Quando isso n&atilde;o for poss&iacute;vel, podem ser utilizadas informa&ccedil;&otilde;es de fornecedores.</p>\n" +
                    "\n" +
                    "<p>A origem da informa&ccedil;&atilde;o deve ficar registrada em ambos os casos</p>"
            requisitoRAR4_1_5.save(flush:true)
        }

        def requisitoRAR4_1_6 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.1.6")
        if(!requisitoRAR4_1_6){
            requisitoRAR4_1_6 = new Requisito()
            requisitoRAR4_1_6.numeroReferenciaMoreqJus = "RAR4.1.6"
            requisitoRAR4_1_6.obrigatorio = true
            requisitoRAR4_1_6.subGrupoRequisito = subGrupo_4_1
            requisitoRAR4_1_6.nome = "Manter estatísticas da durabilidade efetivamente observada das\n" +
                    "memórias secundária e terciária. "
            requisitoRAR4_1_6.save(flush:true)
        }

        def requisitoRAR4_1_7 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.1.7")
        if(!requisitoRAR4_1_7){
            requisitoRAR4_1_7 = new Requisito()
            requisitoRAR4_1_7.numeroReferenciaMoreqJus = "RAR4.1.7"
            requisitoRAR4_1_7.obrigatorio = false
            requisitoRAR4_1_7.subGrupoRequisito = subGrupo_4_1
            requisitoRAR4_1_7.nome = "<p>Utilizar preferencialmente as redes de dados para o acesso &agrave;s informa&ccedil;&otilde;es armazenadas em mem&oacute;ria terci&aacute;ria.</p>\n" +
                    "\n" +
                    "<p>O objetivo &eacute; minimizar o acesso f&iacute;sico &agrave;s m&iacute;dias, visando &agrave; diminui&ccedil;&atilde;o do desgaste. A manipula&ccedil;&atilde;o direta das m&iacute;dias dever&aacute; ser realizada preferencialmente por meio de sistemas autom&aacute;ticos de manipula&ccedil;&atilde;o de m&iacute;dias.</p>"
            requisitoRAR4_1_7.save(flush:true)
        }


        def requisitoRAR4_1_8 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.1.8")
        if(!requisitoRAR4_1_8){
            requisitoRAR4_1_8 = new Requisito()
            requisitoRAR4_1_8.numeroReferenciaMoreqJus = "RAR4.1.8"
            requisitoRAR4_1_8.obrigatorio = true
            requisitoRAR4_1_8.subGrupoRequisito = subGrupo_4_1
            requisitoRAR4_1_8.nome = "<p>Quando se proceder &agrave; elimina&ccedil;&atilde;o de documentos, as mem&oacute;rias de suporte devem ser devidamente &quot;sanitizadas&quot;, isto &eacute;, ter suas informa&ccedil;&otilde;es efetivamente indisponibilizadas.</p>\n" +
                    "\n" +
                    "<p>A elimina&ccedil;&atilde;o de um documento n&atilde;o implica a elimina&ccedil;&atilde;o de seus metadados.</p>\n" +
                    "\n" +
                    "<p>Esse requisito aplica-se principalmente &agrave;s mem&oacute;rias secund&aacute;ria e terci&aacute;ria, pela sua caracter&iacute;stica n&atilde;o-vol&aacute;til. As informa&ccedil;&otilde;es devem ser eliminadas de forma irrevers&iacute;vel, incluindo, no caso de mem&oacute;ria terci&aacute;ria, a possibilidade de destrui&ccedil;&atilde;o f&iacute;sica das m&iacute;dias.</p>"
            requisitoRAR4_1_8.save(flush:true)
        }



        def subGrupo_4_2 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("4.2")
        if(!subGrupo_4_2){
            subGrupo_4_2 = new SubGrupoRequisito()
            subGrupo_4_2.numeroReferenciaMoreqJus="4.2"
            subGrupo_4_2.nome ="Capacidade"
            subGrupo_4_2.grupoRequisito = grupoRequisito_4
            subGrupo_4_2.save(flush:true)

        }

        def requisitoRAR4_2_1 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.2.1")
        if(!requisitoRAR4_2_1){
            requisitoRAR4_2_1 = new Requisito()
            requisitoRAR4_2_1.numeroReferenciaMoreqJus = "RAR4.2.1"
            requisitoRAR4_2_1.obrigatorio = true
            requisitoRAR4_2_1.subGrupoRequisito = subGrupo_4_2
            requisitoRAR4_2_1.nome = "Possuir capacidade de armazenamento suficiente para a\n" +
                    "acomodação de todos os documentos, metadados e suas cópias\n" +
                    "de segurança. "
            requisitoRAR4_2_1.save(flush:true)
        }


        def requisitoRAR4_2_2 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.2.2")
        if(!requisitoRAR4_2_2){
            requisitoRAR4_2_2 = new Requisito()
            requisitoRAR4_2_2.numeroReferenciaMoreqJus = "RAR4.2.2"
            requisitoRAR4_2_2.obrigatorio = true
            requisitoRAR4_2_2.subGrupoRequisito = subGrupo_4_2
            requisitoRAR4_2_2.nome = "<p>Prever a possibilidade de expans&atilde;o da estrutura de armazenamento.</p>\n" +
                    "\n" +
                    "<p>A quantidade de mem&oacute;ria prim&aacute;ria deve ser dimensionada adequadamente no momento da aquisi&ccedil;&atilde;o, a fim de minimizar as indisponibilidades do Gest&atilde;oDoc nas situa&ccedil;&otilde;es de expans&atilde;o desse tipo de mem&oacute;ria.</p>\n" +
                    "\n" +
                    "<p>Quando da aquisi&ccedil;&atilde;o de mem&oacute;ria secund&aacute;ria e terci&aacute;ria as possibilidades de expans&atilde;o dos equipamentos de controle devem ser consideradas.</p>"
            requisitoRAR4_2_2.save(flush:true)
        }


        def requisitoRAR4_2_3 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.2.3")
        if(!requisitoRAR4_2_3){
            requisitoRAR4_2_3 = new Requisito()
            requisitoRAR4_2_3.numeroReferenciaMoreqJus = "RAR4.2.3"
            requisitoRAR4_2_3.obrigatorio = false
            requisitoRAR4_2_3.subGrupoRequisito = subGrupo_4_2
            requisitoRAR4_2_3.nome = "Permitir ao administrador a configuração dos limites de\n" +
                    "capacidade de armazenamento dos diversos dispositivos. "
            requisitoRAR4_2_3.save(flush:true)
        }

        def requisitoRAR4_2_4 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.2.4")
        if(!requisitoRAR4_2_4){
            requisitoRAR4_2_4 = new Requisito()
            requisitoRAR4_2_4.numeroReferenciaMoreqJus = "RAR4.2.4"
            requisitoRAR4_2_4.obrigatorio = true
            requisitoRAR4_2_4.subGrupoRequisito = subGrupo_4_2
            requisitoRAR4_2_4.nome = "<p>Oferecer ao administrador facilidades para a monitora&ccedil;&atilde;o da capacidade de armazenamento.</p>\n" +
                    "\n" +
                    "<p>Esse controle indica, por exemplo, capacidade utilizada, capacidade dispon&iacute;vel e taxa de ocupa&ccedil;&atilde;o. Tais informa&ccedil;&otilde;es s&atilde;o &uacute;teis para subsidiar a&ccedil;&otilde;es de expans&atilde;o em tempo h&aacute;bil.</p>"
            requisitoRAR4_2_4.save(flush:true)
        }


        def requisitoRAR4_2_5 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.2.5")
        if(!requisitoRAR4_2_5){
            requisitoRAR4_2_5 = new Requisito()
            requisitoRAR4_2_5.numeroReferenciaMoreqJus = "RAR4.2.5"
            requisitoRAR4_2_5.obrigatorio = true
            requisitoRAR4_2_5.subGrupoRequisito = subGrupo_4_2
            requisitoRAR4_2_5.nome = "Informar automaticamente ao administrador quando os\n" +
                    "dispositivos de armazenamento on-line atingirem níveis de alerta\n" +
                    "e níveis críticos de ocupação. "
            requisitoRAR4_2_5.save(flush:true)
        }

        def requisitoRAR4_2_6 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.2.6")
        if(!requisitoRAR4_2_6){
            requisitoRAR4_2_6 = new Requisito()
            requisitoRAR4_2_6.numeroReferenciaMoreqJus = "RAR4.2.6"
            requisitoRAR4_2_6.obrigatorio = true
            requisitoRAR4_2_6.subGrupoRequisito = subGrupo_4_2
            requisitoRAR4_2_6.nome = "<p>Manter estat&iacute;sticas de taxa de crescimento de utiliza&ccedil;&atilde;o de mem&oacute;ria secund&aacute;ria e terci&aacute;ria para fornecer ao administrador previs&otilde;es de exaust&atilde;o de recursos.</p>\n" +
                    "\n" +
                    "<p>Esse tipo de estimativa possibilita ao administrador antecipar a&ccedil;&otilde;es de expans&atilde;o antes que a utiliza&ccedil;&atilde;o atinja n&iacute;veis cr&iacute;ticos.</p>"
            requisitoRAR4_2_6.save(flush:true)
        }

        def requisitoRAR4_2_7 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.2.7")
        if(!requisitoRAR4_2_7){
            requisitoRAR4_2_7 = new Requisito()
            requisitoRAR4_2_7.numeroReferenciaMoreqJus = "RAR4.2.7"
            requisitoRAR4_2_7.obrigatorio = false
            requisitoRAR4_2_7.subGrupoRequisito = subGrupo_4_2
            requisitoRAR4_2_7.nome = "Permitir a definição de outras estatísticas referentes à capacidade\n" +
                    "de armazenamento de acordo com as necessidades específicas\n" +
                    "do Judiciário brasileiro. "
            requisitoRAR4_2_7.save(flush:true)
        }


        def subGrupo_4_3 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("4.3")
        if(!subGrupo_4_3){
            subGrupo_4_3 = new SubGrupoRequisito()
            subGrupo_4_3.numeroReferenciaMoreqJus="4.3"
            subGrupo_4_3.nome ="Efetividade de armazenamento"
            subGrupo_4_3.grupoRequisito = grupoRequisito_4
            subGrupo_4_3.save(flush:true)

        }

        def requisitoRAR4_3_1 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.3.1")
        if(!requisitoRAR4_3_1){
            requisitoRAR4_3_1 = new Requisito()
            requisitoRAR4_3_1.numeroReferenciaMoreqJus = "RAR4.3.1"
            requisitoRAR4_3_1.obrigatorio = true
            requisitoRAR4_3_1.subGrupoRequisito = subGrupo_4_3
            requisitoRAR4_3_1.nome = "Os dispositivos de armazenamento devem suportar métodos de\n" +
                    "detecção de erros para leitura e escrita de dados e prover\n" +
                    "mecanismos automáticos de aviso ao administrador do sistema"
            requisitoRAR4_3_1.save(flush:true)
        }

        def requisitoRAR4_3_2 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.3.2")
        if(!requisitoRAR4_3_2){
            requisitoRAR4_3_2 = new Requisito()
            requisitoRAR4_3_2.numeroReferenciaMoreqJus = "RAR4.3.2"
            requisitoRAR4_3_2.obrigatorio = true
            requisitoRAR4_3_2.subGrupoRequisito = subGrupo_4_3
            requisitoRAR4_3_2.nome = "Utilizar técnicas de restauração de dados em caso de falhas. "
            requisitoRAR4_3_2.save(flush:true)
        }


        def requisitoRAR4_3_3 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.3.3")
        if(!requisitoRAR4_3_3){
            requisitoRAR4_3_3 = new Requisito()
            requisitoRAR4_3_3.numeroReferenciaMoreqJus = "RAR4.3.3"
            requisitoRAR4_3_3.obrigatorio = true
            requisitoRAR4_3_3.subGrupoRequisito = subGrupo_4_3
            requisitoRAR4_3_3.nome = "Utilizar mecanismos de proteção que previnam alterações\n" +
                    "indevidas e mantenham a integridade dos dados armazenados. "
            requisitoRAR4_3_3.save(flush:true)
        }

        def requisitoRAR4_3_4 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.3.4")
        if(!requisitoRAR4_3_4){
            requisitoRAR4_3_4 = new Requisito()
            requisitoRAR4_3_4.numeroReferenciaMoreqJus = "RAR4.3.4"
            requisitoRAR4_3_4.obrigatorio = false
            requisitoRAR4_3_4.subGrupoRequisito = subGrupo_4_3
            requisitoRAR4_3_4.nome = "<p>Prever a utiliza&ccedil;&atilde;o de t&eacute;cnicas para garantir maior confiabilidade e desempenho.</p>\n" +
                    "\n" +
                    "<p>As t&eacute;cnicas recomendadas incluem redund&acirc;ncia e paralelismo.</p>"
            requisitoRAR4_3_4.save(flush:true)
        }

        def requisitoRAR4_3_5 = Requisito.findByNumeroReferenciaMoreqJus("RAR4.3.5")
        if(!requisitoRAR4_3_5){
            requisitoRAR4_3_5 = new Requisito()
            requisitoRAR4_3_5.numeroReferenciaMoreqJus = "RAR4.3.5"
            requisitoRAR4_3_5.obrigatorio = true
            requisitoRAR4_3_5.subGrupoRequisito = subGrupo_4_3
            requisitoRAR4_3_5.nome = "A integridade dos dispositivos de armazenamento deve ser\n" +
                    "periodicamente verificada. "
            requisitoRAR4_3_5.save(flush:true)
        }

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
            requisitoRCA3_1_15.obrigatorio = false
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
            requisitoRCA3_1_19.obrigatorio = true
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


        def requisitoRCA3_1_21 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.21")
        if(!requisitoRCA3_1_21){
            requisitoRCA3_1_21 = new Requisito()
            requisitoRCA3_1_21.numeroReferenciaMoreqJus = "RCA3.1.21"
            requisitoRCA3_1_21.obrigatorio = true
            requisitoRCA3_1_21.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_21.nome = "Permitir que um usuário disponibilize documentos a outro usuário\n" +
                    "para complementar o processo de captura, no caso dos\n" +
                    "procedimentos dessa captura serem executados por vários\n" +
                    "usuários. "

            requisitoRCA3_1_21.save(flush:true)
        }


        def requisitoRCA3_1_22 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.22")
        if(!requisitoRCA3_1_22){
            requisitoRCA3_1_22 = new Requisito()
            requisitoRCA3_1_22.numeroReferenciaMoreqJus = "RCA3.1.22"
            requisitoRCA3_1_22.obrigatorio = true
            requisitoRCA3_1_22.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_22.nome = "<p>No caso de documentos ou processos/dossi&ecirc;s constitu&iacute;dos por mais de um objeto digital:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Tratar o documento como uma unidade indivis&iacute;vel, assegurando a rela&ccedil;&atilde;o entre os objetos digitais.</li>\n" +
                    "\t<li>&nbsp;Preservar a integridade do documento, mantendo a rela&ccedil;&atilde;o entre os objetos digitais. \u0001</li>\n" +
                    "\t<li>Garantir a integridade do documento quando da recupera&ccedil;&atilde;o, visualiza&ccedil;&atilde;o e gest&atilde;o posteriores.</li>\n" +
                    "\t<li>&nbsp;Gerenciar a destina&ccedil;&atilde;o de todos os objetos digitais que comp&otilde;em o documento como uma unidade indivis&iacute;vel.</li>\n" +
                    "</ul>"

            requisitoRCA3_1_22.save(flush:true)
        }

        def requisitoRCA3_1_23 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.23")
        if(!requisitoRCA3_1_23){
            requisitoRCA3_1_23 = new Requisito()
            requisitoRCA3_1_23.numeroReferenciaMoreqJus = "RCA3.1.23"
            requisitoRCA3_1_23.obrigatorio = true
            requisitoRCA3_1_23.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_23.nome = "Emitir um aviso caso o usuário tente registrar um documento que\n" +
                    "já tenha sido registrado no mesmo processo/dossiê.\n" +
                    "Para realizar a comparação devem ser observados os metadados\n" +
                    "dos documentos. "

            requisitoRCA3_1_23.save(flush:true)
        }


        def requisitoRCA3_1_24 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.24")
        if(!requisitoRCA3_1_24){
            requisitoRCA3_1_24 = new Requisito()
            requisitoRCA3_1_24.numeroReferenciaMoreqJus = "RCA3.1.24"
            requisitoRCA3_1_24.obrigatorio = true
            requisitoRCA3_1_24.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_24.nome = "Impedir a reinserção de documentos digitais que forem\n" +
                    "detectados como idênticos. "

            requisitoRCA3_1_24.save(flush:true)
        }


        def requisitoRCA3_1_25 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.25")
        if(!requisitoRCA3_1_25){
            requisitoRCA3_1_25 = new Requisito()
            requisitoRCA3_1_25.numeroReferenciaMoreqJus = "RCA3.1.25"
            requisitoRCA3_1_25.obrigatorio = true
            requisitoRCA3_1_25.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_25.nome = "Permitir a captura dos documentos não-digitais e/ou híbridos. "

            requisitoRCA3_1_25.save(flush:true)
        }

        def requisitoRCA3_1_26 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.1.26")
        if(!requisitoRCA3_1_26){
            requisitoRCA3_1_26 = new Requisito()
            requisitoRCA3_1_26.numeroReferenciaMoreqJus = "RCA3.1.26"
            requisitoRCA3_1_26.obrigatorio = true
            requisitoRCA3_1_26.subGrupoRequisito = subGrupo_3_1
            requisitoRCA3_1_26.nome = "Acrescentar aos metadados dos documentos não-digitais\n" +
                    "informações sobre sua localização."

            requisitoRCA3_1_26.save(flush:true)
        }



        def subGrupo_3_2 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("3.2")
        if(!subGrupo_3_2){
            subGrupo_3_2 = new SubGrupoRequisito()
            subGrupo_3_2.numeroReferenciaMoreqJus="3.2"
            subGrupo_3_2.nome ="Captura em lote"
            subGrupo_3_2.grupoRequisito = grupoRequisito_3
            subGrupo_3_2.save(flush:true)

        }


        def requisitoRCA3_2_1 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.2.1")
        if(!requisitoRCA3_2_1){
            requisitoRCA3_2_1 = new Requisito()
            requisitoRCA3_2_1.numeroReferenciaMoreqJus = "RCA3.2.1"
            requisitoRCA3_2_1.obrigatorio = true
            requisitoRCA3_2_1.subGrupoRequisito = subGrupo_3_2
            requisitoRCA3_2_1.nome = "<p>Proporcionar a captura em lote de documentos gerados por outros sistemas. Esse procedimento tem que:&nbsp;</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Permitir importa&ccedil;&atilde;o de transa&ccedil;&otilde;es predefinidas de arquivos em lote.</li>\n" +
                    "\t<li>Registrar automaticamente cada um dos documentos importados contidos no lote.</li>\n" +
                    "\t<li>Permitir e controlar a edi&ccedil;&atilde;o do registro dos documentos importados.</li>\n" +
                    "\t<li>Validar a integridade dos metadados.<br />\n" +
                    "\tExemplos de lote de documento podem ser: mensagens do sistema de comunica&ccedil;&atilde;o eletr&ocirc;nica, correspond&ecirc;ncia digitalizada por meio de esc&acirc;ner, documentos provenientes de uma unidade administrativa/&oacute;rg&atilde;o, de um grupo ou indiv&iacute;duo, transa&ccedil;&otilde;es de aplica&ccedil;&otilde;es de um computador ou ainda documentos oriundos de um sistema de gest&atilde;o de processos e documentos.</li>\n" +
                    "</ul>"

            requisitoRCA3_2_1.save(flush:true)
        }

        def subGrupo_3_3 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("3.3")
        if(!subGrupo_3_3){
            subGrupo_3_3 = new SubGrupoRequisito()
            subGrupo_3_3.numeroReferenciaMoreqJus="3.3"
            subGrupo_3_3.nome ="Captura de mensagens de sistema de\n" +
                    "comunicação eletrônica"
            subGrupo_3_3.grupoRequisito = grupoRequisito_3
            subGrupo_3_3.save(flush:true)

        }

        def requisitoRCA3_3_1 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.3.1")
        if(!requisitoRCA3_3_1){
            requisitoRCA3_3_1 = new Requisito()
            requisitoRCA3_3_1.numeroReferenciaMoreqJus = "RCA3.3.1"
            requisitoRCA3_3_1.obrigatorio = true
            requisitoRCA3_3_1.subGrupoRequisito = subGrupo_3_3
            requisitoRCA3_3_1.nome = "Permitir a captura de mensagens de sistema de comunicação\n" +
                    "eletrônica após a seleção de quais serão objeto de registro. "

            requisitoRCA3_3_1.save(flush:true)
        }

        def requisitoRCA3_3_2 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.3.2")
        if(!requisitoRCA3_3_2){
            requisitoRCA3_3_2 = new Requisito()
            requisitoRCA3_3_2.numeroReferenciaMoreqJus = "RCA3.3.2"
            requisitoRCA3_3_2.obrigatorio = true
            requisitoRCA3_3_2.subGrupoRequisito = subGrupo_3_3
            requisitoRCA3_3_2.nome = "Assegurar a captura dos metadados referentes à mensagem de\n" +
                    "sistema de comunicação eletrônica, de tal forma que a\n" +
                    "confiabilidade e a autenticidade estejam garantidas. "

            requisitoRCA3_3_2.save(flush:true)
        }




        def subGrupo_3_4 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("3.4")
        if(!subGrupo_3_4){
            subGrupo_3_4 = new SubGrupoRequisito()
            subGrupo_3_4.numeroReferenciaMoreqJus="3.4"
            subGrupo_3_4.nome ="Formato de arquivo e estrutura dos documentos\n" +
                    "a serem capturados "
            subGrupo_3_4.grupoRequisito = grupoRequisito_3
            subGrupo_3_4.save(flush:true)

        }

        def requisitoRCA3_4_1 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.4.1")
        if(!requisitoRCA3_4_1){
            requisitoRCA3_4_1 = new Requisito()
            requisitoRCA3_4_1.numeroReferenciaMoreqJus = "RCA3.4.1"
            requisitoRCA3_4_1.obrigatorio = true
            requisitoRCA3_4_1.subGrupoRequisito = subGrupo_3_4
            requisitoRCA3_4_1.nome = "Possuir a capacidade de capturar documentos nos formatos\n" +
                    "previamente definidos como padrão. "

            requisitoRCA3_4_1.save(flush:true)
        }

        def requisitoRCA3_4_2 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.4.2")
        if(!requisitoRCA3_4_2){
            requisitoRCA3_4_2 = new Requisito()
            requisitoRCA3_4_2.numeroReferenciaMoreqJus = "RCA3.4.2"
            requisitoRCA3_4_2.obrigatorio = false
            requisitoRCA3_4_2.subGrupoRequisito = subGrupo_3_4
            requisitoRCA3_4_2.nome = "<p>Capturar, entre outros, os seguintes documentos:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>Informa&ccedil;&otilde;es de outros aplicativos: contabilidade, folha de pagamento, desenho assistido por computador (CAD).</li>\n" +
                    "\t<li>Documentos em papel digitalizados por meio de esc&acirc;ner.</li>\n" +
                    "\t<li>Documentos sonoros.</li>\n" +
                    "\t<li>Videoclipes.</li>\n" +
                    "\t<li>Diagramas e mapas digitais.</li>\n" +
                    "\t<li>Dados estruturados.</li>\n" +
                    "</ul>"

            requisitoRCA3_4_2.save(flush:true)
        }


        def requisitoRCA3_4_3 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.4.3")
        if(!requisitoRCA3_4_3){
            requisitoRCA3_4_3 = new Requisito()
            requisitoRCA3_4_3.numeroReferenciaMoreqJus = "RCA3.4.3"
            requisitoRCA3_4_3.obrigatorio = true
            requisitoRCA3_4_3.subGrupoRequisito = subGrupo_3_4
            requisitoRCA3_4_3.nome = "Fornecer recursos que possibilitem o reconhecimento de\n" +
                    "caracteres a partir de documentos digitalizados, áudio vídeo e\n" +
                    "outras mídias. "

            requisitoRCA3_4_3.save(flush:true)
        }

        def requisitoRCA3_4_4 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.4.4")
        if(!requisitoRCA3_4_4){
            requisitoRCA3_4_4 = new Requisito()
            requisitoRCA3_4_4.numeroReferenciaMoreqJus = "RCA3.4.4"
            requisitoRCA3_4_4.obrigatorio = true
            requisitoRCA3_4_4.subGrupoRequisito = subGrupo_3_4
            requisitoRCA3_4_4.nome = "<p>Capturar documentos que se apresentam com as seguintes estruturas:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;Simples: texto, imagens, mensagens sistema de comunica&ccedil;&atilde;o eletr&ocirc;nica, slides digitais, som e v&iacute;deo.</li>\n" +
                    "\t<li>Composta: mensagens de sistema de comunica&ccedil;&atilde;o eletr&ocirc;nica com anexos, p&aacute;ginas Web e publica&ccedil;&otilde;es eletr&ocirc;nicas.</li>\n" +
                    "</ul>"

            requisitoRCA3_4_4.save(flush:true)
        }

        def requisitoRCA3_4_5 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.4.5")
        if(!requisitoRCA3_4_5){
            requisitoRCA3_4_5 = new Requisito()
            requisitoRCA3_4_5.numeroReferenciaMoreqJus = "RCA3.4.5"
            requisitoRCA3_4_5.obrigatorio = true
            requisitoRCA3_4_5.subGrupoRequisito = subGrupo_3_4
            requisitoRCA3_4_5.nome = "<p>Permitir que um documento composto seja capturado de qualquer uma das duas formas seguintes:</p>\n" +
                    "\n" +
                    "<ul>\n" +
                    "\t<li>&nbsp;&Uacute;nico documento de arquivo composto.</li>\n" +
                    "\t<li>&nbsp;S&eacute;rie de documentos de arquivo simples relacionados, um para cada componente do documento composto.</li>\n" +
                    "</ul>"

            requisitoRCA3_4_5.save(flush:true)
        }

        def requisitoRCA3_4_6 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.4.6")
        if(!requisitoRCA3_4_6){
            requisitoRCA3_4_6 = new Requisito()
            requisitoRCA3_4_6.numeroReferenciaMoreqJus = "RCA3.4.6"
            requisitoRCA3_4_6.obrigatorio = true
            requisitoRCA3_4_6.subGrupoRequisito = subGrupo_3_4
            requisitoRCA3_4_6.nome = "Incluir novos formatos e arquivos à medida que forem adotados\n" +
                    "pelo Judiciário brasileiro. "

            requisitoRCA3_4_6.save(flush:true)
        }


        def requisitoRCA3_4_7 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.4.7")
        if(!requisitoRCA3_4_7){
            requisitoRCA3_4_7 = new Requisito()
            requisitoRCA3_4_7.numeroReferenciaMoreqJus = "RCA3.4.7"
            requisitoRCA3_4_7.obrigatorio = true
            requisitoRCA3_4_7.subGrupoRequisito = subGrupo_3_4
            requisitoRCA3_4_7.nome = "Armazenar em formato que desative o código automodificador\n" +
                    "quando da captura de documento automodificável. "
            requisitoRCA3_4_7.save(flush:true)
        }


        def subGrupo_3_5 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("3.5")
        if(!subGrupo_3_5){
            subGrupo_3_5 = new SubGrupoRequisito()
            subGrupo_3_5.numeroReferenciaMoreqJus="3.5"
            subGrupo_3_5.nome ="Estrutura dos procedimentos de gestão "
            subGrupo_3_5.grupoRequisito = grupoRequisito_3
            subGrupo_3_5.save(flush:true)

        }


        def requisitoRCA3_5_1 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.5.1")
        if(!requisitoRCA3_5_1){
            requisitoRCA3_5_1 = new Requisito()
            requisitoRCA3_5_1.numeroReferenciaMoreqJus = "RCA3.5.1"
            requisitoRCA3_5_1.obrigatorio = true
            requisitoRCA3_5_1.subGrupoRequisito = subGrupo_3_5
            requisitoRCA3_5_1.nome = "Reconhecer três domínios para o controle dos procedimentos de\n" +
                    "gestão: espaço individual, espaço de grupo e espaço geral. "
            requisitoRCA3_5_1.save(flush:true)
        }



        def requisitoRCA3_5_2 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.5.2")
        if(!requisitoRCA3_5_2){
            requisitoRCA3_5_2 = new Requisito()
            requisitoRCA3_5_2.numeroReferenciaMoreqJus = "RCA3.5.2"
            requisitoRCA3_5_2.obrigatorio = true
            requisitoRCA3_5_2.subGrupoRequisito = subGrupo_3_5
            requisitoRCA3_5_2.nome = "Operacionalizar as regras estabelecidas pelo sistema de gestão\n" +
                    "de processos e documentos nos três espaços"
            requisitoRCA3_5_2.save(flush:true)
        }


        def requisitoRCA3_5_3 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.5.3")
        if(!requisitoRCA3_5_3){
            requisitoRCA3_5_3 = new Requisito()
            requisitoRCA3_5_3.numeroReferenciaMoreqJus = "RCA3.5.3"
            requisitoRCA3_5_3.obrigatorio = true
            requisitoRCA3_5_3.subGrupoRequisito = subGrupo_3_5
            requisitoRCA3_5_3.nome = "Impedir que o conteúdo de um documento seja alterado por\n" +
                    "usuários, gestores e administradores, exceto nos casos em que a\n" +
                    "alteração fizer parte do processo documental, conforme tratado\n" +
                    "na seção 6.10 — Alteração e exclusão de documentos\n" +
                    "institucionais. "
            requisitoRCA3_5_3.save(flush:true)
        }

        def requisitoRCA3_5_4 = Requisito.findByNumeroReferenciaMoreqJus("RCA3.5.4")
        if(!requisitoRCA3_5_4){
            requisitoRCA3_5_4 = new Requisito()
            requisitoRCA3_5_4.numeroReferenciaMoreqJus = "RCA3.5.4"
            requisitoRCA3_5_4.obrigatorio = true
            requisitoRCA3_5_4.subGrupoRequisito = subGrupo_3_5
            requisitoRCA3_5_4.nome = "Emitir um aviso, ao se tentar capturar um documento cujos dados\n" +
                    "estruturados estejam incompletos e impedir quando estiverem\n" +
                    "inconsistentes. "
            requisitoRCA3_5_4.save(flush:true)
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
        if (!subGrupo_2_2) {
            subGrupo_2_2 = new SubGrupoRequisito()
            subGrupo_2_2.numeroReferenciaMoreqJus = "2.2"
            subGrupo_2_2.nome = "Classificacao e metadados dos processos/dossiês"
            subGrupo_2_2.grupoRequisito = grupoRequisito_2
            subGrupo_2_2.save(flush: true)

        }

        def requisitoRPC2_2_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.1")
        if (!requisitoRPC2_2_1) {
            requisitoRPC2_2_1 = new Requisito()
            requisitoRPC2_2_1.numeroReferenciaMoreqJus = "RPC2.2.1"
            requisitoRPC2_2_1.obrigatorio = true
            requisitoRPC2_2_1.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_1.nome = "Permitir a classificação dos processos/dossiês somente nas classes\n" +
                    "autorizadas.\n" +
                    "Ver RPC2.1.11 e RPC2.3.7 "
            requisitoRPC2_2_1.save(flush: true)
        }


        def requisitoRPC2_2_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.2")
        if (!requisitoRPC2_2_2) {
            requisitoRPC2_2_2 = new Requisito()
            requisitoRPC2_2_2.numeroReferenciaMoreqJus = "RPC2.2.2"
            requisitoRPC2_2_2.obrigatorio = true
            requisitoRPC2_2_2.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_2.nome = "Permitir a classificação de um número ilimitado de\n" +
                    "processos/dossiês dentro de uma classe. "
            requisitoRPC2_2_2.save(flush: true)
        }

        def requisitoRPC2_2_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.3")
        if (!requisitoRPC2_2_3) {
            requisitoRPC2_2_3 = new Requisito()
            requisitoRPC2_2_3.numeroReferenciaMoreqJus = "RPC2.2.3"
            requisitoRPC2_2_3.obrigatorio = true
            requisitoRPC2_2_3.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_3.nome = "Utilizar o termo completo da classe para identificar um\n" +
                    "processo/dossiê, tal como especificado em RPC2.1.12. "
            requisitoRPC2_2_3.save(flush: true)
        }


        def requisitoRPC2_2_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.4")
        if (!requisitoRPC2_2_4) {
            requisitoRPC2_2_4 = new Requisito()
            requisitoRPC2_2_4.numeroReferenciaMoreqJus = "RPC2.2.4"
            requisitoRPC2_2_4.obrigatorio = true
            requisitoRPC2_2_4.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_4.nome = "Permitir a associação de metadados aos processos/dossiês e\n" +
                    "restringir a inclusão e alteração desses mesmos metadados\n" +
                    "somente a usuários autorizados. "
            requisitoRPC2_2_4.save(flush: true)
        }


        def requisitoRPC2_2_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.5")
        if (!requisitoRPC2_2_5) {
            requisitoRPC2_2_5 = new Requisito()
            requisitoRPC2_2_5.numeroReferenciaMoreqJus = "RPC2.2.5"
            requisitoRPC2_2_5.obrigatorio = true
            requisitoRPC2_2_5.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_5.nome = "Associar os metadados dos processos/dossiês conforme\n" +
                    "estabelecido nos elementos de metadados."
            requisitoRPC2_2_5.save(flush: true)
        }


        def requisitoRPC2_2_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.6")
        if (!requisitoRPC2_2_6) {
            requisitoRPC2_2_6 = new Requisito()
            requisitoRPC2_2_6.numeroReferenciaMoreqJus = "RPC2.2.6"
            requisitoRPC2_2_6.obrigatorio = true
            requisitoRPC2_2_6.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_6.nome = "<p>Permitir que um novo processo/dossi&ecirc; herde, da classe na qual foi classificado, determinados metadados predefinidos.</p>\n" +
                    "\n" +
                    "<p>Exemplos desta heran&ccedil;a s&atilde;o: temporalidade prevista e restri&ccedil;&atilde;o de acesso.</p>"
            requisitoRPC2_2_6.save(flush: true)
        }


        def requisitoRPC2_2_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.7")
        if (!requisitoRPC2_2_7) {
            requisitoRPC2_2_7 = new Requisito()
            requisitoRPC2_2_7.numeroReferenciaMoreqJus = "RPC2.2.7"
            requisitoRPC2_2_7.obrigatorio = false
            requisitoRPC2_2_7.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_7.nome = "Relacionar os metadados herdados de forma que uma alteração no\n" +
                    "metadado de uma classe seja automaticamente incorporada ao\n" +
                    "processo/dossiê que herdou esse metadado. "
            requisitoRPC2_2_7.save(flush: true)
        }


        def requisitoRPC2_2_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.2.8")
        if (!requisitoRPC2_2_8) {
            requisitoRPC2_2_8 = new Requisito()
            requisitoRPC2_2_8.numeroReferenciaMoreqJus = "RPC2.2.8"
            requisitoRPC2_2_8.obrigatorio = true
            requisitoRPC2_2_8.subGrupoRequisito = subGrupo_2_2
            requisitoRPC2_2_8.nome = "Permitir a alteração conjunta de um determinado metadado em um\n" +
                    "grupo de processos/dossiês previamente selecionado."
            requisitoRPC2_2_8.save(flush: true)
        }


        def subGrupo_2_3 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.3")

        if (!subGrupo_2_3) {
            subGrupo_2_3 = new SubGrupoRequisito()
            subGrupo_2_3.numeroReferenciaMoreqJus = "2.3"
            subGrupo_2_3.nome = "Gerenciamento dos processos/dossiês"
            subGrupo_2_3.grupoRequisito = grupoRequisito_2
            subGrupo_2_3.save(flush: true)

        }

        def requisitoRPC2_3_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.1")
        if (!requisitoRPC2_3_1) {
            requisitoRPC2_3_1 = new Requisito()
            requisitoRPC2_3_1.numeroReferenciaMoreqJus = "RPC2.3.1"
            requisitoRPC2_3_1.obrigatorio = true
            requisitoRPC2_3_1.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_1.nome = "<p>Registrar automaticamente a data de abertura e de encerramento ou baixa do processo/dossi&ecirc;.</p>\n" +
                    "\n" +
                    "<p>Essas datas s&atilde;o par&acirc;metros para aplica&ccedil;&atilde;o dos prazos de guarda e destina&ccedil;&atilde;o do processo/dossi&ecirc;.</p>"
            requisitoRPC2_3_1.save(flush: true)
        }

        def requisitoRPC2_3_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.2")
        if (!requisitoRPC2_3_2) {
            requisitoRPC2_3_2 = new Requisito()
            requisitoRPC2_3_2.numeroReferenciaMoreqJus = "RPC2.3.2"
            requisitoRPC2_3_2.obrigatorio = true
            requisitoRPC2_3_2.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_2.nome = "Permitir que um processo/dossiê seja encerrado, reaberto ou\n" +
                    "baixado mediante procedimentos regulamentares. "
            requisitoRPC2_3_2.save(flush: true)
        }


        def requisitoRPC2_3_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.3")
        if (!requisitoRPC2_3_3) {
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
            requisitoRPC2_3_3.save(flush: true)
        }


        def requisitoRPC2_3_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.4")
        if (!requisitoRPC2_3_4) {
            requisitoRPC2_3_4 = new Requisito()
            requisitoRPC2_3_4.numeroReferenciaMoreqJus = "RPC2.3.4"
            requisitoRPC2_3_4.obrigatorio = true
            requisitoRPC2_3_4.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_4.nome = "Manter o registro de suas posições anteriores à reclassificação,\n" +
                    "quando um processo/dossiê é reclassificado, de forma a obter-se\n" +
                    "um histórico. "
            requisitoRPC2_3_4.save(flush: true)
        }

        def requisitoRPC2_3_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.5")
        if (!requisitoRPC2_3_5) {
            requisitoRPC2_3_5 = new Requisito()
            requisitoRPC2_3_5.numeroReferenciaMoreqJus = "RPC2.3.5"
            requisitoRPC2_3_5.obrigatorio = true
            requisitoRPC2_3_5.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_5.nome = "Permitir que o usuário autorizado introduza as razões para a\n" +
                    "reclassificação, quando um processo/dossiê ou documento é\n" +
                    "reclassificado. "
            requisitoRPC2_3_5.save(flush: true)
        }


        def requisitoRPC2_3_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.6")
        if (!requisitoRPC2_3_6) {
            requisitoRPC2_3_6 = new Requisito()
            requisitoRPC2_3_6.numeroReferenciaMoreqJus = "RPC2.3.6"
            requisitoRPC2_3_6.obrigatorio = true
            requisitoRPC2_3_6.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_6.nome = "Permitir a geração de referências cruzadas para\n" +
                    "processos/dossiês afins. "
            requisitoRPC2_3_6.save(flush: true)
        }


        def requisitoRPC2_3_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.7")
        if (!requisitoRPC2_3_7) {
            requisitoRPC2_3_7 = new Requisito()
            requisitoRPC2_3_7.numeroReferenciaMoreqJus = "RPC2.3.7"
            requisitoRPC2_3_7.obrigatorio = true
            requisitoRPC2_3_7.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_7.nome = "Registrar múltiplas entradas para um documento digital em mais\n" +
                    "de um processo/dossiê"
            requisitoRPC2_3_7.save(flush: true)
        }

        def requisitoRPC2_3_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.8")
        if (!requisitoRPC2_3_8) {
            requisitoRPC2_3_8 = new Requisito()
            requisitoRPC2_3_8.numeroReferenciaMoreqJus = "RPC2.3.8"
            requisitoRPC2_3_8.obrigatorio = true
            requisitoRPC2_3_8.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_8.nome = "<p>Impedir a elimina&ccedil;&atilde;o de um processo/dossi&ecirc; digital ou de qualquer parte de seu conte&uacute;do em qualquer momento, exceto quando se tratar de elimina&ccedil;&atilde;o definitiva, consoante os crit&eacute;rios de classifica&ccedil;&atilde;o e guarda.</p>\n" +
                    "\n" +
                    "<p>A elimina&ccedil;&atilde;o ser&aacute; devidamente registrada em trilha de auditoria.</p>"
            requisitoRPC2_3_8.save(flush: true)
        }


        def requisitoRPC2_3_9 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.9")
        if (!requisitoRPC2_3_9) {
            requisitoRPC2_3_9 = new Requisito()
            requisitoRPC2_3_9.numeroReferenciaMoreqJus = "RPC2.3.9"
            requisitoRPC2_3_9.obrigatorio = true
            requisitoRPC2_3_9.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_9.nome = "<p>Impedir o acr&eacute;scimo de novos documentos a processos/dossi&ecirc;s j&aacute; encerrados.</p>\n" +
                    "\n" +
                    "<p>Para receber novos documentos, os processos/dossi&ecirc;s encerrados dever&atilde;o ser reabertos.</p>"
            requisitoRPC2_3_9.save(flush: true)
        }


        def requisitoRPC2_3_10 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.10")
        if (!requisitoRPC2_3_10) {
            requisitoRPC2_3_10 = new Requisito()
            requisitoRPC2_3_10.numeroReferenciaMoreqJus = "RPC2.3.10"
            requisitoRPC2_3_10.obrigatorio = true
            requisitoRPC2_3_10.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_10.nome = "Permitir a consulta aos processos/dossiês já encerrados. "
            requisitoRPC2_3_10.save(flush: true)
        }


        def requisitoRPC2_3_11 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.11")
        if (!requisitoRPC2_3_11) {
            requisitoRPC2_3_11 = new Requisito()
            requisitoRPC2_3_11.numeroReferenciaMoreqJus = "RPC2.3.11"
            requisitoRPC2_3_11.obrigatorio = true
            requisitoRPC2_3_11.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_11.nome = "<p>Garantir a integridade da rela&ccedil;&atilde;o hier&aacute;rquica entre classe, processo/dossi&ecirc;, volume e documento em todos os momentos, independentemente de atividades de manuten&ccedil;&atilde;o, a&ccedil;&otilde;es do usu&aacute;rio ou falha de componentes do sistema.</p>\n" +
                    "\n" +
                    "<p>Em hip&oacute;tese alguma poder&aacute; ocorrer uma situa&ccedil;&atilde;o em que qualquer a&ccedil;&atilde;o do usu&aacute;rio ou falha do sistema d&ecirc; origem a uma inconsist&ecirc;ncia na base de dados do Gest&atilde;oDoc.</p>"
            requisitoRPC2_3_11.save(flush: true)
        }


        def requisitoRPC2_3_12 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.3.12")
        if (!requisitoRPC2_3_12) {
            requisitoRPC2_3_12 = new Requisito()
            requisitoRPC2_3_12.numeroReferenciaMoreqJus = "RPC2.3.12"
            requisitoRPC2_3_12.obrigatorio = true
            requisitoRPC2_3_12.subGrupoRequisito = subGrupo_2_3
            requisitoRPC2_3_12.nome = "Oferecer ferramentas para a realização de operações em lote,\n" +
                    "tais como: abertura e encerramento de processos/dossiês e seus\n" +
                    "respectivos volumes, reclassificação, citação/intimação,\n" +
                    "sentença/decisão/despacho, etc. "
            requisitoRPC2_3_12.save(flush: true)
        }


        def subGrupo_2_4 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.4")
        if (!subGrupo_2_4) {
            subGrupo_2_4 = new SubGrupoRequisito()
            subGrupo_2_4.numeroReferenciaMoreqJus = "2.4"
            subGrupo_2_4.nome = "Processos "
            subGrupo_2_4.grupoRequisito = grupoRequisito_2
            subGrupo_2_4.save(flush: true)

        }

        def requisitoRPC2_4_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.1")
        if (!requisitoRPC2_4_1) {
            requisitoRPC2_4_1 = new Requisito()
            requisitoRPC2_4_1.numeroReferenciaMoreqJus = "RPC2.4.1"
            requisitoRPC2_4_1.obrigatorio = true
            requisitoRPC2_4_1.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_1.nome = "Prever a formação/autuação de processos conforme estabelecido\n" +
                    "nas leis e regulamentações vigentes. "
            requisitoRPC2_4_1.save(flush: true)
        }


        def requisitoRPC2_4_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.2")
        if (!requisitoRPC2_4_2) {
            requisitoRPC2_4_2 = new Requisito()
            requisitoRPC2_4_2.numeroReferenciaMoreqJus = "RPC2.4.2"
            requisitoRPC2_4_2.obrigatorio = true
            requisitoRPC2_4_2.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_2.nome = "<p>Prever que as pe&ccedil;as integrantes do processo recebam pagina&ccedil;&atilde;o contextualizada de acordo com cada processo relacionado.</p>\n" +
                    "\n" +
                    "<p>Uma mesma contesta&ccedil;&atilde;o juntada a v&aacute;rios processos tem numera&ccedil;&atilde;o diferente de acordo com a numera&ccedil;&atilde;o de cada processo.</p>"
            requisitoRPC2_4_2.save(flush: true)
        }


        def requisitoRPC2_4_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.3")
        if (!requisitoRPC2_4_3) {
            requisitoRPC2_4_3 = new Requisito()
            requisitoRPC2_4_3.numeroReferenciaMoreqJus = "RPC2.4.3"
            requisitoRPC2_4_3.obrigatorio = true
            requisitoRPC2_4_3.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_3.nome = "<p>Prever procedimentos para reuni&atilde;o de processos por apensa&ccedil;&atilde;o.</p>\n" +
                    "\n" +
                    "<p>Nos processos judiciais, a apensa&ccedil;&atilde;o ocorre por determina&ccedil;&atilde;o legal ou judicial e nos administrativos, por determina&ccedil;&atilde;o da autoridade competente.</p>\n" +
                    "\n" +
                    "<p>Esse procedimento dever&aacute; ser registrado nos metadados do processo. Quando se tratar de processo judicial, deve-se lan&ccedil;ar o evento correspondente da Tabela Unificada de Movimenta&ccedil;&atilde;o Processual do Judici&aacute;rio Brasileiro (apensamento) e seu complemento obrigat&oacute;rio (n&uacute;mero do processo).</p>"
            requisitoRPC2_4_3.save(flush: true)
        }


        def requisitoRPC2_4_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.4")
        if (!requisitoRPC2_4_4) {
            requisitoRPC2_4_4 = new Requisito()
            requisitoRPC2_4_4.numeroReferenciaMoreqJus = "RPC2.4.4"
            requisitoRPC2_4_4.obrigatorio = true
            requisitoRPC2_4_4.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_4.nome = "<p>Prever procedimentos para desapensa&ccedil;&atilde;o.</p>\n" +
                    "\n" +
                    "<p>Nos processos judiciais, via de regra, a desapensa&ccedil;&atilde;o ocorre por decis&atilde;o judicial e nos administrativos, por determina&ccedil;&atilde;o da autoridade competente.</p>\n" +
                    "\n" +
                    "<p>Esse procedimento dever&aacute; ser registrado nos metadados do processo. Quando se tratar de processo judicial, deve-se lan&ccedil;ar o evento correspondente da Tabela Unificada de Movimenta&ccedil;&atilde;o Processual do Judici&aacute;rio Brasileiro (desapensamento) e seu complemento obrigat&oacute;rio (n&uacute;mero do processo).</p>"
            requisitoRPC2_4_4.save(flush: true)
        }


        def requisitoRPC2_4_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.5")
        if (!requisitoRPC2_4_5) {
            requisitoRPC2_4_5 = new Requisito()
            requisitoRPC2_4_5.numeroReferenciaMoreqJus = "RPC2.4.5"
            requisitoRPC2_4_5.obrigatorio = true
            requisitoRPC2_4_5.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_5.nome = "<p>Prever procedimentos para desentranhamento de pe&ccedil;as dos processos judiciais em aten&ccedil;&atilde;o &agrave; decis&atilde;o judicial ou segundo a legisla&ccedil;&atilde;o espec&iacute;fica, e dos administrativos, por determina&ccedil;&atilde;o da autoridade competente.</p>\n" +
                    "\n" +
                    "<p>Esse procedimento dever&aacute; ser registrado nos metadados do processo. Quando se tratar de processo judicial, deve-se lan&ccedil;ar o evento correspondente da Tabela Unificada de Movimenta&ccedil;&atilde;o Processual do Judici&aacute;rio Brasileiro (cancelamento de juntada &mdash; desentranhamento) e seu complemento obrigat&oacute;rio (especificar documento).</p>"
            requisitoRPC2_4_5.save(flush: true)
        }


        def requisitoRPC2_4_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.6")
        if (!requisitoRPC2_4_6) {
            requisitoRPC2_4_6 = new Requisito()
            requisitoRPC2_4_6.numeroReferenciaMoreqJus = "RPC2.4.6"
            requisitoRPC2_4_6.obrigatorio = true
            requisitoRPC2_4_6.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_6.nome = "<p>Prever procedimentos para desmembramento de um processo judicial ou administrativo em dois ou mais processos.</p>\n" +
                    "\n" +
                    "<p>Nos processos judiciais, sempre ocorre por decis&atilde;o judicial, como no exemplo do art. 46, par&aacute;grafo &uacute;nico, do CPC ou do art. 80, CPP.</p>\n" +
                    "\n" +
                    "<p>Esse procedimento dever&aacute; ser registrado nos metadados do processo.</p>"
            requisitoRPC2_4_6.save(flush: true)
        }


        def requisitoRPC2_4_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.4.7")
        if (!requisitoRPC2_4_7) {
            requisitoRPC2_4_7 = new Requisito()
            requisitoRPC2_4_7.numeroReferenciaMoreqJus = "RPC2.4.7"
            requisitoRPC2_4_7.obrigatorio = true
            requisitoRPC2_4_7.subGrupoRequisito = subGrupo_2_4
            requisitoRPC2_4_7.nome = "Prever procedimentos para a anexação de documentos\n" +
                    "organizados em volumes próprios a um determinado processo.\n" +
                    "Esse procedimento deverá ser registrado nos metadados do\n" +
                    "processo. "
            requisitoRPC2_4_7.save(flush: true)
        }


        def subGrupo_2_5 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.5")

        if (!subGrupo_2_5) {
            subGrupo_2_5 = new SubGrupoRequisito()
            subGrupo_2_5.numeroReferenciaMoreqJus = "2.5"
            subGrupo_2_5.nome = "Volumes: abertura, encerramento e metadados"
            subGrupo_2_5.grupoRequisito = grupoRequisito_2
            subGrupo_2_5.save(flush: true)
        }

        def requisitoRPC2_5_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.1")
        if (!requisitoRPC2_5_1) {
            requisitoRPC2_5_1 = new Requisito()
            requisitoRPC2_5_1.numeroReferenciaMoreqJus = "RPC2.5.1"
            requisitoRPC2_5_1.obrigatorio = true
            requisitoRPC2_5_1.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_1.nome = "Gerenciar volumes para subdividir processos/dossiês,\n" +
                    "distinguindo entre processos/dossiês e volumes. "
            requisitoRPC2_5_1.save(flush: true)
        }

        def requisitoRPC2_5_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.2")
        if (!requisitoRPC2_5_2) {
            requisitoRPC2_5_2 = new Requisito()
            requisitoRPC2_5_2.numeroReferenciaMoreqJus = "RPC2.5.2"
            requisitoRPC2_5_2.obrigatorio = true
            requisitoRPC2_5_2.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_2.nome = "Permitir a associação de metadados aos volumes e restringir a\n" +
                    "inclusão e a alteração desses mesmos metadados somente a\n" +
                    "usuários autorizados. "
            requisitoRPC2_5_2.save(flush: true)
        }

        def requisitoRPC2_5_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.3")
        if (!requisitoRPC2_5_3) {
            requisitoRPC2_5_3 = new Requisito()
            requisitoRPC2_5_3.numeroReferenciaMoreqJus = "RPC2.5.3"
            requisitoRPC2_5_3.obrigatorio = true
            requisitoRPC2_5_3.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_3.nome = "<p>Permitir que um volume herde automaticamente do processo/dossi&ecirc; ao qual pertence determinados metadados predefinidos.</p>\n" +
                    "\n" +
                    "<p>Por exemplo: volume juntado em processo sigiloso tamb&eacute;m &eacute; sigiloso.</p>"
            requisitoRPC2_5_3.save(flush: true)
        }


        def requisitoRPC2_5_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.4")
        if (!requisitoRPC2_5_4) {
            requisitoRPC2_5_4 = new Requisito()
            requisitoRPC2_5_4.numeroReferenciaMoreqJus = "RPC2.5.4"
            requisitoRPC2_5_4.obrigatorio = true
            requisitoRPC2_5_4.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_4.nome = "Permitir a abertura de volumes a qualquer processo/dossiê que\n" +
                    "não esteja encerrado. "
            requisitoRPC2_5_4.save(flush: true)
        }

        def requisitoRPC2_5_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.5")
        if (!requisitoRPC2_5_5) {
            requisitoRPC2_5_5 = new Requisito()
            requisitoRPC2_5_5.numeroReferenciaMoreqJus = "RPC2.5.5"
            requisitoRPC2_5_5.obrigatorio = true
            requisitoRPC2_5_5.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_5.nome = "<p>Assegurar que, ao abrir um novo volume, o volume precedente seja automaticamente encerrado, registrando a data de encerramento.</p>\n" +
                    "\n" +
                    "<p>Apenas o volume produzido mais recentemente pode estar aberto; todos os outros volumes existentes nesse processo/dossi&ecirc; t&ecirc;m de estar fechados.</p>"
            requisitoRPC2_5_5.save(flush: true)
        }


        def requisitoRPC2_5_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.6")
        if (!requisitoRPC2_5_6) {
            requisitoRPC2_5_6 = new Requisito()
            requisitoRPC2_5_6.numeroReferenciaMoreqJus = "RPC2.5.6"
            requisitoRPC2_5_6.obrigatorio = true
            requisitoRPC2_5_6.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_6.nome = "Impedir a reabertura de um volume já encerrado para acréscimo\n" +
                    "de documentos. "
            requisitoRPC2_5_6.save(flush: true)
        }


        def requisitoRPC2_5_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.7")
        if (!requisitoRPC2_5_7) {
            requisitoRPC2_5_7 = new Requisito()
            requisitoRPC2_5_7.numeroReferenciaMoreqJus = "RPC2.5.7"
            requisitoRPC2_5_7.obrigatorio = true
            requisitoRPC2_5_7.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_7.nome = "Assegurar que um volume somente conterá documentos. Não é\n" +
                    "permitido que contenha outro volume ou um outro\n" +
                    "processo/dossiê. "
            requisitoRPC2_5_7.save(flush: true)
        }

        def requisitoRPC2_5_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.5.8")
        if (!requisitoRPC2_5_8) {
            requisitoRPC2_5_8 = new Requisito()
            requisitoRPC2_5_8.numeroReferenciaMoreqJus = "RPC2.5.8"
            requisitoRPC2_5_8.obrigatorio = true
            requisitoRPC2_5_8.subGrupoRequisito = subGrupo_2_5
            requisitoRPC2_5_8.nome = "Permitir que um volume seja encerrado por meio de\n" +
                    "procedimentos regulamentares. "
            requisitoRPC2_5_8.save(flush: true)
        }


        def subGrupo_2_6 = SubGrupoRequisito.findByNumeroReferenciaMoreqJus("2.6")

        if (!subGrupo_2_6) {
            subGrupo_2_6 = new SubGrupoRequisito()
            subGrupo_2_6.numeroReferenciaMoreqJus = "2.6"
            subGrupo_2_6.nome = "Manutenção de documentos institucionais nãodigitais e híbridos "
            subGrupo_2_6.grupoRequisito = grupoRequisito_2
            subGrupo_2_6.save(flush: true)
        }

        def requisitoRPC2_6_1 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.1")
        if (!requisitoRPC2_6_1) {
            requisitoRPC2_6_1 = new Requisito()
            requisitoRPC2_6_1.numeroReferenciaMoreqJus = "RPC2.6.1"
            requisitoRPC2_6_1.obrigatorio = true
            requisitoRPC2_6_1.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_1.nome = "<p>Capturar documentos ou processos/dossi&ecirc;s n&atilde;o-digitais e gerenci&aacute;-los como os digitais.</p>\n" +
                    "\n" +
                    "<p>Para conceito de captura veja cap&iacute;tulo 3.</p>"
            requisitoRPC2_6_1.save(flush: true)
        }

        def requisitoRPC2_6_2 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.2")
        if (!requisitoRPC2_6_2) {
            requisitoRPC2_6_2 = new Requisito()
            requisitoRPC2_6_2.numeroReferenciaMoreqJus = "RPC2.6.2"
            requisitoRPC2_6_2.obrigatorio = true
            requisitoRPC2_6_2.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_2.nome = "Gerenciar as partes dos documentos ou processos/dossiês\n" +
                    "híbridos, associando-as ao mesmo número identificador, atribuído\n" +
                    "pelo sistema, e título, além de indicar que se trata de um\n" +
                    "documento institucional híbrido. "
            requisitoRPC2_6_2.save(flush: true)
        }

        def requisitoRPC2_6_3 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.3")
        if (!requisitoRPC2_6_3) {
            requisitoRPC2_6_3 = new Requisito()
            requisitoRPC2_6_3.numeroReferenciaMoreqJus = "RPC2.6.3"
            requisitoRPC2_6_3.obrigatorio = true
            requisitoRPC2_6_3.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_3.nome = "Permitir que um conjunto específico de metadados seja\n" +
                    "configurado para os documentos ou processos/dossiês nãodigitais e incluir informações sobre o local onde se encontram. "
            requisitoRPC2_6_3.save(flush: true)
        }


        def requisitoRPC2_6_4 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.4")
        if (!requisitoRPC2_6_4) {
            requisitoRPC2_6_4 = new Requisito()
            requisitoRPC2_6_4.numeroReferenciaMoreqJus = "RPC2.6.4"
            requisitoRPC2_6_4.obrigatorio = true
            requisitoRPC2_6_4.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_4.nome = "Possuir mecanismos para acompanhar a movimentação do\n" +
                    "documento, processo/dossiê não-digital, de forma que se\n" +
                    "evidencie ao usuário a localização atual. "
            requisitoRPC2_6_4.save(flush: true)
        }

        def requisitoRPC2_6_5 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.5")
        if (!requisitoRPC2_6_5) {
            requisitoRPC2_6_5 = new Requisito()
            requisitoRPC2_6_5.numeroReferenciaMoreqJus = "RPC2.6.5"
            requisitoRPC2_6_5.obrigatorio = true
            requisitoRPC2_6_5.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_5.nome = "Oferecer ao usuário funcionalidades para solicitar vista, carga ou\n" +
                    "desarquivamento de um documento e/ou processo não-digital."
            requisitoRPC2_6_5.save(flush: true)
        }

        def requisitoRPC2_6_6 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.6")
        if (!requisitoRPC2_6_6) {
            requisitoRPC2_6_6 = new Requisito()
            requisitoRPC2_6_6.numeroReferenciaMoreqJus = "RPC2.6.6"
            requisitoRPC2_6_6.obrigatorio = true
            requisitoRPC2_6_6.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_6.nome = "Incluir mecanismos de impressão e reconhecimento de códigos\n" +
                    "de barra para automatizar a introdução de dados e acompanhar\n" +
                    "as movimentações de documentos ou processos/dossiês nãodigitais. "
            requisitoRPC2_6_6.save(flush: true)
        }

        def requisitoRPC2_6_7 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.7")
        if (!requisitoRPC2_6_7) {
            requisitoRPC2_6_7 = new Requisito()
            requisitoRPC2_6_7.numeroReferenciaMoreqJus = "RPC2.6.7"
            requisitoRPC2_6_7.obrigatorio = true
            requisitoRPC2_6_7.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_7.nome = "Assegurar que a recuperação de um documento ou\n" +
                    "processo/dossiê híbrido permita igualmente a recuperação dos\n" +
                    "metadados tanto da parte digital como da parte não-digital"
            requisitoRPC2_6_7.save(flush: true)
        }


        def requisitoRPC2_6_8 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.8")
        if (!requisitoRPC2_6_8) {
            requisitoRPC2_6_8 = new Requisito()
            requisitoRPC2_6_8.numeroReferenciaMoreqJus = "RPC2.6.8"
            requisitoRPC2_6_8.obrigatorio = true
            requisitoRPC2_6_8.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_8.nome = "Sempre que os documentos ou processos/dossiês híbridos\n" +
                    "estiverem classificados quanto ao grau de sigilo, garantir que o\n" +
                    "grau de sigilo seja estendido ao todo ou à parte,\n" +
                    "independentemente do suporte. "
            requisitoRPC2_6_8.save(flush: true)
        }

        def requisitoRPC2_6_9 = Requisito.findByNumeroReferenciaMoreqJus("RPC2.6.9")
        if (!requisitoRPC2_6_9) {
            requisitoRPC2_6_9 = new Requisito()
            requisitoRPC2_6_9.numeroReferenciaMoreqJus = "RPC2.6.9"
            requisitoRPC2_6_9.obrigatorio = true
            requisitoRPC2_6_9.subGrupoRequisito = subGrupo_2_6
            requisitoRPC2_6_9.nome = "Registrar na trilha de auditoria todas as alterações efetuadas nos\n" +
                    "metadados dos documentos ou processos/dossiês não-digitais ou\n" +
                    "híbridos."
            requisitoRPC2_6_9.save(flush: true)
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
