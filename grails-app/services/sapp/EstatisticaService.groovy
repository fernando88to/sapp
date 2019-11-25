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


}
