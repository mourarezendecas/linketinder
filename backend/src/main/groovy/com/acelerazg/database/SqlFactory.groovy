package com.acelerazg.database

import com.acelerazg.classes.Candidato
import groovy.sql.Sql



class SqlFactory {
    static Map dbConnParams = [
            url: 'jdbc:postgresql://localhost:5432/linketinderdb',
            user: 'postgres',
            password: 'postgres',
            driver: 'org.postgresql.Driver']

    static def cadastracandidato(){
        Candidato c = new Candidato()
        println('---CADASTRO DE CANDIDATO---')
        printf('Digite o nome: ')
        c.nome = (System.in.newReader().readLine())
        printf('Digite a data de nascimento (AAAA-MM-DD): ')
        c.data_nasc = (System.in.newReader().readLine())
        printf('Digite o CPF: ')
        c.cpf = (System.in.newReader().readLine())
        printf('Digite o e-mail: ')
        c.email = (System.in.newReader().readLine())
        printf('Digite o país: ')
        c.pais = (System.in.newReader().readLine())
        printf('Digite o CEP: ')
        c.cep = (System.in.newReader().readLine())
        printf('Nos dê uma breve descrição: ')
        c.descricao = (System.in.newReader().readLine())
        printf('Informe a senha: ')
        c.senha = (System.in.newReader().readLine())

        List<String> atributos = [c.nome, c.data_nasc, c.cpf, c.email, c.pais, c.cep, c.descricao, c.senha]
        def sql = Sql.newInstance(dbConnParams)

        sql.executeInsert('INSERT INTO candidatos (nome_candidato, data_nascimento, cpf, email_candidato, pais_candidato, cep_candidato, descricao_candidato, senha_candidato) VALUES (?,?,?,?,?,?,?,?)', atributos)

        sql.close()
    }


}

