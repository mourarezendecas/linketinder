package Model.DAO

import DatabaseConnection.ModelConnection
import Model.Classes.ModelCandidato
import groovy.sql.Sql

class DAOCandidato {
    ModelConnection modelConnection = new ModelConnection()

    void create (ModelCandidato candidato){
        List<String> atributos = [candidato.nome_candidato, candidato.data_nascimento, candidato.cpf, candidato.email_candidato, candidato.pais_candidato, candidato.cep_candidato, candidato.descricao_candidato, candidato.senha_candidato]
        Sql sql = modelConnection.connect()
        sql.executeInsert('INSERT INTO candidatos (nome_candidato, data_nascimento, cpf, email_candidato, pais_candidato, cep_candidato, descricao_candidato, senha_candidato) VALUES (?,?,?,?,?,?,?,?)', atributos)
        sql.close()
    }

    void read(){
        println "---READING ALL---"
        Sql sql = modelConnection.connect()
        sql.eachRow("SELECT * FROM candidatos"){
            candidato ->
                println ("ID: " + candidato.id_candidato)
                println ("NOME: " + candidato.nome_candidato)
                println ("CPF: " +candidato.cpf)
                println ("NASCIMENTO: " + candidato.data_nascimento)
                println ("EMAIL: " + candidato.email_candidato)
                println ("PAIS: " + candidato.pais_candidato)
                println ("CEP: " + candidato.cep_candidato)
        }
        sql.close()
        println "---CLOSE READER---"
    }

    void updateNome(int id, String novoNome){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE candidatos SET nome_candidato = ? WHERE id_candidato = ?", novoNome, id)
        sql.close()
    }

    void updateCPF(int id, String novoCPF){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE candidatos SET cpf = ? WHERE id_candidato = ?", novoCPF, id)
        sql.close()
    }

    void updateNascimento(int id, String novoNasc){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE candidatos SET data_nascimento = ? WHERE id_candidato = ?", novoNasc, id)
        sql.close()
    }

    void updateEmail(int id, String novoEmail){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE candidatos SET email_candidato = ? WHERE id_candidato = ?", novoEmail, id)
        sql.close()
    }

    void updatePais(int id, String novoPais){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE candidatos SET pais_candidato = ? WHERE id_candidato = ?", novoPais, id)
        sql.close()
    }

    void updateCEP(int id, String novoCEP){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE candidatos SET cep_candidato = ? WHERE id_candidato = ?", novoCEP, id)
        sql.close()
    }

    void updateSenha(int id, String novaSenha){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE candidatos SET senha_candidato = ? WHERE id_candidato = ?", novaSenha, id)
        sql.close()
    }

    void updateDescricao(int id, String novaDescricao){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE candidatos SET descricao_candidato = ? WHERE id_candidato = ?" ,novaDescricao, id)
    }

    void delete (int id){
        Sql sql = modelConnection.connect()
        sql.execute("DELETE FROM candidatos WHERE id_candidato = ?", id)
        sql.close()
    }

}
