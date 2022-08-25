package com.acelera

import com.acelera.generators.CriaCandidato
import com.acelera.generators.CriaEmpresa
import com.acelera.generators.GeraCandidatoeEmpresa
import com.acelera.main.Curtidas

//Invoca a Classe geradora de Candidatos e Empresas
    GeraCandidatoeEmpresa.geraCandidatos()
    GeraCandidatoeEmpresa.geraEmpresas()

    menu()

    def menu()
    {
        println "---LINKETINDER---"
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

    void switchMenu(opt){
        switch(opt)
        {
            case 1:
                GeraCandidatoeEmpresa.listaCandidatos()
                menu()
                break
            case 2:
                GeraCandidatoeEmpresa.listaEmpresas()
                menu()
                break
            case 3:
                CriaCandidato.cria()
                menu()
                break
            case 4:
            CriaEmpresa.cria()
                menu()
                break
            case 5:
                Curtidas.main()
                menu()
                break
        }
    }