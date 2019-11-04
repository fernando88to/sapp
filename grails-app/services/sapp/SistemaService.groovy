package sapp

import grails.gorm.services.Service

@Service(Sistema)
interface SistemaService {

    Sistema get(Serializable id)

    List<Sistema> list(Map args)

    Long count()

    void delete(Serializable id)

    Sistema save(Sistema sistema)

}