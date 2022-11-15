package Model.DAO

import DatabaseConnection.ModelConnection
import Model.Classes.ModelEmpresa
import groovy.sql.Sql

class DAOEmpresa {
    ModelConnection modelConnection = new ModelConnection()

    void create(ModelEmpresa empresa){
        List<String> atributos = [empresa.nome_empresa, empresa.cnpj, empresa.email_empresa, empresa.pais_empresa, empresa.cep_empresa, empresa.descricao_empresa, empresa.senha_empresa]
        Sql sql = modelConnection.connect()
        sql.executeInsert('INSERT INTO empresas (nome_empresa, cnpj, email_empresa, pais_empresa, cep_empresa, descricao_empresa, senha_empresa) VALUES (?,?,?,?,?,?,?)', atributos)
        sql.close()
    }

    void read(){
        println "---READING ALL---"
        Sql sql = modelConnection.connect()
        sql.eachRow("SELECT * FROM empresas"){
            empresa ->
                println ("ID: " + empresa.id_empresa)
                println ("NOME: " + empresa.nome_empresa)
                println ("CNPJ: " +empresa.cnpj)
                println ("EMAIL: " + empresa.email_empresa)
                println ("PAIS: " + empresa.pais_empresa)
                println ("CEP: " + empresa.cep_empresa)
                println ("DESCRICAO: " + empresa.descricao_empresa)
        }
        sql.close()
        println "---CLOSE READER---"
    }

    void updateNome(int id, String novoNome){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE empresas SET nome_empresa = ? WHERE id_empresa = ?", novoNome, id)
        sql.close()
    }

    void updateCNPJ(int id, String novoCNPJ){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE empresas SET cnpj = ? WHERE id_empresa = ?", novoCNPJ, id)
        sql.close()
    }

    void updateEmail(int id, String novoEmail){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE empresas SET email_empresa = ? WHERE id_empresa = ?", novoEmail, id)
        sql.close()
    }

    void updatePais(int id, String novoPais){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE empresas SET pais_empresa = ? WHERE id_empresa = ?", novoPais, id)
        sql.close()
    }

    void updateCEP(int id, String novoCEP){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE empresas SET cep_empresa = ? WHERE id_empresa = ?", novoCEP, id)
        sql.close()
    }

    void updateDescricao(int id, String novaDescricao){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE empresas SET descricao_empresa = ? WHERE id_empresa = ?", novaDescricao, id)
        sql.close()
    }

    void updateSenha(int id, String novaSenha){
        Sql sql = modelConnection.connect()
        sql.execute("UPDATE empresas SET senha_empresa = ? WHERE id_empresa = ?", novaSenha, id)
        sql.close()
    }

    void delete(int id)
    {
        Sql sql = modelConnection.connect()
        sql.execute("DELETE FROM empresas WHERE id_empresa = ?", id)
        sql.close()
    }
}
