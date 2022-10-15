package com.acelerazg.main

import com.acelerazg.database.SqlFactory
import groovy.sql.Sql

class Menu {
    def initialpage(){
        println('---LINKETINDER---')
        println "1 - LISTAR TODOS OS CANDIDATOS"
        println "2 - LISTAR TODAS AS EMPRESAS"
        println "3 - CRIAR CANDIDATO"
        println "4 - CRIAR EMPRESA"
        println "5 - CURTIR CANDIDATOS OU EMPRESAS"
        println "6 - SAIR"
        printf "Escolha a opção: "
        def opt = System.in.newReader().readLine() as Integer
        switchMenu(opt)
    }

    void switchMenu(opt)
    {
        switch(opt)
        {
            case 1:
                println('Seleção 1')
                initialpage()
                break
//            case 2:
//                GeraCandidatoeEmpresa.listaEmpresas()
//                menu()
//                break
            case 3:
                println('INITIALIZING SERVER')
                SqlFactory.cadastracandidato()
                initialpage()
                break
//            case 4:
//                CriaEmpresa.cria()
//                menu()
//                break
//            case 5:
//                Curtidas.main()
//                menu()
//                break
        }
    }

}
