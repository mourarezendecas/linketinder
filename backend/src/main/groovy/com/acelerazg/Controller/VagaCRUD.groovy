package com.acelerazg.Controller

import com.acelerazg.DAO.DAOEmpresa
import com.acelerazg.DAO.DAOVaga
import com.acelerazg.Model.ModelVaga
import com.acelerazg.connection.IConnection
import com.acelerazg.connection.PostgreConnection
import groovy.sql.Sql

class VagaCRUD implements ICrud{
    EmpresaCRUD empresaCRUD = new EmpresaCRUD()

    IConnection postgreConnection = new PostgreConnection()
    Map dbConnParams = postgreConnection.Connection()

    DAOVaga daoVaga = new DAOVaga()

    @Override
    void create() {
        ModelVaga v = new ModelVaga()
        empresaCRUD.read()

        printf('SELECIONE O ID DA EMPRESA RESPONSÁVEL PELA VAGA: ')
        v.idEmpresa = (System.in.newReader().readLine() as Integer)
        printf('Nome da vaga: ')
        v.nome = (System.in.newReader().readLine())
        printf('Descrição: ')
        v.descricao = (System.in.newReader().readLine())
        printf('Modalidade (Presencial ou Remoto): ')
        v.modalidade = (System.in.newReader().readLine())

        daoVaga.create(v)
    }

    @Override
    void read() {
        Sql sql = Sql.newInstance(dbConnParams)
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

    @Override
    void update() {
        println('SELECIONE O ID DA VAGA QUE DESEJA ATUALIZAR: ')
        read()
        daoVaga.update()
    }

    @Override
    void delete() {
        println('SELECIONE O ID DA VAGA QUE DESEJA DELETAR: ')
        read()
        daoVaga.delete()
    }
}
