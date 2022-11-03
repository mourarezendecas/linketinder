package com.acelerazg.main

import com.acelerazg.Controller.CandidatoCRUD
import com.acelerazg.Controller.EmpresaCRUD
import com.acelerazg.Controller.ICrud
import com.acelerazg.Controller.VagaCRUD

class Menu {
    ICrud candidatoCRUD = new CandidatoCRUD()
    ICrud empresaCRUD = new EmpresaCRUD()
    ICrud vagaCRUD = new VagaCRUD()

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
                candidatoCRUD.create()
                initialpage()
                break
            case 2:
                empresaCRUD.create()
                initialpage()
                break
            case 3:
                vagaCRUD.create()
                initialpage()
                break
            case 4:
                candidatoCRUD.read()
                initialpage()
                break
            case 5:
                empresaCRUD.read()
                initialpage()
                break
            case 6:
                vagaCRUD.read()
                initialpage()
                break
            case 7:
                candidatoCRUD.update()
                initialpage()
            case 8:
                empresaCRUD.update()
                initialpage()
            case 9:
                vagaCRUD.update()
                initialpage()
            case 10:
                candidatoCRUD.delete()
                initialpage()
                break
            case 11:
                empresaCRUD.delete()
                initialpage()
                break
            case 12:
                vagaCRUD.delete()
                initialpage()
                break
        }
    }

}
