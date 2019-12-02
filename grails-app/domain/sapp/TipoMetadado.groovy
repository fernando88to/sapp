package sapp

enum TipoMetadado {

    SEGURANCA(1), AUDITORIA(2), PRESERVACAO(3)

    TipoMetadado(int value) {
        this.value = value
    }
    private final int value
    int getValue() {
        value
    }

    static TipoMetadado getEnum(Integer value){
        def lista = TipoMetadado.values()
        for(e in lista){
            if(e.value==value){
                return e
            }
        }
        return null
    }


    @Override
    String toString() {
        switch (this.value){
            case 1 :
                return "Elementos de metadados de segurança"
                break
            case 2 :
                return "Elementos de metadados de auditoria"
                break
            case 3 :
                return "Elementos de metadados de preservação"
                break


            return ""
        }

    }
}
