package DatabaseConnection

import groovy.sql.Sql

//url: 'jdbc:postgresql://localhost:5432/linketinderteste',
//user: 'postgres',
//password: 'postgres',
//driver: 'org.postgresql.Driver'

class ModelConnection implements IConnection{
    String url = 'jdbc:postgresql://localhost:5432/linketinderteste'
    String user = 'postgres'
    String password = 'postgres'
    String driver = 'org.postgresql.Driver'

    @Override
    Sql connect() {
        return Sql.newInstance(url, user, password, driver)
    }
}
