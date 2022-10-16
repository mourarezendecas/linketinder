package com.acelerazg.database

import com.acelerazg.classes.Candidato
import groovy.sql.Sql

class crudCandidato {
    static Map dbConnParams = [
            url: 'jdbc:postgresql://localhost:5432/linketinderdb',
            user: 'postgres',
            password: 'postgres',
            driver: 'org.postgresql.Driver']

    //CREATE
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

    //READ
    static def listaCandidato(){
        def sql = Sql.newInstance(dbConnParams)
        sql.eachRow("SELECT * FROM candidatos"){
            candidato ->
                println('---ID DO CANDIDATO: ' + candidato.id_candidato + '---')
                println('NOME: ' + candidato.nome_candidato)
                println('DATA DE NASC.: ' + candidato.data_nascimento)
                println('CPF: ' + candidato.cpf)
                println('PAIS: ' + candidato.pais_candidato)
                println('CEP: ' + candidato.cep_candidato)
                println('EMAIL: '+ candidato.email_candidato)
                println('DESCRIÇÃO: ' + candidato.descricao_candidato)
                println()
        }
        sql.close()
    }

    //UPDATE
    static def atualizacandidato(){
        def sql = Sql.newInstance(dbConnParams)
        println('SELECIONE O ID DO CANDIDATO QUE DESEJA ATUALIZAR: ')
        println()
        sql.eachRow("SELECT * FROM candidatos"){
            candidato ->
                println('---ID DO CANDIDATO: ' + candidato.id_candidato + '---')
                println('NOME: ' + candidato.nome_candidato)
                println()
        }
        sql.close()

        printf('ID DO CANDIDATO: ')
        int choice = (System.in.newReader().readLine() as Integer)

        println('O QUE DESEJA ATUALIZAR?')
        println('1 - Nome')
        println('2 - Data de nascimento')
        println('3 - CPF')
        println('4 - E-mail')
        println('5 - País')
        println('6 - CEP')
        println('7 - Descrição')
        println('8 - Senha')
        int opt = (System.in.newReader().readLine() as Integer)

        switch (opt)
        {
            case 1:
                printf('Digite o nome correto: ')
                String novonome = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE candidatos SET nome_candidato = ? WHERE id_candidato = ?' ,novonome,choice)
                sqlupdate.close()
                break
            case 2:
                printf('Digite a data de nascimento correta: ')
                String novadata = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE candidatos SET data_nascimento = ? WHERE id_candidato = ?' ,novadata,choice)
                sqlupdate.close()
                break
            case 3:
                printf('Digite o cpf correto: ')
                String novocpf = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE candidatos SET cpf = ? WHERE id_candidato = ?' ,novocpf,choice)
                sqlupdate.close()
                break
            case 4:
                printf('Digite o e-mail correto: ')
                String novoemail = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE candidatos SET email_candidato = ? WHERE id_candidato = ?' ,novoemail,choice)
                sqlupdate.close()
                break
            case 5:
                printf('Digite o país correto: ')
                String novopais = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE candidatos SET pais_candidato = ? WHERE id_candidato = ?' ,novopais,choice)
                sqlupdate.close()
                break
            case 6:
                printf('Digite o CEP correto: ')
                String novocep = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE candidatos SET cep_candidato = ? WHERE id_candidato = ?' ,novocep,choice)
                sqlupdate.close()
                break
            case 7:
                printf('Digite a nova descrição: ')
                String novadescricao = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE candidatos SET descricao_candidato = ? WHERE id_candidato = ?' ,novadescricao,choice)
                sqlupdate.close()
                break
            case 8:
                printf('Digite a nova senha: ')
                String novasenha = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE candidatos SET senha_candidato = ? WHERE id_candidato = ?' ,novasenha,choice)
                sqlupdate.close()
                break
        }
    }

    //DELETE
    static def deletaCandidato(){
        def sql = Sql.newInstance(dbConnParams)
        println('SELECIONE O ID DO CANDIDATO QUE DESEJA DELETAR: ')
        println()
        sql.eachRow("SELECT * FROM candidatos"){
            candidato ->
                println('---ID DO CANDIDATO: ' + candidato.id_candidato + '---')
                println('NOME: ' + candidato.nome_candidato)
                println()
        }
        sql.close()

        printf('ID DO CANDIDATO: ')
        int choice = (System.in.newReader().readLine() as Integer)

        def sqldelete = Sql.newInstance(dbConnParams)
        sqldelete.execute('DELETE FROM candidatos WHERE id_candidato = ?', choice)
        println('EXCLUIDO!')
        sqldelete.close()
    }
}