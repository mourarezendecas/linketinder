package com.acelerazg.main

import com.acelerazg.database.SqlFactory
import groovy.sql.Sql

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
        def opt = System.in.newReader().readLine() as Integer
        switchMenu(opt)
    }

    void switchMenu(opt)
    {
        switch(opt)
        {
            case 1:
                //CADASTRAR CANDIDATO
                println('INITIALIZING SERVER')
                println()
                SqlFactory.cadastracandidato()
                initialpage()
                break
            case 4:
                //LISTAR CANDIDATO
                println('INITIALIZING SERVER')
                println()
                SqlFactory.listaCandidato()
                initialpage()
                break
            case 7:
                //ATUALIZAR CANDIDATO
                println('INITIALIZING SERVER')
                println()
                SqlFactory.atualizacandidato()
                initialpage()
            case 10:
                //DELETAR CANDIDATO
                println ('INITIALIZING SERVER')
                println()
                SqlFactory.deletaCandidato()
                initialpage()
                break
        }
    }

}
