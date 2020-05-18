package sapp

class TeoremaBayes {
    private List<CategoriaSistema> categorias
    private List<Sistema> sistemas
    private List<PorcentagemSelo> porcentagemSeloList


    /**
     * Fará parte da analise somente os sistema que tenham respondido o formulario do moreqjus
     */
    private void carregarSistemaQueResponderamPeloMenosUmaVez(){
        this.sistemas = new ArrayList<Sistema>()
        for(sistemaBanco in Sistema.list()){
            def formularioRespondido = Formulario.createCriteria().get {
                eq("sistema", sistemaBanco)
                eq("finalizado", true)
                order("dataFinalizacao", "desc")
                maxResults(1)
            }

            if(formularioRespondido){
                this.sistemas +=sistemaBanco
            }
        }
    }

    private void carregarSelosParaCadaSistema(){
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
    }


    TeoremaBayes(List<CategoriaSistema> categoriaSistemas) {
        this.categorias = categoriaSistemas
        this.carregarSistemaQueResponderamPeloMenosUmaVez()
        this.carregarSelosParaCadaSistema()
        this.carregarPorcentagemSistemasPorSelo()



        print("")


    }

    private void carregarPorcentagemSistemasPorSelo() {

        for (c in this.categorias) {
            c.totalSistemas =  Sistema.createCriteria().count(){
                eq("categoriaSistema", c)
                'in'("id", sistemas.id)
            }
            c.porcentagem = c.totalSistemas * 1/ sistemas.size()


        }



        this.porcentagemSeloList = new ArrayList<PorcentagemSelo>()
        for(c in this.categorias){
            for(selo in SeloMoreqJus.values()){

                def porcentagemSelo = new PorcentagemSelo()
                porcentagemSelo.seloMoreqJus = selo
                porcentagemSelo.categoriaSistema = c
                porcentagemSelo.totalSistemas = sistemas.findAll{it.categoriaSistema==c && it.seloMoreqJus==selo}.size()
                porcentagemSelo.porcentagem = porcentagemSelo.totalSistemas * 1/ c.totalSistemas
                this.porcentagemSeloList += porcentagemSelo


            }

        }








    }

   Double probabilidadeSistema(CategoriaSistema categoriaSistema,  SeloMoreqJus seloMoreqJus) {
        def probabilidadeTotal = 0d
        for(c in this.categorias){
            def probabilidadeCategoriaComSelo = this.porcentagemSeloList.find{it.categoriaSistema==c && it.seloMoreqJus==seloMoreqJus}.porcentagem
            probabilidadeTotal+= (c.porcentagem) * probabilidadeCategoriaComSelo

        }


       if(probabilidadeTotal==0.0d){
           return  0.0d

       }

       return ( this.categorias.find{it.id==categoriaSistema.id}.porcentagem * this.porcentagemSeloList.find{it.categoriaSistema==categoriaSistema && it.seloMoreqJus==seloMoreqJus}.porcentagem)/probabilidadeTotal



    }


}
