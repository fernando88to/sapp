package sapp

import grails.converters.JSON

class DashboardController {


    def index() {
        def sistemasList = Sistema.createCriteria().list {
            order("nome")
        }
        model:[sistemasList: sistemasList]
    }

    def json() {
        def questionario= Formulario.createCriteria().get {
            maxResults(1)
        }

        render questionario as JSON
    }
}
