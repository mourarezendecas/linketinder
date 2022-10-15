package com.acelerazg.database

import groovy.sql.Sql
import com.acelerazg.classes.Empresa

class crudEmpresa {
    static Map dbConnParams = [
            url: 'jdbc:postgresql://localhost:5432/linketinderdb',
            user: 'postgres',
            password: 'postgres',
            driver: 'org.postgresql.Driver']
    //CREATE
    static def cadastraEmpresa(){
        Empresa e = new Empresa()
        println('---CADASTRO DE EMPRESA---')
        printf('Digite o nome da empresa: ')
        e.nome = (System.in.newReader().readLine())
        printf('Digite o CNPJ: ')
        e.cnpj = (System.in.newReader().readLine())
        printf('Digite o e-mail corporativo: ')
        e.email = (System.in.newReader().readLine())
        printf('Digite o país: ')
        e.pais = (System.in.newReader().readLine())
        printf('Digite o CEP: ')
        e.cep = (System.in.newReader().readLine())
        printf('Nos dê uma breve descrição: ')
        e.descricao = (System.in.newReader().readLine())
        printf('Informe a senha: ')
        e.senha = (System.in.newReader().readLine())

        List<String> atributos = [e.nome, e.cnpj, e.email, e.pais, e.cep, e.descricao, e.senha]
        def sql = Sql.newInstance(dbConnParams)
        sql.executeInsert('INSERT INTO empresas (nome_empresa, cnpj, email_empresa, pais_empresa, cep_empresa, descricao_empresa, senha_empresa) VALUES (?,?,?,?,?,?,?)', atributos)
        sql.close()
    }

    //READ
    static def listaEmpresa(){
        def sql = Sql.newInstance(dbConnParams)
        sql.eachRow("SELECT * FROM empresas"){
            empresa ->
                println('---ID DA EMPRESA: ' + empresa.id_empresa + '---')
                println('NOME: ' + empresa.nome_empresa)
                println('CNPJ: ' + empresa.cnpj)
                println('PAIS: ' + empresa.pais_empresa)
                println('CEP: ' + empresa.cep_empresa)
                println('EMAIL CORPORATIVO: '+ empresa.email_empresa)
                println('DESCRIÇÃO: ' + empresa.descricao_empresa)
                println()
        }
        sql.close()
    }

    //UPDATE
    static def atualizaEmpresa(){
        def sql = Sql.newInstance(dbConnParams)
        println('SELECIONE O ID DA EMPRESA QUE DESEJA ATUALIZAR: ')
        println()
        sql.eachRow("SELECT * FROM empresas"){
            candidato ->
                println('---ID DA EMPRESA: ' + empresa.id_empresa + '---')
                println('NOME: ' + empresa.nome_empresa)
                println()
        }
        sql.close()

        printf('ID DA EMPRESA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        println('O QUE DESEJA ATUALIZAR?')
        println('1 - Nome')
        println('2 - CNPJ')
        println('3 - E-mail')
        println('4 - País')
        println('5 - CEP')
        println('6 - Descrição')
        println('7 - Senha')
        int opt = (System.in.newReader().readLine() as Integer)

        switch (opt)
        {
            case 1:
                printf('Digite o nome correto: ')
                String novonome = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET nome_empresa = ? WHERE id_empresa = ?' ,novonome,choice)
                sqlupdate.close()
                break
            case 2:
                printf('Digite o cnpj correto: ')
                String novocpf = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET cnpj = ? WHERE id_empresa = ?' ,novocpf,choice)
                sqlupdate.close()
                break
            case 3:
                printf('Digite o e-mail correto: ')
                String novoemail = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET email_empresa = ? WHERE id_empresa = ?' ,novoemail,choice)
                sqlupdate.close()
                break
            case 4:
                printf('Digite o país correto: ')
                String novopais = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET pais_empresa = ? WHERE id_empresa = ?' ,novopais,choice)
                sqlupdate.close()
                break
            case 5:
                printf('Digite o CEP correto: ')
                String novocep = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET cep_empresa = ? WHERE id_empresa = ?' ,novocep,choice)
                sqlupdate.close()
                break
            case 6:
                printf('Digite a nova descrição: ')
                String novadescricao = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET descricao_empresa = ? WHERE id_empresa = ?' ,novadescricao,choice)
                sqlupdate.close()
                break
            case 7:
                printf('Digite a nova senha: ')
                String novasenha = (System.in.newReader().readLine())
                def sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET senha_empresa = ? WHERE id_empresa = ?' ,novasenha,choice)
                sqlupdate.close()
                break
        }
    }

    //DELETE
    static def deletaEmpresa(){
        def sql = Sql.newInstance(dbConnParams)
        println('SELECIONE O ID DA EMPRESA QUE DESEJA DELETAR: ')
        println()
        sql.eachRow("SELECT * FROM empresas"){
            empresa ->
                println('---ID DA EMPRESA: ' + empresa.id_empresa + '---')
                println('NOME: ' + empresa.nome_empresa)
                println()
        }
        sql.close()

        printf('ID DA EMPRESA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        def sqldelete = Sql.newInstance(dbConnParams)
        sqldelete.execute('DELETE FROM empresas WHERE id_empresa = ?', choice)
        println('EXCLUIDO!')
        sqldelete.close()
    }
}
