package sapp

import grails.gorm.services.Service

@Service(Formulario)
interface FormularioService {

    Formulario get(Serializable id)

    List<Formulario> list(Map args)

    Long count()

    void delete(Serializable id)

    Formulario save(Formulario formulario)

}