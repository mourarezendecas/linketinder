package com.acelerazg.generators

import com.acelerazg.classes.Candidato
import com.acelerazg.classes.Empresa

class GeraCandidatoeEmpresa {
   static ArrayList Candidatos = []
   static ArrayList Empresas = []

    static ArrayList geraCandidatos () {


        Candidato c1 = new Candidato(
                nome: "Gabriel Rezende",
                email: "gabrielrezende@gmail.com",
                CPF: "000.000.000-00",
                estado: "GO",
                CEP: "74650-000",
                descPessoal: "Proativo e etc",
                idade: 25,
                competencias: ["Swift", "Kotlin"])
        Candidatos.add(c1)

        Candidato c2 = new Candidato(
                nome: "Alana Freitas",
                email: "alanafreitas@gmail.com",
                CPF: "000.000.000-00",
                estado: "SP",
                CEP: "74650-000",
                descPessoal: "Proativo e etc",
                idade: 23,
                competencias: ["Angular", "Java", "Spring Framework"])
        Candidatos.add(c2)

        Candidato c3 = new Candidato(
                nome: "Maria Eduarda",
                email: "mariaeduarda@gmail.com",
                CPF: "000.000.000-00",
                estado: "RJ",
                CEP: "74650-000",
                descPessoal: "Esforçada",
                idade: 35,
                competencias: ["Swift"])
        Candidatos.add(c3)

        Candidato c4 = new Candidato(
                nome: "Paulo Ricardo",
                email: "pauloricardo@gmail.com",
                CPF: "000.000.000-00",
                estado: "GO",
                CEP: "74650-000",
                descPessoal: "Honesto",
                idade: 25,
                competencias: ["Kotlin", "Python"])
        Candidatos.add(c4)

        Candidato c5 = new Candidato(
                nome: "Mark Zuckeberg",
                email: "himark@gmail.com",
                CPF: "000.000.000-00",
                estado: "GO",
                CEP: "74650-000",
                descPessoal: "Provavelmente vai roubar sua ideia",
                idade: 45,
                competencias: ["Java"])
        Candidatos.add(c5)

        return Candidatos
    }

    static ArrayList geraEmpresas()
    {
        Empresa e1 = new Empresa(
                nome: "Apple",
                email: "jobs@apple.com",
                CNPJ: "00.000.0001/00",
                pais: "USA",
                CEP: "123123123",
                descricao: "One more thing...",
                competencias: ["Swift","Java"])
        Empresas.add(e1)

        Empresa e2 = new Empresa(
                nome: "ZG Soluções",
                email: "jobs@zg.com",
                CNPJ: "00.000.0001/00",
                pais: "BR",
                CEP: "123123123",
                descricao: "Solucionando",
                competencias: ["Java", "Spring Framework"])
        Empresas.add(e2)

        Empresa e3 = new Empresa(
                nome: "Amazon",
                email: "jobs@amazon.com",
                CNPJ: "00.000.0001/00",
                pais: "USA",
                CEP: "123123123",
                descricao: "Entregando",
                competencias: ["Java", "Spring Framework"])
        Empresas.add(e3)

        Empresa e4 = new Empresa(
                nome: "Roystar Royco",
                email: "jobs@rr.com",
                CNPJ: "00.000.0001/00",
                pais: "USA",
                CEP: "123123123",
                descricao: "Negócio de família",
                competencias: ["Kotlin"])
        Empresas.add(e4)

        Empresa e5 = new Empresa(
                nome: "Nubank",
                email: "jobs@nubank.com",
                CNPJ: "00.000.0001/00",
                pais: "BR",
                CEP: "123123123",
                descricao: "Pense Roxo",
                competencias: ["Swift", "Kotlin"])
        Empresas.add(e5)

        return Empresas
    }

    static def listaCandidatos(){
        for(candidato in Candidatos)
        {
            println candidato
        }
    }

    static  def listaEmpresas(){
        for(empresa in Empresas)
        {
            println empresa
        }
    }

    static def addCandidato(Candidato candidato)
    {
        Candidatos.add(candidato)
    }

    static def addEmpresas(Empresa empresa)
    {
        Empresas.add(empresa)
    }

    static ArrayList getCandidatos() {
        return Candidatos
    }

    static ArrayList getEmpresas() {
        return Empresas
    }
}
