package com.acelerazg.database

import groovy.sql.Sql
import com.acelerazg.classes.Vaga
import com.acelerazg.database.crudEmpresa

class crudVaga {
    static Map dbConnParams = [
            url: 'jdbc:postgresql://localhost:5432/linketinderdb',
            user: 'postgres',
            password: 'postgres',
            driver: 'org.postgresql.Driver']

    //CREATE
    static def cadastraVaga (){
        Vaga v = new Vaga()
        println()
        crudEmpresa.listaEmpresa()
        printf('SELECIONE O ID DA EMPRESA RESPONSÁVEL PELA VAGA: ')
        v.idEmpresa = (System.in.newReader().readLine() as Integer)
        printf('Nome da vaga: ')
        v.nome = (System.in.newReader().readLine())
        printf('Descrição: ')
        v.descricao = (System.in.newReader().readLine())
        printf('Modalidade (Presencial ou Remoto): ')
        v.modalidade = (System.in.newReader().readLine())

        List<String> atributos = [v.nome, v.descricao, v.modalidade]

        def sql = Sql.newInstance(dbConnParams)
        //Inserindo a vaga na tabela de vagas
        sql.executeInsert('INSERT INTO vagas (nome_vaga, descricao_vaga, modalidade_vaga) VALUES (?,?,?)', atributos)
        //Relacionando a vaga à empresa
        //sql.executeInsert('INSERT INTO vagasdaempresa (id_empresa, id_vaga) VALUES (?,?)', v.idEmpresa, 1)
        sql.close()

    }

    //READ
    static def listaVagas(){
        def sql = Sql.newInstance(dbConnParams)
        sql.eachRow("SELECT * FROM vagas"){
            vaga ->
                println('---ID DA VAGA: ' + vaga.id_vaga + '---')
                println('NOME: ' + vaga.nome_vaga)
                println('DESCRIÇÃO: ' + vaga.descricao_vaga)
                println('MODALIDADE: ' + vaga.modalidade_vaga)
                println()
        }
        sql.close()
    }

    //UPDATE
    static def atualizaVagas(){
        def sql = Sql.newInstance(dbConnParams)
        println('SELECIONE O ID DA VAGA QUE DESEJA ATUALIZAR: ')
        println()
        sql.eachRow("SELECT * FROM vagas"){
            vaga ->
                println('---ID DA VAGA: ' + vaga.id_vaga + '---')
                println('NOME: ' + vaga.nome_vaga)
                println()
        }
        sql.close()

        printf('ID DA VAGA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        println('O QUE DESEJA ATUALIZAR?')
        println('1 - Nome')
        println('2 - Descrição')
        println('3 - Modalidade')
        int opt = (System.in.newReader().readLine() as Integer)

        switch (opt) {
            case 1:
                printf('Digite o nome correto: ')
                String novonome = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE vagas SET nome_vaga = ? WHERE id_vaga = ?', novonome, choice)
                sqlupdate.close()
                break
            case 2:
                printf('Digite a descrição correta: ')
                String novadata = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE vagas SET descricao_vaga = ? WHERE id_vaga = ?', novadata, choice)
                sqlupdate.close()
                break
            case 3:
                printf('Digite a modalidade correta (Remoto ou Presecial): ')
                String novocpf = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE vagas SET modalidade_vaga = ? WHERE id_vaga = ?', novocpf, choice)
                sqlupdate.close()
                break
        }
    }

    //DELETE
    static def deletaVagas(){
        def sql = Sql.newInstance(dbConnParams)
        println('SELECIONE O ID DA VAGA QUE DESEJA DELETAR: ')
        println()
        sql.eachRow("SELECT * FROM vagas"){
            vaga ->
                println('---ID DA VAGA: ' + vaga.id_vaga + '---')
                println('NOME: ' + vaga.nome_vaga)
                println()
        }
        sql.close()

        printf('ID DO CANDIDATO: ')
        int choice = (System.in.newReader().readLine() as Integer)

        def sqldelete = Sql.newInstance(dbConnParams)
        sqldelete.execute('DELETE FROM vagas WHERE id_vaga = ?', choice)
        println('EXCLUIDO!')
        sqldelete.close()
    }
}
