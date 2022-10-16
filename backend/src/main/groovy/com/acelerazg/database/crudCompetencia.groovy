package com.acelerazg.database

import com.acelerazg.classes.Competencia
import groovy.sql.Sql

class crudCompetencia {
    static Map dbConnParams = [
            url: 'jdbc:postgresql://localhost:5432/linketinderdb',
            user: 'postgres',
            password: 'postgres',
            driver: 'org.postgresql.Driver']

    //CREATE
    static def cadastraCompetencia(){
        Competencia c = new Competencia()
        println()
        printf('Nome da competência: ')
        c.competencia = (System.in.newReader().readLine())

        List<String> atributos = [c.competencia]

        def sql = Sql.newInstance(dbConnParams)
        sql.executeInsert('INSERT INTO competencias (nome_competencia) VALUES (?)', atributos)
        sql.close()
    }

    //READ
    static def listaCompetencia(){
        def sql = Sql.newInstance(dbConnParams)
        sql.eachRow("SELECT * FROM competencias"){
            competencia ->
                println('---ID DA COMPETENCIA: ' + competencia.id_competencia + '---')
                println('NOME: ' + competencia.nome_competencia)
                println()
        }
        sql.close()
    }

    //UPDATE
    static def atualizaCompetencia(){
        def sql = Sql.newInstance(dbConnParams)
        println('SELECIONE O ID DA COMPETENCIA QUE DESEJA ATUALIZAR: ')
        println()
        sql.eachRow("SELECT * FROM competencias"){
            competencia ->
                println('---ID DA COMPETENCIA: ' + competencia.id_competencia + '---')
                println('NOME: ' + competencia.nome_competencia)
                println()
        }
        sql.close()

        printf('ID DA COMPETENCIA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        println('O QUE DESEJA ATUALIZAR?')
        println('1 - Nome')
        int opt = (System.in.newReader().readLine() as Integer)

        switch (opt) {
            case 1:
                printf('Digite o nome correto: ')
                String novonome = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE competencias SET nome_competencia = ? WHERE id_competencia = ?', novonome, choice)
                sqlupdate.close()
                break
        }
    }

    //DELETE
    static def deletaCompetencia(){
        def sql = Sql.newInstance(dbConnParams)
        println('SELECIONE O ID DA COMPETENCIA QUE DESEJA DELETAR: ')
        println()
        sql.eachRow("SELECT * FROM competencias"){
            competencia ->
                println('---ID DA COMPETENCIA: ' + competencia.id_competencia + '---')
                println('NOME: ' + competencia.nome_competencia)
                println()
        }
        sql.close()

        printf('ID DA COMPETENCIA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        def sqldelete = Sql.newInstance(dbConnParams)
        sqldelete.execute('DELETE FROM competencias WHERE id_competencia = ?', choice)
        println('EXCLUIDO!')
        sqldelete.close()
    }
}
