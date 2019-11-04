package sapp

import grails.gorm.services.Service


@Service(Instituicao)
public  abstract  class InstituicaoService implements IInstituicaoService{

    Instituicao getInstituicaoPrincipal(){
        Instituicao.get(1l)
    }

}

interface IInstituicaoService {

    Instituicao get(Serializable id)

    List<Instituicao> list(Map args)

    Long count()

    void delete(Serializable id)

    Instituicao save(Instituicao instituicao)





}
