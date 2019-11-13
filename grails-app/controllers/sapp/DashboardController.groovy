package sapp

class DashboardController {

    def index() {
        def sistemasList = Sistema.createCriteria().list {
            order("nome")
        }
        model:[sistemasList: sistemasList]
    }
}
