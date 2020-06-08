package sapp

import grails.gorm.transactions.Transactional

@Transactional
class EstatisticaService {

     Integer getQuantidadeRequisitos(Formulario formulario, TipoResposta resposta, GrupoRequisito grupoRequisito){
         RespostaFormulario.createCriteria().count {
             createAlias("requisito","r")
             createAlias("r.subGrupoRequisito", "sr")
             eq("formulario", formulario)

             if(resposta){
                 eq("resposta",resposta.getValue())
             }


             if(grupoRequisito){
                 eq "sr.grupoRequisito", grupoRequisito
             }

         }
     }

    Integer getQuantidadeSubGrupoRequisitos(Formulario formulario, TipoResposta resposta, SubGrupoRequisito subGrupoRequisito){
        RespostaFormulario.createCriteria().count {
            createAlias("requisito","r")
            createAlias("r.subGrupoRequisito", "sr")
            eq("formulario", formulario)

            if(resposta){
                eq("resposta",resposta.getValue())
            }


            if(subGrupoRequisito){
                eq "r.subGrupoRequisito", subGrupoRequisito
            }

        }
    }

    Integer getQuantidadeItemRequisitos(Formulario formulario, TipoResposta resposta, SubGrupoRequisito subGrupoRequisito, Requisito requisito){
        RespostaFormulario.createCriteria().count {
            createAlias("requisito","r")
            createAlias("r.subGrupoRequisito", "sr")
            eq("formulario", formulario)

            if(resposta){
                eq("resposta",resposta.getValue())
            }



            if(subGrupoRequisito){
                eq "r.subGrupoRequisito", subGrupoRequisito
            }

            if(requisito){
                eq "requisito", requisito

            }

        }
    }


    List<Metadados> getMetadados(Formulario formulario){
        if(!formulario){
            return []
        }
        List<RespostaFormulario> respostaFormulariosList = RespostaFormulario.createCriteria().list {
            createAlias("requisito", "r")
            createAlias("r.subGrupoRequisito", "sr")
            eq("formulario", formulario)


            eq("resposta", TipoResposta.REQUISITO_ATENDIDO.value)

        }


        def metadadosObrigariosList = []
        for(requisito in  respostaFormulariosList.requisito ){
            def requisitoMetadados = RequisitoMetadados.createCriteria().list {
                eq("requisito", requisito)
            }
            if(requisitoMetadados){
                metadadosObrigariosList.addAll (requisitoMetadados.metadados)
            }
        }





        return metadadosObrigariosList.toSet().toList()
    }


}
