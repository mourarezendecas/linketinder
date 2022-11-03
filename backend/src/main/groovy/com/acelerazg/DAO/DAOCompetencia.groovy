package com.acelerazg.DAO

import com.acelerazg.Model.ModelCompetencia
import com.acelerazg.connection.IConnection
import com.acelerazg.connection.PostgreConnection
import groovy.sql.Sql

class DAOCompetencia {

    IConnection postgreConnection = new PostgreConnection()
    Map dbConnParams = postgreConnection.Connection()

    void create(ModelCompetencia c){
        List<String> atributos = [c.competencia]
        Sql sql = Sql.newInstance(dbConnParams)
        sql.executeInsert('INSERT INTO competencias (nome_competencia) VALUES (?)', atributos)
        sql.close()
    }

    void update(){
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

    void delete(){
        printf('ID DA COMPETENCIA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        def sqldelete = Sql.newInstance(dbConnParams)
        sqldelete.execute('DELETE FROM competencias WHERE id_competencia = ?', choice)
        println('EXCLUIDO!')
        sqldelete.close()
    }
}
