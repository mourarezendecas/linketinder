package com.acelerazg.Controller

import com.acelerazg.DAO.DAOCompetencia
import com.acelerazg.Model.ModelCompetencia
import com.acelerazg.connection.IConnection
import com.acelerazg.connection.PostgreConnection
import groovy.sql.Sql

class CompetenciaCRUD {
    IConnection postgreConnection = new PostgreConnection()
    Map dbConnParams = postgreConnection.Connection()

    DAOCompetencia daoCompetencia = new DAOCompetencia()

    void create(){
        ModelCompetencia c = new ModelCompetencia()
        println()
        printf('Nome da competência: ')
        c.competencia = (System.in.newReader().readLine())
        daoCompetencia.create(c)
    }

    void read(){
        Sql sql = Sql.newInstance(dbConnParams)
        sql.eachRow("SELECT * FROM competencias"){
            competencia ->
                println('---ID DA COMPETENCIA: ' + competencia.id_competencia + '---')
                println('NOME: ' + competencia.nome_competencia)
                println()
        }
        sql.close()
    }

    void update(){
        println('SELECIONE O ID DA COMPETENCIA QUE DESEJA ATUALIZAR: ')
        read()
        daoCompetencia.update()
    }

    void delete(){
        println('SELECIONE O ID DA COMPETENCIA QUE DESEJA DELETAR: ')
        read()
        daoCompetencia.delete()
    }
}
