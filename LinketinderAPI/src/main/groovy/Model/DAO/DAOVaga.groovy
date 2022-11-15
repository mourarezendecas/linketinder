package Model.DAO

import DatabaseConnection.ModelConnection
import Model.Classes.ModelVaga
import groovy.sql.Sql


class DAOVaga {
    ModelConnection modelConnection = new ModelConnection()

    void create(ModelVaga modelVaga){
        List<String> atributos = [modelVaga.nome_vaga, modelVaga.descricao_vaga, modelVaga.modalidade_vaga]
        Sql sql = modelConnection.connect()
        sql.executeInsert("INSERT INTO vagas (nome_vaga, descricao_vaga, modalidade_vaga) VALUES (?,?,?)", atributos)
        sql.close()
    }

    void read(){
        println "---READING ALL---"
        Sql sql = modelConnection.connect()
        sql.eachRow("SELECT * FROM vagas"){
            vaga->
                println("ID: " + vaga.id_vaga)
                println("Nome da vaga: " + vaga.nome_vaga)
                println("Descrição da vaga: " + vaga.descricao_vaga)
                println("Modalidade da vaga: " + vaga.modalidade_vaga)
        }
        sql.close()
        println "---CLOSING READER---"
    }

    void updateNome(int id, String novoNome){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE vagas SET nome_vaga = ? WHERE id_vaga = ?", novoNome, id)
        sql.close()
    }

    void updateDescricao(int id, String novaDescricao){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE vagas SET descricao_vaga = ? WHERE id_vaga = ?", novaDescricao, id)
        sql.close()
    }

    void updateModalidade(int id, String novaModalidade){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE vagas SET modalidade_vaga = ? WHERE id_vaga = ?", novaModalidade, id)
        sql.close()
    }

    void delete(int id){
            Sql sql = modelConnection.connect()
            sql.execute("DELETE FROM vagas WHERE id_vaga = ?", id)
            sql.close()
    }

}
