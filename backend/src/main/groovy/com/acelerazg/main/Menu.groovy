package com.acelerazg.main

import com.acelerazg.database.crudCandidato
import com.acelerazg.database.crudEmpresa
import com.acelerazg.database.crudVaga

class Menu {
    def initialpage(){
        println('---LINKETINDER---')
        println "1 - CRIAR CANDIDATO"
        println "2 - CRIAR EMPRESA"
        println "3 - CRIAR VAGA"
        println "4 - LISTAR TODOS OS CANDIDATOS"
        println "5 - LISTAR TODAS AS EMPRESAS"
        println "6 - LISTAR TODAS AS VAGAS"
        println "7 - ATUALIZAR CANDIDATO"
        println "8 - ATUALIZAR EMPRESA"
        println "9 - ATUALIZAR VAGAS"
        println "10 - DELETAR CANDIDATO"
        println "11 - DELETAR EMPRESA"
        println "12 - DELETAR VAGA"
        println "13 - CURTIR CANDIDATOS OU EMPRESAS"
        println "14 - SAIR"
        printf "Escolha a opção: "
        Integer opt = System.in.newReader().readLine() as Integer
        switchMenu(opt)
    }

    void switchMenu(opt)
    {
        switch(opt)
        {
            case 1:
                crudCandidato.cadastracandidato()
                initialpage()
                break
            case 2:
                crudEmpresa.cadastraEmpresa()
                initialpage()
                break
            case 3:
                crudVaga.cadastraVaga()
                initialpage()
                break
            case 4:
                crudCandidato.listaCandidato()
                initialpage()
                break
            case 5:
                crudEmpresa.listaEmpresa()
                initialpage()
                break
            case 6:
                crudVaga.listaVagas()
                initialpage()
                break
            case 7:
                crudCandidato.atualizacandidato()
                initialpage()
            case 8:
                crudEmpresa.atualizaEmpresa()
                initialpage()
            case 9:
                crudVaga.atualizaVagas()
                initialpage()
            case 10:
                crudCandidato.deletaCandidato()
                initialpage()
                break
            case 11:
                crudEmpresa.deletaEmpresa()
                initialpage()
                break
            case 12:
                crudVaga.deletaVagas()
                initialpage()
                break
        }
    }

}
