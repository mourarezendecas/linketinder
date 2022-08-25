package com.acelera.main

import com.acelera.classes.Candidato
import com.acelera.classes.Empresa
import com.acelera.generators.GeraCandidatoeEmpresa

class Curtidas {
    static def void main(){
        int i = 1
        println "1 - ACESSAR COMO EMPRESA"
        println "2 - ACESSAR COMO CANDIDATO"
        printf "Digite a opção desejada: "
        def opt = System.in.newReader().readLine() as Integer

        if(opt==1) {
            printf "Qual empresa é você? "
            def empresaCurtindo = System.in.newReader().readLine() as String

            for (Empresa empresa : GeraCandidatoeEmpresa.getEmpresas()) {
                if (empresaCurtindo.equals(empresa.nome)) {
                   for(Candidato candidato : GeraCandidatoeEmpresa.getCandidatos()) {
                       println candidato.toString()
                       printf "Deseja curtir esse candidato? (1 - Sim / 2 - Não): "
                       def curtir = System.in.newReader().readLine() as Integer
                       if (curtir == 1) {
                           empresa.curtida(candidato)
                       }
                   }
                }
            }

        }
        else
        {
            printf "Qual candidato é você? "
            def candidatoCurtindo = System.in.newReader().readLine() as String
            for (Candidato candidato : GeraCandidatoeEmpresa.getCandidatos()) {
                if(candidatoCurtindo.equals(candidato.nome))
                {
                    for (Empresa empresa : GeraCandidatoeEmpresa.getEmpresas())
                    {
                        println empresa.toString()
                        printf "Deseja curtir essa empresa? (1 - Sim / 2 - Não): "
                        def curtir = System.in.newReader().readLine() as Integer
                        if (curtir == 1) {
                            candidato.curtida(empresa)
                        }
                    }
                }
            }
        }


    }
}
