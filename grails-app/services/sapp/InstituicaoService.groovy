package sapp

import grails.gorm.services.Service

@Service(Instituicao)
interface InstituicaoService {

    Instituicao get(Serializable id)

    List<Instituicao> list(Map args)

    Long count()

    void delete(Serializable id)

    Instituicao save(Instituicao instituicao)

}