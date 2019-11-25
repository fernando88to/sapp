package sapp

enum TipoResposta {

    REQUISITO_ATENDIDO(1), REQUISITO_NAO_ATENDIDO(2), NAO_SE_APLICA(3)

    TipoResposta(int value) {
        this.value = value
    }
    private final int value
    int getValue() {
        value
    }


}
