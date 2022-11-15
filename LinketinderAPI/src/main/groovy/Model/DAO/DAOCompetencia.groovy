package Model.DAO

import DatabaseConnection.ModelConnection
import groovy.sql.Sql
import Model.Classes.ModelCompetencia

class DAOCompetencia {
    ModelConnection modelConnection = new ModelConnection()

    void create(ModelCompetencia competencia){
        List<String> atributos = [competencia.nome_competencia]
        Sql sql = modelConnection.connect()
        sql.executeInsert("INSERT INTO competencias (nome_competencia) VALUES (?)", atributos)
        sql.close()
    }

    void read(){
        println "---READING ALL---"
        Sql sql = modelConnection.connect()
        sql.eachRow("SELECT * FROM competencias"){
            competencia ->
                println("ID: " + competencia.id_competencia)
                println("NOME: " + competencia.nome_competencia)
        }
        sql.close()
        println "---CLOSING THE READER---"
    }

    void updateNome(int id, String nome_competencia){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE competencias SET nome_competencia = ? WHERE id_competencia = ?", nome_competencia, id)
        sql.close()
    }

    void delete(int id){
        Sql sql = modelConnection.connect()
        sql.execute("DELE FROM competencias WHERE id_competencia = ?", id)
        sql.close()
    }
}
