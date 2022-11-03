package com.acelerazg.Controller

import com.acelerazg.DAO.DAOEmpresa
import com.acelerazg.Model.ModelEmpresa
import com.acelerazg.connection.IConnection
import com.acelerazg.connection.PostgreConnection
import groovy.sql.Sql

class EmpresaCRUD implements ICrud{
    IConnection postgreConnection = new PostgreConnection()
    Map dbConnParams = postgreConnection.Connection()

    DAOEmpresa daoEmpresa = new DAOEmpresa()

    @Override
    void create() {
        ModelEmpresa e = new ModelEmpresa()
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

        daoEmpresa.create(e)
    }

    @Override
    void read() {
        Sql sql = Sql.newInstance(dbConnParams)
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

    @Override
    void update() {
        println('SELECIONE O ID DA EMPRESA QUE DESEJA ATUALIZAR: ')
        read()
        daoEmpresa.update()
    }

    @Override
    void delete() {
        println('SELECIONE O ID DA EMPRESA QUE DESEJA DELETAR: ')
        read()
        daoEmpresa.delete()
    }
}
