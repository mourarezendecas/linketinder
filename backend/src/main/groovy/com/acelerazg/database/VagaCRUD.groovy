package com.acelerazg.database

import com.acelerazg.classes.Vaga
import com.acelerazg.connection.IConnection
import com.acelerazg.connection.PostgreConnection
import groovy.sql.Sql

class VagaCRUD implements ICrud{
    EmpresaCRUD empresaCRUD = new EmpresaCRUD()

    IConnection postgreConnection = new PostgreConnection()
    Map dbConnParams = postgreConnection.Connection()

    @Override
    void create() {
        Vaga v = new Vaga()
        empresaCRUD.read()

        printf('SELECIONE O ID DA EMPRESA RESPONSÁVEL PELA VAGA: ')
        v.idEmpresa = (System.in.newReader().readLine() as Integer)
        printf('Nome da vaga: ')
        v.nome = (System.in.newReader().readLine())
        printf('Descrição: ')
        v.descricao = (System.in.newReader().readLine())
        printf('Modalidade (Presencial ou Remoto): ')
        v.modalidade = (System.in.newReader().readLine())

        List<String> atributos = [v.nome, v.descricao, v.modalidade]

        Sql sql = Sql.newInstance(dbConnParams)
        sql.executeInsert('INSERT INTO vagas (nome_vaga, descricao_vaga, modalidade_vaga) VALUES (?,?,?)', atributos)
        sql.close()
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

        printf('ID DA VAGA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        println('O QUE DESEJA ATUALIZAR?')
        println('1 - Nome')
        println('2 - Descrição')
        println('3 - Modalidade')
        int opt = (System.in.newReader().readLine() as Integer)

        switch (opt) {
            case 1:
                printf('Digite o nome correto: ')
                String novonome = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE vagas SET nome_vaga = ? WHERE id_vaga = ?', novonome, choice)
                sqlupdate.close()
                break
            case 2:
                printf('Digite a descrição correta: ')
                String novadata = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE vagas SET descricao_vaga = ? WHERE id_vaga = ?', novadata, choice)
                sqlupdate.close()
                break
            case 3:
                printf('Digite a modalidade correta (Remoto ou Presecial): ')
                String novocpf = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE vagas SET modalidade_vaga = ? WHERE id_vaga = ?', novocpf, choice)
                sqlupdate.close()
                break
        }
    }

    @Override
    void delete() {
        println('SELECIONE O ID DA VAGA QUE DESEJA DELETAR: ')
        read()

        printf('ID DO CANDIDATO: ')
        int choice = (System.in.newReader().readLine() as Integer)

        def sqldelete = Sql.newInstance(dbConnParams)
        sqldelete.execute('DELETE FROM vagas WHERE id_vaga = ?', choice)
        println('EXCLUIDO!')
        sqldelete.close()
    }
}
