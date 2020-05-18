package sapp

class PorcentagemSelo {
    SeloMoreqJus seloMoreqJus
    Double porcentagem
    CategoriaSistema categoriaSistema
    Integer totalSistemas
    Double probabilidade

    PorcentagemSelo() {
    }

    PorcentagemSelo(SeloMoreqJus seloMoreqJus, Double porcentagem, CategoriaSistema categoriaSistema, Integer totalSistemas) {
        this.seloMoreqJus = seloMoreqJus
        this.porcentagem = porcentagem
        this.categoriaSistema = categoriaSistema
        this.totalSistemas = totalSistemas
    }
}
