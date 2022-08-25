package com.acelera.generators

import com.acelera.classes.Candidato
import spock.lang.Specification

class CriaCandidatoTest extends Specification {
    Candidato candidato = new Candidato(
            nome: "testeNome",
            email: "testEmail@mail.me",
            CPF: "000.000.000-00",
            estado: "XX",
            CEP: "00000-000",
            descPessoal: "testeDesc",
            idade: 99,
            competencias: [],
            empresasCurtidas: [])

    def "Adição de competencias"(){
        when:
            candidato.competencias.add("Swift")
        then:
            candidato.competencias.contains("Swift")
    }
}
