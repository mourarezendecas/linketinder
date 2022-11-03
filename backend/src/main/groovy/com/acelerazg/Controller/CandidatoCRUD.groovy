package com.acelerazg.Controller

import com.acelerazg.DAO.DAOCandidato
import com.acelerazg.Model.ModelCandidato
import com.acelerazg.connection.IConnection
import com.acelerazg.connection.PostgreConnection
import groovy.sql.Sql


class CandidatoCRUD implements ICrud{
    IConnection postgreConnection = new PostgreConnection()
    Map dbConnParams = postgreConnection.Connection()

    DAOCandidato daoCandidato = new DAOCandidato()

    @Override
    void create() {
        ModelCandidato c = new ModelCandidato()
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
        daoCandidato.create(c)
    }

    @Override
    void read() {
        Sql sql = Sql.newInstance(dbConnParams)
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

    @Override
    void update() {
        daoCandidato.update()
    }

    @Override
    void delete() {
        println('SELECIONE O ID DO CANDIDATO QUE DESEJA DELETAR: ')
        read()
        daoCandidato.delete()
    }
}
