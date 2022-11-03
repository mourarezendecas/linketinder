package com.acelerazg.DAO

import com.acelerazg.Model.ModelEmpresa
import com.acelerazg.connection.IConnection
import com.acelerazg.connection.PostgreConnection
import groovy.sql.Sql

class DAOEmpresa {
    IConnection postgreConnection = new PostgreConnection()
    Map dbConnParams = postgreConnection.Connection()

    void create(ModelEmpresa e){
        List<String> atributos = [e.nome, e.cnpj, e.email, e.pais, e.cep, e.descricao, e.senha]
        Sql sql = Sql.newInstance(dbConnParams)
        sql.executeInsert('INSERT INTO empresas (nome_empresa, cnpj, email_empresa, pais_empresa, cep_empresa, descricao_empresa, senha_empresa) VALUES (?,?,?,?,?,?,?)', atributos)
        sql.close()
    }

    void update(){
        printf('ID DA EMPRESA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        println('O QUE DESEJA ATUALIZAR?')
        println('1 - Nome')
        println('2 - CNPJ')
        println('3 - E-mail')
        println('4 - País')
        println('5 - CEP')
        println('6 - Descrição')
        println('7 - Senha')
        int opt = (System.in.newReader().readLine() as Integer)

        switch (opt)
        {
            case 1:
                printf('Digite o nome correto: ')
                String novonome = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET nome_empresa = ? WHERE id_empresa = ?' ,novonome,choice)
                sqlupdate.close()
                break
            case 2:
                printf('Digite o cnpj correto: ')
                String novocpf = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET cnpj = ? WHERE id_empresa = ?' ,novocpf,choice)
                sqlupdate.close()
                break
            case 3:
                printf('Digite o e-mail correto: ')
                String novoemail = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET email_empresa = ? WHERE id_empresa = ?' ,novoemail,choice)
                sqlupdate.close()
                break
            case 4:
                printf('Digite o país correto: ')
                String novopais = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET pais_empresa = ? WHERE id_empresa = ?' ,novopais,choice)
                sqlupdate.close()
                break
            case 5:
                printf('Digite o CEP correto: ')
                String novocep = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET cep_empresa = ? WHERE id_empresa = ?' ,novocep,choice)
                sqlupdate.close()
                break
            case 6:
                printf('Digite a nova descrição: ')
                String novadescricao = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET descricao_empresa = ? WHERE id_empresa = ?' ,novadescricao,choice)
                sqlupdate.close()
                break
            case 7:
                printf('Digite a nova senha: ')
                String novasenha = (System.in.newReader().readLine())
                Sql sqlupdate = Sql.newInstance(dbConnParams)
                sqlupdate.execute('UPDATE empresas SET senha_empresa = ? WHERE id_empresa = ?' ,novasenha,choice)
                sqlupdate.close()
                break
        }
    }

    void delete(){
        printf('ID DA EMPRESA: ')
        int choice = (System.in.newReader().readLine() as Integer)

        Sql sqldelete = Sql.newInstance(dbConnParams)
        sqldelete.execute('DELETE FROM empresas WHERE id_empresa = ?', choice)
        println('EXCLUIDO!')
        sqldelete.close()
    }
}
